package com.san.servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.model.Subject;
import com.san.service.Impl.SubjectServiceImpl;
public class ManageSubject extends HttpServlet {
	/**
	 * 后台题目管理
	 */
	private static final long serialVersionUID = 1L;
	SubjectServiceImpl subjectServiceImpl=new SubjectServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//根据id查询题目
			if(flag.equals("checkSubjectById")){
				checkSubjectById(request, response);
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//题目管理
			if(flag.equals("manageSubject")){
				manageSubject(request, response);
			}
			//删除一道题目
			if(flag.equals("delSubject")){
				delSubject(request, response);
			}
		}
	}
	//根据条件查询题目
	public void manageSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String brushName=request.getParameter("brushName");
		String subjectType=request.getParameter("subjectType");
		String courseName=request.getParameter("courseName");
		String subjectId=request.getParameter("subjectId");
		List<Subject> manageSubjectList=subjectServiceImpl.checkSubjectService(subjectId, brushName, courseName, subjectType);
		//保存记录数
		request.getSession().setAttribute("subjectSize",manageSubjectList.size());
		//根据条件查询的题目,并保存到session中
		request.getSession().setAttribute("manageSubjectList", manageSubjectList);
		response.sendRedirect("../admin2/subject-list.jsp");
	}
	//根据id查询某一道题目具体信息
	public void checkSubjectById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subjectId=request.getParameter("subjectId");
		//保存标记
		request.getSession().setAttribute("manageSubjectId", subjectId);
		Subject subjectById=subjectServiceImpl.checkSubjectByIdService(subjectId);
		request.getSession().setAttribute("subjectById",subjectById);
		response.sendRedirect("../admin2/subject-detail.jsp");
	}
	//删除一道题目
	public void delSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String subjectId=request.getParameter("subjectId");
		String i=subjectServiceImpl.delSubjectService(subjectId)+"";
		//向浏览器响应信息
		response.getWriter().write(i);
	}
}
