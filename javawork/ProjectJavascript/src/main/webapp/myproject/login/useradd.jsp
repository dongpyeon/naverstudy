<%@page import="user.data.UserDto"%>
<%@page import="user.data.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	//dao
	UserDao dao = new UserDao();
	//dto
	UserDto dto = new UserDto();
	dto.setId(id);
	dto.setPasswd(passwd);
	
	//insert
	dao.insertUser(dto);
%>