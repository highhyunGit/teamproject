package com.weaver.dto;

import java.sql.Date;

public class MemberDto {
	// db컬럼명과 동일하게 선언.
	private String userId;
	private String userPass;
	private String userName;
	private String userPhone;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private Date regDate;
	private int verify;
	
	// 기본생성자.
	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 일반생성자.
	public MemberDto(String userId, String userPass, String userName, String userPhone, String userAddr1,
			String userAddr2, String userAddr3, Date regDate, int verify) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.regDate = regDate;
		this.verify = verify;
	}
	
	// getters, setters.
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr1() {
		return userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getUserAddr3() {
		return userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}
	
	// 객체표현양식
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", userPhone="
				+ userPhone + ", userAddr1=" + userAddr1 + ", userAddr2=" + userAddr2 + ", userAddr3=" + userAddr3
				+ ", regDate=" + regDate + ", verify=" + verify + "]";
	}
	
	
}
