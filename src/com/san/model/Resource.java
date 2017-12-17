package com.san.model;
/*
* @Author: zijieya
* @Description: 资源
* */
public class Resource {
	private int resourceId;//资料编号
	private int uploadId;//上传者编号
	private String courseName;//课程名
	private String resourceName;//资料名
	private String resourceDescription;//资料描述
	private String resourcePath;//资料路径
	private int downNumber;//下载次数
	private int integration;//积分数目
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getIntegration() {
		return integration;
	}
	public void setIntegration(int integration) {
		this.integration = integration;
	}
	
	public int getUploadId() {
		return uploadId;
	}
	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceDescription() {
		return resourceDescription;
	}
	public void setResourceDescription(String resourceDescription) {
		this.resourceDescription = resourceDescription;
	}
	public int getDownNumber() {
		return downNumber;
	}
	public void setDownNumber(int downNumber) {
		this.downNumber = downNumber;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

}
