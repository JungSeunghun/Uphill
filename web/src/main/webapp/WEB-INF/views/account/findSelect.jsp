<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/account/findSelect.css">

<section>
	<div>
		<a href="${contextPath}/home/home"><img  id="logo" src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<div id="question">아이디 또는 비밀번호를 찾으시겠습니까?</div>
	<button type="button" onclick="location.href='${contextPath}/account/find-id'">아이디 찾기</button> 
	<button type="button" onclick="location.href='${contextPath}/account/find-password'">비밀번호 찾기</button> 
</section>