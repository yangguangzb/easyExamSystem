package com.san.service.Impl;
import java.sql.SQLException;
import com.san.dao.Impl.QuestionDaoImpl;
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
}
