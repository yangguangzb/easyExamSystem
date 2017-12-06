package com.san.dao.Impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.san.dao.IntegralDao;
import com.san.model.User;
import com.san.utils.C3p0Util;
public class IntegralDaoImpl implements IntegralDao{
	//积分操作
	//购买积分,更新用户积分
	public int buyPoints(int userId,int PointsNumber) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("update user set integralNumber=integralNumber+? where userId=?"
				,PointsNumber,userId);
	}
	//更新积分购买表(使用记录)
	public int pointsRecord(int userId,String useType) throws SQLException{
		return 0;
	}
	/**
	 * 精品课消耗积分记录
	 * 提出问题消耗积分记录
	 * @param userId
	 * @param useType
	 * @param useNumber
	 * @return
	 * @throws SQLException
	 */
	public  int boutiqueReducePoints(int userId,String useType,int useNumber) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("insert into useRecord(userId,useType,useNumber) values(?,?,?)",userId,useType,useNumber);
	}
	/**
	 * 用户提出问题时,查询用户积分是否够
	 * 积分够用,扣除积分，响应1
	 * 积分不够,响应-1
	 * @param userId	
	 * @param questionReward
	 * @return
	 * @throws SQLException
	 */
	public int isQuestionPoints(int userId,int questionReward) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		User user=qr.query("select * from user where userId=?",new BeanHandler<User>(User.class),userId);
		if(user.getIntegralNumber()<questionReward){
			//用户积分不足，不能设置该积分来提问
			return -1;
		}else{
			//积分够,扣除积分
			qr.update("update user set integralNumber=integralNumber-? where userId=?",questionReward,userId);
			return 1;
		}
	}
}
