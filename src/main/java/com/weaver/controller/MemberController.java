package com.weaver.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.weaver.dto.MemberDto;
import com.weaver.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	private static final Logger Logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	// 회원 가입 get
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void getSignup() throws Exception {
		Logger.info("get signup");
	}
	
	// 회원 가입 post
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String postSignup(MemberDto dto) throws Exception {
		Logger.info("post signup");
		
		String inputPass = dto.getUserPass();
		String pass = passEncoder.encode(inputPass);
		dto.setUserPass(pass);
		
		service.signup(dto);
		
		return "redirect:/";
	}
	
	// 로그인 get
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public void getSignin() throws Exception {
		Logger.info("get signin");
	}
	
	// 로그인 post
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String postSignin(MemberDto dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		Logger.info("post signin");
		
		MemberDto login = service.signin(dto);
		HttpSession session = req.getSession();
		
		boolean passMatch = passEncoder.matches(dto.getUserPass(), login.getUserPass());

		if(login != null && passMatch) {
			session.setAttribute("member", login);
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/member/signin";
		}
		
		return "redirect:/";
	}
	
	// 로그아웃
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String getSignout(HttpSession session) throws Exception {
		Logger.info("get signout");
		
		service.signout(session);
		
		return "redirect:/";
	}
	
}
