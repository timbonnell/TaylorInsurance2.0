<%-- 
    Document   : homeQuote
    Created on : Mar 23, 2017, 4:26:00 PM
    Author     : timbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Home Quote</title>


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
                    <li class="btn-trial"><a href="" data-target="#login" data-toggle="modal">Login</a></li>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="homeQuote.jsp">Get a Home Quote</a></li>
                    <li><a href="autoQuote.jsp">Get an Auto Quote</a></li>
                    <li><a href="ContactUs.jsp">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!--End Nav -->
    <!--Modal box-->
    <div class="modal fade" id="login" role="dialog">
        <div class="modal-dialog modal-sm">

            <!-- Modal content no 1-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title text-center form-title">Login</h4>
                </div>
                <div class="modal-body padtrbl">

                    <form class="form-signin" action="LoginServlet">
                        <span id="reauth-email" class="reauth-email"></span>
                        <p class="input_title">Email</p>
                        <input type="text" name="inputEmail" id="inputEmail" class="login_box" placeholder="Email" required autofocus>
                        <p class="input_title">Password</p>
                        <input type="password" name="inputPassword" id="inputPassword" class="login_box" placeholder="******" required>

                        <button class="btn btn-lg btn-primary" type="submit">Login</button>
                    </form><!-- /form -->

                </div>
            </div>

        </div>
    </div>
    <!--/ Modal box-->
    <body style="padding-top: 150px;">

        <div class="container">
            <div class="row">

            </div>
            <form class="form-horizontal" action="HomeQuoteServlet">
                <div class="form-group">
                    <div class="row">
                        <fieldset class="for-panel">
                            <legend>Home Quote</legend>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-horizontal">               
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">First Name: </label>
                                            <input class="form-control-static" name="firstName" type="text" required>     
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Last Name: </label> 
                                            <input class="form-control-static" name="lastName" type="text" required> 
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Email: </label>
                                            <input class="form-control-static" name="email" type="email" required>               
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Phone Number: </label>
                                            <input class="form-control-static" name="phone" type="tel" required>               
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Street Address: </label>
                                            <input class="form-control-static" name="address" type="text" required> 
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">City: </label>
                                            <input class="form-control-static" name="city" type="text" required>   
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Date of Birth: </label>
                                            <input class="form-control-static" type="date" name="dateofbirth" required> 
                                        </div>

                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-horizontal">               
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Province: </label>
                                            <select class="col-xs-5 control-label" name="province" required>
                                                <option Value="10">NL</option>
                                            </select>   
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Country: </label>
                                            <select class="col-xs-5 control-label" name="country" required>
                                                <option value="CAN">Canada</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Postal Code: </label>
                                            <input class="form-control-static" name="postal" type="text" required> 
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Year Built: </label>
                                            <input class="form-control-static" name="yearBuilt" type="text" required>     
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Building Type: </label> 
                                            <select class="col-xs-5 control-label" name="building" required>
                                                <option value="21">Bungalow</option>
                                                <option value="22">Attached</option>
                                                <option value="23">Semi-attached</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Heating Source: </label>
                                            <select class="col-xs-5 control-label" name="heatsource" required>
                                                <option value="24">Electric</option>
                                                <option value="25">Oil</option>
                                                <option value="26">Wood</option>
                                            </select>             
                                        </div>

                                        <div class="form-group">
                                            <label class="col-xs-5 control-label"></label>
                                            <button style="float: center;" class="btn btn-primary" type="submit">Submit Home Quote</button>
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
        body {
            padding:10px;
            padding-bottom:60px;   /* Height of the footer */
        }
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

