package edu.wctc;

import edu.wctc.entity.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet2", urlPatterns = "/list2")
public class ListServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        Statement stmt =null;
        ResultSet rset =null;

        try {
            //load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String absPath = getServletContext().getRealPath("/") +"../../db_books";

            //create a connection
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "anjana",
                    "anjana");
            stmt = conn.createStatement();

            rset =  stmt.executeQuery("Select book_id,isbn,title, category from book ");

            List listOfBooks = new ArrayList();
            while(rset.next()){
                Book currentBook = new Book();
                currentBook.setBookid(rset.getInt("book_id"));
                currentBook.setIsbn(rset.getInt("isbn"));
                currentBook.setTitle(rset.getString("title"));
                currentBook.setCategory(rset.getString("category"));

                listOfBooks.add(currentBook);
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/list2.jsp");
            request.setAttribute("ListOfBooks", listOfBooks);
            requestDispatcher.forward(request, response);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                rset.close();
                stmt.close();
                conn.close();
            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
