package com.weaver.service;

import java.util.List;

import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyDto;
import com.weaver.dto.ExpReplyListDto;

public interface ExpService {
	// 체험목록
	public List<ExpDto> expList() throws Exception;
	
	// 체험조회
	public ExpDto expView(int expNum) throws Exception;
	
	// 체험리뷰
	public void registReply(ExpReplyDto reply) throws Exception;

	// 체험리뷰 리스트
	public List<ExpReplyListDto> replyList(int expNum) throws Exception;
	
	// 체험리뷰 삭제
	public void deleteReply(ExpReplyDto reply) throws Exception;
	
	// 체험리뷰 삭제 시 아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	// 체험리뷰 수정
	public void modifyReply(ExpReplyDto reply) throws Exception;
	
}
