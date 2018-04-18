<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<%@page import="com.san.model.Subject"%><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		 function submitTop(){
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
			
			document.getElementById("top").submit();
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
		var courseName="<%=session.getAttribute("courseName")%>";
		var subjectId="<%=session.getAttribute("subjectId")%>";
		var subjectType="<%=session.getAttribute("subjectType")%>";
		$(function(){
			//设置课程不动
			if(courseName!="null"){
				//根据选择的值,让它选中
				$("#courseName option[value='<%=session.getAttribute("courseName")%>']").attr("selected", true);
				//让select不能选择
				$("#courseName").attr("disabled","disabled");
			}else{
				$("#courseName").removeAttr("disabled"); 
				$("#submitTest").removeAttr("disabled");
			}
			//设置题目编号不动
			if(subjectId!="null"){
				//根据选择的值,让它选中
				$("#subjectId option[value='<%=session.getAttribute("subjectId")%>']").attr("selected", true);
				//让select不能选择
				$("#subjectId").attr("disabled","disabled");
			}else{
				$("#subjectId").removeAttr("disabled");
				$("#submitTest").removeAttr("disabled");
			}
			//设置题目类型不动
			if(subjectType!="null"){
				//根据选择的值,让它选中
				$("#subjectType option[value='<%=session.getAttribute("subjectType")%>']").attr("selected", true);
				//让select不能选择
				$("#subjectType").attr("disabled","disabled");
				//把开始测试按钮失效
				$("#submitTest").attr("disabled","disabled");
			}else{
				$("#subjectType").removeAttr("disabled");
				$("#submitTest").removeAttr("disabled");
			}
		});
		//提交按钮事件
		function gradeByOption(){
			var k=<%=session.getAttribute("k")%>;
			if(k<20||k==null){	//刚开始k为null
				var isSubmit=confirm("题目没有做完,你确定要提交吗?");
			}
			if(isSubmit==true||k>=20){
				//未做完和做完提交
				//获取提交时最后一道题的选项
				var choice=$("input[name='choice']:checked").val();
				var xhr=new XMLHttpRequest();
				xhr.onreadystatechange=function(){
					if(xhr.status==200&&xhr.readyState==4){
						//弹出成绩
						alert("您这次测试的成绩为:"+xhr.responseText);
						//结束这次测试,解除select
						$("#courseName").removeAttr("disabled");
						$("#subjectId").removeAttr("disabled");
						$("#subjectType").removeAttr("disabled");
						$("#submitTest").removeAttr("disabled");
						window.location.reload();
					}
				}
				xhr.open("get","subjectServlet?flag=gradeByOption&choice="+choice);
				xhr.send(null);
			}
		}
		//下一题按钮事件
		function nextSubject(){
			var k=<%=session.getAttribute("k")%>;
			if(k>=20){
				alert("题目做完啦,请提交");
			}else{
				document.getElementById("nextSubject").submit();
			}
		}
	</script>
</head>
<body>
<!-- 读取排名是否存在 -->

<c:if test="sessionScope.pankGrade==null">
	<jsp:forward page="${pageContext.request.contextPath}/subjectAction_showGradeRank.action"></jsp:forward>
</c:if>

<div class="boxed_wrapper">
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 导航栏 -->
<jsp:include page="nav.jsp"></jsp:include>
  
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
    	  <div style="height:500px;width:557px;float:left;">
    		<!-- 选择部分 -->
    		<div style="height:50px; border:1px #999 solid;">
    			<s:form action="subjectAction_display.action" id="top" style="margin:0px;display:inline;">
	    			<select name="courseName" id="courseName" style="height:50px;width:120px; margin-right:25px;">
	    				<option selected value="请选择课程">请选择课程</option>
	    				<option value="大学英语">大学英语</option>
	    				<option value="计算机网络">计算机网络</option>
	    				<option value="马克思原理">马克思原理</option>
	    				<option value="软件工程">软件工程</option>
	    				<option value="数据结构">数据结构</option>
	    				<option value="数据库原理">数据库原理</option>
	    			</select>
	    			<select name="subjectId" id="subjectId" style="height:50px;width:120px; margin-right:25px;">
	    				<option selected value="题目编号">题目编号</option>
	    				<option value="1">1-20</option>
	    				<option value="21">21-40</option>
	    			</select>
	    			<select name="subjectType" id="subjectType" style="height:50px;width:120px; ">
	    				<option selected value="请选择题型">请选择题型</option>
	    				<option value="选择题">选择题</option>
	    				<option value="填空题">填空题</option>
	    			</select>
    				<input type="button" id="submitTest" onclick="submitTop();" class="btn btn-primary" value="开始测试" />
    			</s:form>
    		</div>
    		
    	
 			<!-- 题目内容部分 -->
 			<div id="content">
 				
 				<div style="height:200px;width:100%;border:1px #999 solid;">
 					 
 					<c:if test="${sessionScope.nowSubject!=null}">
 						<p>第${sessionScope.nowSubject.subjectId }题</p>
    					${sessionScope.nowSubject.subjectTitle}
    				</c:if>
    				
	    		</div>
	    		<!-- 显示ABCD选项部分 -->
	    		<div style="height:300px;width:100%;border:1px #999 solid;">
	    			<c:if test="${sessionScope.nowSubject!=null}">
	    				<s:form action="subjectAction_displayNext" id="nextSubject">
		    				<input type="radio" name="choice" value="A" id="A"/>
		    					<label for="A">${sessionScope.nowSubject.optionA }</label>
		    				<input type="radio" name="choice" value="B" id="B"/>
		    					<label for="B">${sessionScope.nowSubject.optionB }</label>
		    				<input type="radio" name="choice" value="C" id="C"/>
		    					<label for="C">${sessionScope.nowSubject.optionC }</label>
		    				<input type="radio" name="choice" value="D" id="D"/>
		    					<label for="D">${sessionScope.nowSubject.optionD }</label>
			    			<div style="padding-left:450px;margin-top:20px;">
			    				<input type="button" class="btn btn-primary" value="下一题" onclick="nextSubject()"/>
			    			</div>
		    			</s:form>
	    			</c:if>
	    		</div>
	    		<!-- 选择上下题按钮,查看解析按钮-->
	    		<table>
	    			<tr>
	    				<td>
	    					<!-- 上一题 -->
	    					<s:form action="subjectAction_displayLast">
	    						<input type="submit" class="btn btn-primary" value="上一题" onclick="lastSubject()"/>
	    					</s:form>
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
	    						<input type="button" class="btn btn-primary" value="提交" onclick="gradeByOption()"/>
	    					</form>
	    				</td>
	    			</tr>
	    		</table>

    		<!-- 显示解析部分 -->
    		<div  id="analysis" style="display:none;" style="height:100px;border:1px #999 solid;margin-top:40px;width:70%;">
    			${sessionScope.nowSubject.analysis }
    		</div>
    	</div>
    	</div>
    	<!-- 刷题排行榜 -->
    	<div style="height:550px;width:239px;border:1px red solid;float:left;text-align:center;">
    		<div style="height:50px;font-size:16px;line-height:50px;text-align:center; ">
    			<a>刷题排行榜</a>
    		</div>
    		<table cellspacing="0" cellpadding="0" height="300px" width="98%">
    			<tbody>
    				
    				<s:iterator value="#session.gradeRank" status="go" var="s">
    					<tr style="border-bottom:1px #999 dashed;">
    						<td style="font-size:16px;color:#2e8f01;width:40px;height:30px;"><s:property value="#go.index+1"/></td>
    						<td style="text-align:centers;height:30px; "><s:property value="#s.userName"/></td>
    						<td style="color:#ff0000;width:80px;height:30px;" ><s:property value="#s.grade"/> </td>
    					</tr>
    				</s:iterator>
    				<!-- 
    				<c:forEach items="${sessionScope.pankGrade}" var="pankGrade" varStatus="go">
    					<tr style="border-bottom:1px #999 dashed;">
    						<td style="font-size:16px;color:#2e8f01;width:40px;height:30px;">${go.index+1}</td>
    						<td style="text-align:centers;height:30px; ">${pankGrade.userName}</td>
    						<td style="color:#ff0000;width:80px;height:30px;" >${pankGrade.grade}</td>
    					</tr>
    				</c:forEach>
    				 -->
    			</tbody>
    		</table>
    	</div>
    
    </div>
</section>
<s:debug></s:debug>
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
