package com.san.service.Impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.san.dao.Impl.IntegralDaoImpl;
import com.san.model.User;
import com.san.utils.DBUtil;

public class IntegralServiceImpl {
	//积分使用记录处理
	IntegralDaoImpl integralDaoImpl=new IntegralDaoImpl();
	QuestionServiceImpl questionServiceImpl=new QuestionServiceImpl();
	/**
	 * @param userId	用户编号
	 * @param useType	使用类型
	 * @param useNumber 使用数目
	 * @return
	 */
	public int  boutiqueReduceService(int userId,String useType,int useNumber){
		try {
			return integralDaoImpl.boutiqueReducePoints(userId, useType, useNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//问题积分是否够
	public User isQuestionPointsService(int userId,String questionReward,
			String questionTitle,String questionContent,String courseName){
		int intquestionReward=Integer.parseInt(questionReward);
		try {
			User user= integralDaoImpl.isQuestionPoints(userId, intquestionReward);
			if(user!=null){
				//积分够用,插入问题信息
				questionServiceImpl.insertQuestServiceImpl(userId, questionTitle, questionContent, questionReward, courseName);
				//更新用户积分使用记录
				integralDaoImpl.boutiqueReducePoints(userId, "提出问题:"+questionTitle, -intquestionReward);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//用户购买积分
	public int buyPointsService(String buyNum,int userId){
		int intBuyNum=0;
		if(buyNum.equals("A")){
			//1元10积分
			intBuyNum=10;
		}
		if(buyNum.equals("B")){
			//5元50积分
			intBuyNum=50;
		}
		if(buyNum.equals("C")){
			//10元100积分
			intBuyNum=100;
		}
		if(buyNum.equals("D")){
			//20元250积分
			intBuyNum=250;
		}
		if(buyNum.equals("E")){
			//50元650积分
			intBuyNum=650;
		}
		try {
			//更新用户积分记录表
			integralDaoImpl.boutiqueReducePoints(userId, "购买积分", intBuyNum);
			return integralDaoImpl.buyPoints(userId, intBuyNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//后台查看积分
	public List<Map<String,Object>> checkIntegralService(String start,String end,String integralNumber,String username){
		int useNum=0;
		if(!"".equals(integralNumber)){
			useNum=Integer.parseInt(integralNumber);
		}
		try {
			List<Map<String,Object>> integralListMap= integralDaoImpl.checkIntegralDaoImpl(start, end, useNum, username);
			for (Map<String, Object> map : integralListMap) {
				int a=Integer.parseInt(map.get("useNubmer").toString());
				map.put("money", DBUtil.transtateIntegral(a));
			}
			return integralListMap;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
