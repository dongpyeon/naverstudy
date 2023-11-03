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
	Cookie []cookies= request.getCookies();
	boolean find=false;
	if(cookies!=null)
	{
		for(Cookie ck:cookies)
		{
			//저장된 쿠키 이름을 얻기
			String name=ck.getName();
			if(name.equals("loginok")){
				find=true;//해당 꾸키가 존재하면 true
			}
		}
	}
%>
<body>
<%
	if(!find){%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();
		</script>
		<%}else{%>
		<pre style="width: 400px;">
			몰라 기사 안 써 이 씨
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
		<%}
%>
</body>
</html>