package edu.wctc;

import edu.wctc.entity.Book;
import edu.wctc.entity.BookDetail;

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

@WebServlet(name = "SearchServlet2", urlPatterns = "/search2")
public class SearchServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt =null;
        ResultSet rset =null;
        String bookName = request.getParameter("BookName");
        try {
            //load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String absPath = getServletContext().getRealPath("/") +"../../db_books";

            //create a connection
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "anjana",
                    "anjana");

            String sql = "Select book.book_id as book_id,isbn,title, category, author, publisher " +
                    " from book inner join BOOK_DETAIL on book.BOOK_ID = BOOK_DETAIL.BOOK_ID " +
                    "where title like ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + bookName + "%");

            rset =  stmt.executeQuery();

            Book currentBook = new Book();
            BookDetail currentBookDetail = new BookDetail();
            while(rset.next()){
                currentBook.setBookid(rset.getInt("book_id"));
                currentBook.setIsbn(rset.getInt("isbn"));
                currentBook.setTitle(rset.getString("title"));
                currentBook.setCategory(rset.getString("category"));
                currentBookDetail.setAuthor(rset.getString("author"));
                currentBookDetail.setPublisher(rset.getString("publisher"));
            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/search2.jsp");
            request.setAttribute("currentBook", currentBook);
            request.setAttribute("currentBookDetail", currentBookDetail);

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
