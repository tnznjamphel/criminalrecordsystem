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
@WebServlet(urlPatterns = {"/searchLogic"})
public class searchLogic extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
         String searchKey= req.getParameter("keyword");
         String type=req.getParameter("type");
         int ch = Integer.parseInt(type);
         
         
         PrintWriter pw= resp.getWriter();
         
         Connection conn;
         Statement stmt;
         String query="select * from CPrisoners where ";
          try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/crecord","root","");
            stmt=conn.createStatement();
            switch(ch){
                case 1:
                    query+="name='"+searchKey+"'";
                    
                    break;
                case 2:
                    query+="age='"+searchKey+"'";
                    break;
                case 3:
                    query+="age='"+searchKey+"'";
                    break;
                    
            }
            ResultSet struct= stmt.executeQuery("desc CPrisoners");
            pw.println("<html>");
            pw.println("<head>");
            pw.println("<body>");
            pw.println(searchKey);
            pw.println(type);
            pw.println("<br>");
            pw.println(query);
            pw.println("<center>");
            pw.println("<h1>Table</h1>");
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
            ResultSet rs=stmt.executeQuery(query);
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
            pw.println("<br><a href='index.jsp'>Back to Menu</a>");
            pw.println("</body>");
            pw.println("</html>");
         
         } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(searchLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}