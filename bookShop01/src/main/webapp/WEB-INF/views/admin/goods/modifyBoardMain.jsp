<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />	
<!DOCTYPE html>
<meta charset="utf-8">
<head>


<!-- order 에서 따옴 -->
<c:choose>
<c:when test='${not empty order_goods_list}'>
<script  type="text/javascript">
window.onload=function()
{
	init();
}

//화면이 표시되면서  각각의 주문건에 대한 배송 상태를 표시한다.
function init(){
	var frm_delivery_list=document.frm_delivery_list;
	var h_delivery_state=frm_delivery_list.h_delivery_state;
	var s_delivery_state=frm_delivery_list.s_delivery_state;
	
	
	if(h_delivery_state.length==undefined){
		s_delivery_state.value=h_delivery_state.value; //조회된 주문 정보가 1건인 경우
	}else{
		for(var i=0; s_delivery_state.length;i++){
			s_delivery_state[i].value=h_delivery_state[i].value;//조회된 주문 정보가 여러건인 경우
		}
	}
}
</script>
</c:when>
</c:choose>


<script type="text/javascript">
  var cnt=0;
  function fn_addFile(){
	  if(cnt == 0){
		  $("#d_file").append("<br>"+"<input  type='file' name='main_image' id='f_main_image' />");	  
	  }else{
		  $("#d_file").append("<br>"+"<input  type='file' name='detail_image"+cnt+"' />");
	  }
  	
  	cnt++;
  }
  
  
  function fn_add_new_goods(obj){
		 fileName = $('#f_main_image').val();
		 if(fileName != null && fileName != undefined){
			 obj.submit();
		 }else{
			 alert("메인 이미지는 반드시 첨부해야 합니다.");
			 return;
		 }
		 
	}
  
  function search_goods_list(fixeSearchPeriod){
		var formObj=document.createElement("form");
		var i_fixedSearch_period = document.createElement("input");
		i_fixedSearch_period.name="fixedSearchPeriod";
		i_fixedSearch_period.value=searchPeriod;
	    formObj.appendChild(i_fixedSearch_period);
	    document.body.appendChild(formObj); 
	    formObj.method="get";
	    formObj.action="${contextPath}/admin/goods/adminGoodsMain.do";
	    formObj.submit();
	}


	function  calcPeriod(search_period){
		var dt = new Date();
		var beginYear,endYear;
		var beginMonth,endMonth;
		var beginDay,endDay;
		var beginDate,endDate;
		
		endYear = dt.getFullYear();
		endMonth = dt.getMonth()+1;
		endDay = dt.getDate();
		if(search_period=='today'){
			beginYear=endYear;
			beginMonth=endMonth;
			beginDay=endDay;
		}else if(search_period=='one_week'){
			beginYear=dt.getFullYear();
			beginMonth=dt.getMonth()+1;
			dt.setDate(endDay-7);
			beginDay=dt.getDate();
			
		}else if(search_period=='two_week'){
			beginYear = dt.getFullYear();
			beginMonth = dt.getMonth()+1;
			dt.setDate(endDay-14);
			beginDay=dt.getDate();
		}else if(search_period=='one_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-1);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}else if(search_period=='two_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-2);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}else if(search_period=='three_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-3);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}else if(search_period=='four_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-4);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}
		
		if(beginMonth <10){
			beginMonth='0'+beginMonth;
			if(beginDay<10){
				beginDay='0'+beginDay;
			}
		}
		if(endMonth <10){
			endMonth='0'+endMonth;
			if(endDay<10){
				endDay='0'+endDay;
			}
		}
		endDate=endYear+'-'+endMonth +'-'+endDay;
		beginDate=beginYear+'-'+beginMonth +'-'+beginDay;
		//alert(beginDate+","+endDate);
		return beginDate+","+endDate;
	}
	
	
	// order 에서 따옴
	function search_order_history(search_period){	
		temp=calcPeriod(search_period);
		var date=temp.split(",");
		beginDate=date[0];
		endDate=date[1];
		
	    
		var formObj=document.createElement("form");
		var i_command = document.createElement("input");
		var i_beginDate = document.createElement("input"); 
		var i_endDate = document.createElement("input");
	    
		i_beginDate.name="beginDate";
		i_beginDate.value=beginDate;
		i_endDate.name="endDate";
		i_endDate.value=endDate;
		
	    formObj.appendChild(i_beginDate);
	    formObj.appendChild(i_endDate);
	    document.body.appendChild(formObj); 
	    formObj.method="get";
	    formObj.action="${contextPath}/admin/order/adminOrderMain.do";
	    formObj.submit();
	}


	function  calcPeriod(search_period){
		var dt = new Date();
		var beginYear,endYear;
		var beginMonth,endMonth;
		var beginDay,endDay;
		var beginDate,endDate;
		
		endYear = dt.getFullYear();
		endMonth = dt.getMonth()+1;
		endDay = dt.getDate();
		if(search_period=='today'){
			beginYear=endYear;
			beginMonth=endMonth;
			beginDay=endDay;
		}else if(search_period=='one_week'){
			beginYear=dt.getFullYear();
			beginMonth=dt.getMonth()+1;
			dt.setDate(endDay-7);
			beginDay=dt.getDate();
			
		}else if(search_period=='two_week'){
			beginYear = dt.getFullYear();
			beginMonth = dt.getMonth()+1;
			dt.setDate(endDay-14);
			beginDay=dt.getDate();
		}else if(search_period=='one_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-1);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}else if(search_period=='two_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-2);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}else if(search_period=='three_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-3);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}else if(search_period=='four_month'){
			beginYear = dt.getFullYear();
			dt.setMonth(endMonth-4);
			beginMonth = dt.getMonth();
			beginDay = dt.getDate();
		}
		
		if(beginMonth <10){
			beginMonth='0'+beginMonth;
			if(beginDay<10){
				beginDay='0'+beginDay;
			}
		}
		if(endMonth <10){
			endMonth='0'+endMonth;
			if(endDay<10){
				endDay='0'+endDay;
			}
		}
		endDate=endYear+'-'+endMonth +'-'+endDay;
		beginDate=beginYear+'-'+beginMonth +'-'+beginDay;
		//alert(beginDate+","+endDate);
		return beginDate+","+endDate;
	}
	
	function fn_modify_order_state(order_id,select_id){
		var s_delivery_state=document.getElementById(select_id);
	    var index = s_delivery_state.selectedIndex;
	    var value = s_delivery_state[index].value;
	    //console.log("value: "+value );
		 
		$.ajax({
			type : "post",
			async : false,
			url : "${contextPath}/admin/order/modifyDeliveryState.do",
			data : {
				order_id:order_id,
				"delivery_state":value
			},
			success : function(data, textStatus) {
				if(data.trim()=='mod_success'){
					alert("주문 정보를 수정했습니다.");
					location.href="${contextPath}//admin/order/adminOrderMain.do";
				}else if(data.trim()=='failed'){
					alert("다시 시도해 주세요.");	
				}
				
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
				
			}
		}); //end ajax		
	}
	
	function fn_enable_detail_search(r_search){
		var frm_delivery_list=document.frm_delivery_list;
		t_beginYear=frm_delivery_list.beginYear;
		t_beginMonth=frm_delivery_list.beginMonth;
		t_beginDay=frm_delivery_list.beginDay;
		t_endYear=frm_delivery_list.endYear;
		t_endMonth=frm_delivery_list.endMonth;
		t_endDay=frm_delivery_list.endDay;
		s_search_type=frm_delivery_list.s_search_type;
		t_search_word=frm_delivery_list.t_search_word;
		btn_search=frm_delivery_list.btn_search;
		
		if(r_search.value=='detail_search'){
			//alert(r_search.value);
			t_beginYear.disabled=false;
			t_beginMonth.disabled=false;
			t_beginDay.disabled=false;
			t_endYear.disabled=false;
			t_endMonth.disabled=false;
			t_endDay.disabled=false;
			
			s_search_type.disabled=false;
			t_search_word.disabled=false;
			btn_search.disabled=false;
		}else{
			t_beginYear.disabled=true;
			t_beginMonth.disabled=true;
			t_beginDay.disabled=true;
			t_endYear.disabled=true;
			t_endMonth.disabled=true;
			t_endDay.disabled=true;
			
			s_search_type.disabled=true;
			t_search_word.disabled=true;
			btn_search.disabled=true;
		}
			
	}
	
	function fn_detail_order(order_id){
		//alert(order_id);
		var frm_delivery_list=document.frm_delivery_list;
		
	
		var formObj=document.createElement("form");
		var i_order_id = document.createElement("input");
		
		i_order_id.name="order_id";
		i_order_id.value=order_id;
		
	    formObj.appendChild(i_order_id);
	    document.body.appendChild(formObj); 
	    formObj.method="post";
	    formObj.action="${contextPath}/admin/order/orderDetail.do";
	    formObj.submit();
		
	}
	
	//상세조회 버튼 클릭 시 수행
	function fn_detail_search(){
		var frm_delivery_list=document.frm_delivery_list;
		
		beginYear=frm_delivery_list.beginYear.value;
		beginMonth=frm_delivery_list.beginMonth.value;
		beginDay=frm_delivery_list.beginDay.value;
		endYear=frm_delivery_list.endYear.value;
		endMonth=frm_delivery_list.endMonth.value;
		endDay=frm_delivery_list.endDay.value;
		search_type=frm_delivery_list.s_search_type.value;
		search_word=frm_delivery_list.t_search_word.value;
	
		var formObj=document.createElement("form");
		var i_command = document.createElement("input");
		var i_beginDate = document.createElement("input"); 
		var i_endDate = document.createElement("input");
		var i_search_type = document.createElement("input");
		var i_search_word = document.createElement("input");
	    
		//alert("beginYear:"+beginYear);
		//alert("endDay:"+endDay);
		//alert("search_type:"+search_type);
		//alert("search_word:"+search_word);
		
	    i_command.name="command";
	    i_beginDate.name="beginDate";
	    i_endDate.name="endDate";
	    i_search_type.name="search_type";
	    i_search_word.name="search_word";
	    
	    i_command.value="list_detail_order_goods";
		i_beginDate.value=beginYear+"-"+beginMonth+"-"+beginDay;
	    i_endDate.value=endYear+"-"+endMonth+"-"+endDay;
	    i_search_type.value=search_type;
	    i_search_word.value=search_word;
		
	    formObj.appendChild(i_command);
	    formObj.appendChild(i_beginDate);
	    formObj.appendChild(i_endDate);
	    formObj.appendChild(i_search_type);
	    formObj.appendChild(i_search_word);
	    document.body.appendChild(formObj); 
	    formObj.method="post";
	    formObj.action="${contextPath}/admin/order/detailOrder.do";
	    formObj.submit();
	    //alert("submit");
		
	}
		
	
</script>    
</head>
<BODY>
<form action="${contextPath}/admin/goods/addNewGoods.do" method="post"  enctype="multipart/form-data">
		<h1>새상품 등록창</h1>
<div class="tab_container">
	<!-- 내용 들어 가는 곳 -->
	<div class="tab_container" id="container">
		<ul class="tabs">
			<li><a href="#tab1">상품정보</a></li>
			<li><a href="#tab2">상품목차</a></li>
			<li><a href="#tab3">상품저자소개</a></li>
			<li><a href="#tab4">상품소개</a></li>
			<li><a href="#tab5">출판사 상품 평가</a></li>
			<li><a href="#tab6">추천사</a></li>
			<li><a href="#tab7">상품이미지</a></li>
		</ul>
		<div class="tab_container">
			<div class="tab_content" id="tab1">
				<table >
			<tr >
				<td width=200 >제품분류</td>
				<td width=500><select name="goods_sort">
						<option value="컴퓨터와 인터넷" selected>컴퓨터와 인터넷
						<option value="디지털 기기">디지털 기기
					</select>
				</td>
			</tr>
			<tr >
				<td >제품이름</td>
				<td><input name="goods_title" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >저자</td>
				<td><input name="goods_writer" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >출판사</td>
				<td><input name="goods_publisher" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >제품정가</td>
				<td><input name="goods_price" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품판매가격</td>
				<td><input name="goods_sales_price" type="text" size="40" /></td>
			</tr>
			
			
			<tr>
				<td >제품 구매 포인트</td>
				<td><input name="goods_point" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품출판일</td>
				<td><input  name="goods_published_date"  type="date" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품 총 페이지수</td>
				<td><input name="goods_total_page" type="text" size="40" /></td>
			</tr>
			
			<tr>
				<td >ISBN</td>
				<td><input name="goods_isbn" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >제품 배송비</td>
				<td><input name="goods_delivery_price" type="text" size="40" /></td>
			</tr>
			<tr>
				<td >제품 도착 예정일</td>
				<td><input name="goods_delivery_date"  type="date" size="40" /></td>
			</tr>
			
			<tr>
				<td >제품종류</td>
				<td>
				<select name="goods_status">
				  <option value="bestseller"  >베스트셀러</option>
				  <option value="steadyseller" >스테디셀러</option>
				  <option value="newbook" selected >신간</option>
				  <option value="on_sale" >판매중</option>
				  <option value="buy_out" >품절</option>
				  <option value="out_of_print" >절판</option>
				</select>
				</td>
			</tr>
			<tr>
			 <td>
			   <br>
			 </td>
			</tr>
				</table>	
			</div>
			<div class="tab_content" id="tab2">
				<H4>책목차</H4>
				<table>	
				 <tr>
					<td >책목차</td>
					<td><textarea  rows="100" cols="80" name="goods_contents_order"></textarea></td>
				</tr>
				</table>	
			</div>
			<div class="tab_content" id="tab3">
				<H4>제품 저자 소개</H4>
				 <table>
  				 <tr>
					<td>제품 저자 소개</td>
					<td><textarea  rows="100" cols="80" name="goods_writer_intro"></textarea></td>
			    </tr>
			   </table>
			</div>
			<div class="tab_content" id="tab4">
				<H4>제품소개</H4>
				<table>
					<tr>
						<td >제품소개</td>
						<td><textarea  rows="100" cols="80" name="goods_intro"></textarea></td>
				    </tr>
			    </table>
			</div>
			<div class="tab_content" id="tab5">
				<H4>출판사 제품 평가</H4>
				<table>
				 <tr>
					<td>출판사 제품 평가</td>
					<td><textarea  rows="100" cols="80" name="goods_publisher_comment"></textarea></td>
			    </tr>
			</table>
			</div>
			<div class="tab_content" id="tab6">
				<H4>추천사</H4>
				 <table>
					 <tr>
					   <td>추천사</td>
					    <td><textarea  rows="100" cols="80" name="goods_recommendation"></textarea></td>
				    </tr>
			    </table>
			</div>
			<div class="tab_content" id="tab7">
				<h4>상품이미지</h4>
				<table >
					<tr>
						<td align="right">이미지파일 첨부</td>
			            
			            <td  align="left"> <input type="button"  value="파일 추가" onClick="fn_addFile()"/></td>
			            <td>
				            <div id="d_file">
				            </div>
			            </td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="clear"></div>
<center>	
	 <table>
	 <tr>
			  <td align=center>
				<!--   <input  type="submit" value="상품 등록하기"> --> 
				  <input  type="button" value="상품 등록하기"  onClick="fn_add_new_goods(this.form)">
			  </td>
			</tr>
	 </table>
</center>	 
</div>
</form>	 