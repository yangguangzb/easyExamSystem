package com.san.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.san.model.Subject;
import com.san.model.User;
import com.san.service.Impl.SubjectServiceImpl;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectServiceImpl subjectService=new SubjectServiceImpl();
	int k=0;//设置题目编号
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断用户是否登录
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
			return ;
		}
		else if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			if(flag.equals("display")){
				//显示题目
				display(request, response);
				return ;
			}
			if(flag.equals("displayNext")){
				//显示下一道题
				displayNext(request, response);
			}
			if(flag.equals("displayLast")){
				//显示上一道题
				displayLast(request, response);
			}
			if(flag.equals("displayParsing")){
				//查看解析
				displayParsing(request, response);
			}
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		//提交选项,统计分数
		if(flag.equals("gradeByOption")){
			gradeByOption(request, response);
		}
		//成绩排名
		if(flag.equals("pankGrade")){
			pankGrade(request, response);
		}
	}
	List<Subject> subjectList;	//20道题目集合
	int grade=0;	//设置分数
	Subject nowSubject=null;	//设置当前题目;
	public void display(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName=request.getParameter("courseName");
		String subjectId=request.getParameter("subjectId");
		String subjectType=request.getParameter("subjectType");
		//把课程,题型,编号存到session中,方便界面取
		request.getSession().setAttribute("courseName",courseName);
		request.getSession().setAttribute("subjectId",subjectId);
		request.getSession().setAttribute("subjectType",subjectType);
		request.getSession().setAttribute("brushName", "普通区");
		//将上次成绩重置为0
		request.getSession().setAttribute("grade", 0);
		//显示20道题目
		try {
			k++;
			subjectList = subjectService.display(courseName, subjectId, subjectType);
			request.getSession().setAttribute("subjectList", subjectList);
			nowSubject=subjectList.get(0);
			nowSubject.setSubjectId(k);//设置当前题目编号
			request.getSession().setAttribute("nowSubject", nowSubject);
			//转发无法响应(待解决)
			//request.getRequestDispatcher("/ordinary.jsp").forward(request, response);
			response.sendRedirect("ordinary.jsp");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void displayNext(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//显示下一题
		if(k<20){
			List<Subject> subjectList=(List<Subject>) request.getSession().getAttribute("subjectList");
			nowSubject=subjectList.get(k);
			//获得当前选项
			String choice="";
			if(request.getParameter("choice")!=null){
				choice = request.getParameter("choice");
			}
			//获取前一道题信息
			Subject lastSubject=subjectList.get(k-1);
			//前一道题答案
			String subjectAnswer=lastSubject.getSubjectAnswer();
			if(subjectAnswer.contains(choice)&&choice!=""){
				grade=grade+5;
			}
			//保存成绩
			request.getSession().setAttribute("grade",grade);
			nowSubject.setSubjectId(++k);//设置当前题目编号
			//把题目编号存入session,方便前台获取
			request.getSession().setAttribute("k", k);
			request.getSession().setAttribute("nowSubject", nowSubject);
			response.sendRedirect("ordinary.jsp");
			return ;
		}
	}
	int j=k;//设置上一题
	public void displayLast(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//显示上一题
		k--;
		if(k>0){
			//题目已做完(第一道题)
			Subject nowSubject=null;
			List<Subject> subjectList=(List<Subject>) request.getSession().getAttribute("subjectList");
			nowSubject=subjectList.get(k);
			nowSubject.setSubjectId(k);
			request.getSession().setAttribute("nowSubject", nowSubject);
			response.sendRedirect("ordinary.jsp");
			return ;
		}
		
	}
	public void displayParsing(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查看解析
		Subject nowSubject=(Subject) request.getSession().getAttribute("nowSubject");
		String analysis=nowSubject.getAnalysis();
		String subjectAnswer=nowSubject.getSubjectAnswer();
		//解析
		request.getSession().setAttribute("analysis",analysis);
		return ;
	}
	public void gradeByOption(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String grade2 = request.getSession().getAttribute("grade").toString();
		if("".equals(grade2)){
			grade=0;
		}else{
			grade=Integer.parseInt(request.getSession().getAttribute("grade").toString());
		}
		//销毁session,结束测试
		request.getSession().setAttribute("nowSubject",null);
		request.getSession().setAttribute("k",null);
		String choice = request.getParameter("choice");
		//获取最后提交一道题的答案
		String answer=subjectList.get(k-1).getSubjectAnswer();
		if(answer.equals(choice)){
			grade+=5;
		}
		//插入测试成绩
		User user=(User)request.getSession().getAttribute("user");
		String brushName=request.getSession().getAttribute("brushName").toString();
		String courseName=request.getSession().getAttribute("courseName").toString();
		try {
			subjectService.insertGradeSevice(brushName, courseName, user.getUserId(), Float.parseFloat(grade+""));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//题目编号重置为0,重置选项信息
		k=0;
		request.getSession().setAttribute("courseName",null);
		request.getSession().setAttribute("subjectId",null);
		request.getSession().setAttribute("subjectType",null);
		request.getSession().setAttribute("grade",0);
		//向前台输出成绩
		response.getWriter().write(grade+"");
		grade=0;
		return ;
	}
	//成绩排行榜
	public void pankGrade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String,Object>> pankGrade= subjectService.pankGradeService();
		request.setAttribute("pankGrade", pankGrade);
		request.getRequestDispatcher("ordinary.jsp").forward(request, response);
		return ;
	}
}
