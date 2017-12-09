package com.san.model;
import java.util.Date;
public class Answer {
	private int answerId;		//答疑回答编号
	private int questionId;		//答疑创建编号
	private int reviewerId;		//评论者编号
	private int answerPath;		//评价资源路径
	private String replyContent;//回复内容
	private Date answerTime;	//答疑时间
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
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
	public int getAnswerPath() {
		return answerPath;
	}
	public void setAnswerPath(int answerPath) {
		this.answerPath = answerPath;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}
	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", answerPath=" + answerPath
				+ ", answerTime=" + answerTime + ", questionId=" + questionId
				+ ", replyContent=" + replyContent + ", reviewerId="
				+ reviewerId + "]";
	}
}
