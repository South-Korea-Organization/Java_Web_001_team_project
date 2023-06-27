<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	 isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<c:if test='${not empty message }'>
<script>
window.onload=function()
{
  result();
}

function result(){
	alert("아이디나  비밀번호가 틀립니다. 다시 로그인해주세요");
}
</script>
</c:if>
</head>
<body>
<div style="margin: 0 auto;	max-width:500px;">
        <div class="tab-content" id="loginTabContents">
            <div class="tab-pane fade show active" id="login-content" role="tabpanel">
                <form method="POST" action="${contextPath}/member/login.do">
                    <input type="hidden" name="_token" value="oM00jfHYsNLRFmpJ2NirOyWTyEUIJOBRfSCoThnw">
                    <BR>
                    <div class="shadow p-3 mb-5 bg-white rounded text-secondary text-center display-4 font-italic">STEPLANT</div>
					<br><br>

                    <div class="form-group col-md-6">
                        <input id="userid" type="text"
                               class="form-control"
                               name="member_id" value="" required autocomplete="userid" autofocus
                               placeholder="아이디">
                    </div>

                    <div class="form-group col-md-6">
                        <input id="password" type="password"
                               class="form-control "
                               name="member_pw" required autocomplete="current-password"
                               placeholder="패스워드">
                    </div>
                    <div class="row login-options">
                        <div class="col-6 text-left">
                            <div class="custom-control custom-checkbox">
                                <input class="custom-control-input" type="checkbox" name="remember" id="remember" >
                                <label class="custom-control-label" for="remember" style="color:rgb(0,0,0)">아이디 저장</label>
                            </div>
                        </div>
                        <div class="col-6 text-right">
                            <a href="#">아이디/비밀번호 찾기&nbsp;&nbsp;</a>
                        </div>
                    </div>
                    <br>
                   
				<div class="row">
                    <div class="form-group col-md-3">
                        <button type="submit" class="form-control btn btn-md btn-primary">로그인</button>
                    </div>
                    <div class="form-group col-md-3">
                        <a href="${contextPath}/member/memberForm.do" class="btn btn-outline-primary btn-md active" role="button" aria-pressed="true">회원가입</a>
					</div>
				</div>
         </div>
	<%-- <H3>회원 로그인 창</H3>
	<DIV id="detail_table">
	<form action="${contextPath}/member/login.do" method="post">
		<TABLE>
			<TBODY>
				<TR class="dot_line">
					<TD class="fixed_join" style=color:"black">아이디</TD>
					<TD><input name="member_id" type="text" size="20" /></TD>
					
				</TR>
				<TR class="solid_line">
					<TD class="fixed_join" style=color:"black">비밀번호</TD>
					<TD><input name="member_pw" type="password" size="20" /></TD>
				</TR>
			</TBODY>
		</TABLE>
		<br><br>
		<INPUT	type="submit" value="로그인" style> 
		<INPUT type="button" value="초기화">
		 --%>
		<Br><br>


					   
	</form>		
</body>
</html>