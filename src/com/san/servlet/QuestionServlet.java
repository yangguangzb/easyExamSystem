package com.san.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.model.User;
import com.san.service.Impl.IntegralServiceImpl;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//用户发布问题
			if(flag.equals("putQuestion")){
				putQuestion(request, response);
			}
		}
	}
	public void putQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取课程名,问题积分,问题标题,问题内容
		String courseName=request.getParameter("courseName");
		String questionReward=request.getParameter("questionReward");
		String questionTitle=request.getParameter("questionTitle");
		String questionContent=request.getParameter("questionContent");
		//判断用户提出问题设置积分是否够
		User user=(User) request.getSession().getAttribute("user");
		String i=integralServiceImpl.isQuestionPointsService(user.getUserId(),questionReward,questionTitle,questionContent,courseName)+"";
		response.getWriter().write(i);
	}
}
