package com.san.dao.Impl;
import java.sql.*;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Test;

import com.san.dao.SubjectDao;
import com.san.model.BrushList;
import com.san.model.Subject;
import com.san.utils.C3p0Util;
import com.san.utils.DBUtil;
/**
 * 题目数据库操作
 * @author Administrator
 */
public class SubjectDaoImpl implements SubjectDao{
	/**
	 * @param courseName	课程名称
	 * @param startPage		开始页(记录)
	 * @param endPage		结束
	 * @return list
	 * @throws SQLException
	 */
	public List<Subject> checkSubject(String courseName,int subjectId,String subjectType) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		//String sql="select * from subject where courseName=? and subjectType=? limit "+subjectId+",20";
		List<Subject> list=qr.query("select * from subject2 where courseName=? and subjectType=? limit "+subjectId+",20",
				new BeanListHandler<Subject>(Subject.class),courseName,subjectType);
		return list;
	}
	/**
	 * 插入测试成绩
	 * @throws SQLException
	 */
	public int insertGrade(int brushId,String courseName,int userId,float grade) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("insert into grade(brushId,courseName,userId,grade) values(?,?,?,?)",brushId,courseName,userId,grade);
	}
	//刷题成绩排名
	@Test
	public List<Map<String,Object>> pankGradeDaoImpl() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		List<Map<String,Object>> pankGradeListMap=qr.query("select user.userName,sum(grade) as grade from grade,user where user.userId=grade.userId GROUP BY user.userName ORDER BY sum(grade) DESC ", new MapListHandler());
		return pankGradeListMap;
	}
	/**
	 * 通过brushName,courseName来查询brushId(刷题区id)
	 * @throws SQLException
	 */
	public BrushList checkBrushId(String brushName,String courseName) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from brushList where brushName=? and courseName=?",
				new BeanHandler<BrushList>(BrushList.class),brushName,courseName);
	}
	//后台数据操作
	public List<Subject> checkSubject(String subjectId,String brushName,String courseName,String subjectType) throws SQLException{
		StringBuffer sql=new StringBuffer("select * from subject2");
		if(!DBUtil.isEmpty(brushName)){
			//区类型不为空
			sql.append(" and brushName='"+brushName+"'");
		}
		if(!DBUtil.isEmpty(courseName)){
			//课程名不为空
			sql.append(" and courseName='"+courseName+"'");
		}
		if(!DBUtil.isEmpty(subjectType)){
			//题目类型不为空
			sql.append(" and subjectType='"+subjectType+"'");
		}
		if(!DBUtil.isEmpty(subjectId)){
			//题目编号不为空
			int id=Integer.parseInt(subjectId);
			sql.append(" and subjectId="+id+"");
		}
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query(sql.toString().replaceFirst("and","where"),new BeanListHandler<Subject>(Subject.class));
	}
	//根据id来查询某一道题目的具体信息
	public Subject checkSubjectById(String subjectId) throws SQLException{
		int subId=1;
		if(subjectId!=""&&subjectId!=null){
			subId=Integer.parseInt(subjectId);
		}
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from subject2 where subjectId=?",new BeanHandler<Subject>(Subject.class),subId);
	}
	//删除某一道题目
	public int delSubject(int subjectId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("delete from subject2 where subjectId=?",subjectId);
	}
	//添加题目
	public int addSubjectDaoImpl(String brushName,String subjectType,String courseName,String title,String Aoption,
			String Boption,String Coption,String Doption,String answer,String analysis) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("insert into subject2(brushName,courseName,subjectType,subjectTitle,optionA,optionB,optionC,optionD,subjectAnswer,analysis) " +
				"values(?,?,?,?,?,?,?,?,?,?)",brushName,courseName,subjectType,title,Aoption,Boption,Coption,Doption,answer,analysis);
	}
	//修改题目信息
	public int editSubjectDaoImpl(int subjectId,String brushName,String subjectType,String courseName,String title,String Aoption,
			String Boption,String Coption,String Doption,String answer,String analysis) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("update subject2 set brushName=?,courseName=?,subjectType=?,subjectTitle=?,optionA=?,optionB=?,optionC=?,optionD=?,subjectAnswer=?,analysis=? where subjectId=?"
				,brushName,courseName,subjectType,title,Aoption,Boption,Coption,Doption,answer,analysis,subjectId);
	}
}

