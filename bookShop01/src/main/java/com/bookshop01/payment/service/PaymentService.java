package com.bookshop01.payment.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop01.api.service.ApiService;

// 카드 결제 서비스 추가
//@Service 현재 페이지가 Service 페이지다라는 것을 spring에게 알려줘야 한다.
@Service
public class PaymentService 
{
	@Autowired
	private ApiService apiService;
	
	
	public Map<String,String> keyin(Map<String,String> receiverMap)
	{
		Map<String,String> resultMap = new HashMap<String, String>();
		
		//Ctl+Shipt+O 자동완성
		
		//API 연동 소스 작성 미정
		//rest api 연동으 할 예정 
		//라이브러리 사용하면 연동
		//OkHttp3.10 버전 라이브러리 사용   구글검색
	    	
		// 카드 결제 주문시 필요한 인자 선언
		String orderNumber = "";
		String cardNo = "";
		String expireMonth = "";
		String expireYear = "";
		String birthday = "";
		String cardPw = "";
		String amount = "";
		String quota = "";
		String itemName = "";
		String userName = "";
		String signature = "";
		String timestamp = "";
		String certKey = "ac805b30517f4fd08e3e80490e559f8e";
		
		// 보내야되는 값 세팅 예정
		orderNumber = "TEST1234";
		cardNo =  receiverMap.get("cardNo");
		expireMonth = receiverMap.get("expireMonth");
		expireYear = receiverMap.get("expireYear");
		birthday = receiverMap.get("birthday");
		cardPw = receiverMap.get("cardPw");
		amount = "1000";
		quota = "0";
		itemName = "TEST아이템";
		userName = "테스터";		
		timestamp = "20230531121110";
		
		try {
			// 암호화해서 생성해야 함.
			signature = encrypt("himedia|"+orderNumber+"|"+amount+"|"+certKey+"|"+timestamp);			
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		
		
		//paramMap은 요청값들이 담김 맵
		Map<String,String> paramMap = new HashMap<String,String>();
		//요청 주소
		// 개발용 주문 api.
		String url = "https://api.testpayup.co.kr/v2/api/payment/himedia/keyin2";
		
		// 보내야되는 값 셋팅 예정	
		paramMap.put("orderNumber",orderNumber);
		paramMap.put("cardNo",cardNo);
		paramMap.put("expireMonth",expireMonth);
		paramMap.put("expireYear",expireYear);
		paramMap.put("birthday",birthday);
		paramMap.put("cardPw",cardPw);
		paramMap.put("amount",amount);
		paramMap.put("quota",quota);
		paramMap.put("itemName",itemName);
		paramMap.put("userName",userName);
		paramMap.put("signature",signature);
		paramMap.put("timestamp",timestamp);
		
		resultMap = apiService.restApi(paramMap, url); 
		
		//연동 결과
		System.out.println("결제 승인 API 통신 결과 = " + resultMap.toString() );
		
		return resultMap;
	}
		
	//카카오 주문 하는 기능
	public Map<String,String> kakaoOrder(Map<String,String> receiverMap){
		
		Map<String,String> resultMap = new HashMap<String, String>();
		
		
		//API 통신
		//카카오 3.1 주문요청
		
		//요청 데이터 설정
		String orderNumber = "";
		String userAgent = "";
		String amount = "";
		String itemName = "";
		String userName = "";
		String returnUrl = "";
		String signature = "";
		String timestamp = "";
		String certKey = "ac805b30517f4fd08e3e80490e559f8e";
		
		orderNumber = "TEST_ORDER";
		userAgent = "WP";
		amount = "100"; //실결제 됩니다... 금액 크게하면 안되요
		itemName = "강의테스트_카카오";
		userName = "choi";
		returnUrl = "test"; //이거는 아무값이나 넣어도됩니다..
		timestamp = "20230601111111";
		//암호화해서 생성해야함.
		try {
			signature = encrypt("himedia|"+orderNumber+"|"+amount+"|"+certKey+"|"+timestamp);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//paramMap은 요청값들이 담길 맵
		Map<String,String> paramMap = new HashMap<String, String>();
		//요청 주소
		String url = "https://api.testpayup.co.kr/ep/api/kakao/himedia/order";
		paramMap.put("orderNumber",orderNumber);
		paramMap.put("userAgent",userAgent);
		paramMap.put("amount",amount);
		paramMap.put("itemName",itemName);
		paramMap.put("userName",userName);
		paramMap.put("returnUrl",returnUrl);
		paramMap.put("amount",amount);
		paramMap.put("timestamp",timestamp);
		paramMap.put("signature",signature);
		
		resultMap = apiService.restApi(paramMap, url);
		
		
		//연동 결과
		System.out.println("카카오 주문 API 통신 결과 = " + resultMap.toString());
		
		return resultMap;
	}
	
	
	public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        return bytesToHex(md.digest());
    }
	
    private String bytesToHex(byte[] bytes) 
    {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
    
    //카카오 승인 요청
	public Map<String,String> kakaoPay(Map<String,String> receiverMap){
		
		Map<String,String> resultMap = new HashMap<String, String>();			
			
		//3.3 승인요청 전문 보고 아래소스 완성
	   /*
		//요청 데이터 설정
		String res_cd = "";		
		String enc_info = "";			
		String enc_data = "";				
		String tran_cd = "";			
		String card_pay_method = "";			
		String ordr_idxx = "";
		
		String url = "https://api.testpayup.co.kr/ep/api/kakao/himedia/pay";
		
		resultMap.put("res_cd", receiverMap.get("res_cd"));
		resultMap.put("enc_info",receiverMap.get("enc_info"));
		resultMap.put("enc_data",receiverMap.get("enc_data"));
		resultMap.put("tran_cd",receiverMap.get("tran_cd"));
		resultMap.put("card_pay_method",receiverMap.get("card_pay_method"));
		resultMap.put("ordr_idxx",receiverMap.get("ordr_idxx"));
	*/
		
		String url = "https://api.testpayup.co.kr/ep/api/kakao/himedia/pay";
		resultMap = apiService.restApi(receiverMap, url);
						
		return resultMap;
	}


	//네이버 주문 하는 기능 <수정전>
	// payType = 'CARD',  POINT 구분자가 넘어와야 한다
	public Map<String,String> naverOrder(Map<String,String> receiverMap){
		
		Map<String,String> resultMap = new HashMap<String, String>();
		
		
		//API 통신
		//카카오 3.1 주문요청
		
		//요청 데이터 설정
		String orderNumber = "";
		String userAgent = "";
		String amount = "";
		String itemName = "";
		String userName = "";
		String returnUrl = "";
		String signature = "";
		String timestamp = "";
		String certKey = "ac805b30517f4fd08e3e80490e559f8e";
		
		orderNumber = "TEST_ORDER";
		userAgent = "WP";
		amount = "100"; //실결제 됩니다... 금액 크게하면 안되요
		itemName = "강의테스트_네이버";
		userName = "choi";
		returnUrl = "test"; //이거는 아무값이나 넣어도됩니다..
		timestamp = "20230601111111";
		//암호화해서 생성해야함.
		try {
			signature = encrypt("himedia|"+orderNumber+"|"+amount+"|"+certKey+"|"+timestamp);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//paramMap은 요청값들이 담길 맵
		Map<String,String> paramMap = new HashMap<String, String>();
		//요청 주소
		String url = "https://api.testpayup.co.kr/ep/api/naver/himedia/order";
		paramMap.put("orderNumber",orderNumber);
		paramMap.put("userAgent",userAgent);
		paramMap.put("amount",amount);
		paramMap.put("itemName",itemName);
		paramMap.put("userName",userName);
		paramMap.put("returnUrl",returnUrl);
		paramMap.put("amount",amount);
		paramMap.put("timestamp",timestamp);
		paramMap.put("signature",signature);
		paramMap.put("payType", receiverMap.get("payType"));  //네이버 카드(CARD)/포인터(POINT) 구분값
		
		resultMap = apiService.restApi(paramMap, url);
		
		
		//연동 결과
		System.out.println("네이버 주문 API 통신 결과 = " + resultMap.toString());
		
		return resultMap;
	}  

	//네이버 승인 요청
	public Map<String,String> naverPay(Map<String,String> receiverMap){
		
		Map<String,String> resultMap = new HashMap<String, String>();			
			
		//3.3 승인요청 전문 보고 아래소스 완성
	   /*
		//요청 데이터 설정
		String res_cd = "";		
		String enc_info = "";			
		String enc_data = "";				
		String tran_cd = "";			
		String card_pay_method = "";			
		String ordr_idxx = "";
		
		String url = "https://api.testpayup.co.kr/ep/api/kakao/himedia/pay";
		
		resultMap.put("res_cd", receiverMap.get("res_cd"));
		resultMap.put("enc_info",receiverMap.get("enc_info"));
		resultMap.put("enc_data",receiverMap.get("enc_data"));
		resultMap.put("tran_cd",receiverMap.get("tran_cd"));
		resultMap.put("card_pay_method",receiverMap.get("card_pay_method"));
		resultMap.put("ordr_idxx",receiverMap.get("ordr_idxx"));
	*/
		
		String url = "https://api.testpayup.co.kr/ep/api/naver/himedia/pay";
		resultMap = apiService.restApi(receiverMap, url);
						
		return resultMap;
	}

}
