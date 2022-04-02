<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="gnb">
	<section>
		<a href="home.home">
			<img alt="uphill_logo_black" src="${contextPath }/images/logos/uphill_logo_black.svg" width="64px">
		</a>
		<a href="introPage.home">소개</a>
		<a href="bicyclePage.item">자전거</a>
		<ul>
			<li><a href="bicyclePage.item">모든 자전거</a></li>
			<li><a href="mtbPage.item">MTB</a></li>
			<li><a href="roadPage.item">Road</a></li>
			<li><a href="miniveloPage.item">Minivelo</a></li>
		</ul>
		<a href="itemPage.item">용품</a>
		<ul>
			<li><a href="itemPage.item">모든 용품</a></li>
			<li><a href="helment.item">헬멧</a></li>
			<li><a href="light.item">라이트</a></li>
			<li><a href="lock.item">자물쇠</a></li>
		</ul>
		<a href="notice.community">커뮤니티</a>
		<ul>
			<li><a href="notice.community">공지사항</a></li>
		</ul>
		<img alt="search icon" src="${contextPath }/images/icons/search_icon_white.svg" width="16px">
		<a href="basketPage.user"><img alt="basket icon" src="${contextPath }/images/icons/basket_icon_white.svg" width="16px"></a>
	</section>
</nav>