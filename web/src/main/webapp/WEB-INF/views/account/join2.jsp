<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<script type="text/javascript" src="${contextPath}/javascript/account/join2.js"></script>

<section>
	<form action="${contextPath}/account/join-action" name="f" method="post">
		<div>
			<a href="${contextPath}/home/home"><img src="${contextPath}/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
		</div>
		<div>회원가입</div>
		<div>
			<div>아이디</div>
			<input type="text" name="userEnterId" id="userEnterId" onchange="changedId();" maxlength="20">
			<button type="button" onclick="checkDuplicateId();">중복확인</button>
			<div id="checkDuplicateIdResult"></div>
			<input type="hidden" id="canUseId" value="false">
		</div>
		<div>
			<div>비밀번호</div>
			<input type="password" name="userPassword" maxlength="20">
		</div>
		<div>
			<div>비밀번호 확인</div>
			<input type="password" name="checkUserPassword" maxlength="20">
		</div>
		<div>
			<div>주소</div>
			<input type="text" name="address" maxlength="100"><br/>
			<input type="text" name="addressDetail" maxlength="50">
		</div>
		<div>
			<div>이메일</div>
			<input type="text" id="emailId" name="emailId" onchange="changedEmail()">@
			<select name="emailAddress">
				<option value="">이메일을 선택하세요.</option>
				<option value="@naver.com">naver.com</option>
				<option value="@daum.net">daum.net</option>
				<option value="@gmail.com">gmail.com</option>
			</select>
			<button type="button" onclick="sendSecureCode()">보안코드 전송</button>
			<div id="checkDuplicateEmailResult"></div>
			<input type="hidden" id="canUseEmail" value="false">
		</div>
		<div>
			<div>보안코드 입력</div>
			<input type="text" id="secureCode">
			<button type="button" onclick="checkSecureCode()">확인</button>
			<div id="checkSecureCodeResult"></div>
			<input type="hidden" id="checkSecureCode" value="false">
		</div>
		<div>
			<button type="button" onclick="checkJoin2();">회원가입</button>
		</div>
		<div>
			<a href="${contextPath}/account/join1">이전으로</a>
		</div>
	</form>
</section>