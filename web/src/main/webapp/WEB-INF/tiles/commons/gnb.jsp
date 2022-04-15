<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }"/>

<script type="text/javascript" src="${contextPath}/javascript/common.js" ></script>
<div id="gnbWrap">
	<nav id="gnb">
		<ul id="gnbList" onmouseenter="openCategory();">
			<li>
				<a href="${contextPath}/home/home">
					<img alt="uphill_logo_black" src="${contextPath}/images/logos/uphill_logo_black.svg" width="64px">
				</a>
			</li>
			<li>
				<a href="${contextPath}/home/intro">소개</a>
			</li>
			<li>
				<a href="${contextPath}/item/bicycle">자전거</a>
			</li>
			<li>
				<a href="${contextPath}/item/item">용품</a>			
			</li>
			<li>
				<a href="${contextPath}/community/notice">커뮤니티</a>
			</li>		
			<li>
				<a href="${contextPath}/user/basket"><img alt="basket icon" src="${contextPath}/images/icons/basket_icon_white.svg" width="16px"></a>
			</li>
			<li>
				<img alt="search icon" src="${contextPath}/images/icons/search_icon_white.svg" width="16px">
			</li>
			<li>
				<img id="menuButton" src="${contextPath}/images/icons/menu_button_white.svg" onclick="mobileCategoryToggle();">
			</li>
		</ul>
		<div id="category" onmouseleave="closeCategory()">
			<div id="categoryDiv">
				<ul></ul>
				<ul></ul>
				<ul>
					<li><a href="${contextPath}/item/mtb">MTB</a></li>
					<li><a href="${contextPath}/item/road">Road</a></li>
					<li><a href="${contextPath}/item/minivelo">Minivelo</a></li>
				</ul>
				<ul>
					<li><a href="${contextPath}/item/helmet">헬멧</a></li>
					<li><a href="${contextPath}/item/light">라이트</a></li>
					<li><a href="${contextPath}/item/lock">자물쇠</a></li>
				</ul>
				<ul>
					<li><a href="${contextPath}/community/notice">공지사항</a></li>
				</ul>
			</div>
		</div>
		<div id="mobileCategory">
			<ul>
				<li>
					<a href="${contextPath}/account/login">로그인</a>
				</li>
				<li>
					<a href="${contextPath}/account/join1">회원가입</a>
				</li>
				<li>
					<img alt="search icon" src="${contextPath}/images/icons/search_icon_white.svg" width="16px">
				</li>		
				<li>
					<a href="${contextPath}/user/basket"><img alt="basket icon" src="${contextPath}/images/icons/basket_icon_white.svg" width="16px"></a>
				</li>
				<li>
					<a href="${contextPath}/home/intro">소개</a>
				</li>
				<li>
					<a href="${contextPath}/item/bicycle">자전거</a>
				</li>
				<li>
					<a href="${contextPath}/item/item">용품</a>			
				</li>
				<li>
					<a href="${contextPath}/community/notice">커뮤니티</a>
				</li>
				<li>
					<a href="${contextPath}/home/customer-center">고객센터</a>
				</li>
			</ul>
		</div>
	</nav>
</div>
