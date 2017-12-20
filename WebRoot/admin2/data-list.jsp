<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin2/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin2/css/xadmin.css">
    
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin2/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin2/js/xadmin.js"></script>
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
        <form method="post" action="${pageContext.request.contextPath}/servlet/ManageDataServlet?flag=checkDatas" class="layui-form layui-col-md12 x-so">
          <div class="layui-input-inline">
            <select name="courseName" id="courseName">
              <option value="">课程名称</option>
              <option value="大学英语" selected="selected">大学英语</option>
              <option value="计算机网络">计算机网络</option>
              <option value="数据结构">数据结构</option>
              <option value="马克思原理">马克思原理</option>
              <option value="软件工程">软件工程</option>
              <option value="高等数学">高等数学</option>
            </select>
          </div>
          <input type="text" name="userId"  placeholder="上传者编号" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./member-add.jsp')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${fn:length(mUserList)} 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>资料编号</th>
            <th>上传者编号</th>
            <th>课程名</th>
            <th>资料名</th>
            <th>资料描述</th>
            <th>资料路径</th>
            <th>下载次数</th>
            <th>积分数目</th>
            <th>操作</th>
            </tr>
        </thead>
        <tbody>
          <c:if test="${requestScope.mUserList!=null}">
          	<c:forEach items="${mUserList}" var="mUser">
	          <tr>
	            <td>
	              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
	            </td>
	            <td>${mUser.userId}</td>
	            <td>${mUser.userName}</td>
	            <td>${mUser.userType}</td>
	            <td>${mUser.e_mail}</td>
	            <td>${mUser.verification}</td>
	            <td >${mUser.integralNumber}</td>
	            <td class="td-manage" width="110px;">
	              <a title="修改"  onclick="x_admin_show('修改信息',
	              './member-edit.jsp?userId=${mUser.userId}&userName=${mUser.userName}&email=${mUser.e_mail}&integralNumber=${mUser.integralNumber}')" 
	              href="javascript:;">
	                <i class="layui-icon">&#xe63c;</i>
	              </a>
	              <a title="删除" onclick="member_del(this,${mUser.userId})" href="javascript:;">
	                <i class="layui-icon">&#xe640;</i>
	              </a>
	            </td>
	          </tr>
	        </c:forEach>
          </c:if>
        </tbody>
      </table>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		
	</fieldset>
	<div id="demo3"></div>
	<!-- 分页 -->
	<script>
		layui.use(['laypage', 'layer'], function(){
		  var laypage = layui.laypage
		  ,layer = layui.layer;
		  //调用分页
		  laypage.render({
		    elem: 'demo3'
		    ,count: ${fn:length(mUserList)}		//数据总数,从服务器得到
		    ,first: '首页'
		    ,last: '尾页'
		    ,prev: '<em>←</em>'
		    ,next: '<em>→</em>'
		    ,limit: 1	//每页记录数
		    ,jump: function(obj){
		      //获得当前页
		      var nowPage=obj.curr;
		      var xhr=new XMLHttpRequest();
		      xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					
				}
		 	 }
			  //xhr.open("get","../servlet/ManageUsers?flag=checkUse&nowPage="+nowPage)
			  xhr.send(null);
		      //if(nowPage!=1){
		      	 //url:'../servlet/ManageUsers?flag=checkUsers&nowPage='+obj.curr;
		      //}
		      //模拟渲染
		      /*document.getElementById('biuuu_city_list').innerHTML = function(){
		        var arr = []
		        ,thisData = data.concat().splice(obj.curr*obj.limit - obj.limit, obj.limit);
		        layui.each(thisData, function(index, item){
		          arr.push('<li>'+ item +'</li>');
		        });
		        return arr.join('');
		      }();*/
		    }
		  });
		});
	</script>
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
              //发异步删除数据
              $.ajax({
              	type:'post',
              	url:'../servlet/ManageUsers?flag=delUser&userId='+id,
              	cache:false,
              	success:function(msg){
              		if(msg==1){
              			$(obj).parents("tr").remove();
             			layer.msg('已删除!',{icon:1,time:1000});
              		}else{
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