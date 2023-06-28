package com.bookshop01.payment.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookshop01.payment.service.PaymentService;

//@controller랑 @RestController는 다릅니다.
//RestController json 형태로 데이터가 나간다.
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	// method 옵션을 제거하면 모든 방식을 제공한다, GET, POST
	// receiverMap 은 orderGoodsForm.jsp ajax 에서 넘긴값  data
	@RequestMapping(value="/payment/kakao/order.do" ) // ,method = RequestMethod.POST) 
	public Map<String,String> kakaoOrder(@RequestParam Map<String, String> receiverMap)  throws Exception{
	
		Map<String,String> resultMap = new HashMap<String,String>();
		
		//제대로 들어오는지 확인
		System.out.println("kakaoOrder 확인");
		
		resultMap = paymentService.kakaoOrder(receiverMap);
		/*
		Map<String,String> returnServiceMap  = 	paymentService.kakaoOrder(receiverMap);
		
		
		//결과가 제대로 나가는지 테스트 데이터		
		resultMap.put("test", "test값");
		
		// 화면에 추가될 인자 {good_mny=100, site_cd=A8QOB, Ret_URL=test, affiliaterCode=0005, buyr_name=choi, 
		// ordr_idxx=20230601111756KK0310, good_name=강의테스트_카카오, responseCode=0000, responseMsg=성공}
		resultMap.put("good_mny",returnServiceMap.get("good_mny"));
		resultMap.put("site_cd",returnServiceMap.get("site_cd"));
		resultMap.put("Ret_URL",returnServiceMap.get("Ret_URL"));
		resultMap.put("affiliaterCode",returnServiceMap.get("affiliaterCode"));
		resultMap.put("buyr_name",returnServiceMap.get("buyr_name"));
		resultMap.put("ordr_idxx",returnServiceMap.get("ordr_idxx"));
		resultMap.put("good_name",returnServiceMap.get("good_name"));
		resultMap.put("responseCode",returnServiceMap.get("responseCode"));
		resultMap.put("responseMsg",returnServiceMap.get("responseMsg"));
		*/
		
		return resultMap;
	}
	
	// 카카오결제를 보고 만드는 중
	// method 옵션을 제거하면 모든 방식을 제공한다, GET, POST
	// receiverMap 은 orderGoodsForm.jsp ajax 에서 넘긴값  data
	@RequestMapping(value="/payment/naver_card/order.do" ) // ,method = RequestMethod.POST) 
	public Map<String,String> naverOrder(@RequestParam Map<String, String> receiverMap)  throws Exception{
	
		Map<String,String> resultMap = new HashMap<String,String>();
		
		//제대로 들어오는지 확인
		System.out.println("naverOrder 확인");
		
		receiverMap.put("payType","CARD");
		resultMap = paymentService.naverOrder(receiverMap);
		/*
		Map<String,String> returnServiceMap  = 	paymentService.kakaoOrder(receiverMap);
		
		
		//결과가 제대로 나가는지 테스트 데이터		
		resultMap.put("test", "test값");
		
		// 화면에 추가될 인자 {good_mny=100, site_cd=A8QOB, Ret_URL=test, affiliaterCode=0005, buyr_name=choi, 
		// ordr_idxx=20230601111756KK0310, good_name=강의테스트_카카오, responseCode=0000, responseMsg=성공}
		resultMap.put("good_mny",returnServiceMap.get("good_mny"));
		resultMap.put("site_cd",returnServiceMap.get("site_cd"));
		resultMap.put("Ret_URL",returnServiceMap.get("Ret_URL"));
		resultMap.put("affiliaterCode",returnServiceMap.get("affiliaterCode"));
		resultMap.put("buyr_name",returnServiceMap.get("buyr_name"));
		resultMap.put("ordr_idxx",returnServiceMap.get("ordr_idxx"));
		resultMap.put("good_name",returnServiceMap.get("good_name"));
		resultMap.put("responseCode",returnServiceMap.get("responseCode"));
		resultMap.put("responseMsg",returnServiceMap.get("responseMsg"));
		*/
		
		return resultMap;
	}
	
	// 카카오결제를 보고 만드는 중
		// method 옵션을 제거하면 모든 방식을 제공한다, GET, POST
		// receiverMap 은 orderGoodsForm.jsp ajax 에서 넘긴값  data
		@RequestMapping(value="/payment/naver_point/order.do" ) // ,method = RequestMethod.POST) 
		public Map<String,String> naverPointOrder(@RequestParam Map<String, String> receiverMap)  throws Exception{
		
			Map<String,String> resultMap = new HashMap<String,String>();
			
			//제대로 들어오는지 확인
			System.out.println("naverPointOrder 확인");
			receiverMap.put("payType","POINT");			
			resultMap = paymentService.naverOrder(receiverMap);
			/*
			Map<String,String> returnServiceMap  = 	paymentService.kakaoOrder(receiverMap);
			
			
			//결과가 제대로 나가는지 테스트 데이터		
			resultMap.put("test", "test값");
			
			// 화면에 추가될 인자 {good_mny=100, site_cd=A8QOB, Ret_URL=test, affiliaterCode=0005, buyr_name=choi, 
			// ordr_idxx=20230601111756KK0310, good_name=강의테스트_카카오, responseCode=0000, responseMsg=성공}
			resultMap.put("good_mny",returnServiceMap.get("good_mny"));
			resultMap.put("site_cd",returnServiceMap.get("site_cd"));
			resultMap.put("Ret_URL",returnServiceMap.get("Ret_URL"));
			resultMap.put("affiliaterCode",returnServiceMap.get("affiliaterCode"));
			resultMap.put("buyr_name",returnServiceMap.get("buyr_name"));
			resultMap.put("ordr_idxx",returnServiceMap.get("ordr_idxx"));
			resultMap.put("good_name",returnServiceMap.get("good_name"));
			resultMap.put("responseCode",returnServiceMap.get("responseCode"));
			resultMap.put("responseMsg",returnServiceMap.get("responseMsg"));
			*/
			
			return resultMap;
		}
	
}
