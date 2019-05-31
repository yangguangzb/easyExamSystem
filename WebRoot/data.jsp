<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>
<% String context=request.getContextPath(); %>
<% 
StringBuffer basePath=request.getRequestURL();
%>
<base href="<%=basePath %>">
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
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-table.min.css">
	<!-- 登录 -->
	<link rel="stylesheet" type="text/css" href="css/login.css"/>
	<script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>

<div class="boxed_wrapper">&nbsp; 
 
<!-- 头部 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 导航栏 -->
<jsp:include page="nav.jsp"></jsp:include>
  
<section class="rev_slider_wrapper">
  <!--  <div id="slider1" class="rev_slider"  data-version="5.0">
    	<u>
    		<li>nihao </li>
    	</u>
     	<p>资料区</p>
    </div>-->
</section>

<section class="service sec-padd2">
    <div class="container" style="margin-top:100px;">
        
        <div class="section-title" style="margin-bottom:0px;">
            <h2>轻松考</h2>
        </div>
        <div>
            <table id="table">

            </table></div>
        <div class="service_carousel">
            
          
        </div>
            
    </div>
</section>

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

    <script src="js/bootstrap-table.min.js"></script>
    <!-- put your locale files after bootstrap-table.js -->
    <script src="js/bootstrap-table-zh-CN.min.js"></script>
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
	<!-- 登录js -->
	<script src="js/login.js" type="text/javascript" charset="utf-8"></script>

    <script>
        $('#table').bootstrapTable({
            method:"get",
            url: "resource/ResourceAction_listResource",
            dataType: "json",
            striped: true,
            showColumns: true,
            classes:'table table-hover table-no-bordered',
            search:true,
            pagination: true,
            clickToSelect: true,
            columns: [{
                field: 'resourceId',
                title: '资料编号',
                sortable:true,
                cardVisible:true
            }, {
                field: 'uploadId',
                title: '上传者编号',
                sortable:true
            }, {
                field: 'courseName',
                title: '课程名',
                sortable:true
            },{
                field:'resourceName',
                title:'资料名'
            },{
                field:'resourceDescription',
                title:'资料描述'
            },{
                field:'downNumber',
                title:'下载次数',
                sortable:true
            },{
                field:'integration',
                title:'积分' ,
                sortable:true
            },
                {
                    field:'resourcePath',
                    title:'下载' ,
                    align:'center',
                    formatter : operateFormatter,
                }
            ],

            onClickCell:function(field, value, row, $element){
                if(field=="resourcePath"){
                    /*  console.log(field);
                      console.log(value);
                      console.log(row);
                      console.log($element);
                      console.log(row.resourceId);*/
                    window.location.href="<%=context%>/resource/ResourceAction_getResource?resourceId="+row.resourceId.toString();
                }

            }
        });
        function operateFormatter(value, row, index) {
            return [
                '<button  type="button" class="btn btn-danger btn-xs">下载</button>', ]
                .join('');
        }
    </script>
</div>
    
</body>
</html>
