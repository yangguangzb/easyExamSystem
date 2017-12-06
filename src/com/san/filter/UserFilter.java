package com.san.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.san.model.User;

public class UserFilter implements Filter{

	public void destroy() {
		
		
	}
	//权限管理
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		User user=(User) request.getSession().getAttribute("user");
		if(user!=null){
			//用户已登录
			if(0==user.getUserType()){
				//不是管理员
				response.getWriter().write("权限不足,无法访问!");
				response.setHeader("refresh","2;url=../index.jsp");
				return ;
			}else{
				//是管理员,放行
				chain.doFilter(request, response);
				return ;
			}
		}else{
			//用户没有登录
			response.sendRedirect("../login.jsp");
			return ;
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
