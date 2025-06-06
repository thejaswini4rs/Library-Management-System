
<!DOCTYPE html>
<head>
    <!-- Meta Tags -->
    <meta charset="utf-8">
    <title>Library Management System</title>
    <meta name="description" content="">
    <meta name="author" content="iSeada.com">
    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=0">
    <!-- Main Stylesheet -->
    <link rel="stylesheet" href="../style.css">
    <!-- Responsiveness -->
    <link rel="stylesheet" href="../assets/css/responsive.css">
    <!-- FAV & Touch Icons -->
    <link href="../assets/css/table.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="../assets/img/icons/favicon.ico">
    <link rel="apple-touch-icon" href="../assets/img/icons/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="../assets/img/icons/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="../assets/img/icons/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="144x144" href="../assets/img/icons/apple-touch-icon-144x144.png">
    <!--[if lt IE 9]>
        <script src="//html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <script>window.html5 || document.write('<script src="assets/js/vendor/html5shiv.js"><\/script>')</script>
    <![endif]-->
    <style>
        .profileset {
            font-weight: bold !important;
            text-align: justify !important;
            margin-left: 20% !important;
            margin-bottom: 3% !important;
        }
    </style>
</head>
<body>
    <div id="entire">
        <div class="loader"></div>

        <%@include file="header.jsp"%>

        <div class="clearfix"></div>

        <article class="instructors-section instructors-page">
            <div class="row">              
                <div class="datagrid">
                    <%
                        String id = request.getParameter("id");
                        String txt = request.getParameter("txt");
                    %>
                    <form action="<%=id%>.jsp" method="post">
                        <center><b style="font-size: 20px;color: green;">Confirmation</b></center>
                        <center>
                            <table style="font-size: 20px">
                                <tr>
                                    <td> &nbsp; </td>
                                </tr>
                                <tr>
                                    <td style="color: #000000;text-align: center"><%=txt%> successfully....!</td>
                                </tr>
                                <tr>
                                    <td> &nbsp; </td>
                                </tr>
                                <tr>
                                    <td style="color: #000000;text-align: center">Press continue...</td>
                                </tr>
                                <tr>
                                    <td> &nbsp;</td>
                                </tr>
                                <tr>
                                    <td><input style="color: maroon; cursor: pointer; padding-bottom: 4%;padding-top: 4%;width: 200px;font-size: 15px;margin-bottom: 30%;" type="submit" class="myButton" style="padding:8px 29px" value="Continue.."/> <br></td>
                                </tr>
                            </table>
                        </center>                        
                    </form>
                </div>

            </div>
        </article>      


    </div><!-- End Entire Wrap -->

    <!-- jQuery -->
    <script src="../assets/js/vendor/jquery.min.js" type="text/javascript"></script>
    <!-- Plugins -->
    <script src="../assets/js/bsmodal.min.js"></script>
    <script src="../assets/js/jquery.countdown.min.js"></script>
    <script src="../assets/js/jquery.easydropdown.min.js"></script>
    <script src="../assets/js/jquery.flexslider-min.js"></script>
    <script src="../assets/js/jquery.isotope.min.js"></script>
    <script src="../assets/js/jquery.themepunch.tools.min.js"></script>
    <script src="../assets/js/jquery.themepunch.revolution.min.js"></script>
    <script src="../assets/js/jquery.viewportchecker.min.js"></script>
    <script src="../assets/js/jquery.waypoints.min.js"></script>
    <script src="../assets/js/scripts.js"></script>

    <script>
                                function getLibrarin(libid) {                                   

                                    $.ajax({
                                        url: "../getLibDetailsById",
                                        type: 'POST',
                                        data: {id: libid},
                                        dataType: 'json',
                                        success: function (data) {                                             
                                            var detayledorder = data.order;
                                            var d = $.parseJSON(detayledorder);
                                            var ele = "";
                                            
                                            $("#profile").empty();
                                             $.each(d, function (idx, obj){                                               
                                                
                                                ele = '<div class="col-md-4 col-sm-12">'+
                                                      '<img src="../ProfileImages/'+obj.pic+'" width="200" height="200" alt=""/>'+
                                                      '</div>'+                                                       
                                                      
                                                      '<div class="col-md-8 col-sm-12">'+
                                                      '<h4 class="profileset">Name : <span>'+obj.name+'</span></h4>'+
                                                      '<h4 class="profileset">DOB : <span>'+obj.dob+'</span></h4>'+
                                                      '<h4 class="profileset">Email : <span>'+obj.email+'</span></h4>'+
                                                      '<h4 class="profileset">Mobile : <span>'+obj.mob+'</span></h4>'+
                                                      '<h4 class="profileset">Place : <span>'+obj.place+'</span></h4>'+
                                                      '</div>';
                                             });
                                             $("#profile").append(ele);
                                        }
                                    });
                                }
    </script>

    <%@include file="footer.jsp"%>