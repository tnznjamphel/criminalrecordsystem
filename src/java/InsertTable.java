/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tenzinjamphel
 */
@WebServlet(urlPatterns = {"/InsertTable"})
public class InsertTable extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        PrintWriter pw = resp.getWriter();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crecord","root","");
            
            Enumeration e =req.getParameterNames();
            String fieldName = null;
            String value = null;
            int value1;
            
            String main_query = "insert into CPrisoners values(";
            boolean comma = false;
            while(e.hasMoreElements()){
                fieldName=(String)e.nextElement();
                if(comma)
                        main_query+= ",";
                if(fieldName.endsWith("var")){
                    value = req.getParameter(fieldName);
                    main_query+="'"+value+"'";
                    comma = true;
                    
                }
                else if(fieldName.endsWith("num")){
                    value1=Integer.parseInt(req.getParameter(fieldName));
                    main_query+=value1;
                    comma = true;
                    
                }}
            
                main_query+=")";
                Statement stmt = conn.createStatement();
                stmt.execute(main_query);
                pw.println("<html>");
            pw.println("<body>");
            pw.println("Successfully Entered");
            pw.println("<br><a href='http://localhost:45603/criminalrecordsystem/index.jsp'>Back to Menu</a>");
            pw.println("</body>");
            pw.println("</html>");
            conn.close();
                    
        } catch (SQLException ex) {
            ex.printStackTrace(pw); }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        pw.close();
        
}
}
