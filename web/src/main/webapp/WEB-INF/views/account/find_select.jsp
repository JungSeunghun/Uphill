<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<section>
	<div>
		<img src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white">
	</div>
	<div>
		<h2>아이디 또는 비밀번호를 찾으시겠습니까?</h2>
	</div>
	<form name="f" method="post">
		<a href="${contextPath}/account/find-id">아이디 찾기</a> 
		<a href="${contextPath}/account/find-password">비밀번호 찾기</a>
	</form>
</section>