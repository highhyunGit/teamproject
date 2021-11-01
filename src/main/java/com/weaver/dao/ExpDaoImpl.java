package com.weaver.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyDto;
import com.weaver.dto.ExpReplyListDto;

@Repository
public class ExpDaoImpl implements ExpDao {

	@Inject
	private SqlSession sql;
	
	// mapper
	private static String namespace = "com.weaver.mappers.expMapper";	
	
	// 체험목록
	// 관리자 모드 리스트의 쿼리문이 동일함.
	@Override
	public List<ExpDto> expList() throws Exception {
		return sql.selectList("com.weaver.mappers.adminMapper.expList");
	}
	
	// 체험조회
	// 관리자 모드 리스트의 쿼리문이 동일함.
	@Override
	public ExpDto expView(int expNum) throws Exception {
		return sql.selectOne("com.weaver.mappers.adminMapper.expView", expNum);
	}
	
	// 체험리뷰
	@Override
	public void registReply(ExpReplyDto reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}
	
	// 체험리뷰 리스트
	@Override
	public List<ExpReplyListDto> replyList(int expNum) throws Exception {
		return sql.selectList(namespace + ".replyList", expNum);
	}
	
	// 체험리뷰 삭제
	@Override
	public void deleteReply(ExpReplyDto reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}
	
	// 체험리뷰 삭제 시 아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}
	
	// 체험리뷰 수정.
	@Override
	public void modifyReply(ExpReplyDto reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}

}
