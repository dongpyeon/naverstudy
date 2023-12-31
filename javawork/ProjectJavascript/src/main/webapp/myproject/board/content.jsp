<%@page import="board.data.BoardDao"%>
<%@page import="board.data.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
    body * {
        font-family: 'Jua';
    }
    
    span.day{
    	font-size: 14px;
    	color: gray;    	
    }
</style>
<script type="text/javascript">
 $(function(){

 });
</script>
</head>
<%
	//num 읽기
	String num=request.getParameter("num");
	//dao 선언
	BoardDao dao=new BoardDao();
	//조회수 증가
	dao.updateReadcount(num);
	//num 에 해당하는 dto 얻기
	BoardDto dto=dao.getData(num);
	//날짜 출력 양식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	String loginok=(String)session.getAttribute("loginok");	
	
	if(loginok==null)
	{%>
		<script type="text/javascript">
		alert("로그인 후 이용 가능합니다.");
		history.back();
		</script>
	<%}
	
%>
<body>
 <div style="margin: 30px 50px">
 	<table class="table table-bordered" style="width: 500px;">
 		<tr>
 			<h2><b><%=dto.getSubject() %></b></h2>
 			<span><b><%=dto.getWriter() %></b></span>
 			&nbsp;&nbsp;
 			<span class="day">
 				<%=sdf.format(dto.getWriteday()) %>
 				&nbsp;
 				조회&nbsp;<%=dto.getReadcount() %>
 			</span>
 		</tr>
 		<tr height="300" valign="top">
 			<td>
 				<!-- 여러줄일경우 replace 로 \n을 <br>로 변경하거나
 				아니면 <pre> 태그로 출력으르 해야만 줄넘김이 된다 -->
 				<%=dto.getContent().replace("\n", "<br>")%>
 				<br><br>
 				<%
 				if(!dto.getPhoto().equals("no"))
 				{%>
 					<img src="../../save/<%=dto.getPhoto()%>" 
 					style="max-width: 300px;">
 				<%}
 				%>
 			</td>
 		</tr>
 		<tr>
 		</tr>
 		<tr>
 			<td align="center">
 				<button type="button" class="btn btn-outline-success"
 				style="width: 100px;" onclick="location.href='boardform.jsp'">글쓰기</button>
 				
 				<button type="button" class="btn btn-outline-success"
 				style="width: 100px;" onclick="location.href='main.jsp'">목록</button>
 				
 				<form name="change" style=" float:left;" action="./updateform.jsp?num=<%=dto.getNum()%>">
	    			<input type="hidden" name="writer" value="<%=dto.getWriter()%>" >
	    			<input type="hidden" name="num" value="<%=dto.getNum()%>" >
	    
	    			<input type="submit" class="btn btn-outline-warning" value="수정" style="width: 100px"; >
				</form>
 				
 				<form name="del" style=" float:left;" action="./boarddelete.jsp?num=<%=dto.getNum()%>">
	    			<input type="hidden" name="writer" value="<%=dto.getWriter()%>" >
	    			<input type="hidden" name="num" value="<%=dto.getNum()%>" >
	    			<input type="submit" class="btn btn-outline-danger" value="삭제" style="width: 100px"; >
				</form>
 			</td>
 		</tr>
 	</table>
 </div>

 <div>

</div>

</body>
</html>