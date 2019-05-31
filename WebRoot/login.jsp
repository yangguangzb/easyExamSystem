<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>登录</title>
	
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
		function change(){
			var userName=document.getElementById("userName").value;
			var password=document.getElementById("password").value;
			if(userName==""||userName==null){
				alert("请输入用户名");
				return false;
			}
			if(password==""||password==null){
				alert("请输入密码");
				return false;
			}
			/*
			var userName=document.getElementById("userName").value;
			var password=document.getElementById("password").value;
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4){
					if(xhr.status==200){
						if(xhr.responseText=="登录成功"){
							window.location.href="index.jsp";
						}
						if(xhr.responseText=="黑名单"){
							alert("您被拉入黑名单，请与管理员联系");
						}
						if(xhr.responseText=="登录失败"){
							alert("用户名密码错误");
						}
					}
				}
			}
			xhr.open("get","loginServlet?userName="+userName+"&password="+password);
			xhr.send(null);*/
		}
	</script>
</head>
<body>
	<div class="event" id="login_box">
		<div class="login">
			<div class="title">
				<span class="t_txt">登录</span>
			</div>
			<s:form action="userAction_login" namespace="/" onsubmit="return change()">
				<s:textfield name="userName" placeholder="用户名/邮箱"></s:textfield>
				<s:password name="password" placeholder="请输入密码"></s:password>
				<s:submit value="登录" class="btn"></s:submit>
				<s:a class="wapper" href="forgetPassword.jsp">
					忘记密码
				</s:a>
			</s:form>
			<!--<form action="userAction_login" method="post" >
				<input type="text" name="userName" id="userName"  placeholder="用户名/邮箱"/>
				<input type="password" name="password" id="password"  placeholder="请输入密码"/>
				<input type="button" value="登录" class="btn" onclick="change()"/>
				<a class="wapper" href="forgetPassword.jsp">忘记密码</a>
			</form>	
		--></div>
	</div>
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>