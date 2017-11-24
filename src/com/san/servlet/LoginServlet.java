package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.san.dao.Impl.UserDaoImpl;
import com.san.model.User;
import com.san.utils.ActivationCode;
import com.san.utils.DBUtil;
import com.san.utils.SendJMail;

import java.sql.*;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		UserDaoImpl userDao=new UserDaoImpl();
		Connection conn=null;
		String flag="";
		//登录验证
		if(request.getParameter("userName")!=null&&request.getParameter("password")!=null){
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			try {
				User user=userDao.loginVerification(userName, password);
				if(user!=null){
					//登录成功
					request.getSession().setAttribute("user", user);
					out.write("登录成功");
				}else{
					out.write("登录失败");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//忘记密码时，通过邮箱发送验证码.重置密码。
		if(request.getParameter("flag")!=null&&request.getParameter("flag").equals("forgetPassword")){
			HttpSession session = request.getSession();
			//找回密码，输入邮箱
			if(request.getParameter("e_mail")!=null){
				String e_mail=request.getParameter("e_mail");
				conn=DBUtil.getconn();
				try {
					int k=userDao.backPassword(e_mail, "", 1, conn);
					if(k==-1){
						out.write("-1");
					}else{
						//邮箱有效，发送验证码
						//保存有效的邮箱
						session.setAttribute("forgetPasswordEmail",e_mail);
						//获取随机数验证码
						String forgetsuiji=ActivationCode.activationCode();
						//保存随机数
						session.setAttribute("forgetsuiji", forgetsuiji);
						//发送验证码
						SendJMail sd=new SendJMail();
						sd.sendMail(e_mail, "验证码为:"+forgetsuiji,"找回密码");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBUtil.closeConn(null,null,conn);
				}
			}
			//验证输入的验证码是否正确
			if(request.getParameter("verificationCode")!=null){
				String verificationCode=request.getParameter("verificationCode");
				//获取保存在session中的验证码
				String trueCode=session.getAttribute("forgetsuiji").toString();
				if(!verificationCode.equals(trueCode)){
					//输入的验证码错误
					out.write("-1");
				}else{
					//验证码正确
					out.write("1");
				}
			}
			//操作数据库重置密码
			if(request.getParameter("password")!=null){
				String password=request.getParameter("password");
				conn=DBUtil.getconn();
				try {
					int k=userDao.backPassword(session.getAttribute("forgetPasswordEmail").toString(), password, 2, conn);
					if(k==1){
						//重置密码成功
						session.setAttribute("forgetPasswordMsg", "密码重置成功");
					}else{
						//重置密码失败
						session.setAttribute("forgetPasswordMsg", "密码重置失败");
					}
					response.sendRedirect("resetPassword.jsp");
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBUtil.closeConn(null, null, conn);
				}
			}
			
		}
		
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
