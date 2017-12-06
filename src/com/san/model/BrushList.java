package com.san.model;

import java.util.Date;

public class BrushList {
	private int brushId;		//刷题区编号
	private String brushName;   //刷题区名称
	private int managerId;		//管理员编号
	private String brushDescribe;//刷题区描述
	private String courseName;	//课程名称
	private int brushIntegral;	//刷题积分
	private Date brushcreateTime;//时间
	private String imageSource;	//图片路径
	public String getImageSource() {
		return imageSource;
	}
	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}
	public int getBrushId() {
		return brushId;
	}
	public void setBrushId(int brushId) {
		this.brushId = brushId;
	}
	public String getBrushName() {
		return brushName;
	}
	public void setBrushName(String brushName) {
		this.brushName = brushName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getBrushDescribe() {
		return brushDescribe;
	}
	public void setBrushDescribe(String brushDescribe) {
		this.brushDescribe = brushDescribe;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getBrushcreateTime() {
		return brushcreateTime;
	}
	public void setBrushcreateTime(Date brushcreateTime) {
		this.brushcreateTime = brushcreateTime;
	}
	public int getBrushIntegral() {
		return brushIntegral;
	}
	public void setBrushIntegral(int brushIntegral) {
		this.brushIntegral = brushIntegral;
	}
	@Override
	public String toString() {
		return "BrushList [brushDescribe=" + brushDescribe + ", brushId="
				+ brushId + ", brushIntegral=" + brushIntegral + ", brushName="
				+ brushName + ", brushcreateTime=" + brushcreateTime
				+ ", courseName=" + courseName + ", imageSource=" + imageSource
				+ ", managerId=" + managerId + "]";
	}
}
