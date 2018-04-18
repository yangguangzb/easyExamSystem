package com.san.service.Impl;

import java.sql.SQLException;

import com.san.dao.UserDao;
import com.san.dao.Impl.UserDaoImpl;
import com.san.model.User;
import com.san.service.UserService;

public class UserServiceImpl implements UserService{
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
	public void updateUserByPassword(User user) {
        UserDao userDao =new UserDaoImpl();
        userDao.updateUserByPassword(user);
	}
	
	//登录
	public User login(User user) {
		try {
			return userDaoImpl.loginVerification(user.getUserName(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//查看邮箱是否存在
	public int isE_mail(String e_mail) {
		int i=userDaoImpl.isE_mail(e_mail);
		return i;
	}
	
	//用户找回密码
	public int backPassword(String e_mail, String password) {
		try {
			return userDaoImpl.backPassword(e_mail, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//通过用户名查找用户
	public User findUserByUserName(String userName) {
		return userDaoImpl.findUserByUserName(userName);
	}
	
	//添加用户
	public int addUser(String userName,String e_mail,String password) {
		
		return userDaoImpl.save(userName,e_mail,password);
	}
}

