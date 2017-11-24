package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.model.User;
import com.san.service.Impl.BackUserService;

public class BackUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BackUserService backUserService=new BackUserService();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag="";
		if(request.getParameter("flag")!=null){
			flag=request.getParameter("flag");
			if(flag.equals("checkUser")){
				this.checkUser(request, response);
			}
		}
	}
	//查询所有用户,并显示
	public void checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int pageNow=Integer.parseInt(request.getParameter("pageNow").toString());
			List<User> backUser=backUserService.BackCheckUseService(pageNow);
			request.getSession().setAttribute("backUser", backUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
