package com.san.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.san.dao.Impl.UserDaoImpl;
import com.san.model.User;

public class MUserServiceImpl {
	//管理后台用户
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	public List<User> mcheckUserService(String userType,String userId,String verification){
		try {
			return userDaoImpl.mcheckUser(userType,userId,verification);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public int maddUserService(String userName,String e_mail,String password){
		try {
			return userDaoImpl.maddUserDaoImpl(userName, e_mail, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return 0;
	}
	//管理员修改用户信息
	public int modifyUserService(String userId,String userType,String verification,String integralNumber){
		try {
			int iter=0;
			//将String的用户积分转化为int
			if(integralNumber!=""){
				iter=Integer.parseInt(integralNumber);
			}
			return userDaoImpl.mmodifyUserDaoImpl(Integer.parseInt(userId), userType, verification, iter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//管理员删除用户
	public int mdelUserService(String userId){
		try {
			return userDaoImpl.deleteUser(Integer.parseInt(userId));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
