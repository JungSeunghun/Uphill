<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<nav id="gnb">
	<section>
		<a href="home.up">
			<img alt="uphill_logo_black" src="${contextPath }/images/logos/uphill_logo_black.svg" width="64px">
		</a>
		<a href="">소개</a>
		<a href="">자전거</a>
		<a href="">용품</a>
		<a href="">커뮤니티</a>
		<a href=""><img alt="search icon" src="${contextPath }/images/icons/search_icon_white.svg" width="16px"></a>
		<a href=""><img alt="basket icon" src="${contextPath }/images/icons/basket_icon_white.svg" width="16px"></a>
	</section>
</nav>