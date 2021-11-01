package com.weaver.dto;

import java.sql.Date;

public class ExpReplyDto {

	// DB 컬럼명과 동일하게 선언.
	private int expNum;
	private String userId;
	private int repNum;
	private String repCon;
	private Date repDate;
	
	// 기본생성자.
	public ExpReplyDto() {
		super();
	}
	
	// 일반생성자.
	public ExpReplyDto(int expNum, String userId, int repNum, String repCon, Date repDate) {
		super();
		this.expNum = expNum;
		this.userId = userId;
		this.repNum = repNum;
		this.repCon = repCon;
		this.repDate = repDate;
	}
	
	// getters, setters
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

	// 객체표현양식
	@Override
	public String toString() {
		return "ExpReplyDto [expNum=" + expNum + ", userId=" + userId + ", repNum=" + repNum + ", repCon=" + repCon
				+ ", repDate=" + repDate + "]";
	}
	
}
