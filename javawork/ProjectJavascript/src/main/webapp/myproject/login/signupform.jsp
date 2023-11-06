<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%request.setCharacterEncoding("utf-8"); %>
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
<body>
<div>
	<form action="signupaction.jsp" method="post">
		<section class="vh-100" style="background-color: #ff5050;">
		  <div class="container py-5 h-100">
		    <div class="row d-flex justify-content-center align-items-center h-100">
		      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
		        <div class="card shadow-2-strong" style="border-radius: 1rem;">
		          <div class="card-body p-5 text-center">
		            <h3 class="mb-5">회원가입</h3>
		            <div class="form-outline mb-4">
		              <input type="text" name="id" id="typeEmailX-2" name="id" autofocus required 
							placeholder="아이디"
		              class="form-control form-control-lg" />
		              <label class="form-label" for="typeEmailX-2">ID</label>
		            </div>
		
		            <div class="form-outline mb-4">
		              <input type="password" id="typePasswordX-2" class="form-control form-control-lg" 
		              required	placeholder ="비밀번호"	 name="passwd"/>
		              <label class="form-label" for="typePasswordX-2">Password</label>
		            </div>
		            <button class="btn btn-primary btn-lg btn-block" type="submit">회원가입</button>
		
		            <hr class="my-4">
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>
	</form>
</div>
</body>
</html>