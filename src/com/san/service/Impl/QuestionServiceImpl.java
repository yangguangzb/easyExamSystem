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
	//待回答问题service
	@Test
	public List<Question> notAnswerService(){
		try {
			List<Question> questions=questionDaoImpl.notAnswerQuestionDaoImpl();
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
			questionDaoImpl.answerQuestionDaoImpl(questionId, userId, answerContent);
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
			questionDaoImpl.questionByIdDaoImpl(intquestionId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
