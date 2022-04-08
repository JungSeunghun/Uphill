<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="/css/account/join1.css">
<script type="text/javascript" src="/javascript/account/join1.js"></script>

<section>
	<div id="joinTitle">
		<a href="/home/home"><img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<div id="joinForm">
		<form action="/account/join2" name="f" method="post">
			<div id="joinFormTitle">본인인증</div>
			<div id="joinFormDiv">
				<div id="joinFormDivTitle">이름</div>
				<input type="text" name="userName">
			</div>
			<div id="joinFormDiv">
				<div id="joinFormDivTitle">생년월일</div>
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
			<div id="joinFormDiv">
			 	<div id="joinFormDivTitle">성별</div>
			 	<label><input type="radio" name="gender" value="M">남자</label>
			 	<label><input type="radio" name="gender" value="F">여자</label>
			</div>
			<div id="joinFormDiv">
			 	<div id="joinFormDivTitle">이동통신사</div>
			 	<label><input type="radio" name="mobileCarrier" value="SKT">SKT</label>
			 	<label><input type="radio" name="mobileCarrier" value="KT">KT</label>
			 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+</label>
			 	<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰</label>
			</div>
			<div id="joinFormDiv">
				<div id="joinFormDivTitle">전화번호</div>
				<select name="firstPhoneNumber">
					<option value="010">010</option>
					<option value="011">011</option>
				</select>
				<input type="text" name="middlePhoneNumber" maxlength="4" onkeydown="moveNumber(event)">
				<input type="text" name="lastPhoneNumber" maxlength="4" onkeydown="moveNumber(event)">
			</div>
			<div id="joinFormDiv">
				<label>
			 		<input type="checkbox" name="agree" onclick="agreeAll();">모두 동의하기
				</label>
				<br>	 	
		 		<input type="checkbox" name="personalAgree" value="personalAgree">
		 		<a href="">개인 정보 수집 및 이용에 동의합니다.</a>
		 		<br>
		 		<input type="checkbox" name="uniqueAgree" value="uniqueAgree">
		 		<a href="">고유식별 정보처리에 동의합니다.</a>
		 		<br>
		 		<input type="checkbox" name="mobileAgree" value="mobileAgree">
		 		<a href="">통신사 이용약관에 동의합니다.</a>
		 		<br>
		 		<input type="checkbox" name="useAgree" value="useAgree">
		 		<a href="">이용약관에 동의합니다.</a>
			</div>
			<button onclick="checkJoin1(); return false;">다음으로</button>
		</form>
	</div>
</section>