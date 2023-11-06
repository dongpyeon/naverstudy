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
	request.setCharacterEncoding("utf-8");
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
<form action="loginaction.jsp" method="post">
	<section class="vh-100" style="background-color: #3366ff;">
	  <div class="container py-5 h-100">
	    <div class="row d-flex justify-content-center align-items-center h-100">
	      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
	        <div class="card shadow-2-strong" style="border-radius: 1rem;">
	          <div class="card-body p-5 text-center">
	
	            <h3 class="mb-5">로그인</h3>
	
	            <div class="form-outline mb-4">
	              <input type="text" name="loginid" id="typeEmailX-2" name="loginid" autofocus required 
						placeholder="아이디" value="<%=loginid%>"
	              class="form-control form-control-lg" />
	              <label class="form-label" for="typeEmailX-2">ID</label>
	            </div>
	
	            <div class="form-outline mb-4">
	              <input type="password" id="typePasswordX-2" class="form-control form-control-lg" 
	              required	placeholder ="비밀번호"	 name="loginpass"/>
	              <label class="form-label" for="typePasswordX-2">Password</label>
	            </div>
	
	            <!-- Checkbox -->
	            <div class="form-check d-flex justify-content-start mb-4">
	              <input class="form-check-input" name="saveid" <%=bCheck?"checked":""%> type="checkbox" value="" id="form1Example3" />
	              <label class="form-check-label" for="form1Example3"> Remember id </label>
	            </div>
	
	            <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
	
	            <hr class="my-4">
	            
	            계정이 없나요? <a href="signupform.jsp">회원가입</a> 
	            
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
</form>
</body>
</html>