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
        <form class="layui-form" id="modifyUser">
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>用户编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="userId" name="userId" value="${param.userId}" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" disabled="disabled">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>用户名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_username" name="username" value="${param.userName }" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input" disabled="disabled">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>用户类型
              </label>
              <div class="layui-input-inline">
	          	<select name="userType">
	              <option value="0">普通用户</option>
	              <option value="1">会员</option>
	              <option value="2">管理员</option>
	            </select>
          	  </div>
              <div class="layui-form-mid layui-word-aux">
                  6到16个字符
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_repass" value="${param.email}" disabled="disabled" name="repass" required="" lay-verify=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>用户状态
              </label>
              <div class="layui-input-inline">
	          	<select name="verification">
	              <option value="0">停用</option>
	              <option value="1">激活</option>
	            </select>
          	  </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>用户积分
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="integralNumber" name="integralNumber" value="${param.integralNumber}" required="" lay-verify=""
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
      
        //自定义验证规则
        /*form.verify({
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
          ,
        });*/

        //监听提交
        form.on('submit(add)', function(data){
          $.ajax({
          	type:'post',
          	url:'manageUsersAction_modifyUser?userId='+${param.userId},
          	data:$("#modifyUser").serialize(),
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