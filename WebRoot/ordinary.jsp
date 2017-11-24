<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<%@page import="com.san.model.Subject"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title> 

    <!-- mobile responsive meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
	<!-- 登录 -->
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- 自己写的普通区的css -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/myOrdinary.css" />
	<script type="text/javascript">
		 function isTrue(){
		 	//获取用户选择的课程
			var courseName=document.getElementById("courseName");
			var courseNameText=courseName.options[courseName.selectedIndex].text;
			//获取用户选择的题目编号
			var subjectId=document.getElementById("subjectId");
			var subjectIdText=subjectId.options[subjectId.selectedIndex].text;
			//获取用户选择的题型
			var subjectType=document.getElementById("subjectType");
			var subjectTypeText=subjectType.options[subjectType.selectedIndex].text;
			if(courseNameText=="请选择课程"){
				alert("请选择课程");
				return false;
			}
			if(subjectIdText=="题目编号"){
				alert("请选择题目编号");
				return false;
			}
			if(subjectTypeText=="请选择题型"){
				alert("请选择题型");
				return false;
			}
			return true;			
		}
		//显示解析
		function displayParsing(){
			var analysis=document.getElementById("analysis").style.display;
			if(analysis=="none"){
				document.getElementById("analysis").style.display='block';
			}else{
				document.getElementById("analysis").style.display='none';
			}
		}
	</script>
</head>
<body>
<div class="boxed_wrapper">
<header class="top-bar">
    <div class="container">
        <div class="clearfix">
            <div class="col-left float_left">
                <div id="polyglotLanguageSwitcher" class="">
                    <!--<form action="#">
                        <select id="polyglot-language-options">
                            <option id="en" value="计算机网络" selected>计算机网络</option>
                            <option id="fr" value="软件工程">软件工程</option>
                            <option id="de" value="数据结构">数据结构</option>
                            <option id="it" value="高等数学">高等数学</option>
                            <option id="es" value="大学英语">大学英语</option>
                        </select>
                    </form>
                --></div>
				
            </div>
            <div class="col-right float_right">
            	
                <div class="link">
                	
                    <a href="login.jsp">登录</a>
                    <a href="register.jsp">注册</a>
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
                       <li><a href="index.jsp">首页</a></li>
						<li  class="active"><a href="ordinary.jsp">普通区</a></li>
                        <li><a href="boutique.jsp">精品区</a></li>
						<li><a href="data.jsp">资料</a></li>
						<li><a href="share.jsp">分享交流</a></li>
                        <li><a href="problem.jsp">随问即答</a></li>
                    </ul><!-- End of .menuzord-menu -->
                </nav> <!-- End of #main_menu -->
            </div>
            <div class="right-column">
                <div class="right-area">
                    <div class="nav_side_content">
                        <div class="search_option">
                            <button class="search tran3s dropdown-toggle color1_bg" id="searchDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-search" aria-hidden="true"></i></button>
                            <form action="#" class="dropdown-menu" aria-labelledby="searchDropdown">
                                <input type="text" placeholder="搜索...">
                                <button><i class="fa fa-search" aria-hidden="true"></i></button>
                            </form>
                       </div>
                   </div>
                </div>
                    
            </div>
        </div>
                

   </div> <!-- End of .conatiner -->
</section>
  
<section class="rev_slider_wrapper">
    <div id="slider1" class="rev_slider"  data-version="5.0">
    	<!--<u>
    		<li>nihao </li>
    	</u>
     	<p>资料区</p>
    --></div>
</section>

<section class="service sec-padd2" >
    <div class="container" style="margin-top:100px;">
        
        <div class="section-title">
            <h2>轻松考</h2>
        </div>
        
        
    	<div style="width:70%;height:800px;border: 1px #999 solid;">
    		<!-- 选择部分 -->
    		<div style="height:50px; border:1px #999 solid;">
    			<form action="subjectServlet?flag=display" method="post" onsubmit="return isTrue()" style="margin:0px;display:inline;">
	    			<select name="courseName" id="courseName" style="height:50px;width:120px; margin-right:25px;">
	    				<option selected>请选择课程</option>
	    				<option>大学英语</option>
	    				<option>数据结构</option>
	    			</select>
	    			<select name="subjectId" id="subjectId" style="height:50px;width:120px; margin-right:25px;">
	    				<option selected>题目编号</option>
	    				<option>1-20</option>
	    				<option>21-40</option>
	    			</select>
	    			<select name="subjectType" id="subjectType" style="height:50px;width:120px; ">
	    				<option selected>请选择题型</option>
	    				<option>选择题</option>
	    				<option>填空题</option>
	    			</select>
    				<input type="submit" class="btn btn-primary" value="题目"/>
    			</form>
    		</div>
    		
    	
 			<!-- 题目内容部分 -->
 			<div id="content">
 				<div style="height:200px;width:70%;border:1px #999 solid;">
 					<p>第${sessionScope.nowSubject.subjectId }题</p>
    				${sessionScope.nowSubject.subjectTitle}
	    		</div>
	    		<!-- 显示ABCD选项部分 -->
	    		<div style="height:250px;width:70%;border:1px #999 solid;">
	    			<form action="subjectServlet?flag=displayNext" method="post">
		    			<div style="height:auto; border:1px red solid;">
		    				<input type="radio"  name="choice" value="A"/>
		    				${sessionScope.nowSubject.optionA }
		    			</div>
		    			<div style="height:auto; border:1px red solid;">
		    				<input type="radio" name="choice" value="B"/>
		    				${sessionScope.nowSubject.optionB }
		    			</div>
		    			<div style="height:auto; border:1px red solid;">
		    				<input type="radio" name="choice" value="C"/>
		    				${sessionScope.nowSubject.optionC }
		    				
		    			</div>
		    			<div style="height:auto; border:1px red solid;">
		    				<input type="radio" name="choice" value="D"/>
		    				${sessionScope.nowSubject.optionD }
		    			</div>
		    			<div style="padding-left:450px;margin-top:20px;">
		    				<input type="submit" class="btn btn-primary" value="下一题" onclick="nextSubject()"/>
		    			</div>
	    			</form>
	    		</div>
	    		
	    		<!-- 选择上下题按钮,查看解析按钮-->
	    		<table>
	    			<tr>
	    				<td>
	    					<!-- 上一题 -->
	    					<form action="subjectServlet?flag=displayLast" method="post">
	    						<input type="submit" class="btn btn-primary" value="上一题" onclick="lastSubject()"/>
	    					</form>
	    				</td>
	    				<td width="20px;"></td>
	    				<td>
	    					<!-- 查看解析 -->
	    					<form action="" method="post">
	    						<input type="button" class="btn btn-primary" value="查看解析" onclick="displayParsing()"/>
	    					</form>
	    				</td>
	    				<td width="20px;"></td>
	    				<td>
	    					<!-- 提交 -->
	    					<form action="">
	    						<input type="submit" class="btn btn-primary" value="提交" onclick="gradeByOption()"/>
	    					</form>
	    				</td>
	    			</tr>
	    		</table>

    		<!-- 显示解析部分 -->
    		<div  id="analysis" style="display:none;">
    			${sessionScope.nowSubject.analysis }
    		</div>
    	</div>
    
    </div>
</section>


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
                                    <div class="text"><p>
									轻松考以帮助千万学子考试不挂为使用，以客户获得奖学金为目标，收集了很多试卷和书中的重点难点
									包括考试大纲											                                    
                                    </p> </div>
                                    <div class="link">
                                        <a href="#" class="default_link">更多 <i class="fa fa-angle-right"></i></a>
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
                                    <div class="text"><p>订阅我们您将获得最新的提示<br>最新的试题等</p></div>
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
     
</footer>

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
</div>
    
</body>
</html>
