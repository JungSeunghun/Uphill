<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="/javascript/check.js"></script>
<script type="text/javaccript" src="/javascript/checkall.js"></script>
<section>
	<form action="/account/join2" name="f" method="post">
		<div>
			<img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white">
		</div>
		<div>
			<h2>본인인증</h2>
		</div>
		<div>
			<p>이름</p>
			<input type="text" name="user_name">
		</div>
		<div>
			<p>생년월일</p>
			<input type="date" name="birth">
			<!-- 자바스크립트 달력 나중에 구현하기 -->
			<%-- <select name="year" required="required">
				<c:forEach var="year" begin="1900" end="">
					<option value="${year }">${year }</option>
				</c:forEach>
			</select>
			<select name="month" required="required">
				<c:forEach var="month" begin="1" end="12">
					<option value="${month }">${month }</option>
				</c:forEach>
			</select>
			<select name="day" required="required">
				<c:forEach var="day" begin="1" end="">
					<option value="${day }">${day }</option>
				</c:forEach>
			</select> --%>
		</div>
		<div>
		 	<p>성별</p>
		 	<label><input type="radio" name="gender" value="M">남자</label>
		 	<label><input type="radio" name="gender" value="F">여자</label>
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
		 	<label>
		 		<input type="checkbox" name="selectall" value="모두 동의하기" onclick="">&nbsp;모두 동의하기
		 	</label><br/>
		 	<label>`
		 		<input type="checkbox" name="agree1" value="agree1">
		 		<a href="">개인 정보 수집 및 이용에 동의합니다</a>
		 	</label><br/>
		 	<label>
		 		<input type="checkbox" name="agree2" value="agree2">
		 		<a href="">고유식별 정보처리에 동의합니다.</a>
		 	</label><br/>
		 	<label>
		 		<input type="checkbox" name="agree3" value="agree3">
		 		<a href="">통신사 이용약관에 동의합니다</a>
		 	</label><br/>
		 	<label>
		 		<input type="checkbox" name="agree4" value="agree4">
		 		<a href="">이용약관에 동의합니다</a>
		 	</label><br/>
		</div>
		<div>
			<input type="submit" value="다음으로" onclick="checkJoin1()">
		</div>
	</form>
</section>