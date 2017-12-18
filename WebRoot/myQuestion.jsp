<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>我的问题</title> 

    <!-- mobile responsive meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript" src="./admin2/lib/layui/layui.js"></script>
	
    
    <!-- 必须 -->
    <script type="text/javascript" src="admin2/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="admin2/js/xadmin.js"></script>
	
	<!-- problem的css -->
	<link rel="stylesheet" href="css/myProblem.css"/>
	<link rel="stylesheet" href="css/myQuestion.css"/>
	<script type="text/javascript">
	/*弹出层*/
	/*
	   	 参数解释：
	    title   标题
	    url     请求的url
	    id      需要操作的数据id
	    w       弹出层宽度（缺省调默认值）
	    h       弹出层高度（缺省调默认值）
	*/
	function x_admin_show(title,url,w,h){
	    if (title == null || title == '') {
	        title=false;
	    };
	    if (url == null || url == '') {
	        url="404.html";
	    };
	    if (w == null || w == '') {
	        w=($(window).width()*0.75);
	    };
	    if (h == null || h == '') {
	        h=($(window).height() - 50);
	    };
	    layer.open({
	        type: 2,
	        area: [w+'px', h +'px'],
	        fix: false, //不固定
	        maxmin: true,
	        shadeClose: true,
	        shade:0.4,
	        title: title,
	        content: url
	    });
	}
	</script>
</head> 
<body>
<c:if test="${sessionScope.user==null}">
	<jsp:forward page="login.jsp"></jsp:forward>
</c:if>
<c:if test="${requestScope.myQuestions==null}">
	<jsp:forward page="questionServlet?flag=myQuestion"></jsp:forward>
</c:if>
<div class="boxed_wrapper">

<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 导航栏 -->
<jsp:include page="nav.jsp"></jsp:include>
  
<section class="rev_slider_wrapper">
    <div id="slider1" class="rev_slider"  data-version="5.0">
    </div>
</section>

<section class="service sec-padd2">
    <div class="container" style="margin-top:120px;">
        
        <div class="section-title">
            <h2>轻松考</h2>
        </div>
        <!-- 主体内容 -->
        <div style="width:75%;height:820px;border:1px #999 solid;">
        	<!-- 头部按钮 -->
        	<div class="top">
        		<ul class="topul">
        			<li><a href="notAnswerQuestion.jsp">待答问题</a></li>
        			<li><a href="highQuestion.jsp">高分问题</a></li>
        			<li><a href="myQuestion.jsp" style="color:#999">我的问题</a></li>
        			<li><a href="myAnswer.jsp">我的回答</a></li>
        			<li><a href="javascript:;" onclick="x_admin_show('提出问题','putQuestions.jsp')">我要提问</a></li>
        		</ul>
        	</div>
        	<table class="notAnswerQuestion">
        		<colgroup>
        			<col style="color:#FF0000;width:50px"/>
        			<col style="color:#333;width:100px"/>
        			<col/>
        			<col style="color:#666;width:50px"/>
        			<col style="color:#666;width:100px"/>
        			<col style="color:#666;width:80px"/>
        		</colgroup>
        		<thead>
        			<tr>
        				<th>积分</th>
        				<th>课程</th>
        				<th>标题</th>
        				<th>回答</th>
        				<th>时间</th>
        				<th>状态</th>
        			</tr>
        		</thead>
        		<tbody>
        			<c:if test="${requestScope.myQuestions!=null&&requestScope.myQuestions!='0'}">
	        			<c:forEach items="${myQuestions}" var="myQuestion">
	        				<tr>
		        				<td>${myQuestion.questionReward}</td>
		        				<td>[${myQuestion.courseName}]</td>
		        				<td style="text-align:left;"><a href="myQuestionDetail.jsp?questionId=${myQuestion.questionId}" style="color:#133DB6;" target="_blank">${myQuestion.questionTitle}</a></td>
		        				<td>${myQuestion.answerNumber}</td>
		        				<td style="color:#999;font-size:14px;">${myQuestion.showTime}</td>
		        				<c:if test="${myQuestion.questionState==0}"><td style="color:#133DB6;font-size:14px;">未解决</td></c:if>
		        				<c:if test="${myQuestion.questionState==1}"><td style="color:#999;font-size:14px;">已解决</td></c:if>
	        				</tr>
	        			</c:forEach>
        			</c:if>
        		</tbody>
        	</table>
        </div>
    </div>
</section>

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
