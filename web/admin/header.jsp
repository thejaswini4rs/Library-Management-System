
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hosting City a Hosting Category Flat Bootstrap responsive Website Template | Home :: w3layouts</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Hosting City Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- bootstrap-css -->
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--// bootstrap-css -->
        <!-- css -->
        <link rel="stylesheet" href="../css/style.css" type="text/css" media="all" />
        <!--// css -->
        <!-- font-awesome icons -->
        <link href="../css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>
        <!-- //font -->
        <script src="../js/jquery-1.11.1.min.js"></script>
        <script src="../js/bootstrap.js"></script>
        <script src="../js/SmoothScroll.min.js"></script>
        <script type="text/javascript">
            jQuery(document).ready(function ($) {
                $(".scroll").click(function (event) {
                    event.preventDefault();
                    $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                });
            });
        </script>
        <link href='../css/immersive-slider.css' rel='stylesheet' type='text/css'>
        <!-- pricing -->
        <link rel="stylesheet" href="../css/jquery.flipster.css">
        <!-- //pricing -->
    </head>
    <body>
        <div class="header-top">
            <div class="container">
                
                
                <div class="clearfix"> </div>
            </div>
        </div>
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
                            <h1><a href="adminHome.jsp"> <span>LIBRARY MANAGEMENT SYSTEM</span></a></h1>
                        </div>
                    </div>
                    <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                        <nav>
                            <ul class="nav navbar-nav">
                                <li><a href="adminHome.jsp" class="hvr-sweep-to-bottom">Home</a></li>
                                <li><a href="#" class="dropdown-toggle hvr-sweep-to-bottom" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Library<span class="caret"></span></a>
                                    <ul class="dropdown-menu">                                         
                                        <li><a class="hvr-sweep-to-bottom" href="addLib.jsp">Add Library</a></li> 
                                    </ul>
                                </li>                                
                                
                                <li><a href="viewReq.jsp" class="hvr-sweep-to-bottom">Requests</a></li>
                                
                                <li><a href="../index.jsp" class="hvr-sweep-to-bottom">Logout</a></li>

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

            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#immersive_slider").immersive_slider({
                    container: ".main"
                });
            });

        </script>