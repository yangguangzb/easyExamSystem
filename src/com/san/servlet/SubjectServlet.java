package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.dao.SubjectDao;
import com.san.model.Subject;

public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SubjectDao subjectDao=new SubjectDao();
		if(request.getParameter("courseName")!=null&&request.getParameter("subjectId")!=null
				&&request.getParameter("subjectType")!=null){
			String courseName=request.getParameter("courseName");
			String subjectId=request.getParameter("subjectId");
			String subjectType=request.getParameter("subjectType");
			if(courseName.equals("请选择课程")||subjectId.equals("题目编号")||subjectType.equals("请选择题型")){
				out.write("-1");
				return ;
			}
			//将subjectId(1-20)分割为1,20
			String[] split = subjectId.split("-");
			int startPage=Integer.parseInt(split[0])-1;
			try {
				List<Subject> subjectList=subjectDao.checkSubject(courseName, startPage);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}
