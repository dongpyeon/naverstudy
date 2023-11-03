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
    
    div.stuform{
		position: absolute;
		left:450px;
		top:100px;
		width:300px;
		height:260px;
		border:3px groove gray;
		padding:10px;	
	}
	
	div.box{
		width:350px;
		height: 110px;
		border:3px solid orange;
		border-radius: 30px;
		box-shadow:3px 3px 3px gray;
		padding:10px;
		margin-bottom:10px;
	}
</style>
<script>
	$(function(){
		//추가
		$("#addfrm").submit(function(e){
			//기본 이벤트 무효화
			e.preventDefault();
			//전체 데이타 폼단위로 읽기
			let formData=$(this).serialize();
			//alert(formData);
			$.ajax({
				type:"get",
				dataType:"html",
				url:"useradd.jsp",
				data:formData,
				success:function(res){
					//추가 성공후 로그인창으로
					alert("회원가입에 성공했습니다")
					//입력값 초기화
			    }
			});
			
		});		
	});
	

</script>	
</head>
<body>

	
	<div class="stuform">
		<form id="addfrm">
			<table class="table table-bordered">
				<tr>
					<th width="100">ID</th>
					<td>
						<input type="text" class="form-control"
						required autofocus name="id" id="name">
					</td>
				</tr>
				<tr>
					<th width="100">PassWord</th>
					<td>
						<input type="text" class="form-control"
						required name="passwd" id="phone">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-success">회원가입</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>