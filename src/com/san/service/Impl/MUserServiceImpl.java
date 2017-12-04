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
}
