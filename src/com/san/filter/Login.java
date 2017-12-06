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
public class Login implements Filter{
	public void destroy() {
		
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//用户是否登录过滤
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		User user =(User)request.getSession().getAttribute("user");
		if(user.getUserName()!=null){
			//用户已经登录
			chain.doFilter(request, response);
			return ;
		}else{
			//用户没有登录,跳转到登录界面
			response.sendRedirect("login.jsp");
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
