package com.san.dao.Impl;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import com.san.dao.IntegralDao;
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
	//精品课消耗积分记录
	public  int boutiqueReducePoints(int userId,String useType,int useNumber) throws SQLException{
		QueryRunner qr=new QueryRunner(C3p0Util.getDataSource());
		return qr.update("insert into useRecord(userId,useType,useNumber) values(?,?,?)",userId,useType,useNumber);
	}
}
