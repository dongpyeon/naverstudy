<%@page import="javax.print.attribute.HashPrintRequestAttributeSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//아이디와 비번을 읽는다
	String loginid=request.getParameter("loginid");
	String loginpass=request.getParameter("loginpass");
	String saveid=request.getParameter("saveid"); //체크를 안할경우 null
	//비번이 1234면 각종 정보를 세션에 저장한다
	if(loginpass.equals("1234")){
		//세션에 저장
		session.setAttribute("loginok", "yes");
		session.setAttribute("loginid", loginid);
		session.setAttribute("savestatus", saveid==null?"no":"yes");
		//유지 시간 지정
		session.setMaxInactiveInterval(60*60);
		//메인 페이지로 이동
		response.sendRedirect("loginmain.jsp");
	}else{%>
		<script type="text/javascript">
			alert("비밀번호가 맞지 않습니다");
			history.back();
		</script>
<%}%>