<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/account/findIdResult.css">

<section>
	<div>
		<a href="${contextPath}/home/home"><img id="logo" src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	
	<div id="answer">
		<c:if test="${findPassword == true }">
			이메일로 비밀번호를 전송했습니다.
		</c:if>
		<c:if test="${findPassword == false || findPassword == null}">
			존재하지 않는 회원입니다.
		</c:if>
	</div>
	
	<button type="button" onclick="location.href='${contextPath }/account/login'">로그인</button>
	<button type="button" onclick="history.back();">이전으로</button>

</section>