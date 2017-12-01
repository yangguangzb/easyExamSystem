package com.san.servlet;

import com.san.model.Resource;
import com.san.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.fileupload.*;
public class ResourceUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      User user=(User)request.getSession().getAttribute("user");
      if(user!=null){
          Resource resource=new Resource();
          resource.setDownNumber(0);
          resource.setUploadId(user.getUserId());

      }
      else {
          response.sendRedirect("login.jsp");
      }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
