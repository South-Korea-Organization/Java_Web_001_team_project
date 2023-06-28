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
	
	// orderGoodsForm.jsp 에서 function m_Completepayment(FormOrJson, closeEvent) 함수에서 호출된 값
	// METHOD 가 없는 경우 모두 허용 GET/ POST
	@RequestMapping(value="/payment/kakao/pay.do")
	public ModelAndView kakaoPay(@RequestParam Map<String, String> receiverMap)  throws Exception{
		
		
		ModelAndView mav = new ModelAndView();	
				
		System.out.println("인증 데이터 확인 = " + receiverMap.toString());
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		resultMap = paymentService.kakaoPay(receiverMap);  //테스트를 위해 주석처리 (카카오 결재)	
		
		//resultMap 승인 결과 내용이 담겨있습니다.
		
		String responseCode = resultMap.get("responseCode");   //테스트를 위해 주석처리( 카카오 결제)
		
		
		if("0000".equals(responseCode)) 
		{
			//승인완료
			//어떤 페이지로 갈지 설정
			mav.setViewName("/payment/kakaoS");		
			
			//결제성공 결과과 낱개로 넣기
		//	mav.addObject("amount",resultMap.get("amount"));
		//	mav.addAllObjects("authDate",resultMap.get("amount"));
			
			
			//결과값 통으로 넣기
			mav.addObject("kakaoData",resultMap);
		
		}
		else
		{
			//승인실패
			mav.setViewName("/payment/kakaoF");
		}
		
		return mav;
	}
	
	// 네이버 카드 결제
	// orderGoodsForm.jsp 에서 function m_Completepayment(FormOrJson, closeEvent) 함수에서 호출된 값
	// METHOD 가 없는 경우 모두 허용 GET/ POST
	@RequestMapping(value="/payment/naver_card/pay.do")
	public ModelAndView naverCardPay(@RequestParam Map<String, String> receiverMap)  throws Exception{
		
		
		ModelAndView mav = new ModelAndView();	
				
		System.out.println("인증 데이터 확인 = " + receiverMap.toString());
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		resultMap = paymentService.naverPay(receiverMap);  //테스트를 위해 주석처리 (네이버 결재)	
		
		//resultMap 승인 결과 내용이 담겨있습니다.
		
		String responseCode = resultMap.get("responseCode");   //테스트를 위해 주석처리( 네이버 결제)
		
		
		if("0000".equals(responseCode)) 
		{
			//승인완료
			//어떤 페이지로 갈지 설정
			mav.setViewName("/payment/naverS");		
			
			//결제성공 결과과 낱개로 넣기
		//	mav.addObject("amount",resultMap.get("amount"));
		//	mav.addAllObjects("authDate",resultMap.get("amount"));
			
			
			//결과값 통으로 넣기
			mav.addObject("naverData",resultMap);
		
		}
		else
		{
			//승인실패
			mav.setViewName("/payment/naverF");
		}
		
		return mav;
	}
	
	// 네이버 포인트 결제
	// orderGoodsForm.jsp 에서 function m_Completepayment(FormOrJson, closeEvent) 함수에서 호출된 값
	// METHOD 가 없는 경우 모두 허용 GET/ POST
	@RequestMapping(value="/payment/naver_point/pay.do")
	public ModelAndView naverPointPay(@RequestParam Map<String, String> receiverMap)  throws Exception{
		
		
		ModelAndView mav = new ModelAndView();	
				
		System.out.println("인증 데이터 확인 = " + receiverMap.toString());
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		resultMap = paymentService.naverPay(receiverMap);  //테스트를 위해 주석처리 (네이버 결재)	
		
		//resultMap 승인 결과 내용이 담겨있습니다.
		
		String responseCode = resultMap.get("responseCode");   //테스트를 위해 주석처리( 네이버 결제)
		
		
		if("0000".equals(responseCode)) 
		{
			//승인완료
			//어떤 페이지로 갈지 설정
			mav.setViewName("/payment/naverS");		
			
			//결제성공 결과과 낱개로 넣기
		//	mav.addObject("amount",resultMap.get("amount"));
		//	mav.addAllObjects("authDate",resultMap.get("amount"));
			
			
			//결과값 통으로 넣기
			mav.addObject("naverData",resultMap);
		
		}
		else
		{
			//승인실패
			mav.setViewName("/payment/naverF");
		}
		
		return mav;
	}
}
