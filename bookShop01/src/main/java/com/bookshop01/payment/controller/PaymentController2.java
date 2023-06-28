package com.bookshop01.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.payment.service.PaymentService;


//@controller랑 @RestController는 다릅니다.
@RestController 
public class PaymentController2 {
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="/payment/kakao/pay.do")
	public ModelAndView kakaoPay(@RequestParam Map<String, String> receiverMap)  throws Exception{
		
		ModelAndView mav = new ModelAndView();
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		resultMap = paymentService.kakaoPay(receiverMap);
		
		//resultMap 승인 결과 내용이 담겨있음.
		
		String responseCode = resultMap.get("responseCode");
	
		if ("0000".equals(responseCode)) {
			
			mav.setViewName("/payment/kakaoS");//tiles 설정으로 간다.
			
			//결제 성공 관련 데이터 넣어서
			mav.addObject("amount",resultMap.get("amount"));
			mav.addObject("authDateTime",resultMap.get("authDateTime"));

		} else {
			mav.setViewName("/payment/kakaoF");
		}
		
		//제대로 들어오는지 확인
		System.out.println("인증 데이터 확인" + receiverMap.toString());

		
		return mav;
	}
}
