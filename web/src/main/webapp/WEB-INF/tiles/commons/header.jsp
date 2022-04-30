<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<header>
	<c:if test="${userVO==null }">
		<a href="${contextPath}/home/customer-center">고객센터</a>
		<a href="${contextPath}/account/join1">회원가입</a>
		<a href="${contextPath}/account/login">로그인</a>
	</c:if>
	<c:if test="${userVO!=null && userVO.gradeIndex != 4 }">
		<a href="${contextPath}/home/customer-center">고객센터</a>
		<a href="${contextPath}/user/user-info">마이페이지</a>
		<a href="${contextPath}/account/logout-action">로그아웃</a>
	</c:if>
	<c:if test="${userVO!=null && userVO.gradeIndex == 4 }">
		<a href="${contextPath}/admin/user">관리자페이지</a>
		<a href="${contextPath}/home/customer-center">고객센터</a>
		<a href="${contextPath}/user/user-info">마이페이지</a>
		<a href="${contextPath}/account/logout-action">로그아웃</a>
	</c:if>
</header>