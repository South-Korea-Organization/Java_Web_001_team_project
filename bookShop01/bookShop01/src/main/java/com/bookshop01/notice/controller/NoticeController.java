package com.bookshop01.notice.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.goods.vo.GoodsVO;
import com.bookshop01.notice.service.NoticeService;
import com.bookshop01.notice.vo.NoticeVO;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
private static final Logger Logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Inject
	NoticeService noticeservice;
	
	@RequestMapping(value= "/nlist.do" ,method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView nlist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav=new ModelAndView();
		String viewName=(String)request.getAttribute("viewName");
		mav.setViewName(viewName);

		return mav;
	}
	
	
	
	//글 작성 get
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public void getWrite() throws Exception{
		Logger.info("get write");
	}
	
	//글 작성 post
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String postWrite(NoticeVO vo) throws Exception{
		Logger.info("get write");
		
		noticeservice.write(vo);
		
		return "redirect:/";
	}
	
	

}
