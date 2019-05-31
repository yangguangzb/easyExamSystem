<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function change(){
		var password=document.getElementById("password").value;
		var password1=document.getElementById("password1").value;
		if(password==""||password1==""){
			alert("请输入密码");
			return false;
		}
		if(password!=password1){
			alert("输入两次密码不一致");
			return false;
		}
		if(password.length<6){
			alert("密码长度不能少于6位");
			return false;
		}
	}
</script>
<STYLE type="text/css">
	.fielderror{
		color:red;
		font-size:15px;
		padding-left: 140px;
	}
</STYLE>
</head>
<body>
	<!-- 重置密码 -->
	<div class="event" id="login_box">
		<div class="login">
			<div class="title">
				<span class="t_txt">重置密码</span>
			</div>
			<s:form namespace="/" action="userAction_resetPassword" onsubmit="return change();">
				<s:textfield name="password" id="password" maxlength="16" placeholder="请输入密码"></s:textfield>
				<s:textfield name="password1" id="password1" maxlength="16" placeholder="请再次输入密码"></s:textfield>
				<div class="fielderror">
					<s:fielderror></s:fielderror>
				</div>
				<s:submit value="提交" class="btn"></s:submit>
			</s:form>
			
			<!--<form action="loginServlet?flag=forgetPassword" method="post" onsubmit="return change();">
				<input type="text" name="password" id="password"  placeholder="请输入密码"/>
				<input type="text" name="password1" id="password1"  placeholder="请再次输入密码"/>
				<input type="submit" value="提交" class="btn"/>
				<a class="wapper" href="login.jsp">返回登录界面</a>
			</form>	
		--></div>
	</div>
</body>
</html>

