<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>成绩记录</title>
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
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">用户中心</a>
        <a href="">成绩记录</a>
      <!--  <a>
          <cite>导航元素</cite></a>-->
      </span>
      <!--<a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    --></div>
    <div class="x-body">
      <div class="layui-row">
        <table data-toggle="table"  data-pagination="true" data-search="true" data-toggle="table" data-dataType="json" data-method="get" data-url="gradehistory/gradeHistory_listGradeHistory">
          <thead>
          <tr>
            <th data-field="gradeId">成绩编号</th>

            <th data-field="brushId">刷题区编号</th>
            <th data-field="courseName">课程</th>
            <th data-field="grade">成绩</th>
            <th data-field="gradeTime">时间</th>
          </tr>
          </thead>
        </table>
      </div>

    </div>

  </body>

</html>