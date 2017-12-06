package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.san.model.User;
import com.san.service.Impl.MUserServiceImpl;

public class ManageUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MUserServiceImpl mUserService=new MUserServiceImpl();
	//get提交
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			
		}
	}
	//Post提交
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			if(flag.equals("checkUsers")){
				checkUsers(request, response);
			}
			//管理员添加用户
			if(flag.equals("addUser")){
				addUser(request, response);
			}
			//管理员修改用户信息
			if(flag.equals("modifyUser")){
				modifyUser(request, response);
			}
			//管理员删除用户
			if(flag.equals("delUser")){
				delUser(request, response);
			}
			
		}
	}
	//查询所有用户,并显示
	public void checkUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userType=request.getParameter("userType");
		String userId=request.getParameter("userId");
		String verification=request.getParameter("verification");
		List<User> mUserList=mUserService.mcheckUserService(userType, userId,verification);
		//保存查询的用户信息
		request.getSession().setAttribute("mUserList",mUserList);
		response.sendRedirect("../admin2/member-list.jsp");
	}
	public void addUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String e_mail = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("pass");
		String i=mUserService.maddUserService(userName, e_mail, password)+"";
		response.getWriter().write(i);
	}
	//修改用户信息
	public void modifyUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userType = request.getParameter("userType");
		String verification = request.getParameter("verification");
		String integralNumber = request.getParameter("integralNumber");
		String i=mUserService.modifyUserService(userId, userType, verification, integralNumber)+"";
		//响应回浏览器
		response.getWriter().write(i);
	}
	//管理员删除用户
	public void delUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId=request.getParameter("userId");
		String i=mUserService.mdelUserService(userId)+"";
		response.getWriter().write(i);
	}
}
