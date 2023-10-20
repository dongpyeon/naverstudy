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
<%
request.setCharacterEncoding("UTF-8");
String myname = request.getParameter("myname");
String java = request.getParameter("java");
String jsp = request.getParameter("jsp");
String spring = request.getParameter("spring");
String hp1 = request.getParameter("hp1");
String hp2 = request.getParameter("hp2");
String fcolor = request.getParameter("fcolor");
String bcolor = request.getParameter("bcolor");
String hp= hp1+hp2;

int sum = 0;
double avg=0;
sum=Integer.parseInt(java)+Integer.parseInt(jsp)+Integer.parseInt(spring);
avg=sum/3.0;
%>
</head>
<body>
<div style="font-size: 22px; background-color: <%=bcolor%>; color:<%=fcolor%>">
이름 : <%=myname%> <br>
자바 점수 : <%=java %> <br>
jsp 점수 : <%=jsp %> <br>
스프링 점수 : <%=spring %> <br>
총점 : <%=sum %>점<br>
총점 : <%=avg %>점<br>
</div>
</body>
</html>