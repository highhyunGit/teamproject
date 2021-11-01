package com.weaver.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.weaver.dto.AddrDto;
import com.weaver.dto.CartDto;
import com.weaver.dto.CartListDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDetailDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyDto;
import com.weaver.dto.ReplyListDto;

@Repository
public class ShopDaoImpl implements ShopDao{
	@Inject
	private SqlSession sql;
	
	// mapper
	private static String namespace = "com.weaver.mappers.shopMapper";

	//카테고리별 상품 리스트 1차
	@Override
	public List<GoodsViewDto> list(int cateCode, int cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode",cateCode);
		map.put("cateCodeRef",cateCodeRef);
		
		return sql.selectList(namespace + ".list_1", map);
	}
	// 2차분류
	@Override
	public List<GoodsViewDto> list(int cateCode) throws Exception {
		return sql.selectList(namespace + ".list_2", cateCode);
	}
	//상품조회
	@Override
	public GoodsViewDto goodsView(int gdsNum) throws Exception {
		return sql.selectOne("com.weaver.mappers.adminMapper.goodsView", gdsNum);
	}
	//상품 댓글 작성
	@Override
	public void registReply(ReplyDto reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}
	//상품 댓글 리스트
	@Override
	public List<ReplyListDto> replyList(int gdsNum) throws Exception {
		return sql.selectList(namespace + ".replyList", gdsNum);
	}
	//상품 댓글 삭제
	@Override
	public void deleteReply(ReplyDto reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}
	//아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}
	//상품 댓글 수정
	@Override
	public void modifyReply(ReplyDto reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}
	//카트 담기
	@Override
	public void addCart(CartDto cart) throws Exception {
		sql.insert(namespace + ".addCart", cart);
	}
	// 카트 리스트
	@Override
	public List<CartListDto> cartList(String userId) throws Exception {
		return sql.selectList(namespace + ".cartList", userId);
	}	
	// 카트 삭제
	@Override
	public void deleteCart(CartDto cart) throws Exception {
		sql.delete(namespace + ".deleteCart", cart);
	}
	//주문 정보
	@Override
	public void orderInfo(OrderDto order) throws Exception {
		sql.insert(namespace + ".orderInfo", order);
	}
	//주문 상세정보
	@Override
	public void orderInfo_Details(OrderDetailDto orderDetail) throws Exception {
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
	}
	//카트 비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace + ".cartAllDelete", userId);
	}
	//주문 목록
	@Override
	public List<OrderDto> orderList(OrderDto order) throws Exception {
		return sql.selectList(namespace + ".orderList", order);
	}
	//주문 목록(특정)
	@Override
	public List<OrderListDto> orderView(OrderDto order) throws Exception {
		return sql.selectList(namespace + ".orderView", order);
	}
	
	// 주소검색
	@Override
	public List<AddrDto> searchAddr(String addr) throws Exception {
		return sql.selectList(namespace + ".searchAddr", addr);
	}

}
