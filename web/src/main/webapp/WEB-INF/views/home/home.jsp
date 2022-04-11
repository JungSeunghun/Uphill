<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/home/home.css">

<section>
		
		<div id="mainBanner">
			<c:if test="${mainBannerList != null }">
				<c:forEach var="banner" items="${mainBannerList }">
					<img alt="main banner" src="${contextPath}/images/banners/${banner }.png">
				</c:forEach>
				
				<img alt="left button" src="${contextPath}/images/icons/left_button.svg">
				
				<c:forEach var="i" items="${fn:length(mainBannerList) }">
					<img alt="circle" src="/images/icons/circle.svg">
				</c:forEach>
				
				<img alt="right button" src="${contextPath}/images/icons/right_button.svg">
			</c:if>
			<c:if test="${mainBannerList == null }">
				<img alt="main banner" src="${contextPath}/images/banners/main_banner1.jpg" width="100%">
				
				<img id="leftButton" alt="left button" src="${contextPath}/images/icons/left_button_black.svg">
				
				<img id="circle" alt="circle" src="${contextPath}/images/icons/circle_green.svg">
				
				<img id="rightButton" alt="right button" src="${contextPath}/images/icons/right_button_black.svg">
			</c:if>
		</div>
		
		<div id="mainArticle">
			<div id="mainArticleTitle">Enjoy your ride</div>
			<div id="mainArticleContent">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sodales vulputate porttitor elementum mauris sed in. Aliquet pellentesque egestas amet, neque, convallis nec turpis curabitur. Aliquam augue volutpat pellentesque sit morbi quisque. Et, justo, nec sit scelerisque.</div>
			<a href="#">MTB</a>
			<a href="#">Road</a>
			<a href="#">Minivelo</a>
		</div>
		
		<div id="bestSellers">
			<c:if test="${bestSellerList != null }">
				<c:forEach var="bestSeller" items="${bestSellerList }">
					<img alt="best seller" src="${contextPath}/images/items/${bestSeller.name }.svg">
					<div>${bestSeller.name }</div>
					<div>${bestSeller.price }</div>
					<div>${bestSeller.discountPrice }</div>
					<c:forEach var="i" begin="0" end="4">
						<img alt="empty star" src="${contextPath}/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach var="i" begin="0" end="${bestSeller.starRating }">
						<img alt="green star" src="${contextPath}/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if>
		</div>
		
		<div id="promotion">
			<div id="promotionTitle">Promotion</div>
			<video width="100%" autoplay="autoplay" muted="muted" loop="loop">
				<source src="${contextPath }/videos/promotion.webm" type="video/webm">
			</video>
		</div>
		
		<div id="bestItems">
			<c:if test="${itemList != null }">
				<c:forEach var="item" items="${itemList }">
					<img alt="best item" src="${contextPath}/images/items/${item.name }.svg">
					<div>${item.name }</div>
					<div>${item.price }</div>
					<div>${item.discountPrice }</div>
					<c:forEach var="i" begin="0" end="4">
						<img alt="empty star" src="${contextPath}/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach var="i" begin="0" end="${item.starRating}">
						<img alt="green star" src="${contextPath}/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if>
		</div>
		
		<div id="recentReviews">
			<c:if test="${reviewList != null }">
				<c:forEach var="review" items="${reviewList }">
					<img alt="recent review" src="">
					<div>${review.title }</div>
					<div>${review.content }</div>
					<c:forEach var="i" begin="0" end="4">
						<img alt="empty star" src="${contextPath}/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach var="i" begin="0" end="${review.starRating }">
						<img alt="green star" src="${contextPath}/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if>
		</div>
	</section>