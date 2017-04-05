<%-- 
    Document   : autoQuoteExisting
    Created on : Mar 30, 2017, 3:18:19 PM
    Author     : timbo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Auto Quote</title>
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
                    <li><a href="userprofile.jsp">Home</a></li>
                    <li><a href="homeQuoteExisting.jsp">Add Home Quote</a></li>
                    <li><a href="autoQuoteExisting.jsp">Add Auto Quote</a></li>
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
    <!--End Nav -->

    <body style="padding-top: 150px;">

        <div class="container">
            <div class="row">

            </div>
            <form class="form-horizontal" action="ExistingAutoQuoteServlet">
                <div class="form-group">
                    <div class="row">
                        <fieldset class="for-panel">
                            <legend>Auto Quote</legend>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="form-horizontal">               
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Make: </label> 
                                            <input class="form-control-static" name="make" type="text" required>   
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Model: </label> 
                                            <input class="form-control-static" name="model" type="text" required>   
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Year: </label>
                                            <input class="form-control-static" name="year" type="text" required>              
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Vehicle Type: </label>
                                            <select class="form-control-static" name="type" type="text" required>
                                                <option value="16">SEDAN</option>
                                                <option value="17">TRUCK</option>
                                                <option value="18">SUV</option>
                                                <option value="19">VAN</option>
                                                <option value="20">CROSSOVER</option>
                                            </select>    
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Date of Birth: </label>
                                            <input class="form-control-static" type="date" name="dateofbirth" required> 
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Color: </label>
                                            <select class="form-control-static" name="color" type="text" required>
                                                <option value="27">White</option>
                                                <option value="28">Silver</option>
                                                <option value="29">Black</option>
                                                <option value="30">Grey</option>
                                                <option value="31">Blue</option>
                                                <option value="32">Red</option>
                                                <option value="33">Brown</option>
                                                <option value="34">Green</option>
                                                <option value="35">Other</option>
                                            </select>    
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-6">
                                    <div class="form-horizontal">               
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">VIN: </label>
                                            <input class="form-control-static" name="vin" type="text" required>              
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label">Estimated Value: </label>
                                            <input class="form-control-static" name="estValue" type="text" required>              
                                        </div>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label"><p>Number of Accidents</p> (Last 5 Years) </label>
                                            <input class="form-control-static" name="accidents" required>   
                                        </div>

                                        <br><br><br>
                                        <div class="form-group">
                                            <label class="col-xs-5 control-label"></label>
                                            <button style="float: center;" class="btn btn-primary" type="submit">Submit Auto Quote</button>
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

</html>



