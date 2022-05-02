<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="snb">
	<div>
		<a href="${contextPath}/community/notice">공지사항</a>
	</div>
	<div>
		<a href="${contextPath}/community/road">산책로</a>
	</div>
</nav>