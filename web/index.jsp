<%@include file="header.jsp" %>

<div class="domain">
    <div class="container">
        <form class="search-form domain-search" action="#" method="post">
            <div class="two-fifth column first">
                <h2>search your <span>domain</span></h2>
            </div>
            <div class="three-fifth column first">
                <input type="text" class="text" name="Name" placeholder="Enter your domain name" required="">               
            </div>
            <div class="one-fifth column">
                <span class="selection-box">
                    <select class="domains valid" name="domains">
                        <option>Year (0-1 Year)</option>
                        <option>Year (0-2 Year)</option>
                        <option>Year (0-4 Year)</option>
                        <option>Year (0-8 Year)</option>
                    </select>
                </span>
            </div>
            <div class="one-fifth column">
                <span class="selection-box">
                    <select class="domains valid" name="domains">
                        <option>.com</option>
                        <option>.info</option>
                        <option>.net</option>
                        <option>.org</option>
                    </select>
                </span>
            </div>
            <div class="one-fifth column">
                <input type="submit" value="Search">
            </div>
            <div class="clearfix"> </div>
        </form>
    </div>
</div>

<!-- choose -->
<div class="choose jarallax">
    <div class="w3-agile-testimonial">
        <div class="container">
            <div class="w3-agileits-choose">
                <div class="col-md-6 choose-grid">
                    <div class="w3-banner-bottom-heading choose-heading">
                        <h3>Why Choose<span> Us?</span></h3>
                    </div>
                    <div class="top-choose-info">
                        <div class="choose-info-top">
                            <div class="choose-left-grid col-sm-6">
                                <div class="choose-info-grid ">
                                    <ul>
                                        <li><i class="fa fa-bell" aria-hidden="true"></i></li>
                                        <li>Lorem ipsum</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="choose-right-grid col-sm-6">
                                <div class="choose-info-grid ">
                                    <ul>
                                        <li><i class="fa fa-cog" aria-hidden="true"></i></li>
                                        <li>Nulla dictum</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="choose-info-top">
                            <div class="choose-left-grid col-sm-6">
                                <div class="choose-info-grid ">
                                    <ul>
                                        <li><i class="fa fa-comments" aria-hidden="true"></i></li>
                                        <li>Lorem ipsum</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="choose-right-grid col-sm-6">
                                <div class="choose-info-grid ">
                                    <ul>
                                        <li><i class="fa fa-user" aria-hidden="true"></i></li>
                                        <li>Nulla dictum</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="choose-info-top">
                            <div class="choose-left-grid col-sm-6">
                                <div class="choose-info-grid ">
                                    <ul>
                                        <li><i class="fa fa-money" aria-hidden="true"></i></li>
                                        <li>Lorem ipsum</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="choose-right-grid col-sm-6">
                                <div class="choose-info-grid ">
                                    <ul>
                                        <li><i class="fa fa-thumbs-o-up" aria-hidden="true"></i></li>
                                        <li>Nulla dictum</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 choose-grid">
                    <div class="w3-banner-bottom-heading choose-heading">
                        <h3>What People<span> say's?</span></h3>
                    </div>
                    <div class="top-choose-info testimonial-info">
                        <div class="wthree-testimonial-grid">
                            <div class="slider">
                                <div class="callbacks_container">
                                    <ul class="rslides" id="slider3">
                                        <li>
                                            <div class="testimonial-top">
                                                <i class="fa fa-quote-right" aria-hidden="true"></i>
                                                <p>Donec feugiat tellus sem, laoreet iaculis orci lobortis vel. Sed sed luctus orci, at lacinia risus. Ut porttitor ante ac tincidunt elementum. Curabitur ex dolor, condimentum vitae nunc vel, pulvinar semper justo. Vestibulum et aliquet magna, maximus dapibus enim.</p>
                                                <h5>John Smith <span>- Customer</span></h5>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="testimonial-top">
                                                <i class="fa fa-quote-right" aria-hidden="true"></i>
                                                <p>Pellentesque urna ex, ultricies a nunc at, pretium maximus nisi. Vestibulum non auctor diam. Mauris eget consectetur mauris. Aenean leo elit, accumsan vel elit vitae, mattis ultricies lacus. Cras consectetur justo lorem, sed dictum sapien eleifend at.Donec sed </p>
                                                <h5>Divide Rule <span>- Customer</span></h5>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <script>
                                    // You can also use "$(window).load(function() {"
                                    $(function() {
                                        // Slideshow 4
                                        $("#slider3").responsiveSlides({
                                            auto: true,
                                            pager: true,
                                            nav: false,
                                            speed: 500,
                                            namespace: "callbacks",
                                            before: function() {
                                                $('.events').append("<li>before event fired.</li>");
                                            },
                                            after: function() {
                                                $('.events').append("<li>after event fired.</li>");
                                            }
                                        });

                                    });
                                </script>
                                <!--banner Slider starts Here-->
                            </div>
                        </div>

                    </div>
                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
    </div>
</div>
<!-- //choose -->
<!-- subscribe -->
<div class="subscribe">
    <div class="container">
        <div class="w3-banner-bottom-heading">
            <h3>Subscribe<span> with Us</span></h3>
        </div>
        <div class="w3-agile-subscribe-form">
            <form action="#" method="post">
                <input type="text" placeholder="Email" name="Email" required="">
                <button class="btn1">Subscribe</button>
            </form>
        </div>
    </div>
</div>
<!-- //subscribe -->

<!-- footer -->
<%@include file="footer.jsp" %>