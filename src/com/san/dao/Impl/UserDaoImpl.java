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
			sql="insert into user values("+null+",'"+userName+"',"+1+",'"+e_mail+"','"+password+"',"+1+")";
			return stmt.executeUpdate(sql);
		}
		return 0;
		
	}
	/**
	 * 登录时，验证用户
	 * @param userName
	 * @param password
	 * //@param conn
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

    @Override
    public void  addIntegralNumber(User user, int IntegralNumber) {
        try{
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="update user set integralNumber=?+? where userId=?";
            Object[] params={user.getIntegralNumber(),IntegralNumber,user.getUserId()};
            runner.update(sql,params);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void minusIntegralNumber(User user, int IntegralNumber) {
        try{
            QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
            String sql="update user set integralNumber=?-? where userId=?";
            Object[] params={user.getIntegralNumber(),IntegralNumber,user.getUserId()};
            runner.update(sql,params);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

	@Override
	public void updateUserByPassword(User user) {
		try {
			QueryRunner runner=new QueryRunner(C3p0Util.getDataSource());
			String sql="update user set  password=? where userId=?";
			Object[] params= {user.getPassword(),user.getUserId()};
			runner.update(sql,params);
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	//后台用户数据管理
	/**
	 * 分页查询用户
	 * @return list
	 */
	public List<User> checkAllUser(int pageNow) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		int a=(pageNow-1)*10;
		List<User> list=qr.query("select * from user limit "+a+",10", new BeanListHandler<User>(User.class));
		return list;
	}
	/**
	 * 删除用户
	 * @return int
	 */
	@Test
	public int deleteUser(int id) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("delete from user where userId=?",3);
	}

	
}
