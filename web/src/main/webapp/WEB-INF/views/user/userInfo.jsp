<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/user/userInfo.js" ></script>

<section>
	<form action="${contextPath }/user/leave-action" name="f" method="post">
		<div id="userInfoName">${userVO.userName } 회원님 반갑습니다!</div>
		<c:if test="${userVO.gradeIndex == 1 }">
			<div id="userInfo">등급:&nbsp;실버</div>
		</c:if>
		<c:if test="${userVO.gradeIndex == 2 }">
			<div id="userInfo">등급:&nbsp;골드</div>
		</c:if>
		<c:if test="${userVO.gradeIndex == 3 }">
			<div id="userInfo">등급:&nbsp;다이아몬드</div>
		</c:if>
		<c:if test="${userVO.gradeIndex == 4 }">
			<div id="userInfo">등급:&nbsp;관리자</div>
		</c:if>
		<div id="userInfo">포인트:&nbsp;${userVO.point }&nbsp;포인트</div>
		<button type="button" id="leaveButton" onclick="leave();">탈퇴하기</button>
	</form>
</section>	