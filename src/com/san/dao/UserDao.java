package com.san.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.san.model.User;

public interface UserDao {
	 public User loginVerification(String userName,String password) throws SQLException;
	public int backPassword(String e_mail,String password,int flag,Connection conn) throws SQLException;
	
}
