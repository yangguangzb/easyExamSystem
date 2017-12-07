package com.san.service.Impl;
import java.sql.SQLException;
import java.util.List;

import com.san.dao.Impl.QuestionDaoImpl;
import com.san.model.Question;
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
	public List<Question> notAnswerService(){
		try {
			return questionDaoImpl.notAnswerQuestionDaoImpl();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
