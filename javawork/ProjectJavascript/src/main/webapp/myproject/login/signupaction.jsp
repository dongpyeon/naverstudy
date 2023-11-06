<%@page import="user.data.UserDto"%>
<%@page import="user.data.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	//dao
	UserDao dao = new UserDao();
	//dto
	UserDto dto = new UserDto();
	dto.setId(id);
	dto.setPasswd(passwd);
	
	boolean check =dao.checkId(dto);
	if(check)
	{
	%>
	<script>
		alert("중복된 아이디가 있습니다")
		history.back();
	</script>
	<%
	}
	else{
		dao.insertUser(dto);
		%>
		<script>
		alert("회원가입에 성공했습니다 로그인 해주세요")
		location.href = "./loginmain.jsp";
		</script>
	<%}%>