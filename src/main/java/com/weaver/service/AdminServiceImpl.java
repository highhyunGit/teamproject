package com.weaver.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.weaver.dao.AdminDao;
import com.weaver.dto.CategoryDto;
import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyListDto;
import com.weaver.dto.GoodsDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyListDto;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Inject
	private AdminDao dao;

	//카테고리
	@Override
	public List<CategoryDto> category() throws Exception {
		return dao.category();
	}
	//상품등록
	@Override
	public void register(GoodsDto dto) throws Exception {
		dao.register(dto);
	}
//	상품목록
//	@Override
//	public List<GoodsDto> goodsList() throws Exception {
//		System.out.println("리스트 서비스");
//		return dao.goodsList();
//	}
	//상품목록
	@Override
	public List<GoodsViewDto> goodsList() throws Exception {
		System.out.println("리스트 서비스");
		return dao.goodsList();
	}	
//	상품조회
//	@Override
//	public GoodsDto goodsView(int gdsNum) throws Exception {
//		return dao.goodsView(gdsNum);
//	}
	//상품조회 + 카테고리 조인
	@Override
	public GoodsViewDto goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}
	//상품수정
	@Override
	public void goodsModify(GoodsDto dto) throws Exception {
		dao.goodsModify(dto);
	}
	//상품삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
	}
	//주문목록
	@Override
	public List<OrderDto> orderList() throws Exception {
		return dao.orderList();
	}
	//특정주문목록
	@Override
	public List<OrderListDto> orderView(OrderDto order) throws Exception {
		return dao.orderView(order);
	}
	// 배송 상태
	@Override
	public void delivery(OrderDto order) throws Exception {
		dao.delivery(order);
	}
	// 상품 수량 조절
	@Override
	public void changeStock(GoodsDto goods) throws Exception {		
		dao.changeStock(goods);
	}
	//모든 댓
	@Override
	public List<ReplyListDto> allReply() throws Exception {
		return dao.allReply();
	}
	//댓글 삭제
	@Override
	public void deleteReply(int repNum) throws Exception {
		dao.deleteReply(repNum);
	}
	
	// 체험등록
	@Override
	public void expRegister(ExpDto dto) throws Exception {
		dao.expRegister(dto);
	}
	
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

	// 체험수정
	@Override
	public void expModify(ExpDto dto) throws Exception {
		dao.expModify(dto);
	}
	
	// 체험삭제
	@Override
	public void expDelete(int expNum) throws Exception {
		dao.expDelete(expNum);
	}
	
	// 모든 체험리뷰 리스트 
	@Override
	public List<ExpReplyListDto> allExpReply() throws Exception {
		return dao.allExpReply();
	}
	
	// 체험리뷰 삭제
	@Override
	public void deleteExpReply(int repNum) throws Exception {
		dao.deleteExpReply(repNum);
	}
}
