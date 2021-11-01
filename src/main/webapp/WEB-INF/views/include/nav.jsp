<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<ul>
<c:if test="${member == null}">
	<li>
		<a href="/member/signin">LogIn</a>
	</li>
	<li>
		<a href="/member/signup">Join</a>
	</li>
</c:if>
<c:if test="${member != null}">
	<c:if test="${member.verify == 9}">
	<li>
		<a href="/admin/index">Admin</a>	
	</li>
	</c:if>
	<li>
		${member.userName}님 환영합니다🙇
	</li>
	<li>
		<a href="/shop/cartList">Cart</a>
	</li>
	<li>
		<a href="/shop/orderList">OrderList</a>
	</li>		
	<li>
		<a href="/member/signout">LogOut</a>
	</li>
</c:if>

</ul>