package com.san.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.san.dao.UserDao;
import com.san.model.User;
import com.san.utils.DBUtil;
import com.san.utils.SendJMail;
/**
 * 注册业务处理
 * @author Administrator
 *
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		String flag="";
		UserDao userDao=new UserDao();
		User user=new User();
		Connection conn=null;
		int k;
		if(request.getParameter("flag")!=null){
			flag=request.getParameter("flag");
			if(request.getParameter("userName")!=null&&flag.equals("userName")){
				//验证注册的用户名是否存在
				conn=DBUtil.getconn();
				String userName=request.getParameter("userName");
				try {
					k=userDao.registerUser(userName, "", "", conn,1);
					if(k==-1){
						//用户已存在,不能注册
						out.write("-1");
					}else{
						//user.setUserName(userName);
						session.setAttribute("userName", userName);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBUtil.closeConn(null, null, conn);
				}
			}
			if(request.getParameter("e_mail")!=null&&flag.equals("e_mail")){
				//验证注册的邮箱是否存在
				conn=DBUtil.getconn();
				String e_mail=request.getParameter("e_mail");
				try {
					k=userDao.registerUser("", e_mail, "", conn,2);
					if(k==-1){
						//用户已存在,不能注册
						out.write("-1");
					}else{
						session.setAttribute("e_mail",e_mail);
						//user.setE_mail(e_mail);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBUtil.closeConn(null, null, conn);
				}
			}
			if(request.getParameter("password")!=null&&flag.equals("password")){
				String password=request.getParameter("password");
				//user.setPassword(password);
				session.setAttribute("password", password);
			}
			//发送激活码
			if(flag.equals("jihuoma")){
				//生成激活码
				Random rd=new Random();
				String jihuoma="";
				for(int i=0;i<6;i++){
					String m=""+rd.nextInt(10);
					jihuoma=jihuoma+m;
				}
				session.setAttribute("suiji",jihuoma);
				SendJMail sm=new SendJMail();
				sm.sendMail(session.getAttribute("e_mail").toString(), jihuoma,"用户激活码:");
			}
			if(flag.equals("yanEmail")){
				String verifyNo=request.getParameter("verifyNo");
				if(session.getAttribute("suiji")!=null){
					if(verifyNo.equals(session.getAttribute("suiji").toString())){
						//激活成功，将用户添加到数据库
						conn=DBUtil.getconn();
						try {
							k=userDao.registerUser(session.getAttribute("userName").toString(),session.getAttribute("e_mail").toString(),
									session.getAttribute("password").toString(),conn,3);
							System.out.println(k);
							if(k==1){
								//System.out.println("成功");
							}else{
								//System.out.println("失败");
								out.write("-1");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}else{
					out.write("-1");
				}
			}
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
