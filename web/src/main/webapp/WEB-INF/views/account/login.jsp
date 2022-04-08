<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<link rel="stylesheet" type="text/css" href="/css/account/login.css">
<script type="text/javascript" src="/javascript/account/login.js"></script>

<section>
	<div id="loginTitle">
		<a href="/home/home"><img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<div id="loginHello">
		<c:if test="${loginFail == null}">
			어서오세요.
		</c:if>
		<c:if test="${loginFail != null}">
			<c:remove var="loginFail"/>
			아이디 또는 비밀번호를 틀렸습니다.
		</c:if>
	</div>
	<div id="loginForm">
		<form action="/account/login-action" name="f" method="post">
			<div id="idForm">
				<div>아이디</div>
				<input type="text" id="userEnterId" name="userEnterId" value="${userEnterIdCookie }" maxlength="20"><br> 
				<div id="rememberIdForm">
					<input type="checkbox" id="rememberId" name="rememberId" ${rememberIdCookie }>
					<label for="rememberId"><span id="rememberIdText">아이디 저장</span></label>
				</div>
			</div>
			<div id="passwordForm">
				<div>비밀번호</div>
				<input type="password" id="userPassword" name="userPassword" maxlength="20"><br>
				<a href="/account/find-select">아이디 또는 비밀번호 찾기</a>
			</div>
			<button id="loginButton" onclick="loginCheck(); return false;">로그인</button>
		</form>
	</div>
	<button id="joinButton" onclick="location.href='/account/join1'">회원가입</button>
</section>	
