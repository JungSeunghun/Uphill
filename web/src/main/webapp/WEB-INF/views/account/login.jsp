<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/account/login.css">
<script type="text/javascript" src="${contextPath}/javascript/account/login.js"></script>

<section>
	<div id="loginTitle">
		<a href="${contextPath}/home/home"><img src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<div id="loginHello">
		<c:if test="${loginFail == null}">
			<c:if test="${join == null }">
				어서오세요.
			</c:if>
			<c:if test="${join == 'true' }">
				회원가입을 축하드립니다.
			</c:if>
			<c:if test="${join == 'false' }">
				회원가입을 실패했습니다.
			</c:if>
		</c:if>
		<c:if test="${loginFail != null}">
			<c:remove var="loginFail"/>
			아이디 또는 비밀번호를 틀렸습니다.
		</c:if>
		
	</div>
	<form action="${contextPath}/account/login-action" id="f" name="f" method="post">
		<div id="idForm">
			<div>아이디</div>
			<input type="text" id="userId" name="userId" value="${userEnterIdCookie }" maxlength="20"><br> 
			<div id="rememberIdForm">
				<input type="checkbox" id="rememberId" name="rememberId" ${rememberIdCookie }>
				<label for="rememberId"><span id="rememberIdText">아이디 저장</span></label>
			</div>
		</div>
		<div id="passwordForm">
			<div>비밀번호</div>
			<input type="password" id="userPassword" name="userPassword" maxlength="20"><br>
			<a href="${contextPath}/account/find-select">아이디 또는 비밀번호 찾기</a>
		</div>
		<button id="loginButton" onclick="loginCheck(); return false;">로그인</button>
	</form>
	<button id="joinButton" onclick="location.href='${contextPath}/account/join1'">회원가입</button>
</section>	
