<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- 必须 -->
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form method="post" action="../servlet/ManageSubject?flag=manageSubject" class="layui-form layui-col-md12 x-so">
          <!--<input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end">
          -->
          <div class="layui-input-inline">
            <select name="brushName">
              <option value="">区类型</option>
              <option value="普通区">普通区</option>
              <option value="精品区">精品区</option>
            </select>
          </div>
          <div class="layui-input-inline">
            <select name="subjectType">
              <option value="">题目类型</option>
              <option value="选择题">选择题</option>
              <option value="填空题">填空题</option>
              
            </select>
          </div>
          <div class="layui-input-inline">
            <select name="courseName">
              <option value="">课程名称</option>
              <option value="大学英语">大学英语</option>
              <option value="计算机网络">计算机网络</option>
              <option value="数据结构">数据结构</option>
              <option value="马克思原理">马克思原理</option>
              <option value="软件工程">软件工程</option>
              <option value="高等数学">高等数学</option>
            </select>
          </div>
          <input type="text" name="subjectId"  placeholder="题目编号" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加题目','./subject-add.jsp')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${sessionScope.subjectSize} 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>题目编号</th>
            <th>区类型</th>
            <th>课程名</th>
            <th>题目类型</th>
            <th>题目标题</th>
            <th>操作</th>
            </tr>
        </thead>
        <tbody>
          <c:if test="${sessionScope.manageSubjectList!=null}">
          	<c:forEach items="${manageSubjectList}" var="manageSubject">
	          <tr>
	            <td>
	              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
	            </td>
	            <td width="90px;">${manageSubject.subjectId}</td>
	            <td width="90px;">${manageSubject.brushName}</td>
	            <td width="90px;">${manageSubject.courseName}</td>
	            <td width="90px;">${manageSubject.subjectType}</td>
	            <td >${manageSubject.subjectTitle}</td>
	            <td class="td-manage" width="110px;">
	              <a title="详情"  onclick="x_admin_show('查看详情','subject-detail.jsp?subjectId=${manageSubject.subjectId}')" href="javascript:;">
	                <i class="layui-icon">&#xe63c;</i>
	              </a>
	              <a title="删除" onclick="member_del(this,${manageSubject.subjectId})" href="javascript:;">
	                <i class="layui-icon">&#xe640;</i>
	              </a>
	              <a title="修改" onclick="x_admin_show('修改信息','subject-edit.jsp?subjectId=${manageSubject.subjectId}')" href="javascript:;">
	                <i class="layui-icon">&#xe639;</i>
	              </a>
	            </td>
	          </tr>
	        </c:forEach>
          </c:if>
        </tbody>
      </table>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              $.ajax({
              	type:'post',
              	url:'../servlet/ManageSubject?flag=delSubject&subjectId='+id,
              	cache:false,
              	success:function(msg){
					if(msg==1){
						//删除成功
						$(obj).parents("tr").remove();
              			layer.msg('已删除!',{icon:1,time:1000});
					}else{
						//删除失败
						layer.alert("删除失败");
					}              	
              	}
              });
          });
      }



      function delAll (argument) {
        var data = tableCheck.getData();
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
        });
      }
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>