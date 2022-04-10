<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/account/join2.css">
<script type="text/javascript" src="${contextPath}/javascript/account/join2.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<section>
	<div id="joinTitle">
		<a href="${contextPath}/home/home"><img src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
	</div>
	<form action="${contextPath}/account/join-action" id="f" name="f" method="post">
		<div id="joinFormTitle">회원가입</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">아이디</div>
			<input type="text" name="userId" id="userId" onchange="changedId();" maxlength="20">
			<button type="button" onclick="checkDuplicateId();">중복확인</button>
			<div id="checkDuplicateIdResult"></div>
			<input type="hidden" id="canUseId" value="false">
		</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">비밀번호</div>
			<input type="password" name="userPassword" id="userPassword" maxlength="20"><br>
			<input type="password" name="checkUserPassword" id="checkUserPassword" maxlength="20">
		</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">주소</div>
			<input type="text" name="postCode" id="postCode" onclick="findAddress();" readonly="readonly"><br>
			<input type="text" name="address" id="address" onclick="findAddress();" readonly="readonly"><br>
			<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
			</div>
			<div id="addressForm">
				<input type="text" name="addressDetail" id="addressDetail" maxlength="45">
				<input type="text" name="addressExtra" id="addressExtra" readonly="readonly">
			</div>
		</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">이메일</div>
			<input type="text" id="emailId" name="emailId" onchange="changedEmail()"> @
			<select id="emailAddress" name="emailAddress">
				<option value="">이메일을 선택하세요.</option>
				<option value="@naver.com">naver.com</option>
				<option value="@daum.net">daum.net</option>
				<option value="@gmail.com">gmail.com</option>
			</select>
			<button type="button" onclick="sendSecureCode();">보안코드 전송</button>
			<div id="checkDuplicateEmailResult"></div>
			<input type="hidden" id="canUseEmail" value="false">
		</div>
		<div id="joinFormDiv">
			<div id="joinFormDivTitle">보안코드 입력</div>
			<input type="text" id="secureCode">
			<button type="button" onclick="checkSecureCode();">확인</button>
			<div id="checkSecureCodeResult"></div>
			<input type="hidden" id="isSecureCode" value="false">
		</div>
		<button type="button" id="join" onclick="checkJoin2();">회원가입</button><br>
		<button type="button" id="prev" onclick="history.back();">이전으로</button>
	</form>	
</section>