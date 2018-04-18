
package com.san.model;

import java.util.Date;
public class Grade {
	private int gradeId;	    //成绩编号
	private String brushId;	//刷题区名称
	private int userId;		    //用户编号
	private float grade;		//成绩
	private Date gradetime;	   		//时间\
	public String getBrushId() {
		return brushId;
	}
	public void setBrushId(String brushId) {
		this.brushId = brushId;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public Date getGradetime() {
		return gradetime;
	}
	public void setGradetime(Date gradetime) {
		this.gradetime = gradetime;
	}
}

