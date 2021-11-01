package com.weaver.dao;

import java.util.List;

import com.weaver.dto.AddrDto;
import com.weaver.dto.CartDto;
import com.weaver.dto.CartListDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDetailDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyDto;
import com.weaver.dto.ReplyListDto;

public interface ShopDao {
	// 카테고리별 상품 리스트 1차분류
	public List<GoodsViewDto> list(int cateCode, int cateCodeRef) throws Exception;
	// 카테고리별 상품 리스트 2차분류
	public List<GoodsViewDto> list(int cateCode) throws Exception;
	// 상품 조회
	public GoodsViewDto goodsView(int gdsNum) throws Exception;
	// 상품 후기 작성
	public void registReply(ReplyDto reply) throws Exception;
	// 상품 댓글 리스트
	public List<ReplyListDto> replyList(int gdsNum) throws Exception;
	// 상품 댓글 삭제
	public void deleteReply(ReplyDto reply) throws Exception;
	// 아이디 체크(작성한 사람과 접속한 사람)
	public String idCheck(int repNum) throws Exception;
	// 상품 댓글 수정
	public void modifyReply(ReplyDto reply) throws Exception;
	// 카트 담기
	public void addCart(CartDto cart) throws Exception;
	// 카트 리스트
	public List<CartListDto> cartList(String userId) throws Exception;
	// 카트 삭제
	public void deleteCart(CartDto cart) throws Exception;
	// 주문 정보
	public void orderInfo(OrderDto order) throws Exception;
	// 주문 상세정보
	public void orderInfo_Details(OrderDetailDto orderDetail) throws Exception;
	// 카트 비우기
	public void cartAllDelete(String userId) throws Exception;
	// 주문 목록
	public List<OrderDto> orderList(OrderDto order) throws Exception;
	// 주문목록(특정)
	public List<OrderListDto> orderView(OrderDto order) throws Exception;
	
	// 주소검색
	public List<AddrDto> searchAddr(String addr) throws Exception;
}
