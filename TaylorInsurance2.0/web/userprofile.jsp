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
                    <li><a href="userprofile.jsp">Add Home Quote</a></li>
                    <li><a href="#team">Add Auto Quote</a></li>
                    <li><a href="#testimonial">File a Claim</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <body style="padding-top: 150px;">
        <% Customer currentClient = (Customer) (session.getAttribute("currentSessionClient"));%>
        <% Map<Integer, Integer> map = (Map<Integer, Integer>) (session.getAttribute("currentPolicyID"));%>
        <% Map<Integer, Integer> map2 = (Map<Integer, Integer>) (session.getAttribute("currentQuoteID"));%>
        
        
        
        <!--/ Navigation bar-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">

                    <h3>Customer Information</h3>
                    <p>Customer ID: <%= currentClient.getId()%></p>
                    <p>
                        <span>Hi, </span><span><%= currentClient.getFirstName() + " " + currentClient.getLastName()%></span>
                    </p>
                    <br>
                    <br>
                    <h3>Address</h3>
                    <p><%= currentClient.getAddress()%></p>
                </div>
                <div class="col-sm-4">
                    <div>
                             

                        <%
                            if(!(map == null)){
                            for (Entry<Integer, Integer> maps : map.entrySet()) {
                                if (maps.getKey() == 15) {
                        %>
                        <h3>Active Policies</h3>  
                        <form class="form-horizontal" action="ViewHomePolicyServlet"> 
                            <label>Home Policy ID:</label>

                            <select name="homePolicyIds">
                                <option value="<%=maps.getValue()%>">
                                    <%= maps.getValue()%>
                                </option>
                            </select>
                            <br><br>
                            <button class="btn btn-info" type="submit">View Home Policy</button>
                        </form>
                        <%
                                }}
                              }
                        %>
                        
                        <%
                            if(!(map == null)){
                            for (Entry<Integer, Integer> maps2 : map.entrySet()) {
                                if (maps2.getKey() == 14) {
                        %>
                        <h3>Active Policies</h3>  
                        <form class="form-horizontal" action="ViewAutoPolicyServlet"> 
                            <label>Auto Policy ID:</label>

                            <select name="autoPolicyIds">
                                <option value="<%= maps2.getValue()%>">
                                    <%= maps2.getValue()%>
                                </option>
                            </select>
                            <br><br>
                            <button class="btn btn-info" type="submit">View Auto Policy</button>
                        </form>
                        <%
                                }
                            }
                        }
                        %>
                    </div>

                </div>
                <div class="col-sm-4">
                    <div>
                        

                        <%
                            if(!(map2 == null)){
                            for (Entry<Integer, Integer> maps2 : map2.entrySet()) {
                                if (maps2.getKey() == 15) {
                        %>
                        <h3>Active Quotes</h3>  
                        <form class="form-horizontal" action="ViewHomeQuoteServlet"> 
                            <label>Home Quote ID:</label>

                            <select name="homequoteIds">
                                <option value="<%=maps2.getValue()%>">
                                    <%= maps2.getValue()%>
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
                            for (Entry<Integer, Integer> maps2 : map2.entrySet()) {
                                if (maps2.getKey() == 14) {
                        %>
                        <h3>Active Quotes</h3>  
                        <form class="form-horizontal" action="ViewAutoQuoteServlet"> 
                            <label>Auto Quote ID:</label>

                            <select name="autoquoteIds">
                                <option value="<%= maps2.getValue()%>">
                                    <%= maps2.getValue()%>
                                </option>
                            </select>
                            <br><br>
                            <button class="btn btn-info" type="submit">View Auto Quote</button>
                        </form>
                        <%
                                }
                            }
                        }
                        %>
                    </div>
                </div>
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
