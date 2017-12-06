package com.san.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.san.model.Question;
import com.san.utils.C3p0Util;

public class QuestionDaoImpl {
	/**
	 * @param creatorId	提问者id
	 * @param questionPath	//提问资源路径
	 * @param questionTitle	//问题标题
	 * @param questionContent	//问题内容
	 * @param questionReward	//问题积分
	 * @param courseName		//问题学科
	 * @return
	 * @throws SQLException
	 */
	public int insertQuestion(int creatorId,String questionTitle,String questionContent,
			String questionReward,String courseName)throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("insert into question(creatorId,questionTitle,questionContent,questionReward,courseName) " +
				"values(?,?,?,?,?)",creatorId,questionTitle,questionContent,questionReward,courseName);
	}
	/**
	 * 查看高分问题,积分在15，20分
	 * 问题未被采纳,即问题状态为0
	 */
	public List<Question> checkHeightQuestion() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from question where questionState=0 and questionReward>10",
			new BeanListHandler<Question>(Question.class));
	}
	//查看待答问题,即问题状态为0
	public List<Question> notAnswerQuestion() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from question where questionState=0",
				new BeanListHandler<Question>(Question.class));
	}
	//查看我的问题
	public List<Question> myQuestion(int userId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from question where creatorId=?", 
			new BeanListHandler<Question>(Question.class),userId);
	}
	
}
