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
                    <li><a href="userprofile.jsp">My Policies</a></li>
                    <li><a href="#team">File a Claim</a></li>
                    <li><a href="#testimonial">Get a Quote</a></li>
                    <li><a href="#contact">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <body style="padding-top: 50px;">

        <div class="container">
            <div class="featured-content">
                <div class="block">        
                    <form class="form-basic" method="post" action="#">

                        <div class="form-title-row">
                            <h1>Home Quote</h1>
                        </div>

                        <div class="form-row">
                            <label>
                                <span>Year Built</span>
                                <input type="text" name="yearBuilt">
                            </label>
                        </div>

                        <div class="form-row">
                            <label>
                                <span>Building Type</span>
                                <select name="dropdown">
                                    <option>Bungalow</option>
                                    <option>Attached</option>
                                    <option>Semi-attached</option>
                                    <option>Other</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-row">
                            <label>
                                <span>Heating Source</span>
                                <select name="dropdown">
                                    <option>Electric</option>
                                    <option>Oil</option>
                                    <option>Wood</option>
                                    <option>Other</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-row">
                            <label>
                                <span>Replacement Cost</span>
                                <input type="text" name="replacementCost">
                            </label>
                        </div>
                        <div class="form-row">
                            <label>
                                <span>Liability limit</span>
                                <select name="dropdown">
                                    <option>$1,000,000</option>
                                    <option>$2,000,000</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-row">
                            <label>
                                <span>Liability Deductible</span>
                                <select name="dropdown">
                                    <option>$500</option>
                                    <option>$1,000</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-row">
                            <label>
                                <span>Contents limit</span>
                                <select name="dropdown">
                                    <option>$1,000</option>
                                    <option>$2,000</option>
                                </select>
                            </label>
                        </div>
                        <div class="form-row">
                            <label>
                                <span>Contents Deductible</span>
                                <select name="dropdown">
                                    <option>$500</option>
                                    <option>$1,000</option>
                                </select>
                            </label>
                        </div>                                 
                        <div class="form-row">
                            <button type="submit" style="color:white;">Submit Form</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>

        <div class="footer-wrapper">
            <div class="copy-rights">
                <div class="container">
                    <div class="row">
                    </div>
                </div>
            </div>
        </div>




        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/modernizr-2.6.2-respond-1.1.0.min.js"></script>


    </body>

</html>

