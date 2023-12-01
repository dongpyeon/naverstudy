 <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Jua&family=Lobster&family=Nanum+Pen+Script&family=Permanent+Marker&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
   body * {
       font-family: 'Jua';
   }
  
</style>
</head>
<body>
<a href="/test"><h1>안녕 이 화면이 나오길 빌게</h1></a>
<a href = "/test/dig/dag">디그다그 링크로 이동해볼래??</a><br>
<a href = "test">테스트 컨트롤러 링크야</a><br>
<a href = "site/"> 여기는 사이트야</a>
<a href = "./board"> <h2>게시판 목록</h2> </a>
<a href = "/test/mypage"> 마이페이지 이동</a>
<a href = "/test/signup"> 회원가입</a>
<a href = "a/b/c/d/e/f/g"> 깊은 링크</a>


<div style="width: 200px; position: fixed; right: 50px; top: 30px;">
	<c:if test="${sessionScope.loginok==null }">
		<button type="button" class="btn btn-success"
		style="width: 100px;" onclick="location.href='/test/login'">로그인</button>
	</c:if>
	
	<c:if test="${sessionScope.loginok!=null }">
			<h5>${sessionScope.myname}님</h5>&nbsp;&nbsp;
			<button type="button" class="btn btn-success"
			style="width: 100px;" id="btnlogout" onclick="location.href='login/logout'">로그아웃</button>
	</c:if>
</div>

</body>
</html>