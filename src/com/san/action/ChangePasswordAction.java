package com.san.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.san.base.BaseAction;
import com.san.model.Subject;
import com.san.model.User;
import com.san.service.UserService;
import com.san.service.Impl.UserServiceImpl;

public class ChangePasswordAction extends BaseAction<User> {
      public String changePassword(){
    	  HttpServletResponse response = ServletActionContext.getResponse();
   	   response.setContentType("text/html;charset=utf-8");
   		 HttpServletRequest request=ServletActionContext.getRequest();//获取request
    	  String password=request.getParameter("pass").trim();
          User user=(User) request.getSession().getAttribute("user");
          if(user!=null){
              user.setPassword(password);
              UserService userService=new UserServiceImpl();
              userService.updateUserByPassword(user);
              return "login";
          }
		return null;

      }
}
