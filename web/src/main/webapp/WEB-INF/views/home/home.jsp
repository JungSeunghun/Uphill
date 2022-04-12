<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/home/home.css">
<script type="text/javascript" src="${contextPath}/javascript/home/home.js" ></script>

<section>
		
		<div id="mainBanner">
			<c:if test="${mainBannerList != null }">
				<div id="mainBannerImageDiv">
					<c:forEach var="banner" items="${mainBannerList }"><img class="mainBannerImage" src="${contextPath}/images/banners/${banner.imageFile }" onclick="var path='${contextPath}${banner.link}'; moveBanner(this, path);" ></c:forEach>
				</div>
			</c:if>
		</div>
		
		<div id="mainArticle">
			<div id="mainArticleTitle">Enjoy your ride</div>
			<div id="mainArticleContent">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sodales vulputate porttitor elementum mauris sed in. Aliquet pellentesque egestas amet, neque, convallis nec turpis curabitur. Aliquam augue volutpat pellentesque sit morbi quisque. Et, justo, nec sit scelerisque.</div>
			<a href="#">MTB</a>
			<a href="#">Road</a>
			<a href="#">Minivelo</a>
		</div>
		
		<div id="bestSeller">
			<div id="bestSellerTitle">Best Seller</div>
			<c:if test="${bestSellerList != null }">
				<div id="bestSellerContentList">
					<c:forEach var="bestSeller" items="${bestSellerList }">
						<div id="bestSellerContent">
							<img id="bestSellerImage" alt="${bestSeller.itemImage }" src="${contextPath}/images/items/${bestSeller.itemImage }">
							<div id="bestSellerInfo">
								<div id="bestSellerName">${bestSeller.itemName }</div>
								<c:if test="${bestSeller.itemDiscountPrice != 0 }">
									<div id="bestSellerPrice"><fmt:formatNumber value="${bestSeller.itemDiscountPrice }" pattern="#,###" />원</div>
									<div id="bestSellerBeforePrice"><fmt:formatNumber value="${bestSeller.itemPrice }" pattern="#,###" />원</div>
								</c:if>
								<c:if test="${bestSeller.itemDiscountPrice == 0 }">
									<div id="bestSellerPrice"><fmt:formatNumber value="${bestSeller.itemPrice }" pattern="#,###" />원</div>
								</c:if>
								<div id="starDiv">
									<div id="emptyStar">
										<c:forEach var="i" begin="1" end="5">
											<img src="${contextPath}/images/icons/empty_star.svg">
										</c:forEach>
									</div>
									<div id="greenStar">
										<c:forEach var="i" begin="1" end="${bestSeller.starRating+(1-(bestSeller.starRating%1))%1}">
											<span class="starWrap">
												<img src="${contextPath}/images/icons/green_star.svg" onload="const star='${bestSeller.itemPrice }'; setStar(star);">
											</span>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
		
		<div id="promotion">
			<div id="promotionTitle">Promotion</div>
			<video width="100%" autoplay="autoplay" muted="muted" loop="loop">
				<source src="${contextPath }/videos/promotion.webm" type="video/webm">
			</video>
		</div>
		
		<div id="bestItems">
			<c:if test="${bestItemList != null }">
				<c:forEach var="item" items="${bestItemList }">
					<div>
						<img alt="${item.itemImage }" src="${contextPath}/images/items/${item.itemImage }">
						<div>${item.itemName }</div>
						<div>${item.itemPrice }</div>
						<div>${item.itemDiscountPrice }</div>
						<c:forEach var="i" begin="1" end="5">
							<img src="${contextPath}/images/icons/empty_star.svg">
						</c:forEach>
						<c:forEach var="i" begin="1" end="${item.starRating+(1-(item.starRating%1))%1}">
							<img src="${contextPath}/images/icons/green_star.svg">
						</c:forEach>
					</div>
				</c:forEach>
			</c:if>
		</div>
		
		<div id="recentReviews">
			<c:if test="${recentReviewList != null }">
				<c:forEach var="review" items="${recentReviewList }">
					<div>
						<c:if test="${review.imageFile != null }">
							<img alt="${review.imageFile }" src="${contextPath}/images/reviews/${review.imageFile }">
						</c:if>
						<div>${review.title }</div>
						<div>${review.content }</div>
						<c:forEach var="i" begin="1" end="5">
							<img src="${contextPath}/images/icons/empty_star.svg">
						</c:forEach>
						<c:forEach var="i" begin="1" end="${review.starRating+(1-(review.starRating%1))%1 }">
							<img src="${contextPath}/images/icons/green_star.svg">
						</c:forEach>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</section>