package com.weaver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.weaver.dao.ExpDao;
import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyDto;
import com.weaver.dto.ExpReplyListDto;

@Service
public class ExpServiceImpl implements ExpService {
	
	@Inject
	private ExpDao dao;
	
	// 체험목록
	@Override
	public List<ExpDto> expList() throws Exception {
		return dao.expList();
	}
	
	// 체험조회
	@Override
	public ExpDto expView(int expNum) throws Exception {
		return dao.expView(expNum);
	}

	// 체험리뷰
	@Override
	public void registReply(ExpReplyDto reply) throws Exception {
		dao.registReply(reply);
	}
	
	// 체험리뷰 리스트
	@Override
	public List<ExpReplyListDto> replyList(int expNum) throws Exception {
		return dao.replyList(expNum);
	}
	
	// 체험리뷰 삭제
	@Override
	public void deleteReply(ExpReplyDto reply) throws Exception {
		dao.deleteReply(reply);
	}
	
	// 체험리뷰 삭제 시 아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return dao.idCheck(repNum);
	}
	
	// 체험리뷰 수정
	@Override
	public void modifyReply(ExpReplyDto reply) throws Exception {
		dao.modifyReply(reply);
	}

}
