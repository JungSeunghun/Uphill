<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/basket.css">

<section>
	<c:if test="${basketItemList == null }">
		<div id="basketItem">장바구니에 물건이 없습니다.</div>
	</c:if>
	<c:if test="${basketItemList != null }">
		<form action="" name="f" method="post">
			<c:forEach var="basketItem" items="${basketItemList }">
				<div id="basketItem">
					<div id="itemDiv" onclick="location.href='${contextPath}/item/item-info?id=${basketItem.itemIndex }'">
						<div id="itemImageDiv"><img id="itemImage" alt="${basketItem.itemImage }" src="${contextPath }/images/items/${basketItem.itemImage }"></div>
						<div id="itemInfo">
							<div id="itemName">${basketItem.itemName }</div>
							<c:if test="${basketItem.itemDiscountPrice != 0 }">
								<div id="itemPrice"><fmt:formatNumber value="${basketItem.itemDiscountPrice }" pattern="#,###" />원</div>
								<div id="itemBeforePrice"><fmt:formatNumber value="${basketItem.itemPrice }" pattern="#,###" />원</div>
							</c:if>
							<c:if test="${basketItem.itemDiscountPrice == 0 }">
								<div id="itemPrice"><fmt:formatNumber value="${basketItem.itemPrice }" pattern="#,###" />원</div>
							</c:if>					
							<div id="starDiv">
								<div id="emptyStar">
									<c:forEach begin="1" end="5">
										<img alt="empty star" src="${contextPath }/images/icons/empty_star.svg">
									</c:forEach>
								</div>
								<div id="greenStar" style="width:${100 * basketItem.starRating/5}%">
									<div id="starWrap">
										<c:forEach begin="1" end="5">
											<img alt="green star" src="${contextPath }/images/icons/green_star.svg">
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div id="basketInfo">
						<div id="basketInfoTop">
							<div id="basketOptionName">${basketItem.optionName }</div>
							<div id="basketInfoTopDiv">
								<input id="optionQty" type="number" min="1" max="10" value="${basketItem.optionQty }">
								<button id="cancelButton" type="button">취소</button>
							</div>
						</div>
						<div id="basketInfoBottom">
							<div id="orderPriceTitle">주문금액</div>
							<div id="orderPrice"><fmt:formatNumber value="${basketItem.optionPrice }" pattern="#,###" />원</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<div id="orderInfo">		
				<div id="orderTotalPriceTitle">총 주문금액</div>
				<div id="orderTotalPrice">3,000,000원</div>
				<div>
					<button type="button">구매하기</button>
				</div>
				<div>
					<button type="button">전체취소</button>
				</div>
			</div>
		</form>	
	</c:if>
</section>