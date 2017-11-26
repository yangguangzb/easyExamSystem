<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>

<!-- mobile responsive meta -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<!-- 登录 -->
<link rel="stylesheet" type="text/css" href="css/login.css" />
<link rel="stylesheet" href="css/bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrap-table.min.css">

</head>
<body>

	<div class="boxed_wrapper">

		<header class="top-bar">
			<div class="container">
				<div class="clearfix">
					<div class="col-left float_left">
						<div id="polyglotLanguageSwitcher" class="">
							<form action="#">
								<select id="polyglot-language-options">
									<option id="en" value="计算机网络" selected>计算机网络</option>
									<option id="fr" value="软件工程">软件工程</option>
									<option id="de" value="数据结构">数据结构</option>
									<option id="it" value="高等数学">高等数学</option>
									<option id="es" value="大学英语">大学英语</option>
								</select>
							</form>
						</div>
						<!--  
                <ul class="top-bar-info">
                    <li><i class="icon-technology"></i>Phone: (123) 0200 12345</li>
                    <li><i class="icon-note2"></i>Mailus@TheExperts.com</li>
                </ul>
                -->
					</div>
					<div class="col-right float_right">
						<!--  
                <ul class="social">
                    <li>Stay Connected: </li>
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                </ul>
                -->
						<div class="link">
							<!--  
                    <a href="contact.html" class="thm-btn">get a quote</a>
                    -->
							<a href="login.jsp">登录</a> <a href="register.jsp">注册</a>
						</div>
					</div>


				</div>


			</div>
		</header>

		<section class="theme_menu stricky">
			<div class="container">
				<div class="row">
					<div class="col-md-4">
						<div class="main-logo">
							<a href="index.jsp"><img src="images/logo/logo.png" alt=""></a>
						</div>
					</div>
					<div class="col-md-8 menu-column">
						<nav class="menuzord" id="main_menu">
							<ul class="menuzord-menu">
								<li ><a href="index.jsp">首页</a></li>
								<li><a href="ordinary.jsp">普通区</a></li>
								<li><a href="boutique.jsp">精品区</a></li>
								<li class="active"><a href="data.jsp">资料</a></li>
								<li><a href="share.jsp">分享交流</a></li>
								<li><a href="problem.jsp">随问即答</a></li>
							</ul>
							<!-- End of .menuzord-menu -->
						</nav>
						<!-- End of #main_menu -->
					</div>
					<div class="right-column">
						<div class="right-area">
							<div class="nav_side_content">
								<div class="search_option">
									<button class="search tran3s dropdown-toggle color1_bg"
										id="searchDropdown" data-toggle="dropdown"
										aria-haspopup="true" aria-expanded="false">
										<i class="fa fa-search" aria-hidden="true"></i>
									</button>
									<form action="#" class="dropdown-menu"
										aria-labelledby="searchDropdown">
										<input type="text" placeholder="搜索...">
										<button>
											<i class="fa fa-search" aria-hidden="true"></i>
										</button>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>


			</div>
			<!-- End of .conatiner -->
		</section>

		<section class="rev_slider_wrapper">
			<div id="slider1" class="rev_slider" data-version="5.0">
				<u>
					<li>nihao</li>
				</u>
				<p>资料区</p>

			</div>
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
			<div class="container">

				<div class="section-title">
					<h2>轻松考</h2>
				</div>
<div><table id="table">
    
</table></div>
			<!-- 	<div class="service_carousel"></div> -->
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
                    <a href="index.html"><img src="images/logo/logo2.png" alt=""></a>
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
		<footer class="main-footer">


			<div class="widgets-section">
				<div class="container">
					<div class="row">
						<!--Big Column-->
						<div class="big-column col-md-6 col-sm-12 col-xs-12">
							<div class="row clearfix">

								<!--Footer Column-->
								<div class="footer-column col-md-6 col-sm-6 col-xs-12">
									<div class="footer-widget about-widget">
										<h3 class="footer-title">关于我们</h3>

										<div class="widget-content">
											<div class="text">
												<p>
													轻松考以帮助千万学子考试不挂为使用，以客户获得奖学金为目标，收集了很多试卷和书中的重点难点
													包括考试大纲</p>
											</div>
											<div class="link">
												<a href="#" class="default_link">更多 <i
													class="fa fa-angle-right"></i></a>
											</div>
										</div>
									</div>
								</div>
								<!--Footer Column-->
								<div class="footer-column col-md-6 col-sm-6 col-xs-12">
									<div class="footer-widget links-widget">
										<h3 class="footer-title">轻松考</h3>
										<div class="widget-content">
											<ul class="list">
												<li><a href="ordinary.jsp">必过之旅</a></li>
												<li><a href="boutique.jsp">奖学金之旅</a></li>
												<li><a href="data.jsp">资料之旅</a></li>
												<li><a href="share.jsp">分享之旅</a></li>
												<li><a href="problem.jsp">随问即答</a></li>
												<li><a href="#">其他</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!--Big Column-->
						<div class="big-column col-md-6 col-sm-12 col-xs-12">
							<div class="row clearfix">


								<!--Footer Column-->
								<div class="footer-column col-md-6 col-sm-6 col-xs-12">
									<div class="footer-widget contact-widget">
										<h3 class="footer-title">联系我们</h3>
										<div class="widget-content">
											<ul class="contact-info">
												<li><span class="icon-signs"></span>江西省南昌市<br>江西师大</li>
												<li><span class="icon-phone-call"></span>电话:123456789</li>
												<li><span class="icon-e-mail-envelope"></span>邮箱:123@qq.com</li>
											</ul>
										</div>
										<!--  
                                <ul class="social">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                </ul>
                                -->
									</div>
								</div>

								<!--Footer Column-->
								<div class="footer-column col-md-6 col-sm-6 col-xs-12">
									<div class="footer-widget news-widget">
										<h3 class="footer-title">通讯</h3>
										<div class="widget-content">
											<!--Post-->
											<div class="text">
												<p>
													订阅我们您将获得最新的提示<br>最新的试题等
												</p>
											</div>
											<!--Post-->
											<form action="#" class="default-form">
												<input type="email" placeholder="邮箱地址">
												<button type="submit" class="thm-btn">定于我们</button>
											</form>
										</div>

									</div>
								</div>

							</div>
						</div>

					</div>
				</div>
			</div>

			<!--Footer Bottom-->
			<!--  
     <section class="footer-bottom">
        <div class="container">
            <div class="pull-left copy-text">
                <p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="#"></a></p>
                
            </div>
            <div class="pull-right get-text">
                <ul>
                    <li><a href="#">Support |  </a></li>
                    <li><a href="#">Privacy & Policy |</a></li>
                    <li><a href="#"> Terms & Conditions</a></li>
                </ul>
            </div>
        </div>
    </section>
     -->
		</footer>

		<!-- Scroll Top Button -->
		<button class="scroll-top tran3s color2_bg">
			<span class="fa fa-angle-up"></span>
		</button>
		<!-- pre loader  -->
		<div class="preloader"></div>
	<!-- 	</script>  -->
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
    	  url: "/resourceServlet",
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
        },
        ],
        
      /*  data: [{
            resourceId: 12,
            uploadId: 12,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',
            download:'testfile.txt',
        }, 
        {
            resourceId: 13,
            uploadId: 11,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'16',
            integrtion:'2',

        },
        {
            resourceId: 12,
            uploadId: 12,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',

        }, 
        {
            resourceId: 12,
            uploadId: 12,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',

        }, 
        {
            resourceId: 12,
            uploadId: 12,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',

        }, 
        {
            resourceId: 12,
            uploadId: 12,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',

        }, 
        {
            resourceId: 12,
            uploadId: 12,
            courseName: '高等数学',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',

        }, 
        {
            resourceId: 12,
            uploadId: 12,
            courseName: '线性代数',
            resourceName:'期末复习',
            resourceDescription:'期末复习',
            downNumber:'3',
            integrtion:'5',

        }, 
        ],*/
        onClickCell:function(field, value, row, $element){
            if(field=="resourcePath")
                window.location.href=value;
        },
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
