<%-- 
    Document   : index.jsp
    Created on : Nov 14, 2018, 1:50:05 PM
    Author     : tenzinjamphel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .main{
                width:500px;
                height:500px;
                -webkit-box-shadow: -1px 4px 8px 3px rgba(0,0,0,0.75);
                -moz-box-shadow: -1px 4px 8px 3px rgba(0,0,0,0.75);
                box-shadow: -1px 4px 8px 3px rgba(0,0,0,0.75);
                border-radius: 28px 28px 28px 28px;
                -moz-border-radius: 28px 28px 28px 28px;
                -webkit-border-radius: 28px 28px 28px 28px;
                border: 0px solid #000000;
                
            }
            .header{
                height:300px;
            }  
            img{
                 height:310px;
            }
            </style>
    </head>
    <body>
     <center>
         <div class="header"><img src="criminal.png">
         </div>   
         <div class="main">
        <h1>MENU</h1>
        <a href='http://localhost:45603/criminalrecordsystem/searchEntry.jsp'>1. Search entry</a>
        
        <br>
        <br>
        <a href="http://localhost:45603/criminalrecordsystem/getData">2. insert into prisoners database</a>
        <br>
        <br>
        <a href="http://localhost:45603/criminalrecordsystem/showCP">3. Show the list of current active prisoners</a>
        <br>
        <br>
        
    </div></center>
    
    
    
    </body>
</html><html
  
   

