package com.san.model;
/**
 * 积分表
 * @author Administrator
 */
public class Integral {
	private int integralId;		//积分编号
	private int userId;			//用户编号
	private int integralNumber;	//积分数目
	public int getIntegralId() {
		return integralId;
	}
	public void setIntegralId(int integralId) {
		this.integralId = integralId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIntegralNumber() {
		return integralNumber;
	}
	public void setIntegralNumber(int integralNumber) {
		this.integralNumber = integralNumber;
	}
}
