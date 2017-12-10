package com.san.servlet;

import com.san.model.User;
import com.san.service.Impl.UserServiceImpl;
import com.san.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangePasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* PrintWriter out=response.getWriter();
        out.write("hello world!");*/
        String password=request.getParameter("pass").trim();
        User user=(User) request.getSession().getAttribute("user");
        if(user!=null){
            user.setPassword(password);
            UserService userService=new UserServiceImpl();
            userService.updateUserByPassword(user);
            response.sendRedirect("/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
