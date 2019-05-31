package com.san.action;

import java.io.IOException;
import java.util.List;

import com.san.base.BaseAction;
import com.san.model.User;
import com.san.service.Impl.MUserServiceImpl;

public class ManageUsersAction extends BaseAction<User>{
	private static final long serialVersionUID = 1L;
	MUserServiceImpl mUserService=new MUserServiceImpl();
	/**
	 * 查询所有用户,并显示
	 * @return
	 */
	public String checkUsers(){
		String userType=getRequest().getParameter("userType");
		String userId=getRequest().getParameter("userId");
		String verification=getRequest().getParameter("verification");
		List<User> mUserList=mUserService.mcheckUserService(userType, userId,verification);
		//保存查询的用户信息
		getRequest().setAttribute("mUserList", mUserList);
		return "checkUsers";
	}
	
	/**
	 * 添加用户
	 * @return
	 * @throws IOException 
	 */
	public String addUser() throws IOException{
		String e_mail = this.getModel().getE_mail();
		String userName = this.getModel().getUserName();
		String password = this.getModel().getPassword();
		String i=mUserService.maddUserService(userName, e_mail, password)+"";
		getPrintWriter().write(i);
		return null;
	}
	
	/**
	 * 修改用户信息
	 * @return
	 * @throws IOException 
	 */
	public String modifyUser() throws IOException{
		String userId = getRequest().getParameter("userId");
		String userType = this.getModel().getUserType()+"";
		String verification = this.getModel().getVerification()+"";
		String integralNumber = this.getModel().getIntegralNumber()+"";
		String i=mUserService.modifyUserService(userId, userType, verification, integralNumber)+"";
		//响应回浏览器
		getPrintWriter().write(i);
		return null;
	}
	
	/**
	 * 删除用户
	 * @return
	 * @throws IOException 
	 */
	public String delUser() throws IOException{
		String userId=getRequest().getParameter("userId");
		String i=mUserService.mdelUserService(userId)+"";
		getPrintWriter().write(i);
		return null;
	}
}
