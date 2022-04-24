<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="snb">
	
	<div>
		<a href="${contextPath}/user/basket">장바구니</a>
	</div>
	<div>
		<a href="${contextPath}/user/order-list">주문내역</a>
	</div>
	<div>
		<a href="${contextPath}/user/user-info">회원정보</a>
	</div>
	<div>
		<a href="${contextPath}/user/user-update">회원정보수정</a>
	</div>

</nav>