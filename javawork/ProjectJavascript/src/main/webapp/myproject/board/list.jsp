<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.data.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="board.data.BoardDao"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
	body{ background-color: e6f3ff;
	
	}
    body * {
        font-family: 'Jua';
    }
    
    a:link{/*초기 a링크에 적용*/
    	text-decoration: none;
    	color: black;
    }
    a:visited {/*한번이라도 클릭한 글에만 적용*/
		text-decoration: none;
		color: gray;
	}
	a:hover {/*a태그에 마우스를 올렸을때*/
		text-decoration: underline;
		color: blue;
	}
	
	.photoicon{
		font-size: 0.8em;
		color: gray;
	}
    div.simpleicon{
    	margin: 30px 100px;
    }
    
    div.simpleicon *{
    	cursor: pointer;
    	margin-right:30px;
    	font-size:30px;
    }
    
    div.list{
    	margin: 30px 50px;
    }
    
     div.box{
    	width:200px;
    	height: 270px;
    	text-align: center;
    	border-radius: 20px;
    	float: left;
    	margin-right: 30px;
    	margin-bottom: 20px;
    }
    
    div.box figure img{
    	height: 160px;
    	border-radius: 30px;
    	margin-top:5px;
    }
    
    .day{
    	color:gray;
    	font-size:0.8em;
    	margin-right:20px;
    }

	
</style>
<%
	//dao 선언
	BoardDao dao=new BoardDao();
	//전체 데이타 가져오기
	List<BoardDto> list=dao.getAllList();
	//날짜 형식
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.");
	
	
		
%>
<script type="text/javascript">
	$(function(){
		//처음 시작시 그리드모양 이미지형태로 출력하기
		//grid();
		
		list();
		
		$(".simplelist").css("color","red");
		
		$(".simplegrid").click(function(){
			$(this).css("color","red");
			$(".simplelist").css("color","black");
			grid();
		});
		
		$(".simplelist").click(function(){
			$(this).css("color","red");
			$(".simplegrid").css("color","black");
			list();
		});
		
		
		
		
			
	});
	
	function grid()
	{
		$.ajax({
			type:"get",
			dataType:"json",
			url:"simpletojson.jsp",
			success:function(res){
				let s="";
				$.each(res,function(idx,item){
					if(item.photo!='no'){
						s+=
							`
							<div class="container">
							<div class="box">
								<figure>
									<a href="content.jsp?num=\${item.num}">
										<img src="../../save/\${item.photo}" style="width : 170px">
										</a>
									<figcaption>
										<b>\${item.subject}</b><br>
										<span style="color:gray;">\${item.writer}</span>
										<br>
										<span class="day">\${item.writeday}
											&nbsp;&nbsp;&nbsp;
										조회 \${item.readcount}</span>
									</figcaption>
								</figure>
							</div>
							</div>
							`;
							
							
						
					
					}
				});
				$(".list").html(s);
		    },
			statusCode:{
				404:function(){
					alert("json 파일을 찾을수 없어요!");
				},
				500:function(){
				   alert("서버 오류..코드를 다시한버너 보세요");
				}
			}
		});
	}
	
	function list()
	{
				let s="";
					s+=
					`
						<div class= "container">
						<table class="table table-striped" style="width:80%;">
							<thead>
								<tr>
									<th width="50">번호</th>
									<th width="300">제목</th>
									<th width="80">작성자</th>
									<th width="100">작성일</th>
									<th width="70">조회</th>				
								</tr>
							</thead>
							<tbody>
							<%
							if(list.size()==0){%>
								<tr height="50">
									<td colspan="5" align="center">
										<h5>등록된 글이 없습니다</h5>
									</td>
								</tr>
							<%}else{
								int n=0;
								for(BoardDto dto:list)
								{

								%>
									<tr align="center">
										<td><%=list.size()-n++ %></td>
										<td align="left">
											<a href="content.jsp?num=<%=dto.getNum()%>">
												<%=dto.getSubject() %>
												<%
												if(!dto.getPhoto().equals("no")){%>
													<i class="bi bi-image photoicon"></i>
												<%}
												%>
											</a>
										</td>
										<td><%=dto.getWriter() %></td>
										<td><%=sdf.format(dto.getWriteday()) %></td>
										<td><%=dto.getReadcount() %></td>
									</tr>
								<%}
							}
							%>
							</tbody>
						</table>
						<button type="button" class="btn btn-success btn-sm"
							onclick="location.href='boardform.jsp'">글쓰기</button>
					</div>
					`;
				$(".list").html(s);
				}
</script>
</head>

<body>
	<div class="simpleicon">
		<i class="bi bi-grid simplegrid"></i>
		<i class="bi bi-card-list simplelist"></i>
		<h3 style="text-align: center;">Snack review</h3>
		<form action="">
		</form>
	</div style margis >
	<div class="list">
	</div>
</body>
</html>