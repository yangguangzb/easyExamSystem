package com.san.utils;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	//根据积分数目,转化为响应的金额
	public static int transtateIntegral(int integral){
		switch (integral) {
		case 10:return 1;
		case 50:return 5;
		case 100:return 10;
		case 250:return 20;
		case 650:return 50;
		default:
			return 0;
		}
	}
	//将时间显示为几天前，几小时前等形式
	private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年
    public static String getTimeByDate(Date date) {
        if (date == null) {
            return null;
        }
        long diff = new Date().getTime() - date.getTime();
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "个月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "个小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }
	//数据库连接
	private static String driverClass="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/java_review?useUnicode=true&characterEncoding=UTF8";
	private static String user="root";
	private static String password="root";
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










