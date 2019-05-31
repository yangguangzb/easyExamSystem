<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function change(){
		var verificationCode=document.getElementById("verificationCode").value;
		if(verificationCode==""||verificationCode==null){
			alert("请输入验证码");
			return false;
		}
		/*
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.status==200&&xhr.readyState==4){
				if(xhr.responseText==-1){
					alert("验证码错误");
					return false;
				}else{
					location.href="resetPassword.jsp";
				}
			}
		}
		xhr.open("get","loginServlet?flag=forgetPassword&verificationCode="+verificationCode);
		xhr.send(null);
		*/
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
	<!-- 输入验证码 -->
	<div class="event" id="login_box">
		<div class="login">
			<div class="title">
				<span class="t_txt">输入验证码</span>
			</div>
			<s:form namespace="/" action="userAction_verificationCode" onsubmit="return change()">
				<s:textfield name="verificationCode" maxlength="6" id="verificationCode"  placeholder="输入验证码"></s:textfield>
				<div class="fielderror">
					<s:fielderror></s:fielderror>
				</div>
				<s:submit value="提交" class="btn"></s:submit>
				<s:a class="wapper" href="forgetPassword.jsp"></s:a>
			</s:form>
			
			<!--<form action="" method="post" >
				<input type="text" name="verificationCode" maxlength="6" id="verificationCode"  placeholder="输入验证码"/>
				<input type="button" value="提交" class="btn" onclick="return change();"/>
				<a class="wapper" href="forgetPassword.jsp">返回上一步</a>
			</form>	
		--></div>
	</div>
</body>
</html>

