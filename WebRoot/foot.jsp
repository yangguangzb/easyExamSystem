<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<footer class="main-footer">
    <div class="widgets-section">
        <div class="container">
            <div class="row">
                <!--Big Column-->
                <div class="big-column col-md-6 col-sm-12 col-xs-12">
                    <div class="row clearfix">
                        
                        <!--Footer Column-->
                        <div class="footer-column col-md-6 col-sm-6 col-xs-12">
                            <div class="footer-widget about-widget">
                                <h3 class="footer-title">关于我们</h3>
                                
                                <div class="widget-content">
                                    <div class="text"><p>
									轻松考以帮助千万学子考试不挂为使用，以客户获得奖学金为目标，收集了很多试卷和书中的重点难点
									包括考试大纲											                                    
                                    </p> </div>
                                    <div class="link">
                                        <a href="#" class="default_link">更多 <i class="fa fa-angle-right"></i></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--Footer Column-->
                        <div class="footer-column col-md-6 col-sm-6 col-xs-12">
                            <div class="footer-widget links-widget">
                                <h3 class="footer-title">轻松考</h3>
                                <div class="widget-content">
                                    <ul class="list">
                                        <li>
											<s:a action="subjectAction_showGradeRank.action" namespace="/">必过之旅</s:a>
										</li>
										<li>
                        					<s:a action="boutiqueAction_display.action" namespace="/">奖学金之旅</s:a>
                       					</li>
										
                                        <li><a href="data.jsp">资料之旅</a></li>
                                        <li><a href="share.jsp">分享之旅</a></li>
                                        
                                        <li>
                        					<s:a action="questionAction_notAnswerQuestion.action" namespace="/">随问即答</s:a>
                        				</li>
                                        <li><a href="#">其他</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!--Big Column-->
                <div class="big-column col-md-6 col-sm-12 col-xs-12">
                    <div class="row clearfix">
                        

                        <!--Footer Column-->
                        <div class="footer-column col-md-6 col-sm-6 col-xs-12">
                            <div class="footer-widget contact-widget">
                                <h3 class="footer-title">联系我们</h3>
                                <div class="widget-content">
                                    <ul class="contact-info">
                                        <li><span class="icon-signs"></span>江西省南昌市<br>江西师大</li>
                                        <li><span class="icon-phone-call"></span>电话:123456789</li>
                                        <li><span class="icon-e-mail-envelope"></span>邮箱:123@qq.com</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!--Footer Column-->
                        <div class="footer-column col-md-6 col-sm-6 col-xs-12">
                            <div class="footer-widget news-widget">
                                <h3 class="footer-title">通讯</h3>
                                <div class="widget-content">
                                    <!--Post-->
                                    <div class="text"><p>订阅我们您将获得最新的提示<br>最新的试题等</p></div>
                                    <!--Post-->
                                    <form action="#" class="default-form">
                                        <input type="email" placeholder="邮箱地址">
                                        <button type="submit" class="thm-btn">定于我们</button>
                                    </form>
                                </div>
                                
                            </div>
                        </div>                     
                        
                    </div>
                </div>
                
             </div>
         </div>
     </div>