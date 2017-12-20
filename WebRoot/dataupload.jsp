<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/12/4
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8");response.setContentType("text/html;charset=utf-8"); %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.5/css/fileinput.min.css" media="all" rel="stylesheet" type="text/css" />
    <!-- 登录 -->
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript" charset="utf-8"></script>

</head>
<body>

<div class="boxed_wrapper">

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
                <form method="post" action="resourceuploadservlet" enctype="multipart/form-data">
                <c:if test="not empty message">
                <div class="alert alert-danger" role="alert">
                ${message}
</div>
                </c:if>
            
                    <div class="form-group">
                        <label for="course">课程</label>
                        <select  class="custom-select form-control" id="course" name="course">
                            <option>高等数学</option>
                            <option>线性代数</option>
                            <option>大学英语</option>
                            <option>计算机网络</option>
                            <option>软件工程</option>
                            <option>马克思原理</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="resourceName">资料名称</label>
                        <input type="text" class="form-control" id="resourceName" placeholder="资料名称"  name="resourceName">
                    </div>
                    <div class="form-group">
                        <label for="resourceDescription">资料简介</label>
                        <input type="text" class="form-control" id="resourceDescription" placeholder="资料简介" name="resourceDescription" >
                    </div>
                    <div class="form-group">
                        <label for="integration">设置积分</label>
                        <select  class="custom-select form-control" id="integration" name="integration">
                            <option>2</option>
                            <option>5</option>
                            <option>10</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="resource">上传资料</label>
                        <input id="input-id" type="file" class="file" data-preview-file-type="text" id="resource" name="file" >
                    </div>
                    <button type="submit" class="btn btn-primary">确定</button>
                </form>
            </div>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.5/js/fileinput.min.js"></script>
    <!-- optionally if you need a theme like font awesome theme you can include it as mentioned below -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.5/themes/fa/theme.js"></script>
    <!-- optionally if you need translation for your language then include  locale file as mentioned below -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-fileinput/4.4.5/js/(lang).js"></script>
    <!-- Latest compiled and minified JavaScript -->
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
</div>

</body>
</html>

