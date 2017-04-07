<%-- 
    Document   : invalidLogin
    Created on : Mar 22, 2017, 9:30:05 PM
    Author     : tim
--%>
<%session.invalidate();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval()%>; URL= index.jsp" />
        <title>User Profile</title>


        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">       
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.green-light_green.min.css" />
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
        
    </head>
    
        <!--Navigation bar-->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <img src="img/logo.png" alt="" HEIGHT="70" WIDTH="70" BORDER="0"/><a class="navbar-brand" href="index.jsp">Taylor<span>Insurance</span></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="homeQuote.jsp">Get a Home Quote</a></li>
                        <li><a href="autoQuote.jsp">Get an Auto Quote</a></li>
                        <li><a href="ContactUs.jsp">Contact Us</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--/ Navigation bar-->
    <body style="padding-top: 150px;">
       <div style="text-align: center;">
        <h1 style="text-align: center;">Invalid Login</h1>
        <p style="text-align: center;">If you are having issues logging in please contact us at</p>
        <p style="text-align: center;">(709) 867-5309</p>
        <a style="margin: 0 auto;" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" href="index.jsp">Home</a>
       </div>
          
    </body>
</html>