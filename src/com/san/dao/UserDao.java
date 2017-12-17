package com.san.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.san.model.User;

public interface UserDao {
	 public User loginVerification(String userName,String password) throws SQLException;
	public int backPassword(String e_mail,String password,int flag,Connection conn) throws SQLException;
	public void addIntegralNumber(User user,int IntegralNumber);//增加积分
    public void minusIntegralNumber(User user,int IntegralNumber);//减少积分
	public void updateUserByPassword(User user);//通过密码更新用户信息
    public User getUser(int userId);
	
}
