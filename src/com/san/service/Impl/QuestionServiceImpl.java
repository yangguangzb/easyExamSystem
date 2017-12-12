package com.san.service.Impl;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.san.dao.Impl.IntegralDaoImpl;
import com.san.dao.Impl.QuestionDaoImpl;
import com.san.dao.Impl.UserDaoImpl;
import com.san.model.Answer;
import com.san.model.Question;
import com.san.model.User;
import com.san.utils.DBUtil;
public class QuestionServiceImpl {
	//插入一条问题记录
	QuestionDaoImpl questionDaoImpl=new QuestionDaoImpl();
	UserDaoImpl userDaoImpl=new UserDaoImpl();
	IntegralDaoImpl integralDaoImpl=new IntegralDaoImpl();
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
			List<Answer> answers= questionDaoImpl.showAllAnswerDaoImpl(intquestionId);
			for (Answer answer : answers) {
				User user=userDaoImpl.checkUserById(answer.getReviewerId());
				answer.setAnswerUserName(user.getUserName());
			}
			return answers;
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
			User user=userDaoImpl.checkUserById(question.getCreatorId());//根据提问者Id获得信息
			question.setCreatorName(user.getUserName());
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
	//我的所有问题
	public List<Question> myQuestion(int userId){
		//先根据用户Id查出该用户所有问题,在根据问题Id查出所有答案(避免没有回答的问题)
		try {
			List<Question> myQuestions=questionDaoImpl.myQuestion(userId);
			for (Question question : myQuestions) {
				//将数据库中的时间转化
				question.setShowTime(DBUtil.getTimeByDate(question.getQuestionCreationTime()));
				//设置问题回答次数
				int number=questionDaoImpl.answerNumber(question.getQuestionId());
				question.setAnswerNumber(number);
			}
			return myQuestions;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//我的回答
	public List<Map<String,Object>> myAnswerService(int userId){
		try {
			List<Map<String,Object>> listMap=questionDaoImpl.myAnswerDaoImpl(userId);
			for (Map<String, Object> map : listMap) {
				Date answerTime=(Date) map.get("answerTime");
				map.put("answerTime",DBUtil.getTimeByDate(answerTime));
			}
			return listMap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/*//我的某个问题显示所有信息(用list map)
	public void myQuestionDetailService(String questionId){
		int intQuestionId=Integer.parseInt(questionId);
		
	}*/
	//我的某个问题被解决处理
	public void myQuestionDetailService(String questionId,String reviewerId){
		int intQuestionId=Integer.parseInt(questionId);
		int intRreviewerId=Integer.parseInt(reviewerId);
		try {
			//更新该问题状态,设置为1(已解决)
			questionDaoImpl.updateQuestionState(intQuestionId);
			Question question=questionDaoImpl.questionByIdDaoImpl(intQuestionId);
			//给最好答案用户加积分(相当于购买了积分)
			integralDaoImpl.buyPoints(intRreviewerId, question.getQuestionReward());
			//更新最好答案用户积分记录
			integralDaoImpl.boutiqueReducePoints(intRreviewerId, "回答问题:回答问题所得积分", question.getQuestionReward());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
