<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
<link rel="icon" href="http://localhost/resources/favicon.ico">
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="/resources/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/resources/bootstrap/bootstrap-theme.min.css">
<script src="/resources/bootstrap/bootstrap.min.js"></script>

<script src="/resources/ckeditor/ckeditor.js"></script>
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
	
	.select_img img { width:500px; margin:20px 0; }
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
				<h2>체험 수정</h2>
				
				<form role = "form" method = "post" autocomplete = "off" enctype = "multipart/form-data">
				<input type = "hidden" name = "expNum" value = "${dto.expNum}" />
					<div class = "inputArea">
						<label for = "expName">체험명</label>
						<input type = "text" id = "expName" name = "expName" value = "${dto.expName}" />
					</div>
					
					<div class = "inputArea">
						<label for = "expPrice">체험가격</label>
						<input type = "text" id = "expPrice" name = "expPrice" value = "${dto.expPrice}" />
					</div>
					
					<div class = "inputArea">
						<label for = "expDes">체험소개</label>
						<textarea rows = "5" cols = "50" id = "expDes" name = "expDes">${dto.expDes}</textarea>
						
						<script>
							var ckeditor_config = {
									resize_enaled : false,
									enterMode : CKEDITOR.ENTER_BP,
									shiftEnterMode : CKEDITOR.ENTER_P,
									filebrowserUploadUrl : "/admin/exp/ckUpload"
							};
							
							CKEDITOR.replace("expDes", ckeditor_config);
						</script>
					</div>
					
					<div class = "inputArea">
						<label for = "expImg">체험이미지</label>
						<input type = "file" id = "expImg" name = "file" />
						<div class = "select_img">
							<img src = "${dto.expImg}" />
							<input type = "hidden" name = "expImg" value = "${dto.expImg}" />
							<input type = "hidden" name = "expThumbImg" value = "${dto.expThumbImg}" />
						</div>
						
						<script>
							$("#expImg").change(function(){
								if(this.files && this.files[0]) {
									var reader = new FileReader;
									reader.onload = function(data) {
										$(".select_img img").attr("src", data.target.result).width(500);
									}
									reader.readAsDataURL(this.files[0]);
								}
							});
						</script>
						
						<%= request.getRealPath("/") %>
						
					</div>
					
					<div class = "inputArea">
						<button type = "submit" id = "update_btn" class = "btn btn-primary">완료</button>
						<button type = "button" id = "cancel_btn" class = "btn btn-warning">취소</button>
						
						<script>
							$("#cancel_btn").click(function(){
								location.href = "/admin/exp/view?n=" + ${dto.expNum};
							})
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
	<script>
	// 정규표현식을 의미함.
	var regExp = /[^0-9]/gi;
	
	$("#expPrice").keyup(function(){
		numCheck($(this));
	});
	
	function numCheck(selector) {
		var tempVal = selector.val();
		selector.val(tempVal.replace(regExp, ""));
	}
	</script>	
</body>
</html>