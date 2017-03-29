<%-- 
    Document   : viewHomeQuote
    Created on : Mar 27, 2017, 10:05:45 PM
    Author     : tim
--%>

<%@page import="BEANS.InfoObjects.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>View Home Quote</title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" href="css/form-basic.css"> 

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
        <% Customer currentClient = (Customer) (session.getAttribute("currentSessionClient"));%>
        <% String name = (String) session.getAttribute("currentsessionHomeQuote");%>
        <form class="form-horizontal" action="CreateHomePolicyServlet">
            <div class="form-group">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">

                            <h3>Customer Information</h3>
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
                            <h3>Home Quote Information:</h3>
                            <p><%=name%></p>

                        </div>
                        <div class="form-group">
                            <label class="col-xs-5 control-label"></label>
                            <button style="float: center;" class="btn btn-primary" type="submit">Accept Home Policy</button>
                        </div>
                    </div>
                </div>
            </div>

        </form>

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
</html>
