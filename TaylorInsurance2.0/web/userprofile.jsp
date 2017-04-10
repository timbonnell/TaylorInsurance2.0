<%-- 
    Document   : index
    Created on : Mar 8, 2017, 9:44:40 PM
    Author     : tim
--%>
<%@page import="BEANS.BusinessProcessObjects.BusinessProcessManager"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval()%>; URL= index.jsp" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>User Profile</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.green-light_green.min.css" />
        <script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>

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
                        <form style="padding-top: 10px;" class="form-horizontal" action="LogoutServlet"> 
                            <button class="btn btn-info" type="submit">Logout</button>
                        </form>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
    <body style="padding-top: 150px;">
        <% BusinessProcessManager newBusinessProcessManager = (BusinessProcessManager) (session.getAttribute("BusinessProcessManager"));%>

        <!--/ Navigation bar-->
        <div class="container">
            <div class="row">
                <div class="col-sm-4">

                    <div class="demo-card-square mdl-card mdl-shadow--2dp">
                        <div class="mdl-card__title_info mdl-card--expand">
                            <h2 class="mdl-card__title_home-text">Customer Information</h2>
                        </div>

                        <div style="padding: 20px;">
                        <p>Customer ID: <%= newBusinessProcessManager.getCustomer().getId()%></p>
                        <p>
                            <span>Hi, </span><span><%= newBusinessProcessManager.getCustomer().getFirstName() + " " + newBusinessProcessManager.getCustomer().getLastName()%></span>
                        </p>
                        <p><%= newBusinessProcessManager.getCustomer().getEmail() %></p>
                        <p><%= newBusinessProcessManager.getCustomer().getAddress()%></p>
                        </div>
                    </div>

                    <div style="padding-top: 60px;">
                        <div  class="demo-card-square mdl-card mdl-shadow--2dp">
                            <div class="mdl-card__title_info mdl-card--expand">
                                <h2 class="mdl-card__title_home-text">Payment Information</h2>
                            </div>

                             <div style="padding: 20px;">
                            <p>Payment Type: Visa</p>
                            <p>
                               Card Number: **** **** **** 4556
                            </p>
                            <p>Policy Payment Type: Fixed Yearly</p>
                            </div>
                        </div>
                    </div>


                </div>

                <div class="col-sm-4">
                    <div style="padding-bottom: 60px;"   id="homePolicyID">

                        <div class="demo-card-square mdl-card mdl-shadow--2dp">
                            <div class="mdl-card__title_home mdl-card--expand">
                                <h2 class="mdl-card__title_home-text"></h2>
                            </div>
                            <div style="padding: 20px;" class=""> 
                                <form class="form-horizontal" action="ViewHomePolicyServlet"> 
                                    <select id="homePolicies" name="homePolicies">
                                        <c:forEach items="${BusinessProcessManager.getHousePolicyList()}" var="homepolicy">
                                            <option value="${homepolicy.key}">ID: ${homepolicy.key} Cost: $ ${homepolicy.value.getPremium()}</option>
                                        </c:forEach>
                                    </select>
                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">View Home Policy</button> 
                            </div>
                            </form>
                        </div>  
                    </div>


                    <div id="AutoPolicySection">

                        <div class="demo-card-square mdl-card mdl-shadow--2dp">
                            <div class="mdl-card__title_auto mdl-card--expand">
                                <h2 class="mdl-card__title_auto-text"></h2>
                            </div>
                            <div style="padding: 20px;" class="">
                                <form class="form-horizontal" action="ViewAutoPolicyServlet"> 
                                    <select id="autoPolicies" name="autoPolicies">
                                        <c:forEach items="${BusinessProcessManager.getVehiclePolicyList()}" var="autopolicy">
                                            <option value="${autopolicy.key}">ID: ${autopolicy.key} Cost: $ ${autopolicy.value.getPremium()}</option>
                                        </c:forEach>
                                    </select>


                            </div>
                            <div class="mdl-card__actions mdl-card--border">
                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">View Auto Policy</button> 
                            </div>
                            </form>
                        </div>    

                    </div>




                </div>

                <div class="col-sm-4">
                    <div>
                        <div style="padding-bottom: 60px;" id="homeQuoteSection">

                            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                <div class="mdl-card__title_home mdl-card--expand">
                                    <h2 class="mdl-card__title_home-text"></h2>
                                </div>
                                <div style="padding: 20px;" class="">
                                    <form class="form-horizontal" action="ViewHomeQuoteServlet"> 
                                        <select id="homeQuotes" name="homeQuotes">
                                            <c:forEach items="${BusinessProcessManager.getHouseQuoteList()}" var="homequotes">
                                                <c:if test="${(BusinessProcessManager.checkExpiry(homequotes.value))}">
                                                    <option value="${homequotes.key}">ID: ${homequotes.key} Cost: $ ${homequotes.value.getTotalPremium()} </option>
                                                </c:if>
                                            </c:forEach>                                   
                                        </select>
                                </div>
                                <div class="mdl-card__actions mdl-card--border">
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">View Home Quote</button> 
                                </div>
                                </form>
                            </div>     

                        </div>

                        <div id="autoQuoteSection">

                            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                <div class="mdl-card__title_auto mdl-card--expand">
                                    <h2 class="mdl-card__title_auto-text"></h2>
                                </div>
                                <div style="padding: 20px;" class="">
                                    <form class="form-horizontal" action="ViewAutoQuoteServlet"> 
                                        <select id="autoQuotes" name="autoquotes">
                                            <c:forEach items="${BusinessProcessManager.getVehicleQuoteList()}" var="autoquotes">
                                                <c:if test="${(BusinessProcessManager.checkExpiry(autoquotes.value))}">
                                                    <option value="${autoquotes.key}">ID: ${autoquotes.key} Cost: $ ${autoquotes.value.getTotalPremium()}</option>
                                                </c:if>
                                            </c:forEach>
                                        </select>


                                </div>
                                <div class="mdl-card__actions mdl-card--border">
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">View Auto Quote</button> 
                                </div>
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
        <!-- Square card -->
        <style>
            .demo-card-square.mdl-card {
                width: 320px;
                height: 270px;
            }
            .demo-card-square > .mdl-card__title_auto {
                color: #fff;
                background:
                    url('https://img.clipartfest.com/e93053963be276dec149592341d14d87_car-back-red-icon-back-of-car-clipart-png_256-256.png') center no-repeat #2196F3;
            }
            .demo-card-square > .mdl-card__title_home {
                color: #fff;
                background:
                    url('http://findicons.com/files/icons/776/chakram_2/128/home.png') center no-repeat #2196F3;
            }
            .demo-card-square > .mdl-card__title_info {
                color: #fff;
                text-align: center;
                background:
                     center no-repeat #2196F3;
            }
        </style>

    </body>

</html>
