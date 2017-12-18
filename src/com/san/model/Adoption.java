package com.san.model;

public class Adoption {
	private int adoptionId;	//采纳编号
	private int questionId;	//答疑创建编号
	private int reviewerId;	//评论者编号
	public int getAdoptionId() {
		return adoptionId;
	}
	public void setAdoptionId(int adoptionId) {
		this.adoptionId = adoptionId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(int reviewerId) {
		this.reviewerId = reviewerId;
	}
	
}
