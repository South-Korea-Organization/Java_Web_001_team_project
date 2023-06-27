package com.bookshop01.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.payment.service.PaymentService;

@Controller
public class PaymentController2 {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="/payment/kakao/pay.do")
	public ModelAndView kakaoPay(@RequestParam Map<String,String> receiverMap) throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("인증 데이터 확인 = " + receiverMap.toString());
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		resultMap = paymentService.kakaoPay(receiverMap);
		
		//resultMap 승인 결과 내용이 담겨있습니다
		
		String responseCode = resultMap.get("responseCode");
		//간단하게 승인 됐는지 확인하기 위해 아래 코드 넣음
		//String responseCode = "0000"; 
		
		if("0000".equals(responseCode)) {
			//승인완료
			
			//어떤 페이지로 갈지 설정
			mav.setViewName("/payment/kakaoS");
			
			//결제 성공관련 데이터 하나씩 넣기
			mav.addObject("amount", resultMap.get("amount"));
			mav.addObject("authDateTime", resultMap.get("authDateTime"));
			mav.addObject("type", resultMap.get("type"));
			
			//결과값 통으로 넣기
			//mav.addObject("kakaoData", resultMap);
		} else {
			//승인실패
			mav.setViewName("/payment/kakaoF");
		}
		
		return mav;
	}
	

}
