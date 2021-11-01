package com.weaver.dto;

public class AddrDto {
	// DB컬럼명과 동일하게 선언.
	private String zipcode;
	private String addr;
	
	// 기본생성자.
	public AddrDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 일반생성자.
	public AddrDto(String zipcode, String addr) {
		super();
		this.zipcode = zipcode;
		this.addr = addr;
	}
	
	// getters, setters
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	// 객체표현양식
	@Override
	public String toString() {
		return "AddrDto [zipcode=" + zipcode + ", addr=" + addr + "]";
	}
	
}
