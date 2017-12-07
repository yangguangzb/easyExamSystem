package com.san.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.model.Question;
import com.san.model.User;
import com.san.service.Impl.IntegralServiceImpl;
import com.san.service.Impl.QuestionServiceImpl;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	QuestionServiceImpl questionServiceImpl=new QuestionServiceImpl();
	//post提交处理
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
	//get提交处理
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//待解答问题
			if(flag.equals("notAnswerQuestion")){
				notAnswerQuestion(request, response);
			}
		}
	}
//get提交处理
	
	public void putQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取课程名,问题积分,问题标题,问题内容
		String courseName=request.getParameter("courseName");
		String questionReward=request.getParameter("questionReward");
		String questionTitle=request.getParameter("questionTitle");
		String questionContent=request.getParameter("questionContent");
		//获得用户id(获得的积分没有用，需要在查询，在存储)
		User user=(User) request.getSession().getAttribute("user");
		//判断用户提出问题设置积分是否够
		User newUser=integralServiceImpl.isQuestionPointsService(user.getUserId(),questionReward,questionTitle,questionContent,courseName);
		//动态修改用户积分并保存
		if(newUser==null){
			response.getWriter().write("-1");//积分不够
		}else{
			//积分够，修改session中用户积分信息
			request.getSession().setAttribute("user",newUser);
			response.getWriter().write("1");
		}
	}
	//待回答问题处理
	public void notAnswerQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Question> notAnswer=questionServiceImpl.notAnswerService();
		request.setAttribute("notAnswer", notAnswer);
		request.getRequestDispatcher("notAnswerQuestion.jsp").forward(request, response);
	}
}
