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
	String savestatus=(String)session.getAttribute("savestatus");//업을 경우 null
	String loginid=(String)session.getAttribute("loginid");//업을 경우 null
	boolean bCheck=false;
	if(savestatus==null || savestatus.equals("no")){
		bCheck=false;
	}else{
		bCheck=true;
	}
	
	//체크를 안했을 경우는 아이디를 없앤다
	if(!bCheck) loginid="";
%>
<body>
<div style="margin: 30px 100px;">
	<form action="signupaction.jsp" method="post">
		<table class="table table-bordered" style="width: 200px; border:5px groove gray; ">
			<caption align="top">
				<label><input type="checkbox" name="saveid"
				<%=bCheck?"checked":""%>>아이디저장</label>
				
			</caption>
			<tr>
				<td width="150">
					<input type="text" name="id" class="form-control" autofocus required 
					placeholder="아이디" value="<%=loginid%>">
				</td>
				<td rowspan="2" width="100">
					<button type="submit" style="width: 100%; height: 100px;">회원가입</button>		
				</td>
			</tr>
			<tr>
			<td width="150">
				<input type="password" class="form-control" required
				placeholder ="비밀번호"	 name="passwd">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>