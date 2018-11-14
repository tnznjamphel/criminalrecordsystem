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

/**
 *
 * @author tenzinjamphel
 */
@WebServlet(urlPatterns = {"/searchEntry"})
public class searchEntry extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException{
       String sword=req.getParameter("search");
       PrintWriter out=resp.getWriter();
       out.println("<html>");
       out.println("<head>");
       out.println("</head>");
       out.println("<body>");
       out.println("<form method='post' action='http://localhost:45603/criminalrecordsystem/searchLogic'>");
       
       out.println("<input type='text' value='"+sword+"' disabled>the keyword to be searched");
       out.println("<input type='radio' value='name'>Name");
       out.println("<input type='radio' value='age'>Age");
       out.println("<input type='radio' value='ctype'>Crime type");
       out.println("</body>");
       
       out.println("</html>");
       
       
    
       
       
       
   }
    
}