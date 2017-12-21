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
			//查询资源
			if(flag.equals("checkDatas")){
				checkDatas(request, response);
			}
			//删除资源
			if(flag.equals("delDatas")){
				delDatas(request, response);
			}
			//修改资源
			if(flag.equals("modifyDatas")){
				modifyDatas(request, response);
			}
		}
	}
	public void checkDatas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName=request.getParameter("courseName");
		String userId=request.getParameter("userId");
		List<Resource> resourceList=resourceServiceImpl.checkResourceService(courseName, userId);
		request.setAttribute("resourceList", resourceList);
		request.getRequestDispatcher("../admin2/data-list.jsp").forward(request, response);
	}
	public void delDatas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resourceId=request.getParameter("resourceId");
		String i=""+resourceServiceImpl.delDatasService(resourceId);
		response.getWriter().write(i);
	}
	public void modifyDatas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resourceId=request.getParameter("resourceId");
		String courseName=request.getParameter("courseName");
		String resourceName=request.getParameter("resourceName");
		String resourceDescription=request.getParameter("resourceDescription");
		String resourcePath=request.getParameter("resourcePath");
		String integration=request.getParameter("integration");
		String i=""+resourceServiceImpl.modifyDatasService(resourceId, courseName, resourceName, resourceDescription, resourcePath, integration);
		response.getWriter().write(i);
	}
}
