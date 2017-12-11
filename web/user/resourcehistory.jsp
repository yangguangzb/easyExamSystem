<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>资料记录</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/bootstrap-table.min.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
      <script src="../js/bootstrap.min.js"></script>

      <script src="../js/bootstrap-table.min.js"></script>
      <!-- put your locale files after bootstrap-table.js -->
      <script src="../js/bootstrap-table-zh-CN.min.js"></script>
      <!-- bootstrap js -->
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">用户中心</a>
        <a href="">资料使用记录</a>
      <!--  <a>
          <cite>导航元素</cite></a>-->
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
          <table data-toggle="table"  data-pagination="true" data-search="true" data-toggle="table" data-dataType="json" data-method="get" data-url="/resourceHistoryServlet">
              <thead>
              <tr>
                  <th data-field="recordId">记录编号</th>

                  <th data-field="useType">使用类型</th>
                  <th data-field="useNumber">使用数目</th>
                  <th data-field="useTime">使用时间</th>
              </tr>
              </thead>

          </table>
      </div>

    </div>

  </body>

</html>