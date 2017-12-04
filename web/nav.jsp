<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导航栏 -->
<section class="theme_menu stricky">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <div class="main-logo">
                    <a href="index.jsp"><img src="images/logo/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-8 menu-column">
                <nav class="menuzord" id="main_menu">
                   <ul class="menuzord-menu">
                       <!--<li class="active"><a href="index.jsp">首页</a></li>
						-->
						<li><a href="index.jsp">首页</a></li>
						<li><a href="ordinary.jsp">普通区</a></li>
                        <li><a href="boutique.jsp">精品区</a></li>
						<li><a href="data.jsp">资料下载</a></li>
                       <li><a href="dataupload.jsp">资料上传</a></li>
                       <li><a href="share.jsp">分享交流</a></li>
                        <li><a href="problem.jsp">随问即答</a></li>
                    </ul><!-- End of .menuzord-menu -->
                </nav> <!-- End of #main_menu -->
            </div>
            <div class="right-column">
                <div class="right-area">
                    <div class="nav_side_content">
                        <div class="search_option">
                            <button class="search tran3s dropdown-toggle color1_bg" id="searchDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="fa fa-search" aria-hidden="true"></i></button>
                            <form action="#" class="dropdown-menu" aria-labelledby="searchDropdown">
                                <input type="text" placeholder="搜索...">
                                <button><i class="fa fa-search" aria-hidden="true"></i></button>
                            </form>
                       </div>
                   </div>
                </div>
                    
            </div>
        </div>
                

   </div> 
</section>
<style>
    .dropdown {
        position: relative;
        display: inline-block;
    }
    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f9f9f9;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        padding: 12px 16px;
    }
    .dropdown:hover .dropdown-content {
        display: block;
    }
</style>