<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
</head>
<BODY>
	<H1>카카오성공</H1>
	
	<table>
		<TBODY>
			<TR class="dot_line">
				<TD class="fixed_join">결제금액</TD>
				<TD>
				   <fmt:formatNumber value="${kakaoData.amount}" pattern="#,###" /> 원
			    </TD>
			</TR>
			<TR class="dot_line">
				<TD class="fixed_join">승인일시</TD>
				<TD>
					<fmt:parseDate value="${kakaoData.authDateTime}" var="dateValue" pattern="yyyyMMddHHmmss"/>
					<fmt:formatDate value="${kakaoData.dateValue}" pattern="yyyy-MM-dd HH:mm"/>
			    </TD>
			</TR>

			<TR class="dot_line">
				<TD class="fixed_join">결제타입</TD>
				<TD>
					<c:if test="${kakaoData.type eq 'KAKAO_MONEY'}">
						카카오 머니
					</c:if>
					<c:if test="${kakaoData.type eq 'KAKAO_CARD'}">
						카카오 카드
					</c:if>
			    </TD>
			</TR>
		</TBODY>
	</table>
</BODY>
	
	
	
	

	


