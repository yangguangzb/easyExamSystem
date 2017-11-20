package com.san.utils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TestCRUD {
	@Test
	public void test1() throws SQLException{
		//创建一个QueryRunner对象
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		//执行sql查询
		//int k=qr.update("insert into user(userName,password,e_mail) values(?,?,?)","李四","444","44@qq.com");
		int k=qr.update("insert into user(userName,password,e_mail) values(?,?,?)","李四","44","44@qq.com");
		System.out.println(k);
	}

	/*//创建一个QueryRunner对象
	QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
	//执行sql语句
	qr.update("insert into users(username,password,email,birthday) values(?,?,?,?)", 
			"菜10","123","c10@163.com",new Date());*/
}
