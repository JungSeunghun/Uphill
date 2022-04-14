<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="snb">
	<c:if test="${snb=='bicycle' }">
		<div>
			<a href="${contextPath}/item/bicycle">전체</a>
		</div>
		<div>
			<a href="${contextPath}/item/mtb">MTB</a>
		</div>
		<div>
			<a href="${contextPath}/item/road">Road</a>
		</div>
		<div>
			<a href="${contextPath}/item/minivelo">MiniVelo</a>
		</div>
	</c:if>
	<c:if test="${snb=='item' }">
		<div>
			<a href="${contextPath}/item/item">전체</a>
		</div>
		<div>
			<a href="${contextPath}/item/helmet">헬멧</a>
		</div>
		<div>
			<a href="${contextPath}/item/light">라이트</a>
		</div>
		<div>
			<a href="${contextPath}/item/lock">자물쇠</a>
		</div>
	</c:if>
	<c:if test="${snb=='user' }">
		<div>
			<a href="${contextPath}/user/basket">장바구니</a>
		</div>
		<div>
			<a href="${contextPath}/user/order">주문내역</a>
		</div>
		<div>
			<a href="${contextPath}/user/user-info">회원정보</a>
		</div>
		<div>
			<a href="${contextPath}/user/user-update">회원정보수정</a>
		</div>
	</c:if>
	<c:if test="${snb=='community' }">
		<div>
			<a href="${contextPath}/community/notice">공지사항</a>
		</div>
	</c:if>
</nav>