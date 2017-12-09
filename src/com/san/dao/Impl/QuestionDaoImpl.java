package com.san.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.san.model.Answer;
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
	public List<Question> notAnswerQuestionDaoImpl() throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		List<Question> t=qr.query("select * from question where questionState=0",
				new BeanListHandler<Question>(Question.class));
		return qr.query("select * from question where questionState=0",
				new BeanListHandler<Question>(Question.class));
	}
	//查看我的问题
	public List<Question> myQuestion(int userId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from question where creatorId=?", 
			new BeanListHandler<Question>(Question.class),userId);
	}
	//插入问题回答的内容
	public int answerQuestionDaoImpl(String questionId,int userId,String answerContent) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("insert into answer(questionId,reviewerId,replyContent) values(?,?,?)",questionId,userId,answerContent);
	}
	//显示某一题所有答案
	public List<Answer> showAllAnswerDaoImpl(int questionId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from answer where questionId=?",new BeanListHandler<Answer>(Answer.class),questionId);
	}
	//查看某道题被回答的次数
	public int answerNumber(int questionId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		Object o=qr.query("select count(*) from answer where questionId=?",new ScalarHandler(1),questionId);
		String number=o.toString();
		int intnumber=Integer.parseInt(number);
		return intnumber;
	}
	//根据问题编号，查看某道题的详细信息
	public Question questionByIdDaoImpl(int questionId) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.query("select * from question where questionId=?",new BeanHandler<Question>(Question.class),questionId);
	}
}
