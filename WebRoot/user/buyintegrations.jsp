<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>购买积分</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="../css/font.css">
    <link rel="stylesheet" href="../css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form" action="integration/integration_updateIntegration">
          <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">
                </label>
                <div class="layui-input-inline">
                  <select name="buyNumber">
  <option value ="A">A</option>
  <option value ="B">B</option>
  <option value="C">C</option>
  <option value="D">D</option>
    <option value="E">E</option>
    <option value="F">F</option>
</select>
                </div>
                <div class="layui-form-mid layui-word-aux">
                    购买积分数目
                    </div>
            </div>
            <div class="layui-form-item">
                    <label for="L_repass" class="layui-form-label">
                    </label>
                    <button type="submit" class="layui-btn" >
                        确认
                    </button>
                </div>
      </form>
    </div>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>