/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tenzinjamphel
 */
@WebServlet(urlPatterns = {"/showCP"})
public class showCP extends HttpServlet {

   
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        {
            PrintWriter pw = resp.getWriter();
            Connection conn;
            Statement stmt;
            ResultSet struct;
            ResultSet rs;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crecord","root","");
                stmt=conn.createStatement();
                
                
            
            struct= stmt.executeQuery("desc CPrisoners");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<body>");
           
            pw.println("<br>");
           
            pw.println("<center>");
            pw.println("<h1>List of Prisoners</h1>");
            pw.println("<table border='2'>");
            pw.println("<tr>");
            while(struct.next()){
                pw.println("<td>");
                pw.println(struct.getString(1));
                pw.println("</td>");
            }
            pw.println("</tr>");
            int i;
            stmt=conn.createStatement();
            rs=stmt.executeQuery("select * from CPrisoners");
            while(rs.next()){
                struct.first();
                i=1;
                pw.println("<tr>");
                do{
                    pw.println("<td>");
                    if(struct.getString(2).startsWith("varchar"))
                        pw.println(rs.getString(i));
                    else
                        pw.println(rs.getInt(i));
                    pw.println("</td>");
                    i++;
                }while(struct.next());
                pw.println("</tr>");
             
            }
            
            pw.println("</table>");
            pw.println("</center>");
            
            
            pw.println("<body>");
            pw.println("</body>");
            pw.println("</html>");
            conn.close();
            pw.close();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(showCP.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
}
