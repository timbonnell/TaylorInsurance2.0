<%-- 
    Document   : autoQuote
    Created on : Mar 23, 2017, 4:58:04 PM
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
          <div>
              <h1>Auto Quote</h1>
          </div> 
          <div>
          <div class="form-row">
              <h3 id="auto">Automobile</h3>       
                <div class="form-row">
                <label>
                    <span>Make</span>
                    <input type="text" name="make">
                </label>
                </div>
                <div class="form-row">
                <label>
                    <span>Model </span>
                    <input type="text" name="model">
                </label>
                </div>  
                <div class="form-row">
                <label>
                    <span>Year</span>
                    <input type="text" name="year">
                </label>
          </div>
        </div>  
        </div>              
        <div>  
            <div class="form-row">
              <h3 id="driver">Driver</h3>
            <br />
            <div class="form-row">
                <label>
                    <span>Age</span>
                    <input type="text" name="age">
                </label>
            </div> 
            <div class="form-row">
                <label>
                    <span>Number of Accidents </span>
                    <input type="text" name="accidents">
                </label>
            </div> 
            <div class="form-row">
                <label>
                    <span>Address</span>
                    <input type="text" name="Address">
                </label>
          </div>    
      </div>
        
          <div class="form-row">
              
            <button type="submit" style="color:white;align:center;">Submit Form</button>
          </div>  
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
