package com.weaver.dto;

import java.sql.Date;

public class ExpDto {
	// db컬럼명과 동일하게 선언.
	private int expNum;
	private String expName;
	private int expPrice;
	private String expDes;
	private String expImg;
	private Date regDate;
	// 컬럼 추가 형식으로 생성.
	private String expThumbImg;
	
	// 기본생성자
	public ExpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 일반생성자.
	public ExpDto(int expNum, String expName, int expPrice, String expDes, String expImg, Date regDate,
			String expThumbImg) {
		super();
		this.expNum = expNum;
		this.expName = expName;
		this.expPrice = expPrice;
		this.expDes = expDes;
		this.expImg = expImg;
		this.regDate = regDate;
		this.expThumbImg = expThumbImg;
	}

	// getters, setters
	public int getExpNum() {
		return expNum;
	}

	public void setExpNum(int expNum) {
		this.expNum = expNum;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public int getExpPrice() {
		return expPrice;
	}

	public void setExpPrice(int expPrice) {
		this.expPrice = expPrice;
	}

	public String getExpDes() {
		return expDes;
	}

	public void setExpDes(String expDes) {
		this.expDes = expDes;
	}

	public String getExpImg() {
		return expImg;
	}

	public void setExpImg(String expImg) {
		this.expImg = expImg;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getExpThumbImg() {
		return expThumbImg;
	}

	public void setExpThumbImg(String expThumbImg) {
		this.expThumbImg = expThumbImg;
	}
	
	// 객체표현양식
	@Override
	public String toString() {
		return "ExpDto [expNum=" + expNum + ", expName=" + expName + ", expPrice=" + expPrice + ", expDes=" + expDes
				+ ", expImg=" + expImg + ", regDate=" + regDate + ", expThumbImg=" + expThumbImg + "]";
	}
	
}
