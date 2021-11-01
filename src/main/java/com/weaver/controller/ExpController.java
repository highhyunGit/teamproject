package com.weaver.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyDto;
import com.weaver.dto.ExpReplyListDto;
import com.weaver.dto.MemberDto;
import com.weaver.service.ExpService;

@Controller
@RequestMapping("/exp/*")
public class ExpController {

	private static final Logger logger = LoggerFactory.getLogger(ExpController.class);
	
	@Inject
	ExpService service;
	
	// 체험목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		logger.info("get list");
		
		List<ExpDto> list = null;
		list = service.expList();
		
		model.addAttribute("list", list);
	}
	
	// 체험조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int expNum, Model model) throws Exception {
		logger.info("get view");
		
		ExpDto view = service.expView(expNum);
		model.addAttribute("view", view);
		
//		List<ExpReplyListDto> reply = service.replyList(expNum);
//		model.addAttribute("reply", reply);
	}
	
	// 체험조회 - 리뷰작성
//	@RequestMapping(value = "/view", method = RequestMethod.POST)
//	public String registReply(ExpReplyDto reply, HttpSession session) throws Exception {
//		logger.info("regist reply");
//		
//		MemberDto member = (MemberDto) session.getAttribute("member");
//		reply.setUserId(member.getUserId());
//		
//		service.registReply(reply);
//		
//		return "redirect:/exp/view?n=" + reply.getExpNum();
//	}
	
	// 체험리뷰 작성
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ExpReplyDto reply,  HttpSession session) throws Exception {
		logger.info("regist reply");
		
		MemberDto member = (MemberDto)session.getAttribute("member");
		reply.setUserId(member.getUserId());
		
		service.registReply(reply);
	} 	
	
	// 체험리뷰 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ExpReplyListDto> getReplyList(@RequestParam("n") int expNum) throws Exception {
		logger.info("get reply list");
		
		List<ExpReplyListDto> reply = service.replyList(expNum);
		
		return reply;
	}
	
	// 체험리뷰 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int getReplyList(ExpReplyDto reply,  HttpSession session) throws Exception {
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
	
	// 체험리뷰 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ExpReplyDto reply, HttpSession session) throws Exception {
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
}
