<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="snb">
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
</nav>