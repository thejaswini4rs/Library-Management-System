<div class="footer">
    <div class="container">

    </div>
    <div class="copyright">        
        <p>Design by : <a href="http://w3layouts.com"><span style="color: orange">College Name</span></a></p>
    </div>
</div>
<!-- //footer -->
<script src="js/jarallax.js"></script>
<script type="text/javascript">
    /* init Jarallax */
    $('.jarallax').jarallax({
        speed: 0.5,
        imgWidth: 1366,
        imgHeight: 768
    })
</script>
<script src="js/responsiveslides.min.js"></script>
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
<!-- pricing -->
<script src="js/jquery.flipster.js"></script>
<script>
<!--
		
    $(function () {
        $(".flipster").flipster({style: 'carousel', start: 0}); });

-->
</script>
<!-- //pricing -->
<!-- slider -->
<script type="text/javascript" src="js/jquery.immersive-slider.js"></script>
<!-- //slider -->
</body>	
</html>