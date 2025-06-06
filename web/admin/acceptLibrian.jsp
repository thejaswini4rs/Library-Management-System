<%@include file="header.jsp" %>
<!--<h2><marquee></marquee></h2>-->

<style>
    .btninpt12{
        margin-left: 80px !important;
        margin-bottom: 14px !important;
        outline: none;
        /*                padding: 0.9em 0;*/
        width: 20%;
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
    .inpt{
        border-radius: 25px;
        margin-left: 10px;
        width: 300px;
        padding-left: 1%;
    }
    .inpt1{
        border-radius: 25px;
        margin-left: 10px;
        width: 60%;
        padding-left: 1%;
        outline: none;padding: 0.5%;
        
    }
</style>
<!-- choose -->
<div class="choose jarallax">
    <div class="w3-agile-testimonial">
        <div class="container">
            <%
                String librnid = request.getParameter("id");
            %>
            <div class="w3-agileits-choose">
                <div class="col-md-12 choose-grid">
                    <div class="w3-banner-bottom-heading choose-heading">
                        <marquee style="color: greenyellow;font-size: 25px;">LIBRARY MANAGEMENT SYSTEM</marquee>                        
                    </div>
                    <div class="w3-banner-bottom-heading choose-heading">
                        <center><h3>ACCEPT<span> LIBRARIAN</span></h3></center>
                    </div>
                    <div class="top-choose-info">
                        <div class="choose-info-top">
                            <div class="choose-left-grid col-sm-12">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="choose-info-grid ">
                                            <ul>
                                                <label style="color: white;">Choose Library</label>
                                                <!--                                        <li>Lorem ipsum</li>-->
                                                <select class="inpt1" id="libs" onchange="getLibcode()">
                                                    <option>--Select Library--</option>
                                                </select>
                                            </ul>                                            
                                        </div>
                                    </div>
                                    <div class="choose-info-grid">
                                        <ul>
                                            <label style="color: white;">Library Code</label>
                                            <!--                                        <li>Lorem ipsum</li>-->
                                            <input class="inpt" type="text" id="libcode" name="libcode" placeholder="Library Code" required="">
                                        </ul>                                        
                                    </div>
                                </div>                                                                
                            </div>                            
                            <div class="clearfix"> </div>

                            <center><input type="submit" onclick="assignLibrn(<%=librnid%>)" class="btninpt12" value="ASSIGN"></center>
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
    $(function () {
        getLibDetails();
    });

    function getLibDetails() {
//        $('#libs').empty();
        $.ajax({
            url: "../getAllLibraries",
            type: 'POST',
            dataType: 'json',
            success: function (response) {
                var data = response.libraries;
                var d = $.parseJSON(data);
                $.each(d, function (idx, obj) {
                    $('#libs').append($('<option>').text(obj.name).attr('value', obj.libid));
                });

            }
        });
    }

    function getLibcode() {
        var libryid = $("#libs").val();
        $.ajax({
            url: "../getLibcode",
            type: 'POST',
            data: {id: libryid},
            dataType: 'json',
            success: function (data) {
                $.each(data, function (idx, obj) {
                    $("#libcode").val(obj.libcode);
                });
            }
        });
    }

    function assignLibrn(librnid) {
        var libryid = $("#libs option:selected").val();
        var libcode = $("#libcode").val();

        $.ajax({
            url: "../assignLibrn",
            type: 'POST',
            data: {libryid: libryid, libcode: libcode, librnid: librnid},
            dataType: 'json',
            success: function (data) {
                alert(data);
                if (data == true) {
                    alert("Assigned Successfully");
                    window.location.reload();
                } else {
                    alert("Failed");
                }
            }

        });

    }
</script>
<!-- footer -->
<%@include file="footer.jsp" %>