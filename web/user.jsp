<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Library Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Hosting City Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- bootstrap-css -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--// bootstrap-css -->
        <!-- css -->
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
        <!--// css -->
        <!-- font-awesome icons -->
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
        <!-- //font -->
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/SmoothScroll.min.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>

        <style>
            .form .register-form {
                display: none;
            }
        </style>
    </head>
    <body>

        <%@include file="loginheader.jsp" %>
        <!-- about-heading -->
        <div class="about-heading">
            <marquee style="color: greenyellow;font-size: 25px;">LIBRARY MANAGEMENT SYSTEM</marquee>
        </div>
        <!-- //about-heading -->
        <div class="registration">
            <div class="container">
                <div class="signin-form profile">
                    <div class="login-page">
                        <div class="form">
                            <form class="login-form" action="userLogin" name="myForm" method="post">
                                <h3>Login</h3>
                                <input type="text" id="uemail" name="uemail" placeholder="E-mail">
                                <input type="password" id="upass" name="upass" placeholder="Password">                                
                                <div class="tp">
                                    <input type="submit" value="LOGIN NOW">
                                </div>
                                <br>
                                <p class="message">Not registered? <a href="#"> Create an account </a></p>
                            </form>                            


                            <form class="register-form" action="userReg" method="post" enctype="multipart/form-data">
                                <h3>Registration</h3>
                                <input type="text" id="uname" name="uname" placeholder="Name" required="">
                                <input type="text" id="uemail" name="uemail" placeholder="E-mail" required="">
                                <input type="password" id="upass" name="upass" placeholder="Password" required="">                            
<!--                                <input type="text" id="udob" name="udob" placeholder="DOB" required="">                                -->
                                <input type="text" id="umob" name="umob" placeholder="Mobile" required="">
                                <input type="text" id="uplace" name="uplace" placeholder="Place" required="">
                                <input type="text" id="upin" name="upin" placeholder="Pin Code" required="">
                                <input type="file" name="file" id="file" required="">
                                <div class="tp">
                                    <input type="submit" value="Register NOW">
                                </div>
                                <br>
                                <p class="message">Already registered? <a href="#">Sign In</a></p>
                            </form>


                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- footer -->
        <div class="footer">
            <div class="container">

            </div>
            <div class="copyright">
                <p>Design by : <a href="http://w3layouts.com"><span style="color: orange">College Name</span></a></p>
            </div>
        </div>
        <!-- //footer -->
        <script type="text/javascript" src="js/move-top.js"></script>
        <script type="text/javascript" src="js/easing.js"></script>
        <!-- here stars scrolling icon -->
        <script type="text/javascript">
                                $(document).ready(function () {
                                    /*
                                     var defaults = {
                                     containerID: 'toTop', // fading element id
                                     containerHoverID: 'toTopHover', // fading element hover id
                                     scrollSpeed: 1200,
                                     easingType: 'linear' 
                                     };
                                     */

                                    $().UItoTop({easingType: 'easeOutQuart'});

                                });
        </script>
        <!-- //here ends scrolling icon -->
        <script>
            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });
        </script>
    </body>	
</html>