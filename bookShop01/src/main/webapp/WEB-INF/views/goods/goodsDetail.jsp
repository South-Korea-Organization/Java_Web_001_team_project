<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" 	isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="goods"  value="${goodsMap.goodsVO}"  />
<c:set var="imageList"  value="${goodsMap.imageList }"  />
 <%
     //치환 변수 선언합니다.
      //pageContext.setAttribute("crcn", "\r\n"); //개행문자
      pageContext.setAttribute("crcn" , "\n"); //Ajax로 변경 시 개행 문자 
      pageContext.setAttribute("br", "<br/>"); //br 태그
%>  
<html>
<head>
<style>
 section.replyForm { padding:30px 0; }
 section.replyForm div.input_area { margin:10px 0; }
 section.replyForm textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px;; height:150px; }
 section.replyForm button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 
 section.replyList { padding:30px 0; }
 section.replyList ol { padding:0; margin:0; }
 section.replyList ol li { padding:10px 0; border-bottom:2px solid #eee; }
 section.replyList div.userInfo { }
 section.replyList div.userInfo .userName { font-size:20px; font-weight:bold; }
 section.replyList div.userInfo .date { color:#999; display:inline-block; margin-left:10px; }
 section.replyList div.replyContent { padding:10px; margin:20px 0; }
 
 section.replyList div.replyFooter button { font-size:14px; border: 1px solid #999; background:none; margin-right:10px; }
 
 div.replyModal { position:relative; z-index:1; display:none;}
 div.modalBackground { position:fixed; top:0; left:0; width:100%; height:100%; background:rgba(0, 0, 0, 0.8); z-index:-1; }
 div.modalContent { position:fixed; top:20%; left:calc(50% - 250px); width:525px; height:290px; padding:20px 10px; background:#fff; border:2px solid #666; }
 div.modalContent textarea { font-size:16px; font-family:'맑은 고딕', verdana; padding:10px; width:500px; height:200px; }
 div.modalContent button { font-size:20px; padding:5px 10px; margin:10px 0; background:#fff; border:1px solid #ccc; }
 div.modalContent button.modal_cancel { margin-left:20px; }
 
#layer {
	z-index: 2;
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
}

#popup {
	z-index: 3;
	position: fixed;
	text-align: center;
	left: 50%;
	top: 45%;
	width: 300px;
	color: black;
	background-color: #82FA58;
	border-radius: 10px;

}

#close {
	z-index: 4;
	float: right;
}
</style>
<script type="text/javascript">

	function fn_delete_reply(url,repNum,goods_id){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	    var repNumInput = document.createElement("input");
	    repNumInput.setAttribute("type","hidden");
	    repNumInput.setAttribute("name","repNum");
	    repNumInput.setAttribute("value", repNum);
	    
		 
	    form.appendChild(repNumInput);
	    
	    var goodsIdInput = document.createElement("input");
	    goodsIdInput.setAttribute("type", "hidden");
	    goodsIdInput.setAttribute("name", "goods_id");
	    goodsIdInput.setAttribute("value", goods_id);
	    form.appendChild(goodsIdInput);
	    document.body.appendChild(form);
	    form.submit();
	
	}
	
	function add_cart(goods_id) {
		$.ajax({
			type : "POST",
			async : false, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/cart/addGoodsInCart.do",
			data : {
				goods_id:goods_id
				
			},
			success : function(data, textStatus) {
				//alert(data);
			//	$('#message').append(data);
				if(data.trim()=='add_success'){
					//alert("등록 성공");
					imagePopup('open', '.layer01');


				}else if(data.trim()=='already_existed'){
					alert("이미 카트에 등록된 상품입니다.");	
				}
				
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을 완료 했습니다");
			}
		}); //end ajax	
	}

	function imagePopup(type) {
		if (type == 'open') {
			// 팝업창을 연다.
			jQuery('#layer').attr('style', 'visibility:visible');

			// 페이지를 가리기위한 레이어 영역의 높이를 페이지 전체의 높이와 같게 한다.
			jQuery('#layer').height(jQuery(document).height());
		}

		else if (type == 'close') {

			// 팝업창을 닫는다.
			jQuery('#layer').attr('style', 'visibility:hidden');
		}
	}


	
function fn_order_each_goods(goods_id,goods_title,goods_sales_price,fileName){
	var _isLogOn=document.getElementById("isLogOn");
	var isLogOn=_isLogOn.value;
	
	 if(isLogOn=="false" || isLogOn=='' ){
		alert("로그인 후 주문이 가능합니다!!!");
	} 
	
	
		var total_price,final_total_price;
		var order_goods_qty=document.getElementById("order_goods_qty");
		
		var formObj=document.createElement("form");
		var i_goods_id = document.createElement("input"); 
    var i_goods_title = document.createElement("input");
    var i_goods_sales_price=document.createElement("input");
    var i_fileName=document.createElement("input");
    var i_order_goods_qty=document.createElement("input");
    
    i_goods_id.name="goods_id";
    i_goods_title.name="goods_title";
    i_goods_sales_price.name="goods_sales_price";
    i_fileName.name="goods_fileName";
    i_order_goods_qty.name="order_goods_qty";
    
    i_goods_id.value=goods_id;
    i_order_goods_qty.value=order_goods_qty.value;
    i_goods_title.value=goods_title;
    i_goods_sales_price.value=goods_sales_price;
    i_fileName.value=fileName;
    
    formObj.appendChild(i_goods_id);
    formObj.appendChild(i_goods_title);
    formObj.appendChild(i_goods_sales_price);
    formObj.appendChild(i_fileName);
    formObj.appendChild(i_order_goods_qty);

    document.body.appendChild(formObj); 
    formObj.method="post";
    formObj.action="${contextPath}/order/orderEachGoods.do";
    formObj.submit();
	}
	
	$(document).on("click", ".delete", function(){
		
		var date = {repNum : $(this)}
		
	})



</script>
</head>
<body>
	<hgroup>
		<h1>${goods.goods_title }</h1>
		<h2>${goods.goods_sort } &gt; 컴퓨터와 인터넷 &gt; 웹 개발</h2>
		
	</hgroup>
	<div id="goods_image">
		<figure>
			<img alt="HTML5 &amp; CSS3"
				src="${contextPath}/thumbnails.do?goods_id=${goods.goods_id}&fileName=${goods.goods_fileName}">
		</figure>
	</div>
	<div id="detail_table">
		<table>
			<tbody>
				<tr>
					<td class="fixed">정가</td>
					<td class="active"><span >
					   <fmt:formatNumber  value="${goods.goods_price}" type="number" var="goods_price" />
				         ${goods_price}원
					</span></td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">판매가</td>
					<td class="active"><span >
					   <fmt:formatNumber  value="${goods.goods_price*0.9}" type="number" var="discounted_price" />
				         ${discounted_price}원(10%할인)</span></td>
				</tr>
				<tr>
					<td class="fixed">포인트적립</td>
					<td class="active">${goods.goods_point}P(10%적립)</td>
				</tr>
				<tr class="dot_line">
					<td class="fixed">포인트 추가적립</td>
					<td class="fixed">만원이상 구매시 1,000P, 5만원이상 구매시 2,000P추가적립 편의점 배송 이용시 300P 추가적립</td>
				</tr>
				<tr>
					<td class="fixed">발행일</td>
					<td class="fixed">
					   <c:set var="pub_date" value="${goods.goods_credate}" />
					   <c:set var="arr" value="${fn:split(pub_date,' ')}" />
					   <c:out value="${arr[0]}" />
					</td>
				</tr>


				<tr>
					<td class="fixed">배송료</td>
					<td class="fixed"><strong>무료</strong></td>
				</tr>
				<tr>
					<td class="fixed">배송안내</td>
					<td class="fixed"><strong>[당일배송]</strong> 당일배송 서비스 시작!<br> <strong>[휴일배송]</strong>
						휴일에도 배송받는 Bookshop</TD>
				</tr>
				<tr>
					<td class="fixed">도착예정일</td>
					<td class="fixed">지금 주문 시 내일 도착 예정</td>
				</tr>
				<tr>
					<td class="fixed">수량</td>
					<td class="fixed">
			      <select style="width: 60px;" id="order_goods_qty">
				      <option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
			     </select>
					 </td>
				</tr>
			</tbody>
		</table>
		<ul>
			<li><a class="buy btn" href="javascript:fn_order_each_goods('${goods.goods_id }','${goods.goods_title }','${goods.goods_sales_price}','${goods.goods_fileName}');">구매하기 </a></li>
			<li><a class="cart btn" href="javascript:add_cart('${goods.goods_id }')">장바구니</a></li>
			<li><a class="wish btn" href="#">위시리스트</a></li>
		</ul>
	</div>
	<div class="clear"></div>
	
	<!-- 일단 주석처리 -->
	<!-- 내용 들어 가는 곳 
	<div id="container">
		<ul class="tabs">
			
			
			<li><a href="#tab5">추천사</a></li>
			<li><a href="#tab6">리뷰</a></li>
		</ul>
		<div class="tab_container">
			

			<div class="tab_content" id="tab5">
				<h4>추천사</h4>
				<p>${fn:replace(goods.goods_recommendation,crcn,br) }</p>
			</div>
			<div class="tab_content" id="tab6">
				<h4>리뷰</h4>
			</div>
		</div>
		
	</div>
	<hr>
	<div id="reply" class="shadow p-3 mb-5 bg-white rounded">
		<div>
			
			<hr style="border: solid 1px ;">
			<h3> 상품 리뷰 </h3>
			<hr style="border: solid 1px ;" >
		</div>
		<c:if test="${memberInfo.member_id == null }">
			<p> 댓글을 남기시려면 <a href="${contextPath}/member/loginForm.do">로그인</a>해주세요</p>
		</c:if>
		
		<c:if test="${memberInfo.member_id != null }">
 		<section class="replyForm">
 		 <form role="form" method="post" autocomplete="off">
 		 	<input type="hidden" name="goods_id" value="${goods.goods_id }">
 		 	<div class="input_area">
 		 		<textarea name="repCon" id="repCon"></textarea>
 		 	</div>
 		 	<div class="input_area">
 		 		<button type="submit" id="reply_btn">댓글 남기기</button>
 		 	</div>
 		 	
 		 </form>
		</section>
		</c:if>

 		<section class="replyList">
 			 <ol>
 			 	<c:forEach items="${reply }" var="reply">
 			 	<li>
 			 		<div class="userInfo">
 			 			<span class="userName">${reply.member_id }</span>
 			 			<span class="date"><fmt:formatDate value="${reply.repDate }" pattern="yyyy-MM-dd" /></span>
 			 		</div>
 			 		<div class="replyContent" data-repNum="${reply.repNum}">${reply.repCon }</div>
 			 		<div class="replyFooter">
 			 			<button type="button" class="modify" data-repNum="${reply.repNum }">수정</button>
 			 			<button type="button" class="delete" onClick="fn_delete_reply('${contextPath}/goods/deleteReply.do', ${reply.repNum}, ${goods.goods_id})">삭제</button>
 			 		</div>
 			 	</li>
 			 	</c:forEach>
 		 	 </ol>    
 		 	 <script>
 		 		$(document).on("click", ".modify", function(){
 		 		 $(".replyModal").fadeIn(300);//.attr("style", "display:block;");
 		 		 
 		 		 var repNum = $(this).attr("data-repNum");
 		 		 var repCon = $(this).parent().parent().children(".replyContent").text();
 		 		 
 		 		 $(".modal_repCon").val(repCon);
 		 		 $(".modal_modify_btn").attr("data-repNum", repNum);
 		 		 

 		 		});
 		 	 </script>
 		 	 
 		 	 
 		</section>
	</div>
	</div>
	-->
	<!-- 일단 주석처리 -->
	
	<div class="clear"></div>

	<div id="layer" style="visibility: hidden">
		<!-- visibility:hidden 으로 설정하여 해당 div안의 모든것들을 가려둔다. -->
		<div id="popup">
			<!-- 팝업창 닫기 버튼 -->



				<div class="alert" role="alert">
				<a href="javascript:" onClick="javascript:imagePopup('close', '.layer01');">
                			<img src="${contextPath}/resources/image/close.png" id="close" alt=""/>
                			</a>
                  <p> 장바구니에 담았습니다 </p> <br>
                   <a href="${contextPath}/cart/myCartList.do" class="alert-link"> 장바구니 바로가기</a>
                </div>
         </div>
         </div>
         
         <div class="replyModal">
	
		<div class="modalContent">
		  
			<div>
				<textarea class="modal_repCon" name="modal_repCon"></textarea>
			</div>
		  
			<div>
				<button type="button" class="modal_modify_btn">수정</button>
				<button type="button" class="modal_cancel">취소</button>
			</div>
	</div>
	
	<div class="modalBackground"></div>

</div>
	
<script>
//$(".modal_cancel").click(function(){
// $(".replyModal").fadeOut(300);//.attr("style", "display:none;");
//});
$(document).ready(function() {
  $(".modal_cancel").click(function() {
    $(".replyModal").fadeOut(300);
  });

  $(".modal_modify_btn").click(function() {
	  var modifyConfirm = confirm("정말로 수정하시겠습니까?");

	  if (modifyConfirm) {
	    var data = {
	      repNum: $(this).attr("data-repNum"),
	      repCon: $(".modal_repCon").val()
	    }; // ReplyVO 형태로 데이터 생성

	    $.ajax({
	      url: "/goods/modifyReply.do",
	      type: "post",
	      data: data,
	      success: function(result) {
	        if (result == 1) {
	          // 해당하는 댓글 내용 업데이트
	          var repNum = data.repNum;
	          var repCon = data.repCon;
	          $(".replyContent[data-repNum='" + repNum + "']").text(repCon);

	          $(".replyModal").fadeOut(300);
	        } else {
	          alert("작성자 본인만 할 수 있습니다.");
	        }
	      },
	      error: function() {
	        alert("로그인하셔야합니다.");
	      }
	    });
	  }
	});
});
</script>


</body>
</html>
<input type="hidden" name="isLogOn" id="isLogOn" value="${isLogOn}"/>