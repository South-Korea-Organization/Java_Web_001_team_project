<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="${contextPath}/resources/css/main_page.css" rel="stylesheet" type="text/css" media="screen">

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

<nav>
<ul>
<c:choose>
<c:when test="${side_menu=='admin_mode' }">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="${contextPath}/main/main.do">Steplant</a>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="${contextPath}/admin/goods/adminGoodsMain.do" style="padding-left:30px; font-size:20px;">상품관리</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${contextPath}/admin/order/adminOrderMain.do" style="padding-left:30px; font-size:20px;">주문관리</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${contextPath}/admin/member/adminMemberMain.do" style="padding-left:30px; font-size:20px;">회원관리</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#" style="padding-left:30px; font-size:20px;">배송관리</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${contextPath}/admin/goods/adminBoardMain.do" style="padding-left:30px; font-size:20px;">게시판관리</a>
	      </li>
	    </ul>
	  </div>
	</nav>
</c:when>
<c:when test="${side_menu=='my_page' }">
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="${contextPath}/main/main.do">Steplant</a>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link mypageNav" href="${contextPath}/mypage/listMyOrderHistory.do">주문내역/배송조회</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link mypageNav" href="#">반품/교환 신청 및 조회</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link mypageNav" href="#">주문 취소 내역</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link mypageNav" href="#">세금계산서</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link mypageNav" href="${contextPath}/mypage/myDetailInfo.do">회원 정보 관리</a>
	      </li>
	    </ul>
	  </div>
	</nav>

</c:when>
<c:otherwise>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">Steplant</a>
	  	<div class="dropdown-menu">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item">
	        <a class="nav-link" href="${contextPath }/goods/goodsList.do" style="padding-left:30px; font-size:20px;">Home</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#" style="padding-left:30px; font-size:20px;">소형 식물</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#" style="padding-left:30px; font-size:20px;">중형 식물</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#" style="padding-left:30px; font-size:20px;">대형 식물</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="#" style="padding-left:30px; font-size:20px;"> 화환 </a>
	      </li>
	      
	    </ul>
	  </div>
	</nav>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
	
 </c:otherwise>
</c:choose>	
</ul>
</nav>
<div class="clear"></div>
</html>