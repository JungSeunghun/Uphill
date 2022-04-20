<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/basket.css">
<script type="text/javascript" src="${contextPath}/javascript/user/basket.js" ></script>
    
<section>
	<c:if test="${fn:length(basketItemList) < 1}">
		<div id="basketItem">장바구니에 물건이 없습니다.</div>
	</c:if>
	<c:if test="${fn:length(basketItemList) > 0 }">
		<form action="${contextPath }/user/order" name="f" method="post">
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
								<input id="optionQty" type="number" min="1" max="10" value="${basketItem.optionQty }" onchange="location.href = '${contextPath }/user/basket-update-action?basketIndex=' + '${basketItem.basketIndex}' + '&&optionQty=' + this.value" >
								<button id="cancelButton" type="button" onclick="location.href = '${contextPath}/user/basket-cancel-action?basketIndex=${basketItem.basketIndex}'">취소</button>
							</div>
						</div>
						<div id="basketInfoBottom">
							<div id="orderPriceTitle">주문금액</div>
							<div id="orderPrice"><fmt:formatNumber value="${basketItem.optionPrice * basketItem.optionQty }" pattern="#,###" />원</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach var="basketItem" items="${basketItemList }">
				<c:set var="totalPrice" value="${totalPrice + basketItem.optionPrice * basketItem.optionQty }"/>
			</c:forEach>
			<div id="orderInfo">		
				<div id="orderTotalPriceTitle">총 주문금액</div>
				<div id="orderTotalPrice"><fmt:formatNumber value="${totalPrice }" pattern="#,###" />원</div>
				<div>
					<button id="buyButton" type="button" onclick="f.submit();">구매하기</button>
				</div>
				<div>
					<button id="cancelAllButton" type="button" onclick="location.href='${contextPath}/user/basket-cancel-all-action'">전체취소</button>
				</div>
			</div>
		</form>	
	</c:if>
</section>