<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<c:if test="${sessionScope.userId==null }">
		<a href="customerPage.home">고객센터</a>
		<a href="joinPage.home">회원가입</a>
		<a href="loginPage.home">로그인</a>
	</c:if>
	<c:if test="${sessionScope.userId!=null }">
		<a href="customerPage.home">고객센터</a>
		<a href="myPage.home">마이페이지</a>
		<a href="logout.home">로그아웃</a>
	</c:if>
</header>