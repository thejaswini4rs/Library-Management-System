<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Student Login</title>
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

        <script>
            function validate()
            {
                var nm = document.forms["myForm"]["aname"].value;
                var pw = document.forms["myForm"]["apswd"].value;

                if (nm == "" || nm == null)
                {
                    alert("Name is mandatory feild");
                    return false;
                }

                if (pw == "" || pw == null)
                {
                    alert("Password is mandatory feild");
                    return false;
                }

            }
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
            <h2>USER</h2>
        </div>
        <!-- //about-heading -->
        <div class="registration">
            <div class="container">
                <div class="signin-form profile">
                    <div class="login-page">
                        <div class="form">
                            <form class="login-form" action="admin" name="myForm" method="post">
                                <h3>Login</h3>
                                <input type="text" name="uname" placeholder="User Name">
                                <input type="password" name="pswd" placeholder="Password">
                                <div class="tp">
                                    <input type="submit" name="login" value="LOGIN NOW">
                                </div>                                                                
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
    </body>	
</html>