<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	<c:if test="${param.page=='bicycle' }">
		<div>
			<a href="">전체</a>
		</div>
		<div>
			<a href="">MTB</a>
		</div>
		<div>
			<a href="">Road</a>
		</div>
		<div>
			<a href="">MiniVelo</a>
		</div>
	</c:if>
	<c:if test="${param.page=='user' }">
		<div>
			<a href="">장바구니</a>
		</div>
		<div>
			<a href="">주문내역</a>
		</div>
		<div>
			<a href="">회원정보</a>
		</div>
		<div>
			<a href="">회원정보수정</a>
		</div>
	</c:if>
	<c:if test="${param.page=='community' }">
		<div>
			<a href="">공지사항</a>
		</div>
	</c:if>
</nav>