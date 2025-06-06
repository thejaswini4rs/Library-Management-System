<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DBUtils.DBsingletone"%>
<%@include file="header.jsp" %>
<!--<h2><marquee></marquee></h2>-->
<link href="../css/table.css" rel="stylesheet" type="text/css"/>

<style>
    .profileset {
        font-weight: bold !important;
        text-align: justify !important;
        margin-left: 20% !important;
        margin-bottom: 3% !important;
    }
</style>

<!-- choose -->
<div class="choose jarallax">
    <div class="w3-agile-testimonial">
        <div class="container">
            <div class="w3-agileits-choose">
                <div class="col-md-12 choose-grid">
                    <div class="w3-banner-bottom-heading choose-heading">
                        <marquee style="color: greenyellow;font-size: 25px;">LIBRARY MANAGEMENT SYSTEM</marquee>
                        <center><h3>Librarians<span> Requests</span></h3></center>
                    </div>
                    <div class="top-choose-info">

                        <%@include file="profileView123.jsp"%>

                        <div class="datagrid">
                            <table>
                                <thead><tr><th>SL. No</th><th>Name</th><th>Email</th><th colspan="3"><center>Actions</center></th></tr></thead>

                                <%  int count = 1;

                                    DBsingletone dbs = DBsingletone.getDbSingletone();
                                    Connection con = dbs.getConnection();
                                    PreparedStatement psmt = con.prepareStatement("select * from librarian where isActive=0 and isRej=0");
                                    ResultSet rs = psmt.executeQuery();
                                    while (rs.next()) {
                                        String librnid = rs.getString("lid");
                                %>

                                <tbody>
                                    <tr><td><%=count++%></td><td><%=rs.getString("name")%></td><td><%=rs.getString("email")%></td><td><a href="#" data-toggle="modal" data-target="#myModal"><center><button onclick="getLibrarin(<%=librnid%>)">Details</button></center></a></td><td><a href="acceptLibrian.jsp?id=<%=librnid%>"><button>Accept</button></center></a></td><td><a href="#"><center><button onclick="delLibrn(<%=librnid%>)">Reject</button></center></a></td></tr>
                                    <tr class="alt"><td></td><td></td><td></td><td></td><td></td><td></td></tr>  
                                            <%                        }
                                            %>  
                                </tbody>
                            </table>
                        </div>                       

                    </div>
                </div>

                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
</div>
<!-- //choose -->
<script>
    function getLibrarin(librnid) {

        $.ajax({
            url: "../getLibDetailsById",
            type: 'POST',
            data: {id: librnid},
            dataType: 'json',
            success: function (data) {
                var detayledorder = data.order;
                var d = $.parseJSON(detayledorder);
                var ele = "";

                $("#librnprofile").empty();
                $.each(d, function (idx, obj) {

                    ele = '<div class="col-md-4 col-sm-12">' +
                            '<img src="../LibrnImgs/' + obj.pic + '" width="200" height="200" alt=""/>' +
                            '</div>' +
                            '<div class="col-md-8 col-sm-12">' +
                            '<h4 class="profileset">Name : <span>' + obj.name + '</span></h4>' +
                            '<h4 class="profileset">Email: <span>' + obj.email + '</span></h4>' +
                            '<h4 class="profileset">Mobile : <span>' + obj.mob + '</span></h4>' +
                            '<h4 class="profileset">Place : <span>' + obj.place + '</span></h4>' +
                            '</div>';
                });
                $("#librnprofile").append(ele);
            }
        });
    }

    function delLibrn(librnid) {
        var res = confirm("Are you sure you want to delete!!");
        if (res) {
            $.ajax({
                url: "../delLibrn",
                type: 'POST',
                data: {librnid: librnid},
                dataType: 'json',
                success: function (data) {
                    if (data == true) {
                        alert("Deleted Successfully...");
                        window.location.reload();
                    }
                }
            });
        }
    }
</script>
<!-- footer -->
<%@include file="footer.jsp" %>