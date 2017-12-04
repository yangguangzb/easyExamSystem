<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if(session.getAttribute("user")==null){
		response.sendRedirect("login.jsp");
		return ;
	}
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
	.person{
		width:1583px;
		height:746px;
		margin:auto;
	}
	.outdata{
	
	}
</style>
</head>

<script>
	$(function() {
		$(".meun-item").click(function() {
			$(".meun-item").removeClass("meun-item-active");
			$(this).addClass("meun-item-active");
			var itmeObj = $(".meun-item").find("img");
			itmeObj.each(function() {
				var items = $(this).attr("src");
				items = items.replace("_grey.png", ".png");
				items = items.replace(".png", "_grey.png")
				$(this).attr("src", items);
			});
			var attrObj = $(this).find("img").attr("src");;
			attrObj = attrObj.replace("_grey.png", ".png");
			$(this).find("img").attr("src", attrObj);
		});
		$("#topAD").click(function() {
			$("#topA").toggleClass(" glyphicon-triangle-right");
			$("#topA").toggleClass(" glyphicon-triangle-bottom");
		});
		$("#topBD").click(function() {
			$("#topB").toggleClass(" glyphicon-triangle-right");
			$("#topB").toggleClass(" glyphicon-triangle-bottom");
		});
		$("#topCD").click(function() {
			$("#topC").toggleClass(" glyphicon-triangle-right");
			$("#topC").toggleClass(" glyphicon-triangle-bottom");
		});
		$(".toggle-btn").click(function() {
			$("#leftMeun").toggleClass("show");
			$("#rightContent").toggleClass("pd0px");
		})
	})
	
</script>

<script type="text/javascript">
	//退出系统
	function signOut(){
		var isSignOut=confirm("您确定要退出系统吗?");
		if(isSignOut==true){
			//退出
			location.href="loginServlet?sign=isSignOut";
		}
	}	
</script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/slide.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="person">
		<div class="leftMeun" id="leftMeun">
			<!--<div id="logoDiv">
				<p id="logoP"><img id="logo" alt="左右结构项目" src="images/logo.png"><span>左右结构项目</span></p>
			</div>
			--><div id="personInfor">
				<p id="userName">${sessionScope.user.userName }</p>
				<p><span>${sessionScope.user.e_mail }</span></p>
				<p>
					<a style="text-decoration:none;" href="javascript:;" onclick="signOut()">退出登录</a>
				</p>
			</div>
			<div class="meun-title">账号管理</div>
			<div class="meun-item meun-item-active" href="#sour" aria-controls="sour" role="tab" data-toggle="tab"><img src="images/icon_source.png">个人资料</div>
			<div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab">
			<img src="images/icon_chara_grey.png">下载记录</div>
			<div class="meun-item" href="#user" aria-controls="user" role="tab" data-toggle="tab">
			<img src="images/icon_user_grey.png">上传记录</div>
			<div class="meun-item" href="#chan" aria-controls="chan" role="tab" data-toggle="tab">
			<img src="images/icon_change_grey.png">修改密码</div>
			<div class="meun-title">地区管理</div>
			<div class="meun-item" href="#scho" aria-controls="scho" role="tab" data-toggle="tab">
			<img src="images/icon_house_grey.png">积分购买</div>
			<div class="meun-item" href="#regu" aria-controls="regu" role="tab" data-toggle="tab">
			<img src="images/icon_rule_grey.png">购买记录</div>
		</div>
		<!-- 右侧具体内容栏目 -->
			<div id="rightContent">
				<a class="toggle-btn" id="nimei">
					<i class="glyphicon glyphicon-align-justify"></i>
				</a>
				<!-- Tab panes -->
				<div class="tab-content">
					<!-- 资源管理模块 -->
					<div role="tabpanel" class="tab-pane active" id="sour">
						<div class="check-div form-inline">
							<!-- 个人资料 -->
							<div class="outdata" style="width:400px;height:400px;border:1px red solid; margin:50px auto;">
								<table>
									<tr>
										<td>用户名:</td>
										<td>${sessionScope.user.userName}</td>
									</tr>
									<tr>
										<td>等级:</td>
										<td>${sessionScope.user.userType}</td>
									</tr>
									<tr>
										<td>邮箱:</td>
										<td>${sessionScope.user.e_mail}</td>
									</tr>
									<tr>
										<td>积分:</td>
										<td>${sessionScope.user.integralNumber}</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
					<!-- 权限管理模块 -->
					<div role="tabpanel" class="tab-pane" id="char">

						<div class="check-div">
							<button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addChar">添加权限</button>
						</div>
						<div class="data-div">
							<p>你好</p>
							<p>你好</p>
							<p>你好</p>
							<p>你好</p>
							
						</div>
						<!--弹出删除权限警告窗口-->
						
						<!-- /.modal -->

					</div>
					<!--用户管理模块-->
					<div role="tabpanel" class="tab-pane" id="user">
						<div class="check-div form-inline">
							<div class="col-xs-3">
								<button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addUser">添加用户 </button>
							</div>
							<div class="col-xs-4">
								<input type="text" class="form-control input-sm" placeholder="输入文字搜索">
								<button class="btn btn-white btn-xs ">查 询 </button>
							</div>
							<div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
								<label for="paixu">排序:&nbsp;</label>
								<select class=" form-control">
									<option>地区</option>
									<option>地区</option>
									<option>班期</option>
									<option>性别</option>
									<option>年龄</option>
									<option>份数</option>
								</select>
							</div>
						</div>
						<div class="data-div">
							<div class="row tableHeader">
								<div class="col-xs-2 ">
									用户名
								</div>
								<div class="col-xs-2">
									地区
								</div>
								<div class="col-xs-2">
									真实姓名
								</div>
								<div class="col-xs-2">
									电话
								</div>
								<div class="col-xs-2">
									状态
								</div>
								<div class="col-xs-2">
									操作
								</div>
							</div>
							<div class="tablebody">

								<div class="row">
									<div class="col-xs-2 ">
										goodmoning
									</div>
									<div class="col-xs-2">
										国际关系地区
									</div>
									<div class="col-xs-2">
										李豆豆
									</div>
									<div class="col-xs-2">
										13688889999
									</div>
									<div class="col-xs-2">
										状态
									</div>
									<div class="col-xs-2">
										<button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseUser">修改</button>
										<button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteUser">删除</button>
									</div>
								</div>

							</div>

						</div>
						<!--页码块-->
						<footer class="footer">
							<ul class="pagination">
								<li>
									<select>
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
										<option>7</option>
										<option>8</option>
										<option>9</option>
										<option>10</option>
									</select>
									页
								</li>
								<li class="gray">
									共20页
								</li>
								<li>
									<i class="glyphicon glyphicon-menu-left">
										</i>
								</li>
								<li>
									<i class="glyphicon glyphicon-menu-right">
										</i>
								</li>
							</ul>
						</footer>
					</div>
					<!-- 修改密码模块 -->
					<div role="tabpanel" class="tab-pane" id="chan">
						<div class="check-div">
							
						</div>
						<div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
							<!-- 重置密码 -->
							<form class="form-horizontal" method="post" action="loginServlet?flag=personRegister">
								<div class="form-group">
									<label for="sKnot" class="col-xs-4 control-label">原密码：</label>
									<div class="col-xs-5">
										<input type="text" class="form-control input-sm duiqi" name="oldPassword" id="sKnot1" placeholder="请输入旧密码" style="margin-top: 7px;">
									</div>
								</div>
								<div class="form-group">
									<label for="sKnot" class="col-xs-4 control-label">新密码：</label>
									<div class="col-xs-5">
										<input type="password" class="form-control input-sm duiqi" name="newPassword" id="sKnot2" placeholder="请输入新密码" style="margin-top: 7px;">
									</div>
								</div>
								<div class="form-group">
									<label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
									<div class="col-xs-5">
										<input type="password" class="form-control input-sm duiqi" id="sKnot3" placeholder="再次输入新密码" style="margin-top: 7px;">
									</div>
								</div>
								<div class="form-group text-right">
									<div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
										<button type="reset" class="btn btn-xs btn-white">取 消</button>
										<button type="submit" class="btn btn-xs btn-green">保存</button>
									</div>
								</div>
							</form>
						</div>

					</div>
					<!--地区管理模块-->
					<div role="tabpanel" class="tab-pane" id="scho">

						<div class="check-div form-inline">
							<div class="col-xs-3">
								<button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addSchool">添加地区 </button>
							</div>
							<div class="col-lg-4 col-xs-5">
								<input type="text" class=" form-control input-sm " placeholder="输入文字搜索">
								<button class="btn btn-white btn-xs ">查 询 </button>
							</div>
							<div class="col-lg-3 col-lg-offset-1 col-xs-3" style="padding-right: 40px;text-align: right;float: right;">
								<label for="paixu">排序:&nbsp;</label>
								<select class="form-control">
									<option>地区</option>
									<option>排名</option>
								</select>
							</div>
						</div>
						<div class="data-div">
							<div class="row tableHeader">
								<div class="col-xs-1 ">
									编码
								</div>
								<div class="col-xs-2 ">
									地区
								</div>
								<div class="col-xs-1">
									经度
								</div>
								<div class="col-xs-1">
									维度
								</div>
								<div class="col-xs-2">
									建筑信息
								</div>
								<div class="col-xs-2">
									人员列表
								</div>
								<div class="col-xs-2">
									操作
								</div>
							</div>
						</div>
						<!--页码块-->
						<footer class="footer">
							
						</footer>
					</div>
					<!--规则管理模块-->
					<div role="tabpanel" class="tab-pane" id="regu" style="padding-top: 50px;">
						<div class="data-div">
							<div class="tablebody col-lg-10 col-lg-offset-1">
								<div class="row">
									<div class="col-xs-3" style="padding-right: 0;">签到超时时间</div>
									<div class="col-xs-7 expand-col">
										<div class="slider-minmax1">
										</div>
										<div class="row top100">
											<span class="left">0</span>
											<span class="right">30</span>
										</div>
									</div>
									<div class="col-xs-2">
										<button class="btn btn-xs btn-white">默认值</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		
		
		
	</div>
	
	
	
	
	
	<script>
			 //min/max slider
			function huadong(my, unit, def,max) {
				$(my).noUiSlider({
					range: [0, max],
					start: [def],
					handles: 1,
					connect: 'upper',
					slide: function() {
						var val =Math.floor($(this).val());
						$(this).find(".noUi-handle").text(
							val + unit
						);
						console.log($(this).find(".noUi-handle").parent().parent().html());
					},
					set: function() {
						var val =Math.floor($(this).val());
						$(this).find(".noUi-handle").text(
							val + unit
						);
					}
				});
				$(my).val(def, true);
			}
			huadong('.slider-minmax1', "分钟", "5",30);
			huadong('.slider-minmax2', "分钟", "6",15);
			huadong('.slider-minmax3', "分钟", "10",60);
			huadong('.slider-minmax4', "次", "2",10);
			huadong('.slider-minmax5', "天", "3",7);
			huadong('.slider-minmax6', "天", "8",10);
		</script>
	<!-- 底部 -->
	<jsp:include page="foot.jsp"></jsp:include>
	<script src="js/bootstrap.min.js"></script>
     <!-- fancy box -->
    <script src="js/jquery.fancybox.pack.js"></script>
    <script src="js/jquery.polyglot.language.switcher.js"></script>
    <script src="js/nouislider.js"></script>
    <script src="js/jquery.bootstrap-touchspin.js"></script>
    <script src="js/SmoothScroll.js"></script>
    <script src="js/jquery.appear.js"></script>
    <script src="js/jquery.countTo.js"></script>
    <script src="js/jquery.flexslider.js"></script>
    <script src="js/imagezoom.js"></script> 
    <script id="map-script" src="js/default-map.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>
