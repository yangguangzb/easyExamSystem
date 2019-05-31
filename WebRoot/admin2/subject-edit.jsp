<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin2/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin2/js/xadmin.js"></script>
  </head>
  <body>
  	
    <div class="x-body">
        <form class="layui-form" id="editSubject">
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>题目编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="subjectId" name="subjectId" readonly="readonly" value="${sessionScope.subjectById.subjectId}" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" >
              </div>
          </div>
          <div class="layui-form-item">
          	  <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>区类型
              </label>
	          <div class="layui-input-inline">
	            <select name="brushName">
	              <option value="普通区">普通区</option>
	              <option value="精品区">精品区</option>
	            </select>
	          </div>
          </div>
          <div class="layui-form-item">
          	  <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>题目类型
              </label>
	          <div class="layui-input-inline">
	            <select name="subjectType">
	              <option value="选择题">选择题</option>
	              <option value="填空题">填空题</option>
	            </select>
	          </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>课程名称
              </label>
	          <div class="layui-input-inline">
	            <select name="courseName">
	              <option value="大学英语">大学英语</option>
	              <option value="计算机网络">计算机网络</option>
	              <option value="数据结构">数据结构</option>
	              <option value="马克思原理">马克思原理</option>
	              <option value="软件工程">软件工程</option>
	              <option value="数据库原理">数据库原理</option>
	            </select>
	          </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>标题
              </label>
    	    <div class="layui-input-block">
              <textarea style="min-height:40px;" name="subjectTitle" lay-verify="required" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.subjectTitle}</textarea>
            </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>A选项
              </label>
    	    <div class="layui-input-block">
              <textarea style="min-height:40px;" name="optionA" lay-verify="required" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.optionA}</textarea>
            </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>B选项
              </label>
    	    <div class="layui-input-block">
              <textarea style="min-height:40px;" name="optionB" lay-verify="required" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.optionB}</textarea>
            </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>C选项
              </label>
    	    <div class="layui-input-block">
              <textarea style="min-height:40px;" name="optionC" lay-verify="required" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.optionC}</textarea>
            </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>D选项
              </label>
    	    <div class="layui-input-block">
              <textarea style="min-height:40px;" name="optionD" lay-verify="required" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.optionD}</textarea>
            </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>答案
              </label>
    	    <div class="layui-input-block">
              <textarea style="min-height:40px;" name="subjectAnswer" lay-verify="required" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.subjectAnswer}</textarea>
            </div>
          </div>
          <div class="layui-form-item layui-form-text">
  			<label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>解析
              </label>
    	    <div class="layui-input-block">
              <textarea name="analysis" placeholder="请输入内容" class="layui-textarea">${sessionScope.subjectById.analysis}</textarea>
            </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  修改
              </button>
          </div>
      </form>
    </div>
     <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
          //监听提交
            form.on('submit(add)', function(data){
            //console.log(data);
            $.ajax({
            	type:'post',
            	url:'manageSubjectAction_editSubject.action',
            	data:$("#editSubject").serialize(),
            	cache:false,
            	//dataType:'json',
            	success:function(msg){
            		if(msg==1){
						//添加成功
						layer.alert("修改成功",{icon:6},function(){
							//获得frame索引
							var index = parent.layer.getFrameIndex(window.name);
							//关闭当前frame
							 parent.layer.close(index);
						});
					}else{
						layer.alert("修改失败");
					}	            	
            	}
            });
            return false;
          });
        });
       </script>
  </body>
</html>