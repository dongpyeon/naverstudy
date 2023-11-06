<%@page import="user.data.UserDao"%>
<%@page import="user.data.UserDto"%>
<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//아이디와 비번을 읽는다
	String id=request.getParameter("loginid");
	String pass=request.getParameter("loginpass");
	String saveid=request.getParameter("saveid"); //체크를 안할경우 null
	
	//dto선언 객체에 아디 비번 저장
	UserDto dto = new UserDto();
	dto.setId(id);
	dto.setPasswd(pass);
	
	UserDao dao = new UserDao();
	boolean check = dao.checkUser(dto);
	
	//비번이 1234면 각종 정보를 세션에 저장한다
	if(check){
		//세션에 저장
		session.setAttribute("loginok", id);
		session.setAttribute("loginid", id);
		session.setAttribute("savestatus", saveid==null?"no":"yes");
		//유지 시간 지정
		session.setMaxInactiveInterval(60*60);
		//메인 페이지로 이동
		response.sendRedirect("loginmain.jsp");
	}else{%>
		<script type="text/javascript">
			alert("아이디 또는 비밀번호가 일치하지 않습니다");
			history.back();
		</script>
<%}%>