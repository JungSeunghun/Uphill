<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<nav id="gnb">
	<section>
		<div>
			<a href="home.up">
				<img alt="uphill_logo_black" src="${contextPath }/images/logos/uphill_logo_black.svg" width="64px">
			</a>
		</div>
		<div>
			<a href="">소개</a>
		</div>
		<div>
			<a href="">자전거</a>
		</div>
		<div>
			<a href="">용품</a>
		</div>
		<div>
			<a href="">커뮤니티</a>
		</div>
		<div>
			<a href=""><img alt="search icon" src="${contextPath }/images/icons/search_icon.svg"></a>
		</div>
		<div>
			<a href=""><img alt="basket icon" src="${contextPath }/images/icons/basket_icon.svg"></a>
		</div>
	</section>
</nav>