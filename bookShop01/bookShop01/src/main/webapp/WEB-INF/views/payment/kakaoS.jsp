<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
</head>
<body>
	<h1>카카오 성공</h1>
	<!-- 컨트롤러2에서 가져온 데이터 뿌려주기
	${amount }
	${kakaoData.amount }
	<c:out value="${kakaoData.amount }"/>
	숫자포맷
	${authDateTime} : 20230531112322
	<fmt:parseDate value="${authDateTime}" var="dateValue" pattern="yyyyMMddHHmmss"/>
	<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/>
	2023-05-31
	-->
	<table class="kakaoS">
		<tbody align=center >
			<tr style="background:#FFD700" >
				<td>가격</td>
				<td> ${amount} </td>
			</tr>
			<tr style="background:#FFD700" >
				<td>승인일시</td>
				<td><fmt:parseDate value="${authDateTime}" var="dateValue" pattern="yyyyMMddHHmmss"/>
					<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			<tr style="background:#FFD700" >
				<td>type</td>
				<td>${type}</td>
			</tr>
		</tbody>
	</table>
			
</body>
</html>