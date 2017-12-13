package com.san.service.Impl;

import java.sql.SQLException;

import com.san.dao.Impl.UserDaoImpl;
import com.san.model.User;

public class UserServiceImpl {
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	//根据用户Id查询用户信息
	public User checkUserByIdService(int userId){
		try {
			return userDaoImpl.checkUserById(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
