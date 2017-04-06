<%-- 
    Document   : index
    Created on : Mar 22, 2017, 7:47:17 PM
    Author     : tim
--%>
<%session.invalidate();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Taylor Insurance</title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Open+Sans|Candal|Alegreya+Sans">
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/imagehover.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <!--Navigation bar-->
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    </button>
                    <img src="img/logo.png" alt="" HEIGHT="70" WIDTH="70" BORDER="0"/><a class="navbar-brand" href="index.jsp">Taylor<span>Insurance</span></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#feature">Our Services</a></li>
                        <li><a href="#team">Our Team</a></li>
                        <li><a href="#testimonial">Testimonials</a></li>
                        <li><a href="ContactUs.jsp">Contact Us</a></li>
                        <li class="btn-trial"><a href="" data-target="#login" data-toggle="modal">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!--/ Navigation bar-->
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
        <!--Banner-->
        <div class="banner">
            <div class="bg-color">
                <div class="container">
                    <div class="row">
                        <div class="banner-text text-center">
                            <div class="text-border">
                                <h2 class="text-dec">Small Town Customer Service</h2>
                            </div>
                            <div class="intro-para text-center quote">
                                <p class="big-text">A Business of Caring</p>
                                <p class="small-text">We are a new company, but we're growing quickly.<br>We currently have over a thousand customers and climbing.</p>
                                <a href="homeQuote.jsp"  class="btn">GET A HOME QUOTE</a>
                                <a href="autoQuote.jsp"  class="btn">GET AN AUTO QUOTE</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--/ Banner-->

        <!--Modal box 2-->
        <div class="modal fade" id="quote" role="dialog">
            <div class="modal-dialog modal-sm">

                <!-- Modal content no 2-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" href="homeQuote.jsp">&times;</button>
                        <h4 class="modal-title text-center form-title">Get a Home Quote</h4>
                    </div>
                    <div class="modal-header">
                        <button type="button" href="autoQuote.jsp">&times;</button>
                        <h4 class="modal-title text-center form-title">Get an Auto Quote</h4>
                    </div>
                    <div class="modal-body padtrbl">



                        <!--
                        <form class="form-signin" action="" method="POST">
                            <span id="reauth-email" class="reauth-email"></span>
                            <p class="input_title">Email</p>
                            <input type="text" name="inputEmail" id="inputEmail" class="login_box" placeholder="Email" required autofocus>
                            <p class="input_title">Password</p>
                            <input type="password" name="inputPassword" id="password" class="login_box" placeholder="******" required>
                            <p class="input_title">Confirm Password</p>
                            <input type="password" name="inputPassword" id="confirm_password" class="login_box" placeholder="******" required>
                            <div id="remember" class="checkbox">
                                <label>

                                </label>
                            </div>
                            <button class="btn btn-lg btn-primary" type="submit">Submit</button>
                        </form> /form -->


                    </div>
                </div>

            </div>
        </div>
        <!--/ Modal box-->



        <!---/ Services -->
        <section id ="feature" class="section-padding">
            <div class="container">
                <div class="row">
                    <div class="header-section text-center">
                        <h2>Our Services</h2>
                        <p>Insurance services that we provide</p>
                        <hr class="bottom-line">
                    </div>
                    <div class="feature-info">
                        <div class="fea">
                            <div class="col-md-4">
                                <div class="heading pull-right">
                                    <h4>Auto Insurance</h4>
                                    <p>Insure your vehicle to protect your livelihood in case of accidents.</p>
                                </div>
                                <div class="fea-img pull-left">
                                    <i class="fa fa-car"></i>
                                </div>
                            </div>
                        </div>
                        <div class="fea">
                            <div class="col-md-4">
                                <div class="heading pull-right">
                                    <h4>Home Insurance</h4>
                                    <p>Insure your Home to protect your livelihood in case of accidents.</p>
                                </div>
                                <div class="fea-img pull-left">
                                    <i class="fa fa-home"></i>
                                </div>
                            </div>
                        </div>
                        <div class="fea">
                            <div class="col-md-4">
                                <div class="heading pull-right">
                                    <h4>Customer Service</h4>
                                    <p>Contact us with any problems with our website or a quote; we are available 24/7!</p>
                                </div>
                                <div class="fea-img pull-left">
                                    <i class="fa fa-trophy"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--/ Services-->


        <!--Our Team-->
        <section id="team" class="section-padding">
            <div class="container">
                <div class="row">
                    <div class="header-section text-center">
                        <h2>Meet Our Team</h2>
                        <p>We have a team of specialists that are determined to provide you the best service possible.</p>
                        <hr class="bottom-line">
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="pm-staff-profile-container" >
                            <div class="pm-staff-profile-image-wrapper text-center">
                                <div class="pm-staff-profile-image">
                                    <img src="img/mentor.jpg" alt="" class="img-thumbnail img-circle" />
                                </div>   
                            </div>                                
                            <div class="pm-staff-profile-details text-center">  
                                <p class="pm-staff-profile-name">Josh Taylor</p>
                                <p class="pm-staff-profile-title">CEO/Owner</p>

                                <p class="pm-staff-profile-bio">Our CEO is Josh Taylor, a new business manager who is determined to see Taylor Insurance succeed.</p>
                            </div>     
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="pm-staff-profile-container" >
                            <div class="pm-staff-profile-image-wrapper text-center">
                                <div class="pm-staff-profile-image">
                                    <img src="img/mentor1.jpg" alt="" class="img-thumbnail img-circle" />
                                </div>   
                            </div>                                
                            <div class="pm-staff-profile-details text-center">  
                                <p class="pm-staff-profile-name">Brent Furlong</p>
                                <p class="pm-staff-profile-title">President</p>

                                <p class="pm-staff-profile-bio">Brent Furlong is the President of Taylor Insurance and oversees all changes the company goes through.</p>
                            </div>     
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-4">
                        <div class="pm-staff-profile-container" >
                            <div class="pm-staff-profile-image-wrapper text-center">
                                <div class="pm-staff-profile-image">
                                    <img src="img/mentor2.jpg" alt="" class="img-thumbnail img-circle" />
                                </div>   
                            </div>                                
                            <div class="pm-staff-profile-details text-center">  
                                <p class="pm-staff-profile-name">Tim Bonnell</p>
                                <p class="pm-staff-profile-title">Vice President </p>

                                <p class="pm-staff-profile-bio">Tim Bonnell keeps everything on track at Taylor Insurance as the Vice President.</p>
                            </div>     
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--/ team-->

        <!--Testimonial-->
        <section id="testimonial" class="section-padding">
            <div class="container">
                <div class="row">
                    <div class="header-section text-center">
                        <h2 class="white">See What Our Customer Are Saying?</h2>
                        <p class="white">Check out some responses we have received from loyal customers.</p>
                        <hr class="bottom-line bg-white">
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="text-comment">
                            <p class="text-par">"I have been very impressed by the work of Taylor Insurance,<br>they have been both very professional and effective."</p>
                            <p class="text-name">John Doe</p>
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="text-comment">
                            <p class="text-par">"Their prices are very fair and their employees are hard-working."</p>
                            <p class="text-name">Mary Sue</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--/ Testimonial-->

       
        <!--Footer-->
        <footer id="footer" class="footer">
            <div class="container text-center">


                <ul class="social-links">
                    <li><a href="#link"><i class="fa fa-twitter fa-fw"></i></a></li>
                    <li><a href="#link"><i class="fa fa-facebook fa-fw"></i></a></li>
                    <li><a href="#link"><i class="fa fa-google-plus fa-fw"></i></a></li>
                    <li><a href="#link"><i class="fa fa-dribbble fa-fw"></i></a></li>
                    <li><a href="#link"><i class="fa fa-linkedin fa-fw"></i></a></li>
                </ul>
                ©2017 Taylor Insurance
            </div>
        </footer>
        <!--/ Footer-->

        <script src="js/jquery.min.js"></script>
        <script src="js/jquery.easing.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="contactform/contactform.js"></script>
        <script>
            var password = document.getElementById("password")
                    , confirm_password = document.getElementById("confirm_password");

            function validatePassword() {
                if (password.value != confirm_password.value) {
                    confirm_password.setCustomValidity("Passwords Don't Match");
                } else {
                    confirm_password.setCustomValidity('');
                }
            }

            password.onchange = validatePassword;
            confirm_password.onkeyup = validatePassword;
        </script>
    </body>
</html>
