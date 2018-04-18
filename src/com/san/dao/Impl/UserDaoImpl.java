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
	QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
	
	//通过用户名查找用户
	public User findUserByUserName(String userName){
		try {
			String sql="select userName from user where userName='"+userName+"'";
			return qr.query(sql,new BeanHandler<User>(User.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 //登录时，验证用户
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
	 
	//验证邮箱是否有效
	public int isE_mail(String e_mail){
		try {
			User user=qr.query("select * from user where e_mail='"+e_mail+"'",new BeanHandler<User>(User.class));
			if(user!=null){
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	//找回密码
	public int backPassword(String e_mail,String password) throws SQLException{
		String sql="update user set password='"+password+"' where e_mail='"+e_mail+"'";
		return qr.update(sql);
	}
	
	//后台用户数据管
	
	// 删除用户
	public int deleteUser(int userId) throws SQLException{
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
				sql.append(" and userName='"+userId+"'");
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
		String sql2=sql.toString().replaceFirst("and","where");
		return qr.query(sql2,new BeanListHandler<User>(User.class));
	}
	
	//添加用户(后台)
	public int maddUserDaoImpl(String userName,String e_mail,String password) throws SQLException{
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
		return qr.update("update user set userType=?,verification=?,integralNumber=? where userId=?"
				,userType,verification,integralNumber,userId);
	}
	
	
	//根据用户id查询用户信息
	public User checkUserById(int userId) throws SQLException{
		return qr.query("select * from user where userId=?",new BeanHandler<User>(User.class),userId);
	}
    public void  addIntegralNumber(User user, int IntegralNumber) {
        try{
            String sql="update user set integralNumber=?+? where userId=?";
            Object[] params={user.getIntegralNumber(),IntegralNumber,user.getUserId()};
            qr.update(sql,params);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void minusIntegralNumber(User user, int IntegralNumber) {
        try{
            String sql="update user set integralNumber=?-? where userId=?";
            Object[] params={user.getIntegralNumber(),IntegralNumber,user.getUserId()};
            qr.update(sql,params);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

	public void updateUserByPassword(User user) {
		try {
			String sql="update user set  password=? where userId=?";
			Object[] params= {user.getPassword(),user.getUserId()};
			qr.update(sql,params);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

    public User getUser(int userId) {
        try{
            String sql="select * from user where userId=?";
            return (User) qr.query(sql,new BeanHandler(User.class),userId);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    //测试
	public int deleteUser2(int id) throws SQLException{
		return qr.update("delete from user where userId=?",3);
	}
	
	//添加用户
	public int save(String userName,String e_mail,String password) {
		try {
			String sql="insert into user values("+null+",'"+userName+"',0," +
			"'"+e_mail+"','"+password+"',1,10)";
			return qr.update(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}

	

