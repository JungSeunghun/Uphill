<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="snb">
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
</nav>