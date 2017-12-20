package com.san.dao.Impl;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.san.model.BrushList;
import com.san.model.Subject;
import com.san.model.UseRecord;
import com.san.utils.C3p0Util;
public class BoutiqueDaoImpl {
	/**
	 *查询所有精品课程信息
	 */
	@Test
	public List<BrushList> checkAllBoutique() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from brushList where brushName='精品区'",new BeanListHandler<BrushList>(BrushList.class));
	}
	/**
	 * 查询精品区具体某门课程的信息
	 */
	public BrushList checkCourse(String courseName) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from brushList where brushName='精品区' and courseName=?",
				new BeanHandler<BrushList>(BrushList.class),courseName);
	}
	public boolean isBuy(int userId,String useType) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		UseRecord useRecord= qr.query("select * from useRecord where userId=? and useType=?",
				new BeanHandler<UseRecord>(UseRecord.class),userId,useType);
		if(useRecord!=null){
			//购买过该课程
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 扣除用户积分
	 * userId:用户编号
	 * BrushIntegral:课程积分-3为打折后积分
	 */
	public int reducePoints(int userId,int BrushIntegral,int integralNumber) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		System.out.println("扣除积分");
		return qr.update("update user set integralNumber=? where userId=?"
				,(integralNumber-BrushIntegral+3),userId);
	}
	/**
	 * 查询精品区某门课程的所有题目
	 */
	public List<Subject> checkBoutiqueSubject(String courseName) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from subject2 where brushName='精品区' and courseName=?",
				new BeanListHandler<Subject>(Subject.class),courseName);
	}
}

