<%-- 
    Document   : index
    Created on : Mar 8, 2017, 9:44:40 PM
    Author     : tim
--%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="BEANS.InfoObjects.Customer" %>
<%@page import="java.util.ArrayList" %>
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
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="userprofile.jsp">My Policies</a></li>
                    <li><a href="#team">File a Claim</a></li>
                    <li><a href="#testimonial">Add Policy</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <body style="padding-top: 150px;">
        <% Customer currentClient = (Customer) (session.getAttribute("currentSessionClient"));%>
        <% Map<Integer, Integer> map = (Map<Integer, Integer>) (session.getAttribute("currentQuoteID"));%>
        <!--/ Navigation bar-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">

                    <h3>My Policies</h3>
                    <p>Customer ID: <%= currentClient.getId()%></p>
                    <p>
                        <span>Hi, </span><span><%= currentClient.getFirstName() + " " + currentClient.getLastName()%></span>
                    </p>

                </div>
                <div class="col-sm-4">
                    <h3>Address</h3>
                    <p><%= currentClient.getAddress()%></p>

                </div>
                <div class="col-sm-4">

                    <h3>Active Quotes</h3>        

                    <%

                        for (Entry<Integer, Integer> maps : map.entrySet()) {
                            if (maps.getKey() == 15) {
                    %>
                    <form class="form-horizontal" action="ViewHomeQuoteServlet"> 
                        <label>Home Quote ID:</label>

                        <select name="homequoteIds">
                            <option value="<%=maps.getValue()%>_<%= maps.getKey()%>">
                                <%= maps.getValue()%>
                            </option>
                        </select>
                        <br><br>
                        <button class="btn btn-info" type="submit">View Home Quote</button>
                    </form>
                    <%
                            }
                        }
                    %>
                    <%
                        for (Entry<Integer, Integer> maps : map.entrySet()) {
                            if (maps.getKey() == 14) {
                    %>
                    <form class="form-horizontal" action="ViewAutoQuoteServlet"> 
                        <label>Auto Quote ID:</label>

                        <select name="autoquoteIds">
                            <option value="<%= maps.getValue()%>_<%= maps.getKey()%>">
                                <%= maps.getValue()%>
                            </option>
                        </select>
                        <br><br>
                        <button class="btn btn-info" type="submit">View Auto Quote</button>
                    </form>
                    <%
                            }
                        }
                    %>

                </div>
            </div>
        </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.easing.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="contactform/contactform.js"></script>
    </body>

</html>
