package com.san.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if(request.getParameter("flag")!=null){
			String flag=request.getParameter("flag");
			//用户发布问题
			if(flag.equals("putQuestion")){
				putQuestion(request, response);
			}
		}
	}
	public void putQuestion(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameter("");
	}
}
