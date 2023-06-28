package com.bookshop01.payment.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshop01.api.service.ApiService;


@Service
public class PaymentService {
	@Autowired
	private ApiService apiService;
	
	public Map<String,String> keyin(Map<String,String> receiverMap){
			
		//컨트롤+쉬프트+O(영어) 자동완성
		
		Map<String,String> resultMap = new HashMap<String, String>();
		
		//API 연동 소스 작성 예정
		
		//rest api 연동을 할 예정
		//라이브러리를 사용해서 연동
		String orderNumber = "";
		String cardNo = "";
		String expireYear = "";
		String expireMonth = "";
		String birthday = "";
		String cardPw = "";
		String amount = "";
		String quota = "";
		String itemName = "";
		String userName = "";
		String signature = "";
		String timestamp = "";
		String certKey = "ac805b30517f4fd08e3e80490e559f8e";
		
		// 보내야되는 값 셋팅 예정
		//receiverMap.get("cardNo");// 화면에서 입력한 카드 번호
		orderNumber = "TEST1234";
		cardNo = receiverMap.get("cardNo");
		expireMonth = receiverMap.get("expireMonth");
		expireYear = receiverMap.get("expireYear");
		birthday = receiverMap.get("birthday");
		cardPw = receiverMap.get("cardPw");
		amount = "1000";
		quota = "0";
		itemName = "TEST아이템";
		userName = "최용수";
		timestamp = "20230531010112";
		
		
		try {
			
			
			signature = encrypt("himedia|"+orderNumber+"|"+amount+"|"+certKey+"|"+timestamp); //암호화해서 생성해야함.
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//
		//
		
		//paramMap은 요청값들이 담길 맵
		Map<String,String> paramMap = new HashMap<String, String>();
		//요청 주소
		String url = "https://api.testpayup.co.kr/v2/api/payment/himedia/keyin2";
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
		
		return resultMap;
	}
	
	// 카카오 주문 하는 기능
	public Map<String,String> kakaoOrder(Map<String,String> receiverMap){
		
		
		//컨트롤+쉬프트+O(영어) 자동완성
		
		Map<String,String> resultMap = new HashMap<String, String>();
		
		
		//API 통신
		//카카오.3.1 주문요청
		//rest api 연동을 할 예정
		//라이브러리를 사용해서 연동	
		// 요청 데이터
		
		String orderNumber = "";
		String userAgent  = "";
		String amount  = "";
		String itemName = "";
		String userName = "";
		String returnUrl = "";
		String signature = "";
		String timestamp = "";
		String certKey = "ac805b30517f4fd08e3e80490e559f8e";
		
		// 보내야되는 값 셋팅 예정
		//receiverMap.get("cardNo");// 화면에서 입력한 카드 번호
		
		orderNumber = "TEST_kakao" ;
		userAgent = "WP" ;
		amount = "2002";
		itemName = "TEST아이템";
		userName = "psb";
		returnUrl = "TEST";
		timestamp = "20230531010112";
		
		
		try {
					
				signature = encrypt("himedia|"+orderNumber+"|"+amount+"|"+certKey+"|"+timestamp); //암호화해서 생성해야함.
				
			} catch (NoSuchAlgorithmException e) 
				{
					e.printStackTrace();
				}
		//
		//
		
		//paramMap은 요청값들이 담길 맵
		Map<String,String> paramMap = new HashMap<String, String>();
		//요청 주소
		String url = "https://api.testpayup.co.kr/ep/api/kakao/himedia/order";
		
		paramMap.put("orderNumber",orderNumber);
		paramMap.put("userAgent",userAgent);
		paramMap.put("amount",amount);
		paramMap.put("itemName",itemName);
		paramMap.put("userName",userName);
		paramMap.put("signature",signature);
		paramMap.put("returnUrl",returnUrl);
		paramMap.put("timestamp",timestamp);
		
		
		resultMap = apiService.restApi(paramMap, url);
		
		//연동 결과
		

	
		return resultMap ;
	}
	
	//카카오 승인 요청
	public Map<String,String> kakaoPay(Map<String,String> receiverMap){
	
		Map<String,String> resultMap = new HashMap<String, String>();
		
		//3.3 승인으로 견적서 보고 아래 소스 완성..
		
		String res_cd = "";
		String enc_info  = "";
		String enc_data  = "";
		String card_pay_method = "";
		String ordr_idxx = "";
		String res_msg = "";
		String authDateTime = "";
		String amount = "";
		String cashReceipt = "";
		String authNumber = "";
		String cardName = "";
		String cardNo = "";
		String quota  = "";
		
		
		// 보내야되는 값 셋팅 예정
		//receiverMap.get("cardNo");// 화면에서 입력한 카드 번호
		
		res_cd = receiverMap.get("res_cd"); 
		enc_info = receiverMap.get("enc_info"); 
		amount = "2002";
		enc_data = receiverMap.get("enc_data");
		card_pay_method = receiverMap.get("card_pay_method");
		ordr_idxx = receiverMap.get("ordr_idxx");
		res_msg = receiverMap.get("res_msg");
		authDateTime = receiverMap.get("authDateTime");
		cashReceipt = receiverMap.get("cashReceipt");
		authNumber = receiverMap.get("authNumber");
		cardName = "현대";
		cardNo = "00";
		quota  = "0";
		

	
		//paramMap은 요청값들이 담길 맵
		Map<String,String> paramMap = new HashMap<String, String>();
		//요청 주소
		String url = "https://api.testpayup.co.kr/ep/api/kakao/himedia/pay";
			
		
		paramMap.put("res_cd",res_cd);
		paramMap.put("enc_info",enc_info);
		paramMap.put("amount",amount);
		paramMap.put("enc_data",enc_data);
		paramMap.put("card_pay_method",card_pay_method);
		paramMap.put("ordr_idxx",ordr_idxx);
		paramMap.put("res_cd",res_cd);
		paramMap.put("res_msg",res_msg);
		paramMap.put("authDateTime",authDateTime);
		paramMap.put("cashReceipt",cashReceipt);
		paramMap.put("authNumber",authNumber);
		paramMap.put("cardName",cardName);
		paramMap.put("cardNo",cardNo);
		paramMap.put("quota",quota);
		
		
		
		resultMap = apiService.restApi(paramMap, url);
			
			
		return resultMap ;
		
	}
	
	
	
	public String encrypt(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        return bytesToHex(md.digest());
    }
	
    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}