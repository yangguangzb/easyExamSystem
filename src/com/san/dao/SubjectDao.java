package com.san.dao;
import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.san.model.Subject;
import com.san.utils.C3p0Util;
/**
 * 题目数据库操作
 * @author Administrator
 */
public class SubjectDao {
	/**
	 * @param courseName	课程名称
	 * @param startPage		开始页(记录)
	 * @param endPage		结束
	 * @return list
	 * @throws SQLException
	 */
	public List<Subject> checkSubject(String courseName,int startPage) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		String sql="select * from subject where courseName='"+courseName+"' limit "+startPage+",20";
		List<Subject> list=qr.query(sql,new BeanListHandler<Subject>(Subject.class),courseName);
		return list;
	}
	
}
