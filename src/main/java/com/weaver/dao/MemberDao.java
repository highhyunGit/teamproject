package com.weaver.dao;

import com.weaver.dto.MemberDto;

public interface MemberDao {
	// 회원 가입
	public void signup(MemberDto dto) throws Exception;
	
	// 로그인
	public MemberDto signin(MemberDto dto) throws Exception;
	
}
