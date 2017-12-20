package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.model.Resource;
import com.san.service.Impl.ResourceServiceImpl;

public class ManageDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			if(flag.equals("checkDatas")){
				checkDatas(request, response);
			}
		}
	}
	public void checkDatas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName=request.getParameter("courseName");
		String userId=request.getParameter("userId");
		List<Resource> resourceList=resourceServiceImpl.checkResourceService(courseName, userId);
		request.setAttribute("resourceList", resourceList);
		request.getRequestDispatcher("").forward(request, response);
	}
}
