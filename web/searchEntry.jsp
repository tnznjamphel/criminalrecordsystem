<%-- 
    Document   : searchEntry.jsp
    Created on : Nov 14, 2018, 2:52:50 PM
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
        
        
       <form method='post' action='http://localhost:45603/criminalrecordsystem/searchLogic'>
       
       <input type='text' name='keyword' >the keyword to be searched
       <input type='radio' name='type' value='1'>Name
       <input type='radio' name='type' value='2'>Age
       <input type='radio' name='type' value='3'>Crime type
       <input type="submit">
       </form>
       
        
    </body>
</html>
