<%@page import="java.sql.Connection"%>
<%@page import="com.DBUtils.DBsingletone"%>
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
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!--// bootstrap-css -->
        <!-- css -->
        <link rel="stylesheet" href="../css/style.css" type="text/css" media="all" />
        <link href="../css/table.css" rel="stylesheet" type="text/css"/>
        <!--// css -->
        <!-- font-awesome icons -->
        <link href="../css/font-awesome.css" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- font -->
        <link href="//fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700italic,700,400italic,300italic,300' rel='stylesheet' type='text/css'>

        <style>
            .signin-form {
                width: 80% !important;
            }
            .btninpt {
                outline: none;
                padding: 0.9em 0;
                width: 100%;
                text-align: center;
                font-size: 1em;
                margin-top: 1em;
                border: none;
                color: #FFFFFF;
                cursor: pointer;
                background: #86c724;
                box-shadow: 0px 2px 1px rgba(28, 28, 29, 0.42);
                border-radius: 22px;
            }
        </style>
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
    </head>
    <body>

        <%@include file="libheader.jsp" %>
        <!-- about-heading -->
        <div class="about-heading">
            <h2>USER</h2>
        </div>
        <!-- //about-heading -->
        <div class="registration">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="signin-form profile">
                            <div class="login-page">
                                <div>                                    
                                    <h3>Add Library</h3>
                                    <input type="text" id="libcode" name="libcode" placeholder="Enter Library code">
                                    <input type="text" id="libname" name="libname" placeholder="Enter Library Name">
                                    <input type="text" id="area" name="area" placeholder="Area">
                                    <input type="text" id="city" name="city" placeholder="City">                                
                                    <div class="tp">
                                        <button class="libadd btninpt" onclick="addLib()" type="submit" name="login">ADD</button>
                                    </div>                              

                                    <div class="tp">
                                        <button class="libupdt btninpt" onclick="updateLib()">UPDATE</button>
                                    </div>                                     
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-6">
                        <center><h3><b>LIBRARY DETAILS</b></h3></center>
                        <div class="datagrid">
                            <%
                                DBsingletone dbs = DBsingletone.getDbSingletone();
                                Connection con = dbs.getConnection();
                            %>

                            <table id="resultdata">
                                <thead><tr><th>SL. No</th><th>Library Code</th><th>Library Name</th><th>Area</th><th>Place</th><th colspan="2">Action</th></tr></thead>
                                <!--<tfoot><tr><td colspan="4"><div id="paging"><ul><li><a href="#"><span>Previous</span></a></li><li><a href="#" class="active"><span>1</span></a></li><li><a href="#"><span>2</span></a></li><li><a href="#"><span>3</span></a></li><li><a href="#"><span>4</span></a></li><li><a href="#"><span>5</span></a></li><li><a href="#"><span>Next</span></a></li></ul></div></tr></tfoot>-->
                                <tbody>                            

                                </tbody>                                
                            </table>                
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
        <script type="text/javascript" src="../js/move-top.js"></script>
        <script type="text/javascript" src="../js/easing.js"></script>
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
            $(function () {
                getLibDetails();
                $(".libupdt").hide();
            });

            $('.message a').click(function () {
                $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
            });

            function addLib() {
                var libcode = $("#libcode").val();
                var libname = $("#libname").val();
                var area = $("#area").val();
                var place = $("#city").val();

                if (libcode == "") {
                    alert("Please Enter Library Code");
                } else if (libname == "") {
                    alert("Please Enter Library Name");
                } else if (area == "") {
                    alert("Please Enter Library Area");
                } else if (place == "") {
                    alert("Please Enter Library City");
                } else {
                    $.ajax({
                        url: "../addLib",
                        type: 'POST',
                        data: {libcode: libcode, libname: libname, area: area, place: place},
                        dataType: 'json',
                        success: function (data) {
                            if (data == true) {
                                alert("Library Added Successfully");
                                getLibDetails();
                            } else if (data == "false" || data == false) {
                                alert("Library Already Exists..!!");
                            }
                        }
                    });
                }
            }

            function getLibDetails() {
                $.ajax({
                    url: "../getLibryInfo",
                    type: 'POST',
                    dataType: 'json',
                    success: function (response) {
                        var data = response.libraries;
                        var d = $.parseJSON(data);
                        var ele = "";
                        var count = 1;
                        $("#resultdata tbody tr").empty();
                        $.each(d, function (idx, obj) {
                            ele += '<tr><td>' + count++ + '</td>' +
                                    '<td>' + obj.libcode + '</td>' +
                                    '<td>' + obj.name + '</td>' +
                                    '<td>' + obj.area + '</td>' +
                                    '<td>' + obj.place + '</td>' +
                                    '<td><center><a href="#" onclick=updateLibry("' + obj.libid + '");><img src="../images/update.jpg" width="30" height="30" alt="Update"></a></td>' +
                                    '<td><a href="#" onclick=deleteLibry("' + obj.libid + '");><img src="../images/delete.png" width="25" height="25" alt="Delete"></a></td>' +
                                    '</tr>' +
                                    '<tr class="alt"><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr> ';
                        });
                        $("#resultdata tbody").append(ele);
                    }
                });
            }

            function updateLibry(libid) {
//                alert("update: "+libid);
                window.localStorage.removeItem("libId");
                window.localStorage.setItem("libId", libid);
                $(".libupdt").show();
                $(".libadd").hide();
                $.ajax({
                    url: "../getLibryDetailsById",
                    type: 'POST',
                    data: {libid: libid},
                    dataType: 'json',
                    success: function (data) {
                        var response = data.libraries;
                        var d = $.parseJSON(response);
                        $.each(d, function (idx, obj) {
                            $("#libcode").val(obj.libcode);
                            $("#libname").val(obj.name);
                            $("#area").val(obj.area);
                            $("#city").val(obj.place);
                        });
                    }
                });
            }

            function updateLib() {
                var libcode = $("#libcode").val();
                var libname = $("#libname").val();
                var area = $("#area").val();
                var place = $("#city").val();
                var libid = window.localStorage.getItem("libId");

                if (libcode == "") {
                    alert("Please Enter Library Code");
                } else if (libname == "") {
                    alert("Please Enter Library Name");
                } else if (area == "") {
                    alert("Please Enter Library Area");
                } else if (place == "") {
                    alert("Please Enter Library City");
                } else {
                    $.ajax({
                        url: "../updateLibryById",
                        type: 'POST',
                        data: {libid: libid, libcode: libcode, libname: libname, area: area, place: place},
                        dataType: 'json',
                        success: function (data) {
                            if (data == true) {
                                alert("Library Updated Successfully");
                                getLibDetails();
                            } else {
                                alert("Library Update Failed");
                            }
                        }
                    });
                }


            }
            function deleteLibry(libid) {
                var res = confirm("Are you sure you want to delte!!");
                if (res) {
                    $.ajax({
                        url: "../delLibryById",
                        type: 'POST',
                        data: {libid: libid},
                        dataType: 'json',
                        success: function (data) {
                            if (data == true) {
                                alert("Library Deleted Successfully...");
                                getLibDetails();
                            }
                        }
                    });
                }
            }
        </script>
    </body>	
</html>