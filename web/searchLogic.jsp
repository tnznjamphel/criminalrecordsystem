<%-- 
    Document   : searchLogic.jsp
    Created on : Nov 14, 2018, 8:06:51 PM
    Author     : tenzinjamphel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ page import="java.util.List" 
                 import="java.sql.*"
                 import="import java.util.logging.Level"
                 import="java.util.logging.Logger"%>
        <% 
            String searchKey= request.getParameter("keyword");
            String type=request.getParameter("type");
            Class.forName("com.mysql.jdbc.Driver");
           
            
                Connection conn;
                Statement stmt;
                conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/crecord","root","");
                stmt=conn.createStatement();   
                String query;
                
                if(type=="1")    
                    query= "select * from CPrisoners where name='"+searchKey+"'";
                else if(type=="2")
                {
                    query="select * from CPrisoners where age=' "+searchKey+"'";
                }
                else if(type=="3"){
                    query="select * from CPrisoners";
                }                   
                ResultSet rs=stmt.executeQuery("query");
                
                
             
            
           
        %>
                
        <h1>Hello World!</h1>
    </body>
</html>
