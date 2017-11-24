package com.san.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.san.dao.Impl.UserDaoImpl;
import com.san.model.User;

public class BackUserService {
	//管理后台用户
	UserDaoImpl userDaoImpl=new UserDaoImpl(); 
	public List<User> BackCheckUseService(int pageNow) throws SQLException{
		List<User> list=userDaoImpl.checkAllUser(pageNow);
		return list;
	}
}
