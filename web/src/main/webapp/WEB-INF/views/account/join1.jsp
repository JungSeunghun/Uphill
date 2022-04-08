<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/account/join1.css">
<script type="text/javascript" src="${contextPath}/javascript/account/join1.js" ></script>

<section>
	<div id="joinTitle">
		<a href="${contextPath}/home/home"><img src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<form action="/account/join2" id="f" name="f" method="post">
		<div id="joinFormTitle">본인인증</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">이름</div>
			<input type="text" name="userName">
		</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">생년월일</div>
			<select name="year" onchange="getDate();"></select>&nbsp;년&nbsp;&nbsp;
			<select name="month" onchange="getDate();"></select>&nbsp;월&nbsp;&nbsp;
			<select name="day"></select>&nbsp;일
		</div>
		<div id="joinFormDiv">
		 	<div id="joinFormDivTitle">성별</div>
		 	<label><input type="radio" name="gender" value="M">남자</label>
		 	<label><input type="radio" name="gender" value="F">여자</label>
		</div>
		<div id="joinFormDiv">
		 	<div id="joinFormDivTitle">이동통신사</div>
		 	<label><input type="radio" id="skt" name="mobileCarrier" value="SKT">SKT</label>
		 	&nbsp;&nbsp;
		 	<label><input type="radio" id="kt" name="mobileCarrier" value="KT">KT</label>
		 	&nbsp;&nbsp;
		 	<label><input type="radio" id="lg" name="mobileCarrier" value="LGU+">LGU+</label>
		 	&nbsp;&nbsp;
		 	<label><input type="radio" id="other" name="mobileCarrier" value="알뜰폰">알뜰폰</label>
		</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">전화번호</div>
			<select name="firstPhoneNumber">
				<option value="010">010</option>
				<option value="011">011</option>
			</select> -
			<input type="text" name="middlePhoneNumber" maxlength="4" onkeydown="moveNumber(event)"> -
			<input type="text" name="lastPhoneNumber" maxlength="4" onkeydown="moveNumber(event)">
		</div>
		<div id="joinFormDiv">
			<div id="joinAgreeForm"><label><input type="checkbox" name="agree" onclick="agreeAll();">모두 동의하기</label></div>
	 		<div id="joinAgreeForm"><a href=""><input type="checkbox" name="personalAgree" value="personalAgree" onclick="return false;">개인 정보 수집 및 이용에 동의합니다.</a></div>
	 		<div id="joinAgreeForm"><a href=""><input type="checkbox" name="uniqueAgree" value="uniqueAgree" onclick="return false;">고유식별 정보처리에 동의합니다.</a></div>
	 		<div id="joinAgreeForm"><a href=""><input type="checkbox" name="mobileAgree" value="mobileAgree" onclick="return false;">통신사 이용약관에 동의합니다.</a></div>
	 		<div id="joinAgreeForm"><a href=""><input type="checkbox" name="useAgree" value="useAgree" onclick="return false;">이용약관에 동의합니다.</a></div>
		</div>
		<button id="next" onclick="checkJoin1(); return false;">다음으로</button>
	</form>
</section>