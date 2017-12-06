package com.san.utils;
import java.sql.*;
public class DBUtil {
	//判断是否为空
	public static boolean isEmpty(String str){
		if("".equals(str)||str==null){
			return true;
		}else{
			return false;
		}
	}
	//判断字符串是否全为数字
	public static boolean isNumeric(String str){
		for(int i = 0; i < str.length(); i++){
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	private static String driverClass="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://119.29.151.185:3306/java_review?useUnicode=true&characterEncoding=UTF8";
	private static String user="java";
	private static String password="123456";
	static{
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 *连接数据库
	 */
	public static Connection getconn(){
		
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关闭数据库
	 * @param conn
	 */
	public static void closeConn(ResultSet rs,PreparedStatement pstmt, Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if(pstmt!=null){
				pstmt.close();
				pstmt=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}










