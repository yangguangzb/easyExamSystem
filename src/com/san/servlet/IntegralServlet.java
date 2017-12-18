package com.san.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//后台查看积分
			if(flag.equals("backCheckIntegral")){
				backCheckIntegral(request, response);
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
	//后台查询积分
	public void backCheckIntegral(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String integralNumber=request.getParameter("integralNumber");
		String username=request.getParameter("username");
		List<Map<String, Object>> integralListMap= integralServiceImpl.checkIntegralService(start, end, integralNumber, username);
		request.setAttribute("integralListMap", integralListMap);
		request.getRequestDispatcher("admin2/integral-list.jsp").forward(request, response);
	}
}
