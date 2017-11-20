package com.san.model;
/**
 * 题目表
 * @author Administrator
 */
public class Subject {
	private int subjectId;			//题目编号	
	private String brushName;		//刷题区名称
	private String courseName;		//课程名称
	private String subjectType;		//题目类型
	private String subjectTitle;	//题目标题
	private String optionA;			//选项A	
	private String optionB;			//选项B	
	private String optionC;			//选项C	
	private String optionD;			//选项D	
	private String optionAnswer;	//答案	
	private String analysis;		//答案解析	
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getBrushName() {
		return brushName;
	}
	public void setBrushName(String brushName) {
		this.brushName = brushName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}
	public String getSubjectTitle() {
		return subjectTitle;
	}
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getOptionAnswer() {
		return optionAnswer;
	}
	public void setOptionAnswer(String optionAnswer) {
		this.optionAnswer = optionAnswer;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	
}
