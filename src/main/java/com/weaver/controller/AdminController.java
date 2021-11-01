package com.weaver.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.weaver.dto.CategoryDto;
import com.weaver.dto.ExpDto;
import com.weaver.dto.ExpReplyDto;
import com.weaver.dto.ExpReplyListDto;
import com.weaver.dto.GoodsDto;
import com.weaver.dto.GoodsViewDto;
import com.weaver.dto.OrderDto;
import com.weaver.dto.OrderListDto;
import com.weaver.dto.ReplyDto;
import com.weaver.dto.ReplyListDto;
import com.weaver.service.AdminService;
import com.weaver.utils.UploadFileUtils;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Inject
	AdminService adminService;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	//관리자화면
	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public void getIndex() throws Exception{
		logger.info("get index");
	}
	
	//상품등록(카테고리)
	@RequestMapping(value = "/goods/register", method=RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("get goods register");
		
		List<CategoryDto> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}

	//상품등록
	@RequestMapping(value = "/goods/register", method=RequestMethod.POST)
	public String postGoodsRegister(GoodsDto dto, MultipartFile file) throws Exception {
		 String imgUploadPath = uploadPath + File.separator + "imgUpload";  // 이미지를 업로드할 폴더를 설정 = /uploadPath/imgUpload
		 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);  // 위의 폴더를 기준으로 연월일 폴더를 생성
		 String fileName = null;  // 기본 경로와 별개로 작성되는 경로 + 파일이름
		   
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			 // 파일 인풋박스에 첨부된 파일이 없다면(=첨부된 파일이 이름이 없다면)
			 fileName =  UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);

			 // gdsImg에 원본 파일 경로 + 파일명 저장
			 dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			 // gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
			 dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		 } else {  // 첨부된 파일이 없으면
			 fileName = File.separator + "images" + File.separator + "none.png";
			 // 미리 준비된 none.png파일을 대신 출력함
		  		dto.setGdsImg(fileName);
		  		dto.setGdsThumbImg(fileName);
		 }
		      
		 adminService.register(dto);
		 
		 return "redirect:/admin/index";
	}
	
	//상품목록 리스트
	@RequestMapping(value = "/goods/list", method=RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception{
		logger.info("get goods list");
//		List<GoodsDto> list = adminService.goodsList();
		List<GoodsViewDto> list = adminService.goodsList();
		model.addAttribute("list", list);
	}
	//상품 상세보기(조회)
	@RequestMapping(value = "/goods/view", method=RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model) throws Exception{ //url에서 "n"의 값을 찾아서 int gdsNum에 전달
		logger.info("get goods view");
//		GoodsDto goods = adminService.goodsView(gdsNum);
		GoodsViewDto goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
	}
	//상품 수정(카테고리 가져오기)
	@RequestMapping(value = "/goods/modify", method=RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception{ 
		logger.info("get goods modify");
//		GoodsDto goods = adminService.goodsView(gdsNum);
		GoodsViewDto goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryDto> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
	}
	//상품 수정
	@RequestMapping(value = "/goods/modify", method=RequestMethod.POST)
	public String postGoodsModify(GoodsDto dto, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("post goods modify");
		
		 // 새로운 파일이 등록되었는지 확인
		 if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
		 // 기존 파일을 삭제
			 new File(uploadPath + req.getParameter("gdsImg")).delete();
			 new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
		  
			 // 새로 첨부한 파일을 등록
			 String imgUploadPath = uploadPath + File.separator + "imgUpload";
			 String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			 String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		  
			 dto.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			 dto.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		  
		} else {  // 새로운 파일이 등록되지 않았다면
		  // 기존 이미지를 그대로 사용
		  dto.setGdsImg(req.getParameter("gdsImg"));
		  dto.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		 
		adminService.goodsModify(dto);
		return "redirect:/admin/index";
	}
	//상품 삭제
	@RequestMapping(value = "/goods/delete", method=RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("post goods delete");
		adminService.goodsDelete(gdsNum);
		return "redirect:/admin/index";
	}
	// ck 에디터에서 파일 업로드
	@RequestMapping(value = "/goods/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
	 logger.info("post CKEditor img upload");
	 
	 // 랜덤 문자 생성
	 UUID uid = UUID.randomUUID();
	 
	 OutputStream out = null;
	 PrintWriter printWriter = null;
	   
	 // 인코딩
	 res.setCharacterEncoding("utf-8");
	 res.setContentType("text/html;charset=utf-8");
	 
	 try {
		 String fileName = upload.getOriginalFilename(); //파일 이름 가져오기
		 byte[] bytes = upload.getBytes();
	  
		 // 업로드 경로
		 String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
	  
		 out = new FileOutputStream(new File(ckUploadPath));
		 out.write(bytes);
		 out.flush(); //out에 저장된 데이터를 전송하고 초기화
	  
		 String callback = req.getParameter("CKEditorFuncNum");
		 printWriter = res.getWriter();
		 String fileUrl = "/resources/ckUpload/" + uid + "_" + fileName; //작성화면
	  
		 // 업로드시 메시지 출력
		 printWriter.println("{\"filename\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
	  
		 printWriter.flush();
	  
	 } catch (IOException e) { e.printStackTrace();
	 } finally {
		 	try {
		 		if(out != null) { out.close(); }
		 		if(printWriter != null) { printWriter.close(); }
		 	} catch(IOException e) { e.printStackTrace(); }
	 }
	 return; 
	}	
	// 주문 목록
	@RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		logger.info("get order list");
	   
		List<OrderDto> orderList = adminService.orderList();
		model.addAttribute("orderList", orderList);
	}

	// 주문 상세 목록
	@RequestMapping(value = "/shop/orderView", method = RequestMethod.GET)
	public void getOrderList(@RequestParam("n") String orderId, OrderDto order, Model model) throws Exception {
		logger.info("get order view");
		
		order.setOrderId(orderId);		
		List<OrderListDto> orderView = adminService.orderView(order);
		model.addAttribute("orderView", orderView);
	}
	// 주문 상세 목록 - 상태 변경
	@RequestMapping(value = "/shop/orderView", method = RequestMethod.POST)
	public String delivery(OrderDto order) throws Exception {
		logger.info("post order view");
		adminService.delivery(order);
		
		//상품수량조절
		List<OrderListDto> orderView = adminService.orderView(order); 
		GoodsDto goods = new GoodsDto();

		for(OrderListDto i : orderView) {
			goods.setGdsNum(i.getGdsNum());
			goods.setGdsStock(i.getCartStock());
			adminService.changeStock(goods);
		}
		return "redirect:/admin/shop/orderView?n=" + order.getOrderId();
	}	
	// 모든 댓글 보기
	@RequestMapping(value = "/shop/allReply", method = RequestMethod.GET)
	public void getAllReply(Model model) throws Exception {
		logger.info("get all reply");
	   
		List<ReplyListDto> reply = adminService.allReply();
		model.addAttribute("reply", reply);
	}
	//댓글 삭제
	@RequestMapping(value = "/shop/allReply", method = RequestMethod.POST)
	public String postAllReply(ReplyDto reply) throws Exception {
		logger.info("post all reply");
				
		adminService.deleteReply(reply.getRepNum());
		
		return "redirect:/admin/shop/allReply";
	}
	// 체험등록 get
	@RequestMapping(value = "/exp/register", method = RequestMethod.GET)
	public void getExpRegister(ExpDto dto) throws Exception {
		logger.info("get exp register");
	}
	
	// 체험등록 post
	@RequestMapping(value = "/exp/register", method = RequestMethod.POST)
	public String postExpRegister(ExpDto dto, MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			dto.setExpImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			dto.setExpThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		} else {
			fileName = File.separator + "images" + File.separator + "none.png";
			
			dto.setExpImg(fileName);
			dto.setExpThumbImg(fileName);
		}
		adminService.expRegister(dto);
		
		return "redirect:/admin/index";
	}
	
	// 체험목록 get
	@RequestMapping(value = "/exp/list", method = RequestMethod.GET)
	public void getExpList(Model model) throws Exception {
		logger.info("get exp list");
		
		List<ExpDto> list = adminService.expList();
		
		model.addAttribute("list", list);
	}
	
	// 체험조회 get
	@RequestMapping(value = "/exp/view", method = RequestMethod.GET)
	public void getExpView(@RequestParam("n") int expNum, Model model) throws Exception {
		logger.info("get exp view");
		
		ExpDto dto = adminService.expView(expNum);
		
		model.addAttribute("dto", dto);
	}
	
	// 체험수정 get
	@RequestMapping(value = "/exp/modify", method = RequestMethod.GET)
	public void getExpModify(@RequestParam("n") int expNum, Model model) throws Exception {
		logger.info("get exp modify");
		
		ExpDto dto = adminService.expView(expNum);
		model.addAttribute("dto", dto);
	}
	
	// 체험수정 post
	@RequestMapping(value = "/exp/modify", method = RequestMethod.POST)
	public String postExpModify(ExpDto dto, MultipartFile file, HttpServletRequest request) throws Exception {
		logger.info("post exp modify");
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			// 기존 업로드 파일을 삭제.
			new File(uploadPath + request.getParameter("expImg")).delete();
			new File(uploadPath + request.getParameter("expThumbImg")).delete();
			
			// 새로 첨부한 파일 등록.
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			dto.setExpImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			dto.setExpThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		} else {
			dto.setExpImg(request.getParameter("expImg"));
			dto.setExpThumbImg(request.getParameter("expThumbImg"));
		}
		
		adminService.expModify(dto);
		
		return "redirect:/admin/index";
	}
	
	// 체험삭제 post
	@RequestMapping(value = "/exp/delete", method = RequestMethod.POST)
	public String postExpDelete(@RequestParam("n") int expNum) throws Exception {
		logger.info("post exp delete");
		
		adminService.expDelete(expNum);
		
		return "redirect:/admin/index";
	}
	// 모든 댓글 보기
	@RequestMapping(value = "/exp/allReply", method = RequestMethod.GET)
	public void getAllExpReply(Model model) throws Exception {
		logger.info("get exp all reply");
	   
		List<ExpReplyListDto> reply = adminService.allExpReply();
		model.addAttribute("reply", reply);
	}
	//댓글 삭제
	@RequestMapping(value = "/exp/allReply", method = RequestMethod.POST)
	public String postAllExpReply(ExpReplyDto reply) throws Exception {
		logger.info("post exp all reply");
				
		adminService.deleteExpReply(reply.getRepNum());
		
		return "redirect:/admin/exp/allReply";
	}
}
