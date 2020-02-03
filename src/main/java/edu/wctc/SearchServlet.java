package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt =null;
        ResultSet rset =null;
        String speciesName = request.getParameter("species");

        try {
            //load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String absPath = getServletContext().getRealPath("/") +"../../db";

            //create a connection
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "anjana",
                    "anjana");

            String sql = "select nm, age, species_nm from pet where species_nm = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,speciesName);
            rset =  stmt.executeQuery();

            StringBuilder sb = new StringBuilder("<html><body>");
            sb.append("<ul>");
            while(rset.next()){
                sb.append("<li>");
                String str = rset.getString("nm");
                int age = rset.getInt("age");

                String species = rset.getString(3);
                sb.append(str + " " + age + " " + species);
                sb.append("</li");
            }

            sb.append("</ul>");
            sb.append("</body></html>");



            System.out.println("TEST species" + sb.toString());
            System.out.println("stmt" + stmt);


            response.setContentType("html");
            response.getWriter().print(sb.toString());

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
