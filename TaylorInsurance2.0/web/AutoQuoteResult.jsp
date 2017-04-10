<%-- 
    Document   : AutoQuoteResult
    Created on : Mar 24, 2017, 1:13:10 PM
    Author     : tim
--%>

<%@page import="BEANS.BusinessProcessObjects.BusinessProcessManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval()%>; URL= index.jsp" />
        <title>Auto Quote Results</title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="css/form-basic.css"> 
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
    <!--End Nav -->

    <body style="padding-top: 150px;">
        <% BusinessProcessManager newBusinessProcessManager = (BusinessProcessManager) (session.getAttribute("BusinessProcessManager"));%>
        <% String AutoQuoteID = (String) (session.getAttribute("AutoQuoteID"));%> 
        <div class="container">
            <div class="row">

            </div>
            <form class="form-horizontal" action="CreateCustomer.jsp">
                <div class="form-group">
                    <div class="row">
                        <fieldset class="for-panel">
                            <legend>Auto Quote Results</legend>
                            <div class="row">

                                <div class="col-sm-4">
                                    <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                        <div class="mdl-card__title_info mdl-card--expand">
                                            <h3 class="mdl-card__title_home-text">Customer Information</h3>
                                        </div>

                                        <div style="padding: 20px;"  mdl-card--expand>
                                            <p>Customer ID: <%= newBusinessProcessManager.getCustomer().getId()%>
                                                <br>
                                                <span><%= newBusinessProcessManager.getCustomer().getFirstName() + " " + newBusinessProcessManager.getCustomer().getLastName()%></span>
                                                <br>
                                                <%= newBusinessProcessManager.getCustomer().getAddress()%></p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">                    
                                    <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                        <div class="mdl-card__title_info mdl-card--expand">
                                            <h3 class="mdl-card__title_home-text">Vehicle Information</h3>
                                        </div>

                                        <div style="padding: 20px;"  mdl-card--expand>
                                            <p>Vehicle Make:   <%= newBusinessProcessManager.getVehicle(newBusinessProcessManager.getVehicleQuote(AutoQuoteID).getProperty().getVehicleId()).getMake()%></p>
                                            <p>Vehicle Model:   <%= newBusinessProcessManager.getVehicle(newBusinessProcessManager.getVehicleQuote(AutoQuoteID).getProperty().getVehicleId()).getModel()%></p>
                                            <p>Vehicle Year:   <%= newBusinessProcessManager.getVehicle(newBusinessProcessManager.getVehicleQuote(AutoQuoteID).getProperty().getVehicleId()).getYear()%></p>
                                        </div>
                                    </div></div>
                                <div class="col-sm-4">
                                    <form class="form-horizontal" action="CreateAutoPolicyServlet">
                                        <div class="form-group">

                                            <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                                <div class="mdl-card__title_info mdl-card--expand">
                                                    <h3 class="mdl-card__title_home-text">Auto Quote Information</h3>
                                                </div>
                                                <br><br>
                                                <b style="padding: 10px;">Yearly Premium: <%= newBusinessProcessManager.getVehicleQuote(AutoQuoteID).getTotalPremium()%></b>
                                                <div class="mdl-card__actions mdl-card--border">
                                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">Create Account</button> 
                                                </div>
                                                </form>

                                            </div>

                                        </div>
                                </div>


                            </div>
                        </fieldset>
                    </div>
                </div>
            </form>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.easing.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="contactform/contactform.js"></script>
    </body>
    <style>
        footer { position:absolute; bottom:0;width:100%}
        fieldset.for-panel {
            background-color: #fcfcfc;
            border: 1px solid #999;
            border-radius: 4px;	
            padding:15px 10px;
            background-color: #d9edf7;
            border-color: #bce8f1;
            background-color: #f9fdfd;
            margin-bottom:12px;
        }
        fieldset.for-panel legend {
            background-color: #fafafa;
            border: 1px solid #ddd;
            border-radius: 5px;
            color: #4381ba;
            font-size: 14px;
            font-weight: bold;
            line-height: 10px;
            margin: inherit;
            padding: 7px;
            width: auto;
            background-color: #d9edf7;
            margin-bottom: 0;
        }
        input {
            display: block; /* add this */
            width: 250px;
            padding: 5px;
            -webkit-box-sizing: border-box; /* Safari/Chrome, other WebKit */
            -moz-box-sizing: border-box;    /* Firefox, other Gecko */
            box-sizing: border-box;         /* Opera/IE 8+ */
        }
    </style>
        <!-- Square card -->
    <style>
        .demo-card-square.mdl-card {
            width: 320px;
            height: 270px;
        }
        .demo-card-square > .mdl-card__title_auto {
            color: #fff;
            background:
                url('https://img.clipartfest.com/e93053963be276dec149592341d14d87_car-back-red-icon-back-of-car-clipart-png_256-256.png') center no-repeat #42A5F5;
        }
        .demo-card-square > .mdl-card__title_home {
            color: #fff;
            background:
                url('http://findicons.com/files/icons/776/chakram_2/128/home.png') center no-repeat #42A5F5;
        }
        .demo-card-square > .mdl-card__title_info {
            color: #fff;
            text-align: center;
            background:
                center no-repeat #42A5F5;
        }
    </style>
</html>
