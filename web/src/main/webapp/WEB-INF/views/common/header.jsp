<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<c:if test="${sessionScope.userId==null }">
		<a href="">고객센터</a>
		<a href="">회원가입</a>
		<a href="">로그인</a>
	</c:if>
	<c:if test="${sessionScope.userId!=null }">
		<a href="">고객센터</a>
		<a href="">마이페이지</a>
		<a href="">로그아웃</a>
	</c:if>
</header>