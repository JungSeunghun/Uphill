<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<c:if test="${userVO==null }">
		<a href="/home/customer-center">고객센터</a>
		<a href="/account/join1">회원가입</a>
		<a href="/account/login">로그인</a>
	</c:if>
	<c:if test="${userVO!=null }">
		<a href="/home/customer-center">고객센터</a>
		<a href="/user/user-info">마이페이지</a>
		<a href="/account/logout-action">로그아웃</a>
	</c:if>
</header>