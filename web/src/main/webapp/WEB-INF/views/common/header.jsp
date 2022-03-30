<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header>
	<c:if test="${sessionScope.userId==null }">
		<div>고객센터</div>
		<div>회원가입</div>
		<div>로그인</div>
	</c:if>
	<c:if test="${sessionScope.userId!=null }">
		<div>고객센터</div>
		<div>마이페이지</div>
		<div>로그아웃</div>
	</c:if>
</header>