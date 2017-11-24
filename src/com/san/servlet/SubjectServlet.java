package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.dao.Impl.SubjectDaoImpl;
import com.san.model.Subject;
import com.san.service.Impl.SubjectService;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SubjectService subjectService=new SubjectService();
	int k=0;//设置题目编号
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			if(flag.equals("display")){
				//显示题目
				this.display(request, response);
			}
			if(flag.equals("displayNext")){
				//显示下一道题
				this.displayNext(request, response);
			}
			if(flag.equals("displayLast")){
				//显示上一道题
				this.displayLast(request, response);
			}
			if(flag.equals("displayParsing")){
				//查看解析
				this.displayParsing(request, response);
			}
			if(flag.equals("gradeByOption")){
				//提交选项,统计分数
				this.gradeByOption(request, response);
			}
		}
		
	}
	List<Subject> subjectList;
	public void display(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName=request.getParameter("courseName");
		String subjectId=request.getParameter("subjectId");
		String subjectType=request.getParameter("subjectType");
		//显示20道题目
		try {
			subjectList = subjectService.display(courseName, subjectId, subjectType);
			request.getSession().setAttribute("subjectList", subjectList);
			request.getSession().setAttribute("nowSubject", subjectList.get(0));
			request.getRequestDispatcher("ordinary.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void displayNext(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//显示下一题
		k++;
		/*if(k>19){
			//题目已做完(最后一道题)
			response.getWriter().write("-1");
			return ;
		}*/
		if(k<20){
			Subject nowSubject=null;
			List<Subject> subjectList=(List<Subject>) request.getSession().getAttribute("subjectList");
			nowSubject=subjectList.get(k);
			nowSubject.setSubjectId(k);//设置当前题目编号
			request.getSession().setAttribute("nowSubject", nowSubject);
			response.sendRedirect("ordinary.jsp");
			System.out.println("k="+k);
			String radio = request.getParameter("radio");
			System.out.println(radio);
		}
	}
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
		}
		
	}
	public void displayParsing(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//查看解析
		Subject nowSubject=(Subject) request.getSession().getAttribute("nowSubject");
		String analysis=nowSubject.getAnalysis();
		String subjectAnswer=nowSubject.getSubjectAnswer();
		//解析为答案，加解析
		
		request.getSession().setAttribute("analysis",analysis);
	}
	public void gradeByOption(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//通过选项统计分数
		String option=request.getParameter("option");
		int grade=0;
		Subject nowSubject=(Subject) request.getSession().getAttribute("nowSubject");
		String subjectAnswer=nowSubject.getSubjectAnswer();
		if(option.equals(subjectAnswer.trim())){
			//选项正确
			grade=grade+5;
		}
		request.getSession().setAttribute("grade",grade);
	}
	
}
