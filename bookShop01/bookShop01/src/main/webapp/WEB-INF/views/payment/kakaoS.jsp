<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
</head>
<BODY>

  
	<H1>카카오성공</H1>

		<h2>${amount}</h2>
		
		${kakaoData.amount}
		
		<c:out value="${kakaoData.amount}"/>
		
		<fmt:formatNumber value="${kakaoData.amount}" pattern="#,###"/>
		
		${authDateTime}
		
		<fmt:parseDate value="${authDateTime}" var="dateValue" pattern="yyyyMMddHHmmss"/>
		
		
<table class="table">
  <thead>
    <tr>
      <th scope="col">순번</th>
      <th scope="col">값</th>
      <th scope="col">일시</th>

    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><fmt:formatNumber value="${amount}" pattern="#,###"/></td>
      <td><fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd"/></td>
    </tr>

  </tbody>
</table>
		
	 <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</BODY>

<DIV class="clear"></DIV>		