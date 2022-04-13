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
			<div id="bestSellerTitle">Best Sellers</div>
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
									<div id="greenStar" style="width:${100 * bestSeller.starRating/5}%">
										<div id="starWrap">
											<c:forEach var="i" begin="1" end="5">
												<img src="${contextPath}/images/icons/green_star.svg">
											</c:forEach>
										</div>
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
		
		<div id="bestItem">
			<div id="bestItemTitle">Best Items</div>
			<c:if test="${bestItemList != null }">
				<div id="bestItemContentList">
					<c:forEach var="bestItem" items="${bestItemList }">
						<div id="bestItemContent">
							<img id="bestItemImage" alt="${bestItem.itemImage }" src="${contextPath}/images/items/${bestItem.itemImage }">
							<div id="bestItemInfo">
								<div id="bestItemName">${bestItem.itemName }</div>
								<c:if test="${bestItem.itemDiscountPrice != 0 }">
									<div id="bestItemPrice"><fmt:formatNumber value="${bestItem.itemDiscountPrice }" pattern="#,###" />원</div>
									<div id="bestItemBeforePrice"><fmt:formatNumber value="${bestItem.itemPrice }" pattern="#,###" />원</div>
								</c:if>
								<c:if test="${bestItem.itemDiscountPrice == 0 }">
									<div id="bestItemPrice"><fmt:formatNumber value="${bestItem.itemPrice }" pattern="#,###" />원</div>
								</c:if>
								<div id="starDiv">
									<div id="emptyStar">
										<c:forEach var="i" begin="1" end="5">
											<img src="${contextPath}/images/icons/empty_star.svg">
										</c:forEach>
									</div>
									<div id="greenStar" style="width:${100 * bestItem.starRating/5}%">
										<div id="starWrap">
											<c:forEach var="i" begin="1" end="5">
												<img src="${contextPath}/images/icons/green_star.svg">
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
		</div>
		
		<div id="recentReview">
			<div id="recentReviewTitle">Recent Reviews</div>
			<c:if test="${recentReviewList != null }">
				<div id="recentReviewList">
					<div id="recentReviewListWrap" onmouseover="setTransition()">
						<c:forEach var="review" items="${recentReviewList }">
							<div id="recentReviewDiv">
								<c:if test="${review.imageFile != null }">
									<img id="recentReviewImage" alt="${review.imageFile }" src="${contextPath}/images/reviews/${review.imageFile }">
								</c:if>
								<c:if test="${review.imageFile == null }">
									<img id="recentReviewImage" alt="${review.imageFile }" src="${contextPath}/images/reviews/default_review.jpg">
								</c:if>
								<div id="recentReviewInfo">
									<div id="recentReviewInfoTitle">${review.title }</div>
									<div id="recentReviewInfoContent">${review.content }</div>
									<div id="starDiv">
										<div id="emptyStar">
											<c:forEach var="i" begin="1" end="5">
												<img src="${contextPath}/images/icons/empty_star.svg">
											</c:forEach>
										</div>
										<div id="greenStar">
											<div id="starWrap">
												<c:forEach var="i" begin="1" end="${review.starRating+(1-(review.starRating%1))%1 }">
													<img src="${contextPath}/images/icons/green_star.svg">
												</c:forEach>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:if>
		</div>
	</section>