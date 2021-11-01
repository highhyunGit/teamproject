package com.weaver.dto;

import java.sql.Date;

public class ExpReplyListDto {

	// DB 컬럼명과 동일하게 선언.
	private int expNum;
	private String userId;
	private int repNum;
	private String repCon;
	private Date repDate;
	private String userName;
	
	// 기본생성자.
	public ExpReplyListDto() {
		super();
	}
	
	// 일반생성자.
	public ExpReplyListDto(int expNum, String userId, int repNum, String repCon, Date repDate, String userName) {
		super();
		this.expNum = expNum;
		this.userId = userId;
		this.repNum = repNum;
		this.repCon = repCon;
		this.repDate = repDate;
		this.userName = userName;
	}
	
	// getters, setters.
	public int getExpNum() {
		return expNum;
	}

	public void setExpNum(int expNum) {
		this.expNum = expNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}

	public String getRepCon() {
		return repCon;
	}

	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}

	public Date getRepDate() {
		return repDate;
	}

	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	// 객체표현양식
	@Override
	public String toString() {
		return "ExpReplyListDto [expNum=" + expNum + ", userId=" + userId + ", repNum=" + repNum + ", repCon=" + repCon
				+ ", repDate=" + repDate + ", userName=" + userName + "]";
	}
	
}
