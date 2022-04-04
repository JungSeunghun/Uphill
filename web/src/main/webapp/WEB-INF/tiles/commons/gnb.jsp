<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav id="gnb">
	<ul id="gnb-list">
		<li>
			<a href="/home/home">
				<img alt="uphill_logo_black" src="/images/logos/uphill_logo_black.svg" width="64px">
			</a>
		</li>
		<li>
			<a href="/home/intro">소개</a>
		</li>
		<li>
			<a href="/bicycle/bicycle">자전거</a>
		</li>
		<li>
			<a href="/item/item">용품</a>
			
		</li>
		<li>
			<a href="/community/notice">커뮤니티</a>
		<li>
		<li>
			<img alt="search icon" src="/images/icons/search_icon_white.svg" width="16px">
		</li>
		<li>
			<a href="/user/basket"><img alt="basket icon" src="/images/icons/basket_icon_white.svg" width="16px"></a>
		</li>
	</ul>
	<div id="category">
		<div>
			<ul></ul>
			<ul></ul>
			<ul>
				<li><a href="/bicycle/mtb">MTB</a></li>
				<li><a href="/bicycle/road">Road</a></li>
				<li><a href="/bicycle/minivelo">Minivelo</a></li>
			</ul>
			<ul>
				<li><a href="/item/helmet">헬멧</a></li>
				<li><a href="/item/light">라이트</a></li>
				<li><a href="/item/lock">자물쇠</a></li>
			</ul>
			<ul>
				<li><a href="/community/notice">공지사항</a></li>
			</ul>
		</div>
	</div>
</nav>