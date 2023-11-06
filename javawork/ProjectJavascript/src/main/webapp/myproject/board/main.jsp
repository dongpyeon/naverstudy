<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
	String loginok=(String)session.getAttribute("loginok");//업을 경우 null
%>
<body>
	<%
	if(loginok==null){%>
		<div class="input-group" style="width:400px; float: right;">
		<button type="button" class="btn btn-success"
		style="width: 100px;"
		onclick="location.href='../login/loginform.jsp'">로그인</button>
		</div>
		
	<%}else{%>
		<div class="input-group" style="width:400px; float: right;">
		<%=loginok %>님 환영합니다 <button type="button" class="btn btn-danger"
		style="width: 100px;"
		onclick="location.href='../login/logoutaction.jsp'">로그아웃</button>
		</div>
		
	<%}
	%>
<jsp:include page="list.jsp"/>
</body>
</html>