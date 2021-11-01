package com.weaver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.weaver.dao.ShopDao;
import com.weaver.dto.AddrDto;
import com.weaver.dto.CartDto;
import com.weaver.dto.CartListDto;
import com.weaver.dto.ExpReplyListDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDetailDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyDto;
import com.weaver.dto.ReplyListDto;

@Service
public class ShopServiceImpl implements ShopService {

	@Inject
	private ShopDao dao;
	
	//카테고리별 상품리스트
	@Override
	public List<GoodsViewDto> list(int cateCode, int level) throws Exception {
		int cateCodeRef = 0;
		
		if(level == 1) { //1차분류, 우리는 1차분류만 있음
			cateCodeRef = cateCode;
			return dao.list(cateCode, cateCodeRef);
		} else { //2차분류
			return dao.list(cateCode);
		}
	}
	
	//상품 조회
	@Override
	public GoodsViewDto goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	
	// 상품 댓글 작성
	@Override
	public void registReply(ReplyDto reply) throws Exception {
		dao.registReply(reply);
	}
	
	//상품 댓글 리스트
	@Override
	public List<ReplyListDto> replyList(int gdsNum) throws Exception {
		return dao.replyList(gdsNum);
	}
	
	//상품 댓글 삭제
	@Override
	public void deleteReply(ReplyDto reply) throws Exception {
		dao.deleteReply(reply);
	}
	
	//아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return dao.idCheck(repNum);
	}
	
	//상품 댓글 수정
	@Override
	public void modifyReply(ReplyDto reply) throws Exception {
		dao.modifyReply(reply);
	}
	
	//카트 담기
	@Override
	public void addCart(CartDto cart) throws Exception {
		dao.addCart(cart);
	}
	
	//카트 리스트
	@Override
	public List<CartListDto> cartList(String userId) throws Exception {
		return dao.cartList(userId);
	}
	
	//카트 삭제
	@Override
	public void deleteCart(CartDto cart) throws Exception {
		dao.deleteCart(cart);
	}
	
	//주문 정보
	@Override
	public void orderInfo(OrderDto order) throws Exception {
		dao.orderInfo(order);
	}
	
	//주문 상세정보
	@Override
	public void orderInfo_Details(OrderDetailDto orderDetail) throws Exception {
		dao.orderInfo_Details(orderDetail);
	}
	
	//카트비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		dao.cartAllDelete(userId);
	}
	
	//주문 목록
	@Override
	public List<OrderDto> orderList(OrderDto order) throws Exception {
		return dao.orderList(order);
	}
	
	//주문 목록(특정)
	@Override
	public List<OrderListDto> orderView(OrderDto order) throws Exception {
		return dao.orderView(order);
	}
	
	@Override
	public List<AddrDto> searchAddr(String addr) throws Exception {
		return dao.searchAddr(addr);
	}
	
}
