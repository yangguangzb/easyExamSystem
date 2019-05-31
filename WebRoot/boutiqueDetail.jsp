<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
	<style type="text/css">
		#analysis{
			height:100px;border:1px #999 solid ;width:70%;
		}
	</style>
	<script type="text/javascript">
		//输入题目编号判断
		function subjectId(){
			var boutiqueSubjectId=document.getElementById("boutiqueSubjectId").value;
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.status==200&&xhr.readyState==4){
					if(xhr.responseText==-1){
						alert("没有这么多题目哦,请重新输入");
					}else if(xhr.responseText==-2){
						alert("题目编号输入有误");					
					}
					else{
						//题目够,刷新界面
						location.reload();
					}
				}
			}
			xhr.open("get","boutiqueAction_detailSubject.action?boutiqueSubjectId="+boutiqueSubjectId);
			xhr.send(null);
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
		//下一题 
		function nextBoutSubject(){
			var boutId=<%=session.getAttribute("boutId")%>;
			var allSubject=<%=session.getAttribute("allSubject")%>;
			if(boutId>=allSubject){
				alert("题目做完啦");
			}else{
				document.getElementById("nextBoutSubject").submit();
			}
		}
		//radio选中事件
		function isSelect(b){
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.status==200&&xhr.readyState==4){
					if(xhr.responseText=="正确"){
						//答案正确
						document.getElementById("cuo").style.display='none';
						document.getElementById("daan").style.display='none';
						document.getElementById("dui").style.display='inline';
					}else{
						//答案错误
						document.getElementById("cuo").style.display='inline';
						document.getElementById("daan").style.display='inline';
						document.getElementById("dui").style.display='none';
					}
				}
			}
			xhr.open("get","boutiqueAction_answerCl.action?submitAnswer="+b);
			xhr.send(null);
		}
	</script>
</head>
<body>
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
	<!-- margin-top:使得轻松考与上面有一定距离 -->
    <div class="container" style="margin-top:100px;">
        
        <div class="section-title">
            <h2>轻松考</h2>
        </div>
        <div style="width:75%;height:820px;border:1px #999 solid;">
        	<!-- 上面搜索框 -->
        	<div style="height:55px; border:1px #999 solid;">
        		<form action="" method="post" style="margin-top:10px;">
		    		<input type="text" placeholder="题目编号" id="boutiqueSubjectId" class="form-control" style="display:inline;width:150px;margin-right:30px;"/>
		    		<input type="button" value="开始刷题" onclick="subjectId()" class="btn btn-primary"/>
	    		</form>
        	</div>
        	
        	<!-- 题目内容部分 -->
 			<div id="content">
 				<div style="height:200px;width:70%;border:1px #999 solid;">
 					<c:if test="${sessionScope.nowBoutiqueSubject!=null}">
 						<p style="font-size:15px;">&nbsp;&nbsp;${sessionScope.boutId}/${sessionScope.allSubject}</p>
    					&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.nowBoutiqueSubject.subjectTitle}
    				</c:if>
	    		</div>
	    		<!-- 显示ABCD选项部分 -->
	    		<div style="height:300px;width:70%;border:1px #999 solid;">
	    			<c:if test="${sessionScope.nowBoutiqueSubject!=null}">
		    			<form action="boutiqueAction_nextBoutSubject.action" id="nextBoutSubject" method="post">
		    				<input type="radio" name="choice" value="A" id="A" onclick="isSelect(this.value)"/>
		    					<label for="A">${sessionScope.nowBoutiqueSubject.optionA }</label>
		    				<input type="radio" name="choice" value="B" id="B" onclick="isSelect(this.value)"/>
		    					<label for="B">${sessionScope.nowBoutiqueSubject.optionB }</label>
		    				<input type="radio" name="choice" value="C" id="C" onclick="isSelect(this.value)"/>
		    					<label for="C">${sessionScope.nowBoutiqueSubject.optionC }</label>
		    				<input type="radio" name="choice" value="D" id="D" onclick="isSelect(this.value)"/>
		    					<label for="D">${sessionScope.nowBoutiqueSubject.optionD }</label>
			    			<div style="height:35px;margin-left:370px; margin-top:20px;">
			    				<div style="float:left; margin-right:30px;width:82px;">
			    					<input type="button" class="btn btn-primary" value="下一题" onclick="nextBoutSubject()"/>
			    				</div>
			    				<div style="float:left; width:82px;">
			    					<input type="button" class="btn btn-primary" value="查看解析" onclick="displayParsing()"/>
			    				</div>
			    			</div>
		    			</form>
	    			</c:if>
	    			<!-- 答案是否正确部分 -->
	    			<div style="height:40px;margin-top:15px;padding-left:20px;">
	    				<span id="dui" style="display:none; color:#2da5ec;">答案正确</span>
	    				<span id="cuo" style="display:none; color:red">回答错误!</span>
	    				<span id="daan" style="display:none; color:#2da5ec;">正确答案:${nowBoutiqueSubject.subjectAnswer}</span>
	    			</div>
	    		</div>
	    		
       	 </div>
       	 <!-- 显示解析部分 -->
    	<div  id="analysis" style="display:none;">
    		${sessionScope.nowBoutiqueSubject.analysis }
    	</div>
    </div>
</section>

<!-- 底部jsp -->
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
</div>
    
</body>
</html>
