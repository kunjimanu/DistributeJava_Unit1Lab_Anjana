package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchBookServlet", urlPatterns = "/search")
public class SearchBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //use the following URL to test it
        //http://localhost:8080/anjazon/search?BookName=Alice%20in%20wonderland
        String absPath = "" ;
        String title = request.getParameter("BookName");
        try {
            //load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            absPath = getServletContext().getRealPath("/") + "../../db_books";
        } catch(Exception e) {
            e.printStackTrace();
        }
        String sql = "select book_id, isbn, title, category from book where title = ?";

        try(Connection conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "anjana",
                    "anjana");

            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, title);

            try (ResultSet rset = stmt.executeQuery()) {
                System.out.println("Just before executing query");
                StringBuilder sb = new StringBuilder("<html><body>");
                sb.append("<ul>");
                while (rset.next()) {
                    sb.append("<li>");
                    int isbn = rset.getInt("isbn");
                    String booktitle = rset.getString("title");
                    String category = rset.getString("category");

                    sb.append(isbn + " " + booktitle + " " + category);
                    sb.append("</li");
                }

                sb.append("</ul>");
                sb.append("</body></html>");

                response.setContentType("html");
                response.getWriter().print(sb.toString());

            } catch(Exception e){
                System.out.println("ERRORR in resultset block" + e);
                e.printStackTrace();
            }
        } catch(SQLException se) {
            System.out.println("ERRORR in resultset block" + se);
            se.printStackTrace();
        }
    }
}
