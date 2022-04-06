<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<script type="text/javascript" src="/javascript/account/login.js"></script>

<section>
	<div>
		<img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white">
	</div>
	<div>
		<c:if test="${loginFail == null}">
			<h2>어서오세요</h2>
		</c:if>
		<c:if test="${loginFail != null}">
			<h2>아이디 또는 비밀번호를 틀렸습니다.</h2>
		</c:if>
	</div>
	<div>
		<form action="/account/login-action" name="f" method="post">
			<div>
				<p>아이디</p>
				<input type="text" name="userEnterId" value="${userEnterIdCookie }" maxlength="20"> 
				<label><input type="checkbox" name="rememberId" ${rememberIdCookie }>아이디 저장</label>
			</div>
			<div>
				<p>비밀번호</p>
				<input type="password" name="userPassword" maxlength="20"> 
				<a href="/account/find-select">아이디 또는 비밀번호 찾기</a>
			</div>
			<div>
				<input type="submit" value="로그인" onclick="loginCheck(); return false;">
			</div>
		</form>
	</div>
	<div>
		<a href="/account/join1">회원가입</a>
	</div>
</section>	
