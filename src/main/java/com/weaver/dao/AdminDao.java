package com.weaver.dao;

import java.util.List;

import com.weaver.dto.CategoryDto;
import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyListDto;
import com.weaver.dto.GoodsDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyListDto;

public interface AdminDao {
	//카테고리
	public List<CategoryDto> category() throws Exception;
	//상품등록
	public void register(GoodsDto dto) throws Exception;
//	상품목록
//	public List<GoodsDto> goodsList() throws Exception;
	//상품목록
	public List<GoodsViewDto> goodsList() throws Exception;	
//	상품조회
//	public GoodsDto goodsView(int gdsNum) throws Exception;
	//상품조회 +  카테고리 조인
	public GoodsViewDto goodsView(int gdsNum) throws Exception;	
	//상품 수정
	public void goodsModify(GoodsDto dto) throws Exception;
	//상품 삭제
	public void goodsDelete(int gdsNum) throws Exception;
	//주문 목록
	public List<OrderDto> orderList() throws Exception;
	//특정 주문 목록
	public List<OrderListDto> orderView(OrderDto order) throws Exception;
	// 배송 상태
	public void delivery(OrderDto order) throws Exception;
	// 상품 수량 조절
	public void changeStock(GoodsDto goods) throws Exception;
	// 모든 소감(댓글)
	public List<ReplyListDto> allReply() throws Exception;
	// 소감(댓글) 삭제
	public void deleteReply(int repNum) throws Exception;
	
	// 체험등록
	public void expRegister(ExpDto dto) throws Exception;
	
	// 체험목록
	public List<ExpDto> expList() throws Exception;
	
	// 체험조회
	public ExpDto expView(int expNum) throws Exception;
	
	// 체험수정
	public void expModify(ExpDto dto) throws Exception;
	
	// 체험삭제
	public void expDelete(int expNum) throws Exception;

	// 모든 체험리뷰 리스트
	public List<ExpReplyListDto> allExpReply() throws Exception;
	
	// 체험리뷰 삭제
	public void deleteExpReply(int repNum) throws Exception;
}
