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
@WebServlet(urlPatterns = {"/getData"})
public class getData extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
       
        PrintWriter pw=resp.getWriter();
        Connection conn;
        Statement stmt;
        ResultSet rs;
        
         try{
           Class.forName("com.mysql.jdbc.Driver");
           
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crecord","root","");
           stmt=conn.createStatement();
           rs= stmt.executeQuery("desc CPrisoners");
           String field=null;
           String type=null;
           String limit=null;
           pw.println("<html>");
           pw.println("<body>");
           pw.println("<h1 align='center'>INSERT DATA</h1>");
           pw.println("<form method='post' action='http://localhost:45603/criminalrecordsystem/InsertTable'>");
           while(rs.next()){
               field =rs.getString("Field");
               type = rs.getString("Type");
               if(type.startsWith("varchar")){
                   limit = type.substring(8,10);
                   type = "varchar";
        
                 }
                pw.println("Enter "+field+" : ");
               if(type.equalsIgnoreCase("varchar"))
                   pw.println("<input type='text placeholder='Enter max("+limit+")'' name='"+field+"var' >");
               else 
                   pw.println("<input type='number' placeholder='Enter' name='"+field+"num' >");
               pw.println("<br>");
           }
           pw.println("<input type='Submit'>");
           pw.println("</form>");
           pw.println("</body>");
           pw.println("</html>");
           conn.close();
           pw.close();
           }
            catch (ClassNotFoundException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(getData.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}