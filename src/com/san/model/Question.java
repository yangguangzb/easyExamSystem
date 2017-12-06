package com.san.model;

import java.util.Date;

public class Question {
	private int questionId;				//答疑创建编号
	private String questionTitle;		//标题
	private int creatorId;				//创建者编号
	private String questionPath;		//答疑资源路径
	private String questionContent;		//提问内容
	private int priority;				//优先级
	private Date questionCreationTime;	//创建时间
	private int questionReward; 		//提问设置积分
	private String courseName;			//课程
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public int getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}
	public String getQuestionPath() {
		return questionPath;
	}
	public void setQuestionPath(String questionPath) {
		this.questionPath = questionPath;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getQuestionCreationTime() {
		return questionCreationTime;
	}
	public void setQuestionCreationTime(Date questionCreationTime) {
		this.questionCreationTime = questionCreationTime;
	}
	public int getQuestionReward() {
		return questionReward;
	}
	public void setQuestionReward(int questionReward) {
		this.questionReward = questionReward;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Question [courseName=" + courseName + ", creatorId="
				+ creatorId + ", priority=" + priority + ", questionContent="
				+ questionContent + ", questionCreationTime="
				+ questionCreationTime + ", questionId=" + questionId
				+ ", questionPath=" + questionPath + ", questionReward="
				+ questionReward + ", questionTitle=" + questionTitle + "]";
	}
	
}
