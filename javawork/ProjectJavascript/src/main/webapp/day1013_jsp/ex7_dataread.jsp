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
	request.setCharacterEncoding("utf-8");

	String []lang=request.getParameterValues("lang");
	String []hobby=request.getParameterValues("hobby");
%>
<body>
<h5>
	구현 가능 언어 개수 : <%=lang==null? 0:lang.length %><br>
	<% 
	if(lang!=null){
		for(String it:lang){%>
		<b style="margin-left: 100px; color: red;"><%=it%></b><br>
		<%} 
	}%>
	<hr>
	
	선택한 취미 개수 : <%=lang==null? 0:hobby.length %><br>
	<% 
	if(hobby!=null){
		for(String item : hobby){%>
		<b style="margin-left: 100px; color: blue;"><%=item %></b><br>
		<%}
	}%>
	

</h5>
</body>
</html>