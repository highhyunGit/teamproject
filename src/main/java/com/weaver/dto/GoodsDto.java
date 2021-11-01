package com.weaver.dto;

import java.sql.Date;

public class GoodsDto {
	// db컬럼명과 동일하게 선언.
	private int gdsNum;
	private String gdsName;
	private String cateCode;
	private int gdsPrice;
	private int gdsStock;
	private String gdsDes;
	private String gdsImg;
	private Date gdsDate;
	
	//썸네일 저장 컬럼 추가
	private String gdsThumbImg;
	
	
	public GoodsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 일반생성자.
	public GoodsDto(int gdsNum, String gdsName, String cateCode, int gdsPrice, int gdsStock, String gdsDes,
			String gdsImg, Date gdsDate) {
		super();
		this.gdsNum = gdsNum;
		this.gdsName = gdsName;
		this.cateCode = cateCode;
		this.gdsPrice = gdsPrice;
		this.gdsStock = gdsStock;
		this.gdsDes = gdsDes;
		this.gdsImg = gdsImg;
		this.gdsDate = gdsDate;
	}
	
	// getters, setters
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}

	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
	
	public int getGdsNum() {
		return gdsNum;
	}

	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}

	public String getGdsName() {
		return gdsName;
	}

	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public int getGdsPrice() {
		return gdsPrice;
	}

	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}

	public int getGdsStock() {
		return gdsStock;
	}

	public void setGdsStock(int gdsStock) {
		this.gdsStock = gdsStock;
	}

	public String getGdsDes() {
		return gdsDes;
	}

	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}

	public String getGdsImg() {
		return gdsImg;
	}

	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}

	public Date getGdsDate() {
		return gdsDate;
	}

	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}
	
	// 객체표현양식
	@Override
	public String toString() {
		return "GoodsDto [gdsNum=" + gdsNum + ", gdsName=" + gdsName + ", cateCode=" + cateCode + ", gdsPrice="
				+ gdsPrice + ", gdsstock=" + gdsStock + ", gdsDes=" + gdsDes + ", gdsImg=" + gdsImg + ", gdsDate="
				+ gdsDate + "]";
	}
	
}
