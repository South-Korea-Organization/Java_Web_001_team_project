<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
</head>
<BODY>
	<H1>카카오성공</H1>	
	<!-- 낱개로 보낸경우 ${amount},  kakaoData통으로 보낸 경우는 ${kakaoData.amount} --> 
	<!-- 결과 뿌려주기 -->
	
	
	<table board=1>
	<c:if test="${kakaoData.type eq 'KAKAO_MONEY'}">
		<tr>
			<td>승인일시:</td>
			<td><fmt:parseDate value="${kakaoData.authDateTime}" var="dateValue" pattern="yyyyMMddHHmmss"/>
				<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm"/></td>					
		</tr>
		<!-- 위쪽 코드로 해야 날짜가 제대로 나온다. 
		<tr>
			<td>승인일시:</td>
			<td><fmt:formatDate value="${kakaoData.dateValue}" pattern="yyyy-MM-dd HH:mm"/></td>					
		</tr>
		//-->
		<tr>
			<td>결제된 총 금액:</td>		
			<td><fmt:formatNumber value="${kakaoData.amount}" pattern="#,###" /></td>
		</tr>
		<tr>
			<td>현금영수증 발급 대상 금액 :</td>
			<td> <fmt:formatNumber value="${kakaoData.cashReceipt}" pattern="#,###" /></td>
		</tr>	
	
	</c:if>
	<c:if test="${kakaoData.type eq 'KAKAO_CARD' }">
		<tr>
			<td>승인일시</td>
			<td><fmt:formatNumber value="${kakaoData.authDateTime}" pattern="yyyy/MM/ddHHmmss" /></td>		
		</tr>
		<tr>
			<td>결제된 총 금액:</td>	
			<td><fmt:formatNumber value="${kakaoData.amount}" pattern="#,###" /></td>		
		</tr>
		<tr>
			<td>카드 승인 번호 :</td>	
			<td><c:out value="${kakaoData.authNumber}"/></td>
		</tr>
		<tr>	
			<td>카드 명 :</td>
			<td><c:out value="${kakaoData.cardName}"/></td>
		</tr>
		<tr>	
			<td>카드 번호 :</td>
			<td><c:out value="${kakaoData.cardNo}"/></td>
		</tr>
		<tr>	
			<td>할부 개월 :</td>
			<td><c:out value="${kakaoData.quota}"/></td>				
		</tr>		
	</c:if>
	</table>
	
</BODY>			
			
			