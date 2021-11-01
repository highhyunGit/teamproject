<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.weaver.service.*" %>
<%@ page import="com.weaver.dto.*" %>
<%@ page import="com.weaver.dao.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search roadname address</title>
<link rel="icon" href="http://localhost/resources/favicon.ico">
	<script>
		function clickAddr(clicked_id){
			btnId = clicked_id
		}
	</script>

	<script>
		function setParentText() {
			opener.document.getElementById("userAddr1").value = document.getElementById(btnId).value;
			opener.document.getElementById("userAddr2").value = document.getElementById(btnId).name;
			// 데이터 전달 후 팝업창이 닫힘.
			window.close();
		}
	</script>
	
	<style>
		.addrBtn { all:unset; }
		.addrBtn:hover { background-color: #fff; border-color: #59b1eb; color: #59b1eb; }
	</style>
</head>
<body>
	<h2>도로명주소 검색</h2>
	<hr>
	
	<form role="form" method="post" autocomplete="off">
		<table>
			<tr>
				<td>
					<input type="text" name="addr" placeholder="도로명주소">
					<input type="submit" value="검색하기">
				</td>
			</tr>
		</table>
		<table>
			<c:forEach items="${list}" var="list" varStatus="listStatus">
			<tr>
				<td>
					<button type="button" onclick="clickAddr(this.id); setParentText();" value = "${list.zipcode}" name = "${list.addr}" id="${listStatus.index}" class="addrBtn">
						<span>${list.zipcode}</span>
						<span>${list.addr}</span>
					</button>
				</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>