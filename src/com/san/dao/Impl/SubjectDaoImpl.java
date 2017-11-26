package com.san.dao.Impl;
import java.sql.*;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.san.dao.SubjectDao;
import com.san.model.Subject;
import com.san.model.User;
import com.san.utils.C3p0Util;
/**
 * 题目数据库操作
 * @author Administrator
 */
public class SubjectDaoImpl implements SubjectDao{
	/**
	 * @param courseName	课程名称
	 * //@param startPage		开始页(记录)
	 * // @param endPage		结束
	 * @return list
	 * @throws SQLException
	 */
	public List<Subject> checkSubject(String courseName,int subjectId,String subjectType) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		//String sql="select * from subject where courseName=? and subjectType=? limit "+subjectId+",20";
		List<Subject> list=qr.query("select * from subject2 where courseName=? and subjectType=? limit "+subjectId+",20",new BeanListHandler<Subject>(Subject.class),courseName,subjectType);
		return list;
	}
	@Test
	public void check() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		List<Subject> list=qr.query("select * from subject2 " ,new BeanListHandler<Subject>(Subject.class));
		for (Subject subject : list) {
			System.out.println(subject.getAnalysis());
		}
		
	}
}
