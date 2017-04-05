<%-- 
    Document   : index
    Created on : Mar 8, 2017, 9:44:40 PM
    Author     : tim
--%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="BEANS.InfoObjects.Customer" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User Profile</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

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
                    <li><a href="homeQuoteExisting.jsp">Add Home Quote</a></li>
                    <li><a href="autoQuoteExisting.jsp">Add Auto Quote</a></li>
                    <li><a href="#testimonial">File a Claim</a></li>
                    <li><a href="ContactUs.jsp">Contact Us</a></li>
                    <li>
                        <form class="form-horizontal" action="LogoutServlet"> 
                             <button class="btn btn-info" type="submit">Logout</button>
                        </form>
                    </li>
                    
                </ul>
            </div>
        </div>
    </nav>
    <body style="padding-top: 150px;">
        <% Customer currentClient = (Customer) (session.getAttribute("currentSessionClient"));%>

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

                        <div id="homePolicyID">
                     
                                <h3>Active Home Policies</h3>  
                                <form class="form-horizontal" action="ViewHomePolicyServlet"> 
                                    <select id="homePolicies" name="homePolicies">
                                        <c:forEach items="${currentHomePolicyID}" var="homepolicy">
                                            <option value="${homepolicy}">${homepolicy}</option>
                                        </c:forEach>
                                    </select>
                                    <br><br>
                                    <button class="btn btn-info" type="submit">View Policy</button>
                              </form>
                        </div>
                        <div id="AutoPolicySection">
                          
                                <h3>Active Auto Policies</h3>  
                                <form class="form-horizontal" action="ViewAutoPolicyServlet"> 
                                    <select id="autoPolicies" name="autoPolicyIds">
                                        <c:forEach items="${currentAutoPolicyID}" var="autopolicy">
                                            <option value="${autopolicy}">${autopolicy}</option>
                                        </c:forEach>
                                    </select>
                                    <br><br>
                                    <button class="btn btn-info" type="submit">View Policy</button>
                                </form>
                        
                        </div>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div>
                        <div id="homeQuoteSection">
                           
                                <h3>Active Home Quotes</h3>  
                                <form class="form-horizontal" action="ViewHomeQuoteServlet"> 
                                    <select id="homeQuotes" name="homeQuotes">
                                        <c:forEach items="${currentHomeQuoteID}" var="quotes">
                                            
                                                <option value="${quotes}">${quotes}</option>
                                           
                                        </c:forEach>
                                    </select>
                                    <br><br>
                                    <button class="btn btn-info" type="submit">View Home Quote</button>
                                </form>
                        
                        </div>

                        <div id="autoQuoteSection">
                           
                                <h3>Active Auto Quotes</h3>  
                                <form class="form-horizontal" action="ViewAutoQuoteServlet"> 
                                    <select id="autoQuotes" name="autoquotes">
                                        <c:forEach items="${currentAutoQuoteID}" var="quotes">

                                                <option value="${quotes}">${quotes}</option>
                                   
                                        </c:forEach>
                                    </select>
                                    <br><br>
                                    <button class="btn btn-info" type="submit">View Auto Quote</button>
                                </form>
                           
                        </div>     
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        $(document).ready(function () {
            if (!$('#homePolicies').val()) {
                $('#homePolicyID').hide();
            }

            if (!$('#autoPolicies').val()) {
                $('#AutoPolicySection').hide();
            }

            if (!$('#autoQuotes').val()) {
                $('#autoQuoteSection').hide();
            }

            if (!$('#homeQuotes').val()) {
                $('#homeQuoteSection').hide();
            }

        });

    </script>
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
    <script src="contactform/contactform.js"></script>
</body>

</html>
