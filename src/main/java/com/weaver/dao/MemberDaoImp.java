package com.weaver.dao;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.weaver.dto.MemberDto;

@Repository
public class MemberDaoImp implements MemberDao {
	
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String namespace = "com.weaver.mappers.memberMapper";
	
	// 회원 가입
	@Override
	public void signup(MemberDto dto) throws Exception {
		sql.insert(namespace + ".signup", dto); 
	}

	// 로그인
	@Override
	public MemberDto signin(MemberDto dto) throws Exception {
		return sql.selectOne(namespace + ".signin", dto);
	}

}
