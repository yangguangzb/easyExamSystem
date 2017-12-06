package com.san.service.Impl;

import java.sql.SQLException;

import com.san.dao.Impl.IntegralDaoImpl;

public class IntegralServiceImpl {
	//积分使用记录处理
	IntegralDaoImpl integralDaoImpl=new IntegralDaoImpl();
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
}
