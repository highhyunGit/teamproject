package com.weaver.dto;

import java.util.Date;

public class ReplyListDto {
	private int gdsNum; //상품번호
	private String userId; //사용자
	private int repNum; //댓글 번호
	private String repCon; //댓글 내용
	private Date repDate; //등록일
	
	private String  userName; //댓글리스트에서 유저명을 보여주기 위해 추가
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
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
	
	
	
}
