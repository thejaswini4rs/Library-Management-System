
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
        <link href='css/immersive-slider.css' rel='stylesheet' type='text/css'>
        <!-- pricing -->
        <link rel="stylesheet" href="css/jquery.flipster.css">
        <!-- //pricing -->
    </head>
    <body>
        <!-- header-top -->
        <div class="header-top">
            <div class="container">
                <div class="w3layouts-address">
                    <ul>
                        <li><i class="fa fa-mobile" aria-hidden="true"></i> +11 222 333 4444</li>
                        <li><i class="fa fa-envelope-o" aria-hidden="true"></i> <a href="mailto:info@example.com"> mail@example.com</a></li>
                    </ul>
                </div>
                <div class="agileinfo-social-grids">
                    <ul>
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-rss"></i></a></li>
                        <li><a href="#"><i class="fa fa-vk"></i></a></li>
                    </ul>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!-- //header-top -->
        <!-- header -->
        <div class="header">
            <div class="container">
                <nav class="navbar navbar-default">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <div class="w3layouts-logo">
                            <h1><a href="index.jsp"> <span>LIBRARY MANAGEMENT SYSTEM</span></a></h1>
                        </div>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                        <nav>
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="index.jsp">Home</a></li>
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ADMIN<span class="caret"></span></a>
                                    <ul class="dropdown-menu">                                         
                                        <li><a class="hvr-sweep-to-bottom" href="adminLogin.jsp">Login</a></li> 
                                    </ul>
                                </li>
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">LIBRARIAN<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="hvr-sweep-to-bottom" href="librarian.jsp">Login / Registration</a></li> 
                                        <!--<li><a class="hvr-sweep-to-bottom" href="librarian.jsp">Login</a></li>--> 
                                    </ul>
                                </li>
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">user<span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a class="hvr-sweep-to-bottom" href="user.jsp">Login / Registration</a></li> 
                                        <!--<li><a class="hvr-sweep-to-bottom" href="userForm.jsp">Login</a></li>--> 
                                    </ul>
                                </li>                                
                            </ul>
                        </nav>
                    </div>
                    <!-- /.navbar-collapse -->
                </nav>
            </div>
        </div>
        <!-- //header -->
        <!-- banner -->
        <div class="main">
            <div class="page_container">
                <div id="immersive_slider">
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib1.jpg" alt=""/>                            
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib2.jpg" alt=""/>  
                        </div>                        
                        <div class="clearfix"> </div>
                    </div>
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib3.jpg" alt=""/>  
                        </div>                        
                        <div class="clearfix"> </div>
                    </div>
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib4.jpg" alt=""/>  
                        </div>                        
                        <div class="clearfix"> </div>
                    </div>
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib5.jpg" alt=""/>  
                        </div>                        
                        <div class="clearfix"> </div>
                    </div>
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib6.jpg" alt=""/>  
                        </div>
                        
                        <div class="clearfix"> </div>
                    </div>
                    <div class="slide" data-blurred="">
                        <div class="col-md-12 image">
                            <img src="images/lib7.jpg" alt=""/>  
                        </div>
                        
                        <div class="clearfix"> </div>
                    </div>                    

                    <a href="#" class="is-prev">&laquo;</a>
                    <a href="#" class="is-next">&raquo;</a>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#immersive_slider").immersive_slider({
                    container: ".main"
                });
            });

        </script>