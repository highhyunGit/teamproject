package com.weaver.service;


import javax.servlet.http.HttpSession;

import com.weaver.dto.MemberDto;

public interface MemberService {
	// 회원 가입
	public void signup(MemberDto dto) throws Exception;
	
	// 로그인
	public MemberDto signin(MemberDto dto) throws Exception;
	
	// 로그인
	public void signout(HttpSession session) throws Exception;
	
}
