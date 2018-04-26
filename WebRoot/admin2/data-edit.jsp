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
    <div class="x-body">
        <form class="layui-form" id="modifyData">
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>资料编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="resourceId" name="resourceId" value="${param.resourceId}" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" disabled="disabled">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>上传者编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="uploadId" name="uploadId" value="${param.uploadId }" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" disabled="disabled">
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
	              <option value="高等数学">高等数学</option>
	            </select>
	          </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>资料名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="resourceName" value="${param.resourceName}" name="resourceName" required="" lay-verify=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>资料描述
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="resourceDescription" name="resourceDescription" value="${param.resourceDescription }" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>资料路径
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="resourcePath" name="resourcePath" value="${param.resourcePath}" required="" lay-verify=""
                  autocomplete="off" class="layui-input" readonly="readonly">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>积分数目
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="integration" name="integration" value="${param.integration }" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input">
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
          $.ajax({
          	type:'post',
          	url:'manageResourceAction_modifyDatas.action?resourceId='+${param.resourceId},
          	data:$("#modifyData").serialize(),
          	cache:false,
          	success:function(msg){
          		if(msg==1){
          			//修改成功
          			layer.alert("修改成功", {icon: 6},function () {
              		// 获得frame索引
              		var index = parent.layer.getFrameIndex(window.name);
              		//关闭当前frame
              		parent.layer.close(index);
          		});
          		}else{
          			//修改失败
          			layer.alert("修改失败");
          		}
          	}
          });
          return false;
        });
      });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>