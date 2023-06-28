package com.bookshop01.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bookshop01.payment.service.PaymentService;

//@controller 와 @RestController는 다르다.

@Controller
public class PaymentController2 {
	
	@Autowired
	private PaymentService paymentService ;
	
	
	@RequestMapping(value="/payment/kakao/pay.do" )
	public ModelAndView kakaoPay(@RequestParam Map<String, String> receiverMap)  
			throws Exception{
		
		
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println( "인증 데이터 확인 = " + receiverMap.toString()) ;
		//인증 데이터 확인 = {ordr_idxx=20230601144923KK0621, good_name=TEST아이템, good_mny=1000, 
		//buyr_name=psb, site_cd=A8QOB, req_tx=pay, pay_method=100000000000, currency=410, 
		//kakaopay_direct=Y, module_type=01, ordr_chk=20230601144923KK0621|1000, param_opt_1=, 
		//param_opt_2=, param_opt_3=, res_cd=0000, res_msg=성공, enc_info=3tAEmi0Avn7AztvGTJir66.rxsx1xrke8CHdpRmI6mZxDbpoPmdYn36UljRenFBd0wAtItgCQHg8CiLZ1UdhxwdH-FcHSTXzWW7EXK9YKKSh40VC47mUF8jB7akCCJEvwnW3PC5LhQz44Z2hc5OAFlTKOgViptbJCsep1i6LfD.m2Vi.4j09aP4VyN-3lYqxTJBD5M5-OBt__, enc_data=0MXiD7yksWDRGkeRiBcJFcrwglrtOIZxxR8h0ctkKXB6-atNtv1oD3Zkus7KO4l6Vu.2pLRYts-adhoXqJzUqyFdGWfoFVb4dU5nLYPTe8WyG0PDKtIpvMgcCQ9k899mZv7X4IlYvm6TU6wfz688U-t10Uz4Oe3lXr0vsRA1gHc2WMifnBhE497sXm-4eRSJVta8tYzTxL-gOcgonKD2TiiWu.Wm1FbFbZI0FgdZflANMe7FONDcbAY-yaDXip1OAwL7cxt2JiSgBOTF06Fmr9Kh.WffbMpcNk7Rt5dqNassYccD997BV-sN7LHRTLC4UQ5.7qveym1w4EC496DCdzyHdFWpVLloDHgNAdTOW8o2fgtyBxIouZzMDAY7xX4czaeqAZ5gg0UMFoy0ifAdKrNn2hWn8ztyPb6Ef5ogEoG8g9LPIUDkeXk5POf8kmNK9Cpa1IyPbeWENxVTmlmgoYHiVrBNdM25fJenNvEhRVpyWtSc0wYw41TXINxWLZ3n.t1ma.VZTftnvK0T.a3umZnoTiSvqB5Vo-tcCBtluLsIDDH59WLLYjG6lXA2KRSiaAWgfJNzx2DLovja2OGxLyNAjOKtJywnUrPHrXF.dScMmMulnWFO.h0DLW0K6.rThtUaAqO5alTsFGPNEkWPQOINloret2JcHjVQ2hstwrXb_, ret_pay_method=CARD, tran_cd=00100000, use_pay_method=100000000000, card_pay_method=KAKAO_MONEY}
		
		
		
		Map<String,String> resultMap = new HashMap<String, String>();
		
		resultMap = paymentService.kakaoPay(receiverMap) ;
		
		
		//resultMap 승인 결과 내용이 담겨있습니다.
		
		//String responseCode = resultMap.get("responseCode") ;
		String responseCode = "0000" ;  // 화면 테스트 코드
		
		
		if("0000".equals(responseCode)) {
			
			//승인완료
			//어떤 페이지로 갈지 성정
			mav.setViewName("/payment/kakaoS") ;  
			
			// 결제 성공 관련 데이터 넣어서
			
//			mav.addObject("amount", resultMap.get("amount")) ;
//			mav.addObject("addDateTime", resultMap.get("addDateTime")) ;
//			mav.addObject("type", resultMap.get("type")) ;
			
			mav.addObject("kakaoData", resultMap) ;
		} else {
			
			//승인실패
			mav.setViewName("/payment/kakaoF") ;
		}
		
		
		
		return mav ;
	}

}
