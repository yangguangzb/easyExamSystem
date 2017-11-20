package com.san.utils;

import java.sql.Connection;

import javax.sql.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class C3p0Util {
	//得到一个数据源
	private static DataSource dataSource=new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return dataSource;
	}
	//从数据源中得到一个连接对象
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//关闭连接资源
	public static void closeConn(Connection conn,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt!=null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if(conn!=null){
			try {
				conn.close();//关闭
			} catch (Exception e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	
}
