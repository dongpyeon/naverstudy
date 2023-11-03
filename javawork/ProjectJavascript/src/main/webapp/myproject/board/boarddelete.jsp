<%@page import="board.data.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");

	BoardDao dao = new BoardDao();
	
	dao.deleteBoard(num);
	
	response.sendRedirect("list.jsp");
%>