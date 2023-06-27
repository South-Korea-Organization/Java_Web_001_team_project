<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="root">
	 <header>
	  <h1>공지사항</h1>
	 </header>
	
	<hr />
	 
	 <nav>
	  처음화면 - 글쓰기 - 로그인
	 </nav>
	
	<hr />
	
	 <section id="container">
	 
	  <form role="form" method="post" autocomplete="off">
	   <p>
	    <label for="title">글 제목</label><input type="text" id="title" name="title" />
	   </p>
	   <p>
	    <label for="content">글 내용</label><textarea id="content" name="content"></textarea>
	   </p>
	   <p>
	    <label for="riter">작성자</label><input type="text" id="writer" name="writer" />
	   </p>
	   <p>
	    <a href="${contextPath}/notice/write.do">작성</a>
	   </p>  
	  </form>
	
	 </section>
	
	<hr />
	
	 <footer>
	  <p>만든이 : kuzuro</p>  
	 </footer>
	
	</div>
</body>
</html>