package com.san.model;

import java.util.Date;

public class UseRecord {
	//用户积分使用记录表
	private int recordId;	//使用记录编号
	private int userId;		//用户编号	
	private String useType;	 //使用类型	
	private int useNumber;	 //使用数目(整数表示加积分,负数表示减积分)
	private Date useTime;		//使用时间	
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public int getUseNumber() {
		return useNumber;
	}
	public void setUseNumber(int useNumber) {
		this.useNumber = useNumber;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	@Override
	public String toString() {
		return "UseRecord [recordId=" + recordId + ", useNumber=" + useNumber
				+ ", useTime=" + useTime + ", useType=" + useType + ", userId="
				+ userId + "]";
	}
}
