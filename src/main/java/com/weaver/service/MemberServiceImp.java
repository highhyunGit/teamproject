package com.weaver.service;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.weaver.dao.MemberDao;
import com.weaver.dto.MemberDto;

@Service
public class MemberServiceImp implements MemberService {
	
	@Inject
	private MemberDao dao;
	
	// 회원 가입
	@Override
	public void signup(MemberDto dto) throws Exception {
		dao.signup(dto);
	}
	
	// 로그인
	@Override
	public MemberDto signin(MemberDto dto) throws Exception {
		return dao.signin(dto);
	}
	
	// 로그아웃
	@Override
	public void signout(HttpSession session) throws Exception {
		session.invalidate();
	}

}
