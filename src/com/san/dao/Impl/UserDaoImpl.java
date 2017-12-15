package com.san.dao.Impl;
import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.san.dao.UserDao;
import com.san.model.User;
import com.san.utils.C3p0Util;
import com.san.utils.DBUtil;
/**
 * 关于用户的数据库操作
 * @author Administrator
 *
 */
public class UserDaoImpl implements UserDao{
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
			sql="insert into user values("+null+",'"+userName+"',1,'"+e_mail+"','"+password+"',1,10)";
			return stmt.executeUpdate(sql);
		}
		return 0;
		
	}
	/**
	 * 登录时，验证用户
	 * @param userName
	 * @param password
	 * @param conn
	 * @return user	登录成功
	 * @return null	用户名或密码错误
	 * @throws SQLException
	 */
	 public User loginVerification(String userName,String password) throws SQLException{
		  QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		  if(!userName.contains("@")){
			  //说明用户通过用户名登录
			  return qr.query("select * from user where userName=? and password=?",
					  new BeanHandler<User>(User.class),userName,password);
		  }
		  if(userName.contains("@")){
			  //说明用户通过邮箱登录
			  return qr.query("select * from user where e_mail=? and password=?",
					  new BeanHandler<User>(User.class),userName,password);
		  }
		  return null;
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
	//后台用户数据管
	/**
	 * 删除用户
	 * @return int
	 */
	@Test
	public int deleteUser(int userId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("delete from user where userId=?",userId);
	}
	//根据条件查询用户
	public List<User> mcheckUser(String userType,String userId,String verification) throws SQLException{
		StringBuffer sql=new StringBuffer("select * from user");
		if(userType!=""&&userType!=null){
			sql.append(" and userType="+userType+"");
		}
		if(userId!=""&&userId!=null){
			if(DBUtil.isNumeric(userId)){
				//输入的是用户编号
				int id=Integer.parseInt(userId);
				sql.append(" and userId="+id+"");
			}else{
				//输入的是用户名
				sql.append(" and userName="+userId+"");
			}
		}
		if(verification!=""&&verification!=null){
			int ve=0;
			if(verification.equals("1")){
				ve=1;
			}
			sql.append(" and verification="+ve+"");
		}
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query(sql.toString().replaceFirst("and","where"),new BeanListHandler<User>(User.class));
	}
	//添加用户
	public int maddUserDaoImpl(String userName,String e_mail,String password) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		User user;
		user=qr.query("select * from user where userName=?",new BeanHandler<User>(User.class),userName);
		if(user!=null){
			//用户名已存在
			return -1;
		}
		user=qr.query("select * from user where e_mail=?",new BeanHandler<User>(User.class),e_mail);
		if(user!=null){
			//邮箱已存在
			return -2;
		}
		return qr.update("insert into user(userName,e_mail,password) values(?,?,?)",userName,e_mail,password);
	}
	//修改用户信息
	public int mmodifyUserDaoImpl(int userId,String userType,String verification,int integralNumber) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("update user set userType=?,verification=?,integralNumber=? where userId=?"
				,userType,verification,integralNumber,userId);
	}
	//根据用户id查询用户信息
	public User checkUserById(int userId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from user where userId=?",new BeanHandler<User>(User.class),userId);
	}
}
