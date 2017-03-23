<%-- 
    Document   : index
    Created on : Mar 8, 2017, 9:44:40 PM
    Author     : tim
--%>
<%@page import="BEANS.Client" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Profile</title>

    
    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
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
        <img src="img/logo.png" alt="" HEIGHT="70" WIDTH="70" BORDER="0"/><a class="navbar-brand" href="userprofile.jsp">Taylor<span>Insurance</span></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="userprofile.jsp">My Policies</a></li>
          <li><a href="#team">File a Claim</a></li>
        <li><a href="#testimonial">Get a Quote</a></li>
          <li><a href="#contact">Contact Us</a></li>
        </ul>
        </div>
      </div>
    </nav>
  <body style="padding-top: 150px;">
       <% Client currentClient = (Client)(session.getAttribute("currentSessionClient"));%>
    <!--/ Navigation bar-->
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      
        <h3>My Policies</h3>
      <p>Client ID: <%= currentClient.getId() %></p>
      <p>
          <span>Hi, </span><span><%= currentClient.getFirstName() + " " + currentClient.getLastName() %></span>
      </p>
      
    </div>
    <div class="col-sm-4">
      <h3>Address</h3>
      <p><%= currentClient.getMailingAddress() %></p>
    
    </div>
    <div class="col-sm-4">
      <h3>Column 3</h3>        
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>
    </body>
</html>
