<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css"/>
<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	function change(){
		var e_mail=document.getElementById("e_mail").value;
		if(e_mail==""||e_mail==null){
			alert("请输入邮箱");
			return false;
		}
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.status==200&&xhr.readyState==4){
				if(xhr.responseText==-1){
					alert("邮箱错误");
					return false;
				}else{
					location.href="inputValidationCode.jsp";
				}
			}
		}
		xhr.open("get","loginServlet?flag=forgetPassword&e_mail="+e_mail);
		xhr.send(null);
	}
</script>

</head>
<body>
	<div class="event" id="login_box">
		<div class="login">
			<div class="title">
				<span class="t_txt">找回密码</span>
			</div>
			<form action="" method="post" >
				<input type="text" name="e_mail" id="e_mail"  placeholder="请输入邮箱"/>
				<input type="button" value="获取验证码" class="btn" onclick="return change();"/>
			</form>	
		</div>
	</div>
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>