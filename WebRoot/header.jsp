<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
   	window.onload=function(){
   		var user="<%=session.getAttribute("user")%>";
   	}
	//退出系统
	function signOut(){
		var isSignOut=confirm("您确定要退出系统吗?");
		if(isSignOut==true){
			//退出
			location.href="loginServlet?sign=isSignOut";
		}
	}	
</script>


<!-- 头部登录,注册,个人中心 -->
<header class="top-bar">
    <div class="container">
        <div class="clearfix">
            <div class="col-left float_left">
                <div id="polyglotLanguageSwitcher" class="">
              
                </div>
				
            </div>
            <div class="col-right float_right">
                <div class="link">
                	<c:if test="${sessionScope.user==null}">
                		<div id="lo" style="display: block;">
                    		<a href="login.jsp">登录</a>
                    		<a href="register.jsp">注册</a>
                    	</div>
                	</c:if>
                    <c:if test="${sessionScope.user!=null}">
                    	<div class="btn-group" id="person" style="margin-top:2px;">
	                		<button type="button" class="btn btn-primary dropdown-toggle btn-sm" data-toggle="dropdown">
	                			${sessionScope.user.userName }
	                			<span class="caret"></span>
	                		</button>
	                		<ul class="dropdown-menu" role="menu">
	                			<li>
						            <a href="buyPoints.jsp">充值积分</a>
						        </li>
						        <li>
						            <a href="user/index.jsp">个人中心</a>
						        </li>
						        <li>
						            <a onclick="signOut()">退出</a>
						        </li>
	                		</ul>
                		</div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</header>