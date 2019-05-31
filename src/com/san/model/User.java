package com.san.model;

public class User {
	private int userId;		     //用户编号
	private String userName;	 //用户名
	private int userType;	     //用户类型
	private String e_mail;	     //邮箱
	private String password;	 //密码
	private int verification;	 //是否验证邮箱
	private int integralNumber;  //用户积分数目
	
	//临时字段
	private String verificationCode; //找回密码时的验证码
	private String password1;	 //找回密码
	private String repass;
	
	
	public String getRepass() {
		return repass;
	}
	public void setRepass(String repass) {
		this.repass = repass;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword1() {
		return password1;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	
	
	
	
	
	public int getIntegralNumber() {
		return integralNumber;
	}
	public void setIntegralNumber(int integralNumber) {
		this.integralNumber = integralNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String eMail) {
		e_mail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getVerification() {
		return verification;
	}
	public void setVerification(int verification) {
		this.verification = verification;
	}
	@Override
	public String toString() {
		return "User [e_mail=" + e_mail + ", integralNumber=" + integralNumber
				+ ", password=" + password + ", userId=" + userId
				+ ", userName=" + userName + ", userTpye=" + userType
				+ ", verification=" + verification + "]";
	}
	
}
