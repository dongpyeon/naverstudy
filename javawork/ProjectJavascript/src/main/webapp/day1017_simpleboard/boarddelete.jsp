<%@page import="simpleboard.data.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");

	SimpleBoardDao dao = new SimpleBoardDao();
	
	dao.deleteBoard(num);
	
	response.sendRedirect("list.jsp");
%>