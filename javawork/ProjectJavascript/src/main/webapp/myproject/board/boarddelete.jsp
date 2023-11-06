<%@page import="board.data.BoardDto"%>
<%@page import="board.data.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	BoardDao dao = new BoardDao();
	String num = request.getParameter("num");
	String writer = request.getParameter("writer");
	String loginid=(String)session.getAttribute("loginid");
	
	if(loginid.equals(writer)||loginid.equals("admin"))
	{
		dao.deleteBoard(num);
		response.sendRedirect("main.jsp");
	}
	else{
		%>
		<script type="text/javascript">
		alert("게시글 작성자만 삭제할 수 있습니다.");
		history.back()
		</script>
		<%
	}
%>