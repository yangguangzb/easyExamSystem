package com.san.service.Impl;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.san.dao.Impl.QuestionDaoImpl;
import com.san.model.Answer;
import com.san.model.Question;
import com.san.utils.DBUtil;
public class QuestionServiceImpl {
	//插入一条问题记录
	QuestionDaoImpl questionDaoImpl=new QuestionDaoImpl();
	public int insertQuestServiceImpl(int creatorId,String questionTitle,String questionContent,
			String questionReward,String courseName){
		try {
			return questionDaoImpl.insertQuestion(creatorId, questionTitle, questionContent, questionReward, courseName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//待回答问题service(可以多加一个参数，和高分问题一起处理)
	@Test
	public List<Question> notAnswerService(int userId){
		try {
			List<Question> questions=questionDaoImpl.notAnswerQuestionDaoImpl(userId);
			for (Question question : questions) {
				//将数据库中的时间转化
				question.setShowTime(DBUtil.getTimeByDate(question.getQuestionCreationTime()));
				//设置问题回答次数
				int number=questionDaoImpl.answerNumber(question.getQuestionId());
				question.setAnswerNumber(number);
			}
			return questions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//回答问题的service
	public int answerQuestionService(String questionId,int userId,String answerContent){
		try {
			return questionDaoImpl.answerQuestionDaoImpl(questionId, userId, answerContent);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//显示网友回答的答案
	public List<Answer> showAllAnswerService(String questionId){
		try {
			int intquestionId=Integer.parseInt(questionId);
			return questionDaoImpl.showAllAnswerDaoImpl(intquestionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据问题编号，查询问题信息
	public Question questionByIdService(String questionId){
		try {
			int intquestionId=Integer.parseInt(questionId);
			//将时间转化
			Question question=questionDaoImpl.questionByIdDaoImpl(intquestionId);
			question.setShowTime(DBUtil.getTimeByDate(question.getQuestionCreationTime()));
			return question;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//查询高积分题目
	public List<Question> highQuestionService(int userId){
		try {
			List<Question> highQuestions=questionDaoImpl.checkHighQuestion(userId);
			for (Question question : highQuestions) {
				//将数据库中的时间转化
				question.setShowTime(DBUtil.getTimeByDate(question.getQuestionCreationTime()));
				//设置问题回答次数
				int number=questionDaoImpl.answerNumber(question.getQuestionId());
				question.setAnswerNumber(number);
			}
			return highQuestions;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
