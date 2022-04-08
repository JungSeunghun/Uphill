<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<section>
	<div>
		<a href="${contextPath}/home/home"><img src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<form action="/account/find-password-action" name="" method="post">
		<div>
			<h2>비밀번호 찾기</h2>
		</div>
		<div>
			<p>아이디</p>
			<input type="text" name="user_id">
		</div>
		<div>
			<p>이름</p>
			<input type="text" name="user_name">
		</div>
		<div>
			<p>생년월일</p>
			<input type="date" name="birth">				
		</div>
		<div>
		 	<p>이동통신사</p>
		 	<label><input type="radio" name="mobile_carrier" value="skt">SKT</label>
		 	<label><input type="radio" name="mobile_carrier" value="kt">KT</label>
		 	<label><input type="radio" name="mobile_carrier" value="lgu+">LGU+</label>
		 	<label><input type="radio" name="mobile_carrier" value="알뜰폰">알뜰폰</label>
		</div>
		<div>
			<p>전화번호</p>
			<select name="phone_number1">
			<option>010</option>
			<option>011</option>
		</select>
		<input type="text" name="phone_number2" maxlength="4">
		<input type="text" name="phone_number3" maxlength="4">
		</div>
		<div>				
			<p>이메일</p>
			<input type="text" name="email" size="">@
			<select name="email">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="gmail.com">gmail.com</option>
			</select>
		</div>
		<div>
			<input type="submit" value="비밀번호 찾기">
		</div>
	</form>
</section>