package com.weaver.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.weaver.dto.CategoryDto;
import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyListDto;
import com.weaver.dto.GoodsDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyListDto;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Inject
	private SqlSession sql;
	
	// 매퍼
	private static String namespace = "com.weaver.mappers.adminMapper";
	
	//카테고리
	@Override
	public List<CategoryDto> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}
	//상품등록
	@Override
	public void register(GoodsDto dto) throws Exception {
		sql.insert(namespace + ".register", dto);
	}
//	상품목록
//	@Override
//	public List<GoodsDto> goodsList() throws Exception {
//		return sql.selectList(namespace + ".goodsList");
//	}
	//상품목록
	@Override
	public List<GoodsViewDto> goodsList() throws Exception {
		return sql.selectList(namespace + ".goodsList");
	}
//		상품조회
//	@Override
//	public GoodsDto goodsView(int gdsNum) throws Exception {
//		return sql.selectOne(namespace + ".goodsView", gdsNum);
//	}
	//상품조회 + 카테고리 조인
	@Override
	public GoodsViewDto goodsView(int gdsNum) throws Exception {
		return sql.selectOne(namespace + ".goodsView", gdsNum);
	}
	//상품수정
	@Override
	public void goodsModify(GoodsDto dto) throws Exception {
		sql.update(namespace + ".goodsModify", dto);
	}
	//상품 삭제
	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		sql.delete(namespace + ".goodsDelete", gdsNum);
	}
	//주문 목록
	@Override
	public List<OrderDto> orderList() throws Exception {
		return sql.selectList(namespace + ".orderList");
	}
	//특정 주문 목록
	@Override
	public List<OrderListDto> orderView(OrderDto order) throws Exception {
		return sql.selectList(namespace + ".orderView", order);
	}
	// 배송 상태
	@Override
	public void delivery(OrderDto order) throws Exception {
		sql.update(namespace + ".delivery", order);
	}
	// 상품 수량 조절
	@Override
	public void changeStock(GoodsDto goods) throws Exception {		
		sql.update(namespace + ".changeStock", goods);
	}
	// 모든 소감(댓글)
	@Override
	public List<ReplyListDto> allReply() throws Exception {
		return sql.selectList(namespace + ".allReply");
	}
	// 소감(댓글) 삭제
	@Override
	public void deleteReply(int repNum) throws Exception {
		sql.delete(namespace + ".deleteReply", repNum);
	}	
	// 체험등록
	@Override
	public void expRegister(ExpDto dto) throws Exception {
		sql.insert(namespace + ".expRegister", dto);
	}
	
	// 체험목록
	@Override
	public List<ExpDto> expList() throws Exception {
		return sql.selectList(namespace + ".expList");
	}
	
	// 체험조회
	@Override
	public ExpDto expView(int expNum) throws Exception {
		return sql.selectOne(namespace + ".expView", expNum);
	}
	
	// 체험수정
	@Override
	public void expModify(ExpDto dto) throws Exception {
		sql.update(namespace + ".expModify", dto);
	}
	
	// 체험삭제
	@Override
	public void expDelete(int expNum) throws Exception {
		sql.delete(namespace + ".expDelete", expNum);
	}
	
	// 모든 체험리뷰 리스트
	@Override
	public List<ExpReplyListDto> allExpReply() throws Exception {
		return sql.selectList(namespace + ".allExpReply");
	}
	
	// 체험리뷰 삭제
	@Override
	public void deleteExpReply(int repNum) throws Exception {
		sql.delete(namespace + ".deleteExpReply", repNum);
	}
	
}
