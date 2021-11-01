<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="icon" href="http://localhost/resources/favicon.ico">png"/>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>
	
<style>
	body { font-family:'맑은 고딕', verdana; padding:0; margin:0; }
	ul { padding:0; margin:0; list-style:none;  }
 
	div#root { width:90%; margin:0 auto; }
	
	header#header { font-size:60px; padding:20px 0; }
	header#header h1 a { color:#000; font-weight:bold; }
	
	nav#nav { padding:10px; text-align:right; }
	nav#nav ul li { display:inline-block; margin-left:10px; }
 
 		section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	aside { float:left; width:200px; }
	div#container_box { float:right; width:calc(100% - 200px - 20px); }
	
	aside ul li { text-align:center; margin-bottom:10px; }
	aside ul li a { display:block; width:100%; padding:10px 0;}
	aside ul li a:hover { background:#eee; }
	
	footer#footer { background:#f9f9f9; padding:20px; }
	footer#footer ul li { display:inline-block; margin-right:10px; } 
</style>

<style>
	.inputArea { margin:10px 0; }
	select { width:100px; }
	label { display:inline-block; width:80px; padding:5px; }
	label[for='expDes'] { display:block; }
	input { width:150px; }
	textarea#expDes { width:400px; height:180px; }
	
	.oriImg { width:500px; height:auto; }
	.thumbImg {}
	
	.expDes img { max-width:600px; height:auto; }
</style>
</head>
<body>
	<div id = "root">
		<header id = "header">
			<div id = "header_box">
				<%@ include file = "../include/header.jsp" %>
			</div>
		</header>
		
		<nav id = "nav">
			<div id = "nav_box">
				<%@ include file = "../include/nav.jsp" %>
			</div>
		</nav>

		<section id = "container">
			<aside>
				<%@ include file = "../include/aside.jsp" %>
			</aside>
			<div id = "container_box">
				<h2>체험 조회</h2>
				
				<form role = "form" method = "post" autocomplete = "off">
				<input type = "hidden" name = "n" value = "${dto.expNum}" />
					<div class = "inputArea">
						<label for = "expName">체험명</label>
						<span>${dto.expName}</span>
					</div>
					
					<div class = "inputArea">
						<label for = "expPrice">체험가격</label>
						<span><fmt:formatNumber value = "${dto.expPrice}" pattern = "###,###,###" /></span>
					</div>
					
					<div class = "inputArea">
						<label for = "expDes">체험소개</label>
						<div class = "expDes">${dto.expDes}</div>
					</div>
					
					<div class = "inputArea">
						<label for = "expImg">체험이미지</label>
						<p>원본 이미지</p>
						<img src = "${dto.expImg}" class = "oriImg" />
						
						<p>썸네일</p>
						<img src = "${dto.expThumbImg}" class = "thumbImg" />
					</div>
					
					<div class = "inputArea">
						<button type = "button" id = "modify_btn" class = "btn btn-warning">수정</button>
						<button type = "button" id = "delete_btn" class = "btn btn-danger">삭제</button>
						
						<script>
							var formObj = $("form[role='form']");
							
							$("#modify_btn").click(function(){
								formObj.attr("action", "/admin/exp/modify");
								formObj.attr("method", "get")
								formObj.submit();
							});
							
							$("#delete_btn").click(function(){
								var con = confirm("정말로 삭제하시겠습니까?");
								
								if(con) {
									formObj.attr("action", "/admin/exp/delete");
									formObj.submit();
								}
							});
						</script>
					</div>
				</form>
			</div>				
		</section>
		
		<footer id = "footer">
			<div id = "footer_box">
				<%@ include file = "../include/footer.jsp" %>
			</div>
		</footer>
	</div>
</body>
</html>