<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>用户中心</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
	<link rel="stylesheet" href="../css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>

</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="./index.jsp">用户中心</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont"></i>
        </div>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">${user.userName}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
              <dd><a href="/logoutServlet">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="../index.jsp">前台首页</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
           
        <li>
            <dd><a onclick="x_admin_show('成绩记录','${pageContext.request.contextPath}/user/gradehistory.jsp')"><i class="iconfont">&#xe6b8;</i>成绩记录</a></dd>
            <dd><a onclick="x_admin_show('资料记录','${pageContext.request.contextPath}/user/resourcehistory.jsp')"><i class="iconfont">&#xe6b8;</i>资料记录</a></dd>
        </li>
        <li>
            <a href="javascript:;">
                <i class="iconfont">&#xe6b8;</i>
                <cite>积分管理</cite>
                <i class="iconfont nav_right">&#xe697;</i>
            </a>
            <ul class="sub-menu">
                <li>
                    <a _href="integrationhistory.jsp">
                        <i class="iconfont">&#xe6a7;</i>
                        <cite>积分记录</cite>
                    </a>
                </li >
                <li>
                    <a _href="buyintegrations.jsp">
                        <i class="iconfont">&#xe6a7;</i>
                        <cite>购买积分</cite>
                        
                    </a>
                </li>
            </ul>
            <li><!--
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>通知管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                --><!--<ul class="sub-menu">
                    <li>
                        <a _href="talknotify.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>讨论区通知</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="sharenotify.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>分享区通知</cite>
                        </a>
                    </li>
                </ul>
                --><li>
                    <dd><a onclick="x_admin_show('修改密码','changepassword.jsp')"><i class="iconfont">&#xe6b8;</i>修改密码</a></dd>
                </li>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='gradehistory.jsp' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">Copyright ©2017 All Rights Reserved</div>  
    </div>
    <!-- 底部结束 -->
</body>
</html>