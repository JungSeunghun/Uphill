<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav>
	<c:if test="${param.page=='bicycle' }">
		<div>
			<div>
				<a href="allBicycles.item">전체</a>
			</div>
			<div>
				<a href="mtb.item">MTB</a>
			</div>
			<div>
				<a href="raod.item">Road</a>
			</div>
			<div>
				<a href="minivelo.item">MiniVelo</a>
			</div>
		</div>
	</c:if>
	<c:if test="${param.page=='item' }">
		<div>
			<div>
				<a href="allItems.item">전체</a>
			</div>
			<div>
				<a href="helmet.item">헬멧</a>
			</div>
			<div>
				<a href="light.item">라이트</a>
			</div>
			<div>
				<a href="lock.item">자물쇠</a>
			</div>
		</div>
	</c:if>
	<c:if test="${param.page=='user' }">
		<div>
			<div>
				<a href="basketPage.user">장바구니</a>
			</div>
			<div>
				<a href="purchasePage.user">주문내역</a>
			</div>
			<div>
				<a href="userInfoPage.user">회원정보</a>
			</div>
			<div>
				<a href="userUpdatePage.user">회원정보수정</a>
			</div>
		</div>
	</c:if>
	<c:if test="${param.page=='community' }">
		<div>
			<a href="noticePage.community">공지사항</a>
		</div>
	</c:if>
</nav>