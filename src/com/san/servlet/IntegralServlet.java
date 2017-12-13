package com.san.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.san.model.User;
import com.san.service.Impl.IntegralServiceImpl;
import com.san.service.Impl.UserServiceImpl;
public class IntegralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IntegralServiceImpl integralServiceImpl=new IntegralServiceImpl();
	UserServiceImpl userServiceImpl=new UserServiceImpl(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//购买积分
			if(flag.equals("buyPoints")){
				buyPoints(request, response);
			}
		}
	}
	public void buyPoints(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String buyNum=request.getParameter("buyNum");
		User user=(User) request.getSession().getAttribute("user");
		int i=integralServiceImpl.buyPointsService(buyNum, user.getUserId());
		//更新用户信息
		User user1=userServiceImpl.checkUserByIdService(user.getUserId());
		request.getSession().setAttribute("user", user1);
		response.getWriter().write(i+"");
	}
}
