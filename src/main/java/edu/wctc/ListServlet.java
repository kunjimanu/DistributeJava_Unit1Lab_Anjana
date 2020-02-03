package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet",urlPatterns = "/listPets")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        Statement stmt =null;
        ResultSet rset =null;

        try {
            //load the driver
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            String absPath = getServletContext().getRealPath("/") +"../../db";

            //create a connection
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + absPath,
                    "anjana",
                    "anjana");
            stmt = conn.createStatement();

            rset =  stmt.executeQuery("Select nm,age,species_nm from pet ");

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
