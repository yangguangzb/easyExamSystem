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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin2/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin2/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <!-- 必须 -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin2/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin2/js/xadmin.js"></script>
  	<script type="text/javascript">
  		var brushName="${requestScope.brushName}";
  		var subjectType="${requestScope.subjectType}";
  		var courseName="${requestScope.courseName}";
		if(brushName!=""){
			$("#brushName option[value='${requestScope.brushName}']").attr("selected", true);
		}
		if(subjectType!=""){
			$("#subjectType option[value='${requestScope.subjectType}']").attr("selected", true);
		}
		if(courseName!=""){
			$("#courseName option[value='${requestScope.subjectType}']").attr("selected", true);
		}
  	</script>
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
        <form method="post" action="manageSubjectAction_manageSubject.action" class="layui-form layui-col-md12 x-so">
          <div class="layui-input-inline">
            <select name="brushName" id="brushName">
              <option value="">区类型</option>
              <option value="普通区">普通区</option>
              <option value="精品区">精品区</option>
            </select>
          </div>
          <div class="layui-input-inline">
            <select name="subjectType" id="subjectType">
              <option value="">题目类型</option>
              <option value="选择题">选择题</option>
              <option value="填空题">填空题</option>
              
            </select>
          </div>
          <div class="layui-input-inline">
            <select name="courseName" id="courseName">
              <option value="">课程名称</option>
              <option value="大学英语">大学英语</option>
              <option value="计算机网络">计算机网络</option>
              <option value="数据结构">数据结构</option>
              <option value="马克思原理">马克思原理</option>
              <option value="软件工程">软件工程</option>
              <option value="数据库原理">数据库原理</option>
            </select>
          </div>
          <input type="text" name="subjectId"  placeholder="题目编号" autocomplete="off" class="layui-input">
          <button class="layui-btn" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加题目','${pageContext.request.contextPath}/admin2/subject-add.jsp')"><i class="layui-icon"></i>添加</button>
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
        <tbody id="table">
          <c:if test="${requestScope.manageSubjectList!=null}">
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
	              <a title="详情"  onclick="x_admin_show('查看详情','manageSubjectAction_checkSubjectById.action?subjectId=${manageSubject.subjectId}')" href="javascript:;">
	                <i class="layui-icon">&#xe63c;</i>
	              </a>
	              <a title="删除" onclick="member_del(this,${manageSubject.subjectId})" href="javascript:;">
	                <i class="layui-icon">&#xe640;</i><!-- ${pageContext.request.contextPath}/admin2/subject-edit.jsp? -->
	              </a>
	              <a title="修改" onclick="x_admin_show('修改信息','manageSubjectAction_checkSubjectById.action?flag2=edit&subjectId=${manageSubject.subjectId}')" href="javascript:;">
	                <i class="layui-icon">&#xe639;</i>
	              </a>
	            </td>
	          </tr>
	        </c:forEach>
          </c:if>
        </tbody>
      </table>
      <div id="demo3"></div>
    </div>
    <script>
		layui.use(['laypage', 'layer'], function(){
		  var laypage = layui.laypage
		  ,layer = layui.layer;
		  //调用分页
		  laypage.render({
		    elem: 'demo3'
		    ,count: ${sessionScope.subjectSize}		//数据总数,从服务器得到
		    ,first: '首页'
		    ,last: '尾页'
		    ,prev: '<em>←</em>'
		    ,next: '<em>→</em>'
		    ,limit: 10	//每页记录数
		    ,jump: function(obj){
		      //获得当前页
		      var nowPage=obj.curr;
		      if(nowPage!=1){
		      	var xhr=new XMLHttpRequest();
		      	xhr.onreadystatechange=function(){
					if(xhr.readyState==4&&xhr.status==200){
						$("#table").reload();
					}
		 	 	}
			  //xhr.open("get","../servlet/ManageUsers?flag=checkUses&nowPage="+nowPage)
			 	xhr.send(null);
		      }
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
      /*删除题目*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              $.ajax({
              	type:'post',
              	url:'manageSubjectAction_delSubject?subjectId='+id,
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