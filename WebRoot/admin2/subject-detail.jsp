<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.san.model.Subject"%>
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
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
  	<!-- 第一次判断 -->
  	<c:if test="${subjectById==null}">
  		<c:redirect url="../servlet/ManageSubject?flag=checkSubjectById&subjectId=${param.subjectId}"></c:redirect>
  	</c:if>
  	 <!-- 第二次判断,servlet到jsp -->
  	 <c:if test="${param.subjectId!=null}">
  	 	<c:if test="${param.subjectId!=subjectById.subjectId}">
  	 		<c:redirect url="../servlet/ManageSubject?flag=checkSubjectById&subjectId=${param.subjectId}"></c:redirect>
  	 	</c:if>
  	 </c:if>
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <p><span class="x-red">*</span>标题</p>
              <div class="layui-input-block" style="width:1060px;font-size:14px;margin-left:30px;">
                  ${sessionScope.subjectById.subjectTitle}
              </div>
          </div>
          <div class="layui-form-item">
              <p><span class="x-red">*</span>A选项</p>
              <div class="layui-input-inline" style="width:1060px;font-size:14px;margin-left:30px;">
                  ${sessionScope.subjectById.optionA}
              </div>
          </div>
          <div class="layui-form-item">
              <p><span class="x-red">*</span>B选项</p>
              <div class="layui-input-inline" style="width:1060px;font-size:14px;margin-left:30px;">
                  ${sessionScope.subjectById.optionB}
              </div>
          </div>
          <div class="layui-form-item">
              <p><span class="x-red">*</span>C选项</p>
              <div class="layui-input-inline" style="width:1060px;font-size:14px;margin-left:30px;">
                  ${sessionScope.subjectById.optionB}
              </div>
          </div>
          <div class="layui-form-item">
          	  <p><span class="x-red">*</span>D选项</p>
              <div class="layui-input-inline" style="width:1060px;font-size:14px;margin-left:30px;">
              	  ${sessionScope.subjectById.optionC}
              </div>
          </div>
          <div class="layui-form-item">
          	  <p><span class="x-red">*</span>答案</p>
              <div class="layui-input-inline" style="width:1060px;font-size:14px;margin-left:30px;">
                  ${sessionScope.subjectById.subjectAnswer}
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <p><span class="x-red">*</span>解析</p>
              <div class="layui-input-inline" style="width:1060px;font-size:14px;margin-left:30px;">
                  ${sessionScope.subjectById.analysis}
              </div>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
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