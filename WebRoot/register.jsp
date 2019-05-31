<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>注册</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/gloab.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/register.js"></script>
<script type="text/javascript">
	//判断用户名是否存在
	function blurUserName(){
		var userName=document.getElementById("adminNo").value;
		if(userName!=null||userName!=""){
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="-1"){
						alert("用户名已存在");
						document.getElementById("adminNo").value="";
					}
				}
			}
			xhr.open("get","userAction_isExistenceUserName?userName="+userName);
			xhr.send(null);
		}
	}
	//判断邮箱是否存在
	function blurEmail(){
		var e_mail=document.getElementById("phone").value;
		if(e_mail!=null||e_mail!=""){
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="-1"){
						alert("邮箱已存在");
						document.getElementById("phone").value="";
					}
				}
			}
			xhr.open("get","userAction_isExistenceEmail?e_mail="+e_mail);
			xhr.send(null);
		}
	}
	//失去焦点时,发送密码
	function blurPassword(){
		var password=document.getElementById("password").value;
		if(password!=null||password!=""){
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
					
				}
			}
			xhr.open("get","userAction_savePassword.action?password="+password);
			xhr.send(null);
		}
	}
	
	function jihuoma(){
		//点击发送激活码
		var xhr=new XMLHttpRequest();
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4&&xhr.status==200){
				
			}
		}
		xhr.open("get","userAction_registerJihuoma.action");
		xhr.send(null);
	}
	
	function yanEmail(){
		//通过激活码验证邮箱是否有效
		var verifyNo=document.getElementById("verifyNo").value;
		if(verifyNo==null||verifyNo==""){
			alert("请输入激活码");
			return false;
		}
		if(verifyNo!=null||verifyNo!=""){
			var xhr=new XMLHttpRequest();
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					if(xhr.responseText=="-1"){
						alert("激活码错误");
						return false;
					}else{
						//正确
						if(!verifyCheck._click()) return;
						//$(".part3").hide();
						$(".part2").hide();
						$(".part4").show();
						$(".step li").eq(2).addClass("on");
						countdown({
							maxTime:10,
							ing:function(c){
								$("#times").text(c);
							},
							after:function(){
								window.location.href="index.jsp";		
							}
						});	
					}
				}
			}
			xhr.open("get","userAction_registerYanEmail?verificationCode="+verifyNo);
			xhr.send(null);
		}
	}
	
</script>
</head>
<body class="bgf4">
<div class="login-box f-mt10 f-pb50">
	<div class="main bgf">    
    	<div class="reg-box-pan display-inline">  
        	<div class="step">        	
                <ul>
                    <li class="col-xs-4 on">
                        <span class="num"><em class="f-r5"></em><i>1</i></span>                	
                        <span class="line_bg lbg-r"></span>
                        <p class="lbg-txt">填写账户信息</p>
                    </li>
                    <li class="col-xs-4">
                        <span class="num"><em class="f-r5"></em><i>2</i></span>
                        <span class="line_bg lbg-l"></span>
                        <span class="line_bg lbg-r"></span>
                        <p class="lbg-txt">验证账户信息</p>
                    </li>
                    <li class="col-xs-4">
                        <span class="num"><em class="f-r5"></em><i>3</i></span>
                        <span class="line_bg lbg-l"></span>
                        <p class="lbg-txt">注册成功</p>
                    </li>
                </ul>
            </div>
        	<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
        		
        		
            	<div class="part1">
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" onblur="blurUserName()" maxlength="20" class="txt03 f-r3 required" tabindex="1" 
                            data-valid="isNonEmpty||between:3-20||isUname" 
       							data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                           
                            <span class="ie8 icon-close close hide"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>邮箱：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" onblur="blurEmail()" class="txt03 f-r3 required" keycodes="tel" tabindex="2" 
                            data-valid="isNonEmpty||isPhone" data-error="邮箱不能为空||邮箱格式不正确" maxlength="20" id="phone" /> 
                            <span class="ie8 icon-close close hide"></span>                           
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请填写有效邮箱</label>
                            <label class="focus valid"></label>
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>    
                        <div class="f-fl item-ifo">
                            <input type="password" id="password" onblur="blurPassword()" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" 
                            onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" 
                            data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" /> 
                            <span class="ie8 icon-close close hide" style="right:55px"></span>
                            <span class="showpwd" data-eye="password"></span>                        
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
                            <label class="focus valid"></label>
                            <span class="clearfix"></span>
                            <label class="strength">
                            	<span class="f-fl f-size12">安全程度：</span>
                            	<b><i>弱</i><i>中</i><i>强</i></b>
                            </label>    
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>    
                        <div class="f-fl item-ifo">
                            <input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="4" style="ime-mode:disabled;" 
                            onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" 
                            data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" />
                            <span class="ie8 icon-close close hide" style="right:55px"></span>
                            <span class="showpwd" data-eye="rePassword"></span>
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus">请再输入一遍上面的密码</label> 
                            <label class="focus valid"></label>                          
                        </div>
                    </div>
                    
                    <div class="item col-xs-12" style="height:auto">
                        <span class="intelligent-label f-fl">&nbsp;</span>  
                        <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款"> 
                        	<input type="checkbox" checked /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
                        </p>                       
                        <label class="focus valid"></label> 
                    </div> 
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl">&nbsp;</span>    
                        <div class="f-fl item-ifo">
                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1" >下一步</a>  
                        </div>
                    </div> 
                </div>
                
                <!-- 发邮件页面 -->
             	 <div class="part2" style="display:none">
                	<div class="alert alert-info" style="width:700px">验证码已发送至您邮箱，请输入邮箱中的验证码，确保您的邮箱真实有效。</div>                    
                    <div class="item col-xs-12 f-mb10" style="height:auto">
                        <!--  
                        <span class="intelligent-label f-fl">：</span>    
                        <div class="f-fl item-ifo c-blue">
                            15824450934
                        </div>
                        -->
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>激活码：</span>    
                        <div class="f-fl item-ifo">
                            <input type="text" maxlength="6" id="verifyNo" class="txt03 f-r3 f-fl required" tabindex="4" style="width:167px" 
                            data-valid="isNonEmpty||isInt" data-error="激活码不能为空||请输入6位数字激活码" /> 
                           	<!--  
                           	<span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="width:97px;display:none;">发送验证码</span>
                            <span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" style="width:97px;">发送验证码</span>
                            <span class="ie8 icon-close close hide" style="right:130px"></span>
                            -->
                            
                            <input type="button" value="发送激活码" style="height:36px;width:92px;" onclick="jihuoma()"/>
                           	
                            <label class="icon-sucessfill blank hide"></label>
                            <label class="focus"><span>请查收邮箱，并填写邮箱中的激活码（此激活码3分钟内有效）</span></label>   
                            <label class="focus valid"></label>                        
                        </div>
                    </div>
                    <div class="item col-xs-12">
                        <span class="intelligent-label f-fl">&nbsp;</span>    
                        <div class="f-fl item-ifo">
                        	<!--  
                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part3" onclick="yanEmail()">注册</a>  
                           -->   
                           <input type="button" class="btn btn-blue f-r3" id="btn_part" onclick="return yanEmail();" value="注册"/>                    
                        </div>
                    </div> 
                </div>
               
              
              	
                <div class="part4 text-center" style="display:none">
                	<h3>恭喜cz82465，您已注册成功，现在开始您的学霸之旅吧！</h3>
                    <p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到
                     <a href="index.jsp" class="c-blue">登录页面</a></p>
                </div>          
            </div>
        </div>
    </div>
</div>
<div class="m-sPopBg" style="z-index:998;"></div>
<div class="m-sPopCon regcon">
	<div class="m-sPopTitle"><strong>服务协议条款</strong><b id="sPopClose" class="m-sPopClose" onClick="closeClause()">×</b></div>
    <div class="apply_up_content">
    	<pre class="f-r0">
		<strong>同意以下服务条款，提交注册信息</strong>
        </pre>
    </div>
    <center><a class="btn btn-blue btn-lg f-size12 b-b0 b-l0 b-t0 b-r0 f-pl50 f-pr50 f-r3" href="javascript:closeClause();">
    已阅读并同意此条款</a></center>
</div>
<script>
$(function(){	
	//第一页的确定按钮
	$("#btn_part1").click(function(){						
		if(!verifyCheck._click()) return;
		$(".part1").hide();
		$(".part2").show();
		$(".step li").eq(1).addClass("on");
	});
	//第二页的确定按钮
	$("#btn_part2").click(function(){			
		if(!verifyCheck._click()) return;
		$(".part2").hide();
		//$(".part3").show();	
	});	
	//第三页的确定按钮
	$("#btn_part3").click(function(){			
		if(!verifyCheck._click()) return;
		//$(".part3").hide();
		$(".part2").hide();
		$(".part4").show();
		$(".step li").eq(2).addClass("on");
		countdown({
			maxTime:10,
			ing:function(c){
				$("#times").text(c);
			},
			after:function(){
				window.location.href="index.jsp";		
			}
		});		
	});	
});
function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
function closeClause(){
	$(".m-sPopBg,.m-sPopCon").hide();		
}
</script>
</body>
</html>