<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="snb">
	<div>
		<a href="${contextPath}/admin/user">멤버관리</a>
	</div>
	<div>
		<a href="${contextPath}/admin/order">주문관리</a>
	</div>
	<div>
		<a href="${contextPath}/admin/item">재고관리</a>
	</div>
</nav>