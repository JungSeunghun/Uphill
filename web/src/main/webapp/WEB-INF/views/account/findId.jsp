<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/account/findId.css">
<script type="text/javascript" src="${contextPath}/javascript/account/findId.js" ></script>

<section>
	<div>
		<a href="${contextPath}/home/home"><img id="logo" src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>

	<form action="${contextPath}/account/find-id-action" id="f" name="f" method="post">
		<div id="findIdFormTitle" >아이디 찾기</div>
		<div id="findIdFormDiv">
			<div id="findIdDivTitle">이름</div>
			<input type="text" id="userName" name="userName">
		</div>
		<div id="findIdFormDiv">
			<div id="findIdDivTitle">생년월일</div>
			<div id="birthDayForm">
				<select name="year" onchange="getDate();"></select>&nbsp;년&nbsp;&nbsp;
				<select name="month" onchange="getDate();"></select>&nbsp;월&nbsp;&nbsp;
				<select name="day"></select>&nbsp;일
			</div>			
		</div>
		<div id="findIdFormDiv">
		 	<div id="findIdDivTitle">이동통신사</div>
		 	<div id="mobileCarrierForm">
			 	<label><input type="radio" id="skt" name="mobileCarrier" value="SKT">SKT&nbsp;&nbsp;</label>
			 	<label><input type="radio" id="kt" name="mobileCarrier" value="KT">KT&nbsp;&nbsp;</label>
			 	<label><input type="radio" id="lg" name="mobileCarrier" value="LGU+">LGU+&nbsp;&nbsp;</label>
		 		<label><input type="radio" id="other" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;&nbsp;</label>
		 	</div>
		</div>
		<div id="findIdFormDiv">
			<div id="findIdDivTitle">전화번호</div>
			<select name="firstPhoneNumber">
				<option value="010">010</option>
				<option value="011">011</option>
			</select> -
			<input type="text" name="middlePhoneNumber" maxlength="4" onkeydown="moveNumber(event)"> -
			<input type="text" name="lastPhoneNumber" maxlength="4" onkeydown="moveNumber(event)">
		</div>
		<div id="findIdFormDiv">
			<div id="findIdDivTitle">이메일</div>
			<input type="text" name="emailId" id="emailId"> @
			<select name="emailAddress" id="emailAddress">
				<option value="">이메일을 선택하세요.</option>
				<option value="@naver.com">naver.com</option>
				<option value="@daum.net">daum.net</option>
				<option value="@gmail.com">gmail.com</option>
			</select>
		</div>
		<div id="findIdFormDiv">
			<button type="button" onclick="checkFindId()">아이디 찾기</button>
		</div>
	</form>
</section>
