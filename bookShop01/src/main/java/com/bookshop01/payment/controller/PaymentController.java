package com.bookshop01.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop01.payment.service.PaymentService;

//@controller 와 @RestController는 다르다.

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService ;
	
	
	@RequestMapping(value="/payment/kakao/order.do" )
	public Map<String,String> kakaoOrder(@RequestParam Map<String, String> receiverMap)  
			throws Exception{
		
		Map<String, String> resultMap = new HashMap<String,String>() ;

		// 제대로 들어오는지 확인
		
		// 주문 API를 사용한 다음.
		
		System.out.println( "kakaoOrder 확인") ;
		
		
		paymentService.kakaoOrder(receiverMap) ;
		
		resultMap = paymentService.kakaoOrder(receiverMap) ;
		
				
		return resultMap ;
	}

}
