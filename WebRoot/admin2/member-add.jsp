<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" id="maddUser">
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required="" lay-verify="email"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>用户名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_username" name="username" required="" lay-verify="nikename"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="pass" required="" lay-verify="pass"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>6到16个字符
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
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
          form.verify({
            nikename: function(value){
              var guize=/^[\u4E00-\u9FA5a-zA-Z][\u4E00-\u9FA5a-zA-Z0-9_]*$/;
              if(!guize.test(value)){
              	return '用户名格式不对';
              }
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
            //console.log(data);
            $.ajax({
            	type:'post',
            	url:'../servlet/ManageUsers?flag=addUser',
            	data:$("#maddUser").serialize(),
            	cache:false,
            	//dataType:'json',
            	success:function(msg){
            		if(msg==1){
						//添加成功
						layer.alert("增加成功",{icon:6},function(){
							//获得frame索引
							var index = parent.layer.getFrameIndex(window.name);
							//关闭当前frame
							 parent.layer.close(index);
						});
					}else if(msg==-1){
						layer.alert("用户名已存在");
					}else{
						layer.alert("邮箱已注册");
					}	            	
            	}
            });
            return false;
          });
        });
       </script>
  </body>

</html>
 
 
 
 
 
 
 
 