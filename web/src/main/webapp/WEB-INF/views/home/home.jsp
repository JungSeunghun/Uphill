<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<section>
		
		<div id="main-banner">
			<c:if test="${mainBannerList != null }">
				<c:forEach var="banner" items="${mainBannerList }">
					<img alt="main banner" src="${pageContext.request.contextPath}/images/banners/${banner }.png">
				</c:forEach>
				
				<button><img alt="left button" src="${pageContext.request.contextPath}/images/icons/left_button.svg"></button>
				
				<c:forEach var="i" items="${fn:length(mainBannerList) }">
					<img alt="circle" src="/images/icons/circle.svg">
				</c:forEach>
				
				<button><img alt="left button" src="${pageContext.request.contextPath}/images/icons/right_button.svg"></button>
			</c:if>
			<c:if test="${mainBannerList == null }">
				<img alt="main banner" src="${pageContext.request.contextPath}/images/banners/main_banner1.jpg" width="100%">
				
				<button><img alt="left button" src="${pageContext.request.contextPath}/images/icons/left_button_black.svg"></button>
				
				<img alt="circle" src="${pageContext.request.contextPath}/images/icons/circle_green.svg">
				
				<button><img alt="left button" src="${pageContext.request.contextPath}/images/icons/right_button_black.svg"></button>
			</c:if>
		</div>
		
		<div id="main-article">
			<div></div>
			<p></p>
			<a href="#">MTB</a>
			<a href="#">Road</a>
			<a href="#">Minivelo</a>
		</div>
		
		<div id="best-sellers">
			<c:if test="${bestSellerList != null }">
				<c:forEach var="bestSeller" items="${bestSellerList }">
					<img alt="best seller" src="${pageContext.request.contextPath}/images/items/${bestSeller.name }.svg">
					<div>${bestSeller.name }</div>
					<div>${bestSeller.price }</div>
					<div>${bestSeller.discountPrice }</div>
					<c:forEach var="i" begin="0" end="4">
						<img alt="empty star" src="${pageContext.request.contextPath}/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach var="i" begin="0" end="${bestSeller.starRating }">
						<img alt="green star" src="${pageContext.request.contextPath}/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if>
		</div>
		
		<div id="promotion">
			<video src=""></video>
		</div>
		
		<div id="best-items">
			<c:if test="${itemList != null }">
				<c:forEach var="item" items="${itemList }">
					<img alt="best item" src="${pageContext.request.contextPath}/images/items/${item.name }.svg">
					<div>${item.name }</div>
					<div>${item.price }</div>
					<div>${item.discountPrice }</div>
					<c:forEach var="i" begin="0" end="4">
						<img alt="empty star" src="${pageContext.request.contextPath}/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach var="i" begin="0" end="${item.starRating}">
						<img alt="green star" src="${pageContext.request.contextPath}/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if>
		</div>
		
		<div id="recent-reviews">
			<c:if test="${reviewList != null }">
				<c:forEach var="review" items="${reviewList }">
					<img alt="recent review" src="">
					<div>${review.title }</div>
					<div>${review.content }</div>
					<c:forEach var="i" begin="0" end="4">
						<img alt="empty star" src="${pageContext.request.contextPath}/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach var="i" begin="0" end="${review.starRating }">
						<img alt="green star" src="${pageContext.request.contextPath}/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if>
		</div>
	</section>