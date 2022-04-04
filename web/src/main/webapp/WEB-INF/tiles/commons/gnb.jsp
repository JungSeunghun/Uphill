<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<nav id="gnb">
	<ul id="gnb-list">
		<li>
			<a href="homePage.home">
				<img alt="uphill_logo_black" src="${contextPath }/images/logos/uphill_logo_black.svg" width="64px">
			</a>
		</li>
		<li>
			<a href="introPage.home">소개</a>
		</li>
		<li>
			<a href="itemListPage.item?item=bicycle">자전거</a>
		</li>
		<li>
			<a href="itemListPage.item?item=item">용품</a>
			
		</li>
		<li>
			<a href="noticePage.community">커뮤니티</a>
		<li>
		<li>
			<img alt="search icon" src="${contextPath }/images/icons/search_icon_white.svg" width="16px">
		</li>
		<li>
			<a href="basketPage.user"><img alt="basket icon" src="${contextPath }/images/icons/basket_icon_white.svg" width="16px"></a>
		</li>
	</ul>
	<div id="category">
		<div>
			<ul></ul>
			<ul></ul>
			<ul>
				<li><a href="itemListPage.item?item=MTB">MTB</a></li>
				<li><a href="itemListPage.item?item=Road">Road</a></li>
				<li><a href="itemListPage.item?item=Minivelo">Minivelo</a></li>
			</ul>
			<ul>
				<li><a href="itemListPage.item?item=helmet">헬멧</a></li>
				<li><a href="itemListPage.item?item=light">라이트</a></li>
				<li><a href="itemListPage.item?item=lock">자물쇠</a></li>
			</ul>
			<ul>
				<li><a href="noticePage.community">공지사항</a></li>
			</ul>
		</div>
	</div>
</nav>