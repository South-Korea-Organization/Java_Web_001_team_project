package com.bookshop01.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop01.payment.service.PaymentService;


//@controller랑 @RestController는 다릅니다.
@RestController 
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value="/payment/kakao/order.do")
	public Map<String,String> kakaoOrder(@RequestParam Map<String, String> receiverMap)  throws Exception{
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		//제대로 들어오는지 확인
		System.out.println("kakaoOrder 확인");
		
		//주문 API를 쏜다음에
		
		//결과 제대로 나가는지 테스트 데이터
		
		resultMap = paymentService.kakaoOrder(receiverMap);
		/* resultMap.put("test","test값");  아웃풋 확인*/
		
		return resultMap;
	}
}
