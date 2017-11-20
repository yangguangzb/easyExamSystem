package com.san.dao;

import java.sql.SQLException;
import java.sql.*;
/**
 * 关于用户的数据库操作
 * @author Administrator
 *
 */
public class UserDao {
	/**
	 * 注册
	 * @param userName
	 * @param e_mail
	 * @param password
	 * @param conn
	 * @return -1	注册 用户名已存在,不能注册
	 * @return -2	注册邮箱已存在,不能注册
	 * @throws SQLException
	 */
	public int registerUser(String userName,String e_mail,String password,Connection conn,int flag) throws SQLException{
		String sql="";
		Statement stmt=conn.createStatement();
		ResultSet rs=null;
		//注册时,验证注册的用户名是否已存在
		if(flag==1){
			sql="select userName from user where userName='"+userName+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				//用户名存在
				return -1;
			}else{
				return 0;
			}
		}
		//注册时,验证注册的邮箱是否存在
		if(flag==2){
			sql="select e_mail from user where e_mail='"+e_mail+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				//邮箱存在
				return -1;
			}else{
				return 0;
			}
		}
		if(flag==3){
			//注册
			sql="insert into user values("+null+",'"+userName+"',"+1+",'"+e_mail+"','"+password+"',"+1+")";
			return stmt.executeUpdate(sql);
		}
		return 0;
		
	}
	/**
	 * 登录时，验证用户
	 * @param userName
	 * @param password
	 * @param conn
	 * @return false	用户名或密码错误
	 * @return true		登录成功
	 * @throws SQLException
	 */
	public boolean loginVerification(String userName,String password,Connection conn) throws SQLException{
		boolean b=false;
		String sql;
		Statement stmt=conn.createStatement();
		ResultSet rs;
		if(userName.contains("@")){
			//用邮箱登录系统
			sql="select e_mail,password from user where e_mail='"+userName+"' and password='"+password+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				b=true;
			}
		}else{
			sql="select userName,password from user where userName='"+userName+"' and password='"+password+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				b=true;
			}
		}
		return b;
	}
	/**
	 * 用户通过邮箱重置密码
	 * @param e_mail
	 * @param conn
	 * @flag=1时	查询用户输入的邮箱是否有效
	 * @flag=2时	用户重置密码
	 * @throws SQLException
	 */
	public int backPassword(String e_mail,String password,int flag,Connection conn) throws SQLException{
		Statement stmt=conn.createStatement();
		String sql="";
		if(flag==1){
			//查询用户输入的邮箱是否有效
			sql="select e_mail from user where e_mail='"+e_mail+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				return 1;	//邮箱有效
			}else{
				return -1;	//邮箱无效
			}
		}
		else if(flag==2){
			sql="update user set password='"+password+"' where e_mail='"+e_mail+"'";
			return stmt.executeUpdate(sql);
		}
		return 0;
	}
	
}
