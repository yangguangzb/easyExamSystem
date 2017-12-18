<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>提出问题</title>
<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="admin2/lib/layui/layui.js"></script>


<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="admin2/css/font.css">
<link rel="stylesheet" href="admin2/css/xadmin.css">
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="admin2/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="admin2/js/xadmin.js"></script>
</head>
<body>
	<div class="x-body">
        <form class="layui-form" id="problem">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>学科
              </label>
              <div class="layui-input-inline">
                  <select id="courseName" name="courseName" class="valid" lay-verify="courseName">
                    <option >大学英语</option>
                    <option >软件工程</option>
                    <option >马克思原理</option>
                    <option >计算机网络</option>
                    <option >数据结构</option>
                    <option >数据库原理</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>积分
              </label>
              <div class="layui-input-inline">
                  <select name="questionReward" id="questionReward" lay-verify="questionReward">
                    <option value="2">2</option>
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="15">15</option>
                    <option value="20">20</option>
                  </select>
              </div>
              <label for="username" class="layui-form-label" style="width: 120px;">
                  <span class="x-red">*</span>您当前积分:<span class="x-red">${sessionScope.user.integralNumber}</span>
              </label>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>标题
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="questionTitle" name="questionTitle" maxlength="40" style="width:500px;" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                  问题描述
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入内容" id="questionContent" name="questionContent" class="layui-textarea" lay-verify="required"></textarea>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  发布问题
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
            courseName: function(value){
              if($('#courseName').val()==0){
                return '请选择学科';
              }
            }
            ,questionReward: function(value){
                if($('#questionReward').val()==0){
                    return '请选择积分';
                }
            }
          });
          //监听提交
          form.on('submit(add)', function(data){
            //发异步，把数据提交给servlet
            $.ajax({
            	type:'post',
            	url:'questionServlet?flag=putQuestion',
            	data:$("#problem").serialize(),
            	cache:false,
            	success:function(msg){
					if(msg==1){
						//问题发布成功
						layer.alert("问题发布成功", {icon: 6},function () {
                		// 获得frame索引
                		var index = parent.layer.getFrameIndex(window.name);
                		//关闭当前frame
                		parent.layer.close(index);
            		});
					}else{
						//问题发布失败
						layer.alert("积分不够,请购买");
					}            	
            	}
            });
            return false;
          });
        });
    </script>
</body>
</html>