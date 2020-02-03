package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListBooksServlet",urlPatterns = "/list")
public class ListBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String absPath = "";
        try {
            //load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            absPath = getServletContext().getRealPath("/") + "../../db_books";
        } catch(Exception e) {
            e.printStackTrace();
        }

        //I tried using the new try with resources statement that avoids the use of finally block. new to JAVA SE 7
        try (Connection conn = DriverManager.getConnection(
                "jdbc:derby:" + absPath,
                "anjana",
                "anjana");
             Statement stmt = conn.createStatement();
             ResultSet rset =stmt.executeQuery("Select book_id,isbn,title,category from book ");)
        {
            StringBuilder sb = new StringBuilder("<html><body>");
            sb.append("<ul>");
            while(rset.next()){
                sb.append("<li>");
                int isbn = rset.getInt("isbn");
                String title = rset.getString("title");
                String category = rset.getString("category");
                sb.append(isbn + " " + title + " " + category);
                sb.append("</li>");
            }

            sb.append("</ul>");
            sb.append("</body></html>");

            response.setContentType("html");
            response.getWriter().print(sb.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
