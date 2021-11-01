package com.weaver.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weaver.dto.AddrDto;
import com.weaver.dto.CartDto;
import com.weaver.dto.CartListDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.MemberDto;
import com.weaver.dto.OrderDetailDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyDto;
import com.weaver.dto.ReplyListDto;
import com.weaver.service.ShopService;

@Controller
@RequestMapping("/shop/*")
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
	
	@Inject
	ShopService service;
	
	//카테고리별 상품리스트
	@RequestMapping(value = "/list", method =  RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception{
		logger.info("get levelList");
		
		List<GoodsViewDto> list = null;
		list = service.list(cateCode, level);
		
		model.addAttribute("list", list);
	}
	
	//상품조회
	@RequestMapping(value = "/view", method =  RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception{
		logger.info("get view");
		
		GoodsViewDto view = service.goodsView(gdsNum);
		model.addAttribute("view", view);
		
		/* 소감목록 메서드 따로 생성해서 필요없다
		List<ReplyListDto> reply = service.replyList(gdsNum);
		model.addAttribute("reply", reply);
		*/
	}	
//	상품조회 - 댓글 작성
//	@RequestMapping(value = "/view", method =  RequestMethod.POST)
//	public String registReply(ReplyDto reply, HttpSession session) throws Exception{
//		logger.info("regist reply");
//		
//		MemberDto member = (MemberDto)session.getAttribute("member");
//		reply.setUserId(member.getUserId());
//		
//		service.registReply(reply);
//		
//		return "redirect:/shop/view?n=" + reply.getGdsNum();
//	}	
	//상품 댓글 작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method =  RequestMethod.POST)
	public void registReply(ReplyDto reply, HttpSession session) throws Exception{
		logger.info("regist reply");
		
		MemberDto member = (MemberDto)session.getAttribute("member");
		reply.setUserId(member.getUserId());
		
		service.registReply(reply);
	}		
	// 상품 댓글 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListDto> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("get reply list");
	   
		List<ReplyListDto> reply = service.replyList(gdsNum);
		return reply;
	}
	
	// 상품 댓글 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ReplyDto reply, HttpSession session) throws Exception {
		logger.info("post delete reply");

		int result = 0;
	 
		MemberDto member = (MemberDto)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
	   
		if(member.getUserId().equals(userId)) {
			reply.setUserId(member.getUserId());
			service.deleteReply(reply);
	  
			result = 1;
		}
		return result; 
	}	
	// 상품 댓글 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyDto reply, HttpSession session) throws Exception {
		logger.info("modify reply");
	 
		int result = 0;
	 
		MemberDto member = (MemberDto)session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
	 
		if(member.getUserId().equals(userId)) {
	  
			reply.setUserId(member.getUserId());
			service.modifyReply(reply);
			result = 1;
		}
		return result;
	}
	// 카트 담기
	@ResponseBody
	@RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
	public int addCart(CartDto cart, HttpSession session) throws Exception {
		int result = 0;
		
		MemberDto member = (MemberDto)session.getAttribute("member");
		if(member != null) {
			cart.setUserId(member.getUserId());
			service.addCart(cart);
			result = 1;
		}
		return result;
	}
	// 카트목록
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
		logger.info("get cart list");
	 
		MemberDto member = (MemberDto)session.getAttribute("member");
		String userId = member.getUserId();
	 
		List<CartListDto> cartList = service.cartList(userId);
		model.addAttribute("cartList", cartList);
	}	
	// 카트 삭제
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartDto cart) throws Exception {
		logger.info("delete cart");
	 
		MemberDto member = (MemberDto)session.getAttribute("member");
		String userId = member.getUserId();
	 
		int result = 0;
		int cartNum = 0;
		if(member != null) {
			cart.setUserId(userId);
	  
			for(String i : chArr) {   
				cartNum = Integer.parseInt(i);
				cart.setCartNum(cartNum);
				service.deleteCart(cart);
			}   
			result = 1;
		}  
		return result;  
	}	
	// 주문
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderDto order, OrderDetailDto orderDetail) throws Exception {
		logger.info("order");
	 
		MemberDto member = (MemberDto)session.getAttribute("member");  
		String userId = member.getUserId();
	 
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
	 
		for(int i = 1; i <= 6; i ++) {
			subNum += (int)(Math.random() * 10);
		}
	 
		String orderId = ymd + "_" + subNum;
	 
		order.setOrderId(orderId);
		order.setUserId(userId);
	  
		service.orderInfo(order);
	 
		orderDetail.setOrderId(orderId);   
		service.orderInfo_Details(orderDetail);
	 
		service.cartAllDelete(userId); //주문완료되면 장바구니에 있을 필요가 없으므로 마지막으로 서비스해줌
		return "redirect:/shop/orderList";  
	}
	
	//특정 유저의 주문목록
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, OrderDto order, Model model) throws Exception {
		logger.info("get order list");
	 
		MemberDto member = (MemberDto)session.getAttribute("member");
		String userId = member.getUserId();
	 
		order.setUserId(userId);
	 
		List<OrderDto> orderList = service.orderList(order);
		model.addAttribute("orderList", orderList);
	}
	
	//주문 상세목록
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, @RequestParam("n") String orderId, OrderDto order, Model model) throws Exception {
		logger.info("get order view");
	 
		MemberDto member = (MemberDto)session.getAttribute("member");
		String userId = member.getUserId();
	 
		order.setUserId(userId);
		order.setOrderId(orderId);
	 
		List<OrderListDto> orderView = service.orderView(order);
		model.addAttribute("orderView", orderView);
	}
	
	// 주소검색
	@RequestMapping(value = "/searchAddr", method = RequestMethod.GET)
	public void getSearchAddr() throws Exception {
		logger.info("get searchAddr list");
	}
	
	// 카트 담기
	@RequestMapping(value = "/searchAddr", method = RequestMethod.POST)
	public List<AddrDto> searchAddr(String addr, Model model) throws Exception {
		logger.info("post searchAddr list");
		
		List<AddrDto> list = null;
		list = service.searchAddr(addr);
		
		model.addAttribute("list", list);
		
		return list;
	}	
}
