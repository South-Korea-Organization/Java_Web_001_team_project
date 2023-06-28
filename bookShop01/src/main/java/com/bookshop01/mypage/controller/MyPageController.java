package com.bookshop01.mypage.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface MyPageController {
	public ModelAndView myPageMain(@RequestParam(required = false,value="message")  String message,HttpServletRequest request, HttpServletResponse response)  throws Exception ;
	public ModelAndView myOrderDetail(@RequestParam("order_id")  String order_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView cancelMyOrder(@RequestParam("order_id")  String order_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView listMyOrderHistory(@RequestParam Map<String, String> dateMap,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ModelAndView myDetailInfo(HttpServletRequest request, HttpServletResponse response)  throws Exception;
	public ResponseEntity modifyMyInfo(@RequestParam("attribute")  String attribute,
					            @RequestParam("value")  String value,
					            HttpServletRequest request, HttpServletResponse response)  throws Exception;
	// 마이페이지 추가
	public ModelAndView delMember(@RequestParam(required = false,value="message")  String message,HttpServletRequest request, HttpServletResponse response)  throws Exception ;
	
	// 2023.6.19 by Dean
	public ModelAndView listChangeMyOrderStatus(@RequestParam(required = false,value="message")  String message ,HttpServletRequest request, HttpServletResponse response)  throws Exception;
	// 2023.6.19 by Dean  
	public ModelAndView exchangeMyOrder(@RequestParam("order_id")  String order_id,HttpServletRequest request, HttpServletResponse response)  throws Exception;

}
