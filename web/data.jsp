<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title> 

    <!-- mobile responsive meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-table.min.css">
	<!-- 登录 -->
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>

<div class="boxed_wrapper">

<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 导航栏 -->
<jsp:include page="nav.jsp"></jsp:include>
  
<section class="rev_slider_wrapper">
  <!--  <div id="slider1" class="rev_slider"  data-version="5.0">
    	<u>
    		<li>nihao </li>
    	</u>
     	<p>资料区</p>
    </div>-->
</section>
<!--  
<section class="whychoos-us sec-padd2">
    <div class="container">
        
        <div class="section-title center">
            <h2>Why Choosing The Expeart</h2>
            <div class="text">
                <p>We are experts in this industry with over 100 years experience. What that means is you are going to get right <br> solution. please find our services.</p>
            </div>
        </div>
            
        
        <div class="row clearfix">
            
            <article class="column col-md-4 col-sm-6 col-xs-12">
                <div class="item">
                    <div class="icon_box">
                        <span class="icon-graphic2"></span>
                    </div>
                    <a href="#"><h4>Why Our Consulting</h4></a>
                    <div class="text">
                        <p>We are experts in this industry with over 100 years of experience. What that means is you are going to get right solution, experts also recommand us.</p>
                    </div>
                    <div class="count">01</div>
                </div>
            </article>
            
            <article class="column col-md-4 col-sm-6 col-xs-12">
                <div class="item">
                    <div class="icon_box">
                        <span class="icon-layers"></span>
                    </div>
                    <a href="#"><h4>Advanced Analytics</h4></a>
                    <div class="text">
                        <p>We are experts in this industry with over 100 years of experience. What that means is you are going to get right solution, experts also recommand us.</p>
                    </div>
                    <div class="count">02</div>
                </div>
            </article>
            
            <article class="column col-md-4 col-sm-6 col-xs-12">
                <div class="item">
                    <div class="icon_box">
                        <span class="icon-computer"></span>
                    </div>
                    <a href="#"><h4>Customer Insights</h4></a>
                    <div class="text">
                        <p>We are experts in this industry with over 100 years of experience. What that means is you are going to get right solution, experts also recommand us.</p>
                    </div>
                    <div class="count">03</div>
                </div>
            </article>
            
        </div>
            
    </div>
</section>
-->
<section class="service sec-padd2">
    <div class="container" style="margin-top:100px;">
        
        <div class="section-title">
            <h2>轻松考</h2>
        </div>
        <div>
            <table id="table">

            </table></div>
        <div class="service_carousel">
            
          
        </div>
            
    </div>
</section>
<!-- 
<section class="fact-counter sec-padd" style="background-image: url(images/background/4.jpg);">
    <div class="container">
        <div class="row clearfix">
            <div class="counter-outer clearfix">
                
                <article class="column counter-column col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-duration="0ms">
                    <div class="item">
                        <div class="count-outer"><span class="count-text" data-speed="3000" data-stop="107">0</span></div>
                        <h4 class="counter-title">Experienced Consultants</h4>
                        <div class="icon"><i class="icon-people3"></i></div>
                    </div>
                        
                </article>
                
                
                <article class="column counter-column col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-duration="0ms">
                    <div class="item">
                        <div class="count-outer"><span class="count-text" data-speed="3000" data-stop="2000">0</span></div>
                        <h4 class="counter-title">Sucessfull Projects</h4>
                        <div class="icon"><i class="icon-technology3"></i></div>
                    </div>
                </article>
                
                
                <article class="column counter-column col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-duration="0ms">
                    <div class="item">
                        <div class="count-outer"><span class="count-text" data-speed="3000" data-stop="47">0</span></div>
                        <h4 class="counter-title">Winning Awards</h4>
                        <div class="icon"><i class="icon-sports"></i></div>
                    </div>
                </article>
                
                
                <article class="column counter-column col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-duration="0ms">
                    <div class="item">
                        <div class="count-outer"><span class="count-text" data-speed="3000" data-stop="100">0</span>%</div>
                        <h4 class="counter-title">Satisfied Customers</h4>
                        <div class="icon"><i class="icon-square2"></i></div>
                    </div>
                </article>
            </div>
        </div>
    </div>
</section>

<section class="feature-service sec-padd2">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12 column style-1">
                <div class="section-title">
                    <h3>About Experts</h3>
                </div>
                <figure class="img-box">
                    <a href="#"><img src="images/resource/1.jpg" alt=""></a>
                </figure>
                <div class="text">
                    <p>We have built an enviable reputation in the consumer goods, heavy industry, high-tech, manufacturing, medical, recreational vehicle, and our transportation sectors. multidisciplinary team of experts.</p>
                </div>
                <div class="link"><a href="#" class="thm-btn-tr style-2">Know More</a></div>
            </div>
            <div class="col-md-4 col-sm-6 col-xs-12 column style-2">
                <div class="section-title">
                    <h2>What We Do</h2>
                </div>
                <div class="content">
                    <div class="text">
                        <p>We are experts in this field with over 100 years <br>experience. What that means is you are going to <br>get right solution. please find our services.</p>
                    </div>
                    <ul class="list">
                        <li><a href="service.html"><i class="fa fa-check-circle-o"></i>Business Growth</a></li>
                        <li><a href="service.html"><i class="fa fa-check-circle-o"></i>Sustainability</a></li>
                        <li><a href="service.html"><i class="fa fa-check-circle-o"></i>Performance</a></li>
                        <li><a href="service.html"><i class="fa fa-check-circle-o"></i>Advanced Analytics</a></li>
                        <li><a href="service.html"><i class="fa fa-check-circle-o"></i>Customer Insights</a></li>
                        <li><a href="service.html"><i class="fa fa-check-circle-o"></i>Organization</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-md-4 col-sm-6 col-xs-12 column style-3">
                <div class="section-title">
                    <h2>Business Growth</h2>
                </div>
                <div class="graph">
                    <figure class="graph-img"><img src="images/resource/graph1.jpg" alt=""></figure>
                    <form action="#" class="default-form">
                        <div class="select-box">
                            <select class="text-capitalize selectpicker form-control required" name="form_subject" data-style="g-select" data-width="100%">
                                <option>Last 6 Months</option>
                                <option>Last 7 Months</option>
                                <option>Last 8 Months</option>
                                <option>Last 9 Months</option>
                            </select>
                        </div>
                    </form>
                        
                </div>
            </div>
            
        </div>
    </div>
</section>

<div class="container"><div class="border-bottom"></div></div>

<section class="testimonials-section sec-padd">
    <div class="container">
        <div class="section-title center">
            <h2>testimonials</h2>
        </div> 
        
             
        <div class="testimonials-slider column-carousel three-column">
            
            
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <div class="img-box">
                        <a href="#"><img src="images/resource/thumb1.png" alt=""></a>
                    </div>
                    <h4>Jenifer Hearly</h4>
                    <a href="#"><p>Newyork</p></a>
                    <div class="rating"><span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span></div>
                </div>
                
                <div class="slide-text">
                    <p>Fortune has helped us to just have a better handle on everything in our business – to actually make decisions and move forward to grow.</p>
                </div>
            </article>
            
            
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <div class="img-box">
                        <a href="#"><img src="images/resource/thumb2.png" alt=""></a>
                    </div>
                    <h4>Mitchel Harward</h4>
                    <a href="#"><p>San Fransisco</p></a>
                    <div class="rating"><span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span></div>
                </div>
                
                <div class="slide-text">
                    <p>They bring a wealth of knowledge as well as a personal touch so often missing from other firms, helped us to just have better handle on everything.</p>
                </div>
            </article>
            
            
            <article class="slide-item">
                <div class="quote"><span class="icon-left"></span></div>
                <div class="author">
                    <div class="img-box">
                        <a href="#"><img src="images/resource/thumb3.png" alt=""></a>
                    </div>
                    <h4>Beally Russel</h4>
                    <a href="#"><p>Newyork</p></a>
                    <div class="rating"><span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span> <span class="fa fa-star"></span></div>
                </div>
                
                <div class="slide-text">
                    <p>It involves an examination of operations which allows their team discuss the art of the possible. They bring a wealth of knowledge, we believe fortune.</p>
                </div>
            </article>

     
        </div>
        
    </div>    
</section>

<section class="latest-project sec-padd">
    <div class="container">
        <div class="section-title">
            <h2>Latest Projects</h2>
        </div>
        <div class="latest-project-carousel">
            <div class="item">
                <div class="single-project">
                    <figure class="imghvr-shutter-in-out-horiz">
                        <img src="images/resource/4.jpg" alt="Awesome Image">
                        <figcaption>
                            <div class="content">
                                <a href="project-single.html"><h4>Latest Technology</h4></a>
                                <p>Consulting</p>
                            </div> 
                        </figcaption>
                    </figure>
                </div>
            </div>
            <div class="item">
                <div class="single-latest-project-carousel">
                    <div class="single-project">
                    <figure class="imghvr-shutter-in-out-horiz">
                        <img src="images/resource/5.jpg" alt="Awesome Image">
                        <figcaption>
                            <div class="content">
                                <a href="project-single.html"><h4>Audit & Assurance</h4></a>
                                <p>Financial</p>
                            </div>    
                        </figcaption>
                    </figure>
                </div>
                </div>
            </div>
            <div class="item">
                <div class="single-latest-project-carousel">
                    <div class="single-project">
                    <figure class="imghvr-shutter-in-out-horiz">
                        <img src="images/resource/6.jpg" alt="Awesome Image">
                        <figcaption>
                            <div class="content">
                                <a href="project-single.html"><h4>Business Growth</h4></a>
                                <p>Growth</p>
                            </div> 
                        </figcaption>
                    </figure>
                </div>
                </div>
            </div>
            <div class="item">
                <div class="single-latest-project-carousel">
                    <div class="single-project">
                    <figure class="imghvr-shutter-in-out-horiz">
                        <img src="images/resource/7.jpg" alt="Awesome Image">
                        <figcaption>
                            <div class="content">
                                <a href="project-single.html"><h4>Transporation Service</h4></a>
                                <p>Marketing</p>
                            </div> 
                        </figcaption>
                    </figure>
                </div>
                </div>
            </div>            
        </div>
                
    </div>
</section>

<section class="blog-section sec-padd2">
    <div class="container">
        <div class="section-title center">
            <h2>latest news</h2>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="default-blog-news wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <figure class="img-holder">
                        <a href="#"><img src="images/blog/1.jpg" alt="News"></a>
                        <figcaption class="overlay">
                            <div class="box">
                                <div class="content">
                                    <a href="#"><i class="fa fa-link" aria-hidden="true"></i></a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="lower-content">
                        <div class="date">21 <br>April</div>
                        <h4><a href="#">Retail banks wake up to digital</a></h4>
                        <div class="post-meta">by fletcher  |  14 Comments</div>
                        <div class="text">
                            <p>know how to pursue pleasure rationally seds encounter consequences.</p>               
                        </div>
                        <div class="link">
                            <a href="#" class="default_link">Read More <i class="fa fa-angle-right"></i></a>
                        </div>
                        
                    </div>
                </div>
                
            </div>
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="default-blog-news wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <figure class="img-holder">
                        <a href="#"><img src="images/blog/2.jpg" alt="News"></a>
                        <figcaption class="overlay">
                            <div class="box">
                                <div class="content">
                                    <a href="#"><i class="fa fa-link" aria-hidden="true"></i></a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="lower-content">
                        <div class="date">17 <br>June</div>
                        <h4><a href="#">Improve your business growth</a></h4>
                        <div class="post-meta">by Richards  |  22 Comments</div>
                        <div class="text">
                            <p>Great pleasure to take a trivial example, which of us undertakes laborious.</p>                            
                        </div>
                        <div class="link">
                            <a href="#" class="default_link">Read More <i class="fa fa-angle-right"></i></a>
                        </div>
                        
                    </div>
                </div>
                
            </div>
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="default-blog-news wow fadeInUp animated" style="visibility: visible; animation-name: fadeInUp;">
                    <figure class="img-holder">
                        <a href="#"><img src="images/blog/3.jpg" alt="News"></a>
                        <figcaption class="overlay">
                            <div class="box">
                                <div class="content">
                                    <a href="#"><i class="fa fa-link" aria-hidden="true"></i></a>
                                </div>
                            </div>
                        </figcaption>
                    </figure>
                    <div class="lower-content">
                        <div class="date">14 <br>Mar</div>
                        <h4><a href="#">Save money for your future.</a></h4>
                        <div class="post-meta">by Vincent  |  16 Comments</div>
                        <div class="text">
                            <p>Pleasure and praising pain was born and I will give you a complete account.</p>                            
                        </div>
                        <div class="link">
                            <a href="#" class="default_link">Read More <i class="fa fa-angle-right"></i></a>
                        </div>
                        
                    </div>
                </div>
                
            </div>
            
        </div>
    </div>
</section>

<section class="consultations sec-padd" style="background-image: url(images/background/5.jpg);">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12">   
                <div class="contact-info">
                    <div class="section-title">
                        <h3>Contact Details</h3>
                    </div>
                    <div class="text">
                        <p>Please find below contact details <br>and contact us today!</p>
                    </div>
                    <div class="widget-content">
                        <ul class="list-info">
                            <li><span class="fa fa-phone"></span>Phone: +321 456 78 901</li>
                            <li><span class="fa fa-envelope"></span>Email: Info@supportyou.com</li>
                            <li><span class="fa fa-clock-o"></span>Mon to Sat: 9.00am to 16.pm</li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="section-title">
                    <h2>Request For Call Back</h2>
                </div>
                <div class="default-form-area">
                    <form id="contact_form" name="contact_form" class="default-form" action="inc/sendmail.php" method="post">
                        <div class="row-10 clearfix">
                            <div class="col-md-4 co-sm-6 col-xs-12 column">
                                <div class="form-group">
                                    <input type="text" name="form_name" class="form-control" value="" placeholder="Name *" required="">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="form_email" class="form-control required email" value="" placeholder="Email Address *" required="">
                                </div>
                                <div class="form-group">
                                    <div class="select-box">
                                        <select class="text-capitalize selectpicker form-control required" name="form_subject" data-style="g-select" data-width="100%">
                                            <option value="0" selected="">Enquiry About</option>
                                            <option value="1">Enquiry Team</option>
                                            <option value="2">Enquiry service</option>
                                        </select>
                                    </div>
                                        
                                </div>
                            </div>
                            <div class="col-md-8 co-sm-6 col-xs-12 column">
                                <div class="form-group style-2">
                                    <textarea name="form_message" class="form-control textarea required" placeholder="Special Request..."></textarea>
                                    <input id="form_botcheck" name="form_botcheck" class="form-control" type="hidden" value="">
                                    <button class="thm-btn thm-color" type="submit" data-loading-text="Please wait..."><i class="fa fa-paper-plane"></i></button>
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="clients-section sec-padd">
    <div class="container">
        <div class="section-title">
            <h2>our partners</h2>
        </div>
        <div class="client-carousel owl-carousel owl-theme">

            <div class="item tool_tip" title="media partner">
                <img src="images/clients/1.png" alt="Awesome Image">
            </div>
            <div class="item tool_tip" title="media partner">
                <img src="images/clients/2.png" alt="Awesome Image">
            </div>
            <div class="item tool_tip" title="media partner">
                <img src="images/clients/3.png" alt="Awesome Image">
            </div>
            <div class="item tool_tip" title="media partner">
                <img src="images/clients/4.png" alt="Awesome Image">
            </div>
            <div class="item tool_tip" title="media partner">
                <img src="images/clients/5.png" alt="Awesome Image">
            </div>

        </div>
    </div>  
</section>

<div class="call-out">
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-12">
                <figure class="logo">
                    <a href="index.jsp"><img src="images/logo/logo2.png" alt=""></a>
                </figure>
            </div>
            <div class="col-md-9 col-sm-12">
                <div class="float_left">
                    <h4>Over 20 years of experience we’ll ensure you get the best guidance.</h4>
                </div>
                <div class="float_right">
                    <a href="contact.html" class="thm-btn-tr">Request Quote</a>
                </div>
            </div>
        </div>
                
    </div>
</div>
-->
<jsp:include page="foot.jsp"></jsp:include>

<!-- Scroll Top Button -->
    <button class="scroll-top tran3s color2_bg">
        <span class="fa fa-angle-up"></span>
    </button>
    <!-- pre loader  -->
    <div class="preloader"></div>


    <!-- jQuery js -->
    <script src="js/jquery.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>

    <script src="js/bootstrap-table.min.js"></script>
    <!-- put your locale files after bootstrap-table.js -->
    <script src="js/bootstrap-table-zh-CN.min.js"></script>
    <!-- jQuery ui js -->
    <script src="js/jquery-ui.js"></script>
    <!-- owl carousel js -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- jQuery validation -->
    <script src="js/jquery.validate.min.js"></script>

    <!-- mixit up -->
    <script src="js/wow.js"></script>
    <script src="js/jquery.mixitup.min.js"></script>
    <script src="js/jquery.fitvids.js"></script>
    <script src="js/bootstrap-select.min.js"></script>
    <script src="js/menuzord.js"></script>

    <!-- revolution slider js -->
    <script src="js/jquery.themepunch.tools.min.js"></script>
    <script src="js/jquery.themepunch.revolution.min.js"></script>
    <script src="js/revolution.extension.actions.min.js"></script>
    <script src="js/revolution.extension.carousel.min.js"></script>
    <script src="js/revolution.extension.kenburn.min.js"></script>
    <script src="js/revolution.extension.layeranimation.min.js"></script>
    <script src="js/revolution.extension.migration.min.js"></script>
    <script src="js/revolution.extension.navigation.min.js"></script>
    <script src="js/revolution.extension.parallax.min.js"></script>
    <script src="js/revolution.extension.slideanims.min.js"></script>
    <script src="js/revolution.extension.video.min.js"></script>

    <!-- fancy box -->
    <script src="js/jquery.fancybox.pack.js"></script>
    <script src="js/jquery.polyglot.language.switcher.js"></script>
    <script src="js/nouislider.js"></script>
    <script src="js/jquery.bootstrap-touchspin.js"></script>
    <script src="js/SmoothScroll.js"></script>
    <script src="js/jquery.appear.js"></script>
    <script src="js/jquery.countTo.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/imagezoom.js"></script> 
    <script id="map-script" src="js/default-map.js"></script>
    <script src="js/custom.js"></script>
	<!-- 登录js -->
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>

    <script>
        $('#table').bootstrapTable({
            method:"get",
            url: "/resourceServlet?method=listResource",
            dataType: "json",
            striped: true,
            showColumns: true,
            classes:'table table-hover table-no-bordered',
            search:true,
            pagination: true,
            clickToSelect: true,
            columns: [{
                field: 'resourceId',
                title: '资料编号',
                sortable:true,
                cardVisible:true
            }, {
                field: 'uploadId',
                title: '上传者编号',
                sortable:true
            }, {
                field: 'courseName',
                title: '课程名',
                sortable:true
            },{
                field:'resourceName',
                title:'资料名'
            },{
                field:'resourceDescription',
                title:'资料描述'
            },{
                field:'downNumber',
                title:'下载次数',
                sortable:true
            },{
                field:'integration',
                title:'积分' ,
                sortable:true
            },
                {
                    field:'resourcePath',
                    title:'下载' ,
                    align:'center',
                    formatter : operateFormatter,
                }
            ],

            onClickCell:function(field, value, row, $element){
                if(field=="resourcePath"){
                    /*  console.log(field);
                      console.log(value);
                      console.log(row);
                      console.log($element);
                      console.log(row.resourceId);*/
                    window.location.href="/resourceServlet?method=getResource&resourceId="+row.resourceId.toString();
                }

            }
        });
        function operateFormatter(value, row, index) {
            return [
                '<button  type="button" class="btn btn-danger btn-xs">下载</button>', ]
                .join('');
        }

    </script>
</div>
    
</body>
</html>
