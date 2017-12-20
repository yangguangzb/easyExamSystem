package com.san.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.san.model.Answer;
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
			//用户回答问题
			if(flag.equals("answerQuestion")){
				answerQuestion(request, response);
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
			//显示所有回答
			if(flag.equals("showAllAnswer")){
				showAllAnswer(request, response);
			}
			//高积分问题
			if(flag.equals("highQuestion")){
				highQuestion(request, response);
			}
			//我的问题
			if(flag.equals("myQuestion")){
				myQuestion(request, response);
			}
			//我的某个问题的具体信息(答案)
			if(flag.equals("myQuestionDetail")){
				myQuestionDetail(request, response);
			}
			//我的回答
			if(flag.equals("myAnswer")){
				myAnswer(request, response);
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
		User newUser=integralServiceImpl.isQuestionPointsService(user.getUserId(),questionReward,questionTitle,questionContent,courseName);
		//动态修改用户积分并保存
		if(newUser==null){
			response.getWriter().write("-1");//积分不够
			return ;
		}else{
			//积分够，修改session中用户积分信息
			request.getSession().setAttribute("user",newUser);
			response.getWriter().write("1");
			return ;
		}
	}
	//待回答问题处理
	public void notAnswerQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		List<Question> notAnswer=questionServiceImpl.notAnswerService(user.getUserId());
		request.setAttribute("notAnswer", notAnswer);
		request.getRequestDispatcher("problem.jsp").forward(request, response);
		return ;
	}
	//用户回答问题处理
	public void answerQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//回答内容
		String answerContent=request.getParameter("answerContent");
		//问题编号
		String questionId=request.getParameter("questionId");
		User user=(User)request.getSession().getAttribute("user");
		String i=questionServiceImpl.answerQuestionService(questionId,user.getUserId(), answerContent)+"";
		response.getWriter().write(i);
		return ;
	}
	//显示网友回答的答案showAllAnswer
	public void showAllAnswer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String questionId=request.getParameter("questionId");
		List<Answer> showAllAnswer=questionServiceImpl.showAllAnswerService(questionId);
		for (Answer answer : showAllAnswer) {
			if(answer.getIsAdoption()==1){
				//该问题被采纳(设置值为回答Id唯一)
				//request.getSession().setAttribute("isAdoption",answer.getAnswerId());
				request.setAttribute("isAdoption",1);
			}
		}
		Question questionById=questionServiceImpl.questionByIdService(questionId);
		if(showAllAnswer.size()==0){
			//没有网友答案
			request.setAttribute("showAllAnswer",0);
		}else{
			request.setAttribute("showAllAnswer", showAllAnswer);
		}
		request.setAttribute("questionById", questionById);
		//我的某个具体问题处理
		if(request.getParameter("flagdetail")!=null&&"detail".equals(request.getParameter("flagdetail"))){
			//转发到我的某个问题的具体内容中
			request.getRequestDispatcher("myQuestionDetail.jsp").forward(request, response);
			return ;
		}
		request.getRequestDispatcher("answerQuestion.jsp").forward(request, response);
		return ;
	}
	//高分问题
	public void highQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		List<Question> highQuestion=questionServiceImpl.highQuestionService(user.getUserId());
		request.setAttribute("highQuestion", highQuestion);
		request.getRequestDispatcher("highQuestion.jsp").forward(request, response);
		return ;
	}
	//我的所有问题显示
	public void myQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		List<Question> myQuestions=questionServiceImpl.myQuestion(user.getUserId());
		if(myQuestions.size()==0){
			request.setAttribute("myQuestions", 0);
		}else{
			request.setAttribute("myQuestions", myQuestions);
		}
		request.getRequestDispatcher("myQuestion.jsp").forward(request, response);
		return ;
	}
	//我的某一个问题具体显示(包含网友答案等)
	public void myQuestionDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得评论者Id(最好网友答案)
		String reviewerId=request.getParameter("reviewerId");
		//获得该问题Id
		String questionId=request.getParameter("questionId");
		questionServiceImpl.myQuestionDetailService(questionId, reviewerId);
		//重定向(让其刷新)
		response.sendRedirect("myQuestionDetail.jsp?questionId="+questionId);
		return ;
	}
	//我的回答
	public void myAnswer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=(User) request.getSession().getAttribute("user");
		List<Map<String, Object>> myAnswer=questionServiceImpl.myAnswerService(user.getUserId());
		if(myAnswer.size()==0){
			//没有回答
			request.setAttribute("myAnswer", 0);
		}else{
			//用户有回答
			request.setAttribute("myAnswer", myAnswer);
		}
		//转发
		request.getRequestDispatcher("myAnswer.jsp").forward(request, response);
		return ;
	}
}
