<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title> 

    <!-- mobile responsive meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>
	<!-- 自己的css -->
	<style type="text/css">
		.clear{
			clear:both;
		}
	</style>
	<script type="text/javascript">
		function buyPoints(){
			var money=document.getElementsByName("money");
			var isEmpty=false;
			var buyNum;
			for(var i=0;i<money.length;i++){
				if(money[i].checked){
					isEmpty=true;
					buyNum=money[i].value;
					break;
				}
			}
			if(isEmpty==false){
				alert("请选择购买的积分");
				return false;
			}else{
				//异步发送购买信息
				var xhr=new XMLHttpRequest();
				xhr.onreadystatechange=function(){
					if(xhr.status==200&&xhr.readyState==4){
						if(xhr.responseText==1){
							alert("购买成功");
						}else{
							alert("购买失败");
						}
					}
				}
				xhr.open("get","useRecordAction_buyPoints.action?buyNum="+buyNum);
				xhr.send(null);
			}
		}
	</script>
</head>
<body>		<!-- 购买积分界面 -->
<div class="boxed_wrapper">
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 导航栏 -->
<jsp:include page="nav.jsp"></jsp:include>
<section class="rev_slider_wrapper">
    <div id="slider1" class="rev_slider"  data-version="5.0">
    	
   </div>
</section>
<section class="service sec-padd2">
	<!-- margin-top:使得轻松考与上面有一定距离 -->
    <div class="container" style="margin-top:100px;">
        
        <div class="section-title">
            <h2>轻松考</h2>
        </div>
        <div style="width:75%;height:500px;border:1px #999 solid;">
        	<div style="height:40px;width:200px;margin-top:20px;">
        		<!-- 注意积分随时在变 -->
        		<a>您的当前积分:${sessionScope.user.integralNumber }</a>
        	</div>
        	<div>
        		<!--<a>1元/10积分</a>-->
        	</div>
        	<div style="width:75%;height:400px;border:1px #999 solid;padding-top:30px;padding-left:15px;">
        	<form action="">
        		<div>
        			<div style="float:left;border:1px #999 solid; width:100px;height:60px;margin-right:20px;">
        				<input type="radio" name="money" id="A" value="A"/>
        				<label for="A">1元/10积分</label>
        			</div>
        			<div style="float:left;border:1px #999 solid; width:100px;height:60px;margin-right:20px;">
        				<input type="radio" name="money" id="B" value="B"/>
        				<label for="B">5元/50积分</label>
        			</div>
        			<div style="float:left;border:1px #999 solid; width:100px;height:60px;margin-right:20px;">
        				<input type="radio" name="money" id="C" value="C"/>
        				<label for="C">10元/100积分</label>
        			</div>
        		</div>
       			<div style="float:left;border:1px #999 solid; width:100px;height:60px;margin-right:20px;">
       				<input type="radio" name="money" id="D" value="D"/>
       				<label for="D">20元/250积分</label>
       			</div>
       			<div style="float:left;border:1px #999 solid; width:100px;height:60px;margin-right:20px;">
       				<input type="radio" name="money" id="E" value="E"/>
       				<label for="E">50元/650积分</label>
       			</div>
       			<div class="clear"></div>
       			<div style="width:150px; margin-top:30px;margin-left:520px;">
       				<input type="button" value="购买" onclick="buyPoints()"/>
       			</div>
        	</form>
        </div>
        </div>
    </div>
</section>

<!-- 底部jsp -->
<jsp:include page="foot.jsp"></jsp:include>
     

<!-- Scroll Top Button -->
    <button class="scroll-top tran3s color2_bg">
        <span class="fa fa-angle-up"></span>
    </button>
    <!-- pre loader  -->
    <div class="preloader"></div>


    <!-- jQuery js -->
    <script src="js/jquery.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- jQuery ui js -->
    <script src="js/jquery-ui.js"></script>
    <!-- owl carousel js -->
    <script src="js/owl.carousel.min.js"></script>
    <!-- jQuery validation -->
    <script src="js/jquery.validate.min.js"></script>

    <!-- mixit up -->
    <script src="js/wow.js"></script>
    <script src="js/jquery.mixitup.min.js"></script>
    <script src="js/jquery.fitvids.js"></script>
    <script src="js/bootstrap-select.min.js"></script>
    <script src="js/menuzord.js"></script>

    <!-- revolution slider js -->
    <script src="js/jquery.themepunch.tools.min.js"></script>
    <script src="js/jquery.themepunch.revolution.min.js"></script>
    <script src="js/revolution.extension.actions.min.js"></script>
    <script src="js/revolution.extension.carousel.min.js"></script>
    <script src="js/revolution.extension.kenburn.min.js"></script>
    <script src="js/revolution.extension.layeranimation.min.js"></script>
    <script src="js/revolution.extension.migration.min.js"></script>
    <script src="js/revolution.extension.navigation.min.js"></script>
    <script src="js/revolution.extension.parallax.min.js"></script>
    <script src="js/revolution.extension.slideanims.min.js"></script>
    <script src="js/revolution.extension.video.min.js"></script>

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
</div>
    
</body>
</html>
