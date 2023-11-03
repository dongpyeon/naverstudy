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
		서울=뉴시스] 황준선 기자 = 대통령실 정문에서 흉기를 휘둘러 경찰관 2명을 다치게 한 70대 남성 A 씨가 2일 오전 서울 마포구 서울서부지방법원에서 열린 영장실질심사(구속 전 피의자 심문)에 출석하고 있다. 2023.11.02. hwang@newsis.com

		[사진 영상 제보받습니다] 공감언론 뉴시스가 독자 여러분의 소중한 제보를 기다립니다. 뉴스 가치나 화제성이 있다고 판단되는 사진 또는 영상을 뉴시스 사진영상부(n-photo@newsis.com)로 보내주시면 적극 반영하겠습니다.
		</pre>
		<br><br>
		<a href="loginmain.jsp">메인페이지로 이동</a>
		<%}
%>
</body>
</html>