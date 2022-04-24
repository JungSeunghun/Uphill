<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/orderList.css">
    
<section>
	<c:if test="${fn:length(orderList) < 1}">
		<div id="orderList">구매내역이 없습니다.</div>
	</c:if>
	<c:if test="${fn:length(orderList) > 0}">
		<c:forEach var="order" items="${orderList }" >	
			<div id="orderList">
				<div id="orderListItem">
					<c:forEach var="orderItem" items="${orderItemList }">							
						<c:if test="${order.orderIndex == orderItem.orderIndex }">
							<div id="orderItem">
								<div id="itemDiv" onclick="location.href='${contextPath}/item/item-info?id=${orderItem.itemIndex }'">
									<div id="itemImageDiv"><img id="itemImage" alt="${orderItem.itemImage }" src="${contextPath }/images/items/${orderItem.itemImage }"></div>
									<div id="itemInfo">
										<div id="itemName">${orderItem.itemName }</div>
										<c:if test="${orderItem.itemDiscountPrice != 0 }">
											<div id="itemPrice"><fmt:formatNumber value="${orderItem.itemDiscountPrice }" pattern="#,###" />원</div>
											<div id="itemBeforePrice"><fmt:formatNumber value="${orderItem.itemPrice }" pattern="#,###" />원</div>
										</c:if>
										<c:if test="${orderItem.itemDiscountPrice == 0 }">
											<div id="itemPrice"><fmt:formatNumber value="${orderItem.itemPrice }" pattern="#,###" />원</div>
										</c:if>					
										<div id="starDiv">
											<div id="emptyStar">
												<c:forEach begin="1" end="5">
													<img alt="empty star" src="${contextPath }/images/icons/empty_star.svg">
												</c:forEach>
											</div>
											<div id="greenStar" style="width:${100 * orderItem.starRating/5}%">
												<div id="starWrap">
													<c:forEach begin="1" end="5">
														<img alt="green star" src="${contextPath }/images/icons/green_star.svg">
													</c:forEach>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div id="orderItemInfo">
									<div id="orderItemInfoTop">
										<div id="orderItemOptionName">${orderItem.optionName }</div>
										<div id="orderItemInfoTopDiv">
											<input id="optionQty" type="number" min="1" max="10" value="${orderItem.optionQty }" readonly="readonly" >
										</div>
									</div>
									<div id="orderItemInfoBottom">
										<div id="orderPriceTitle">주문금액</div>
										<div id="orderPrice"><fmt:formatNumber value="${orderItem.optionPrice * orderItem.optionQty }" pattern="#,###" />원</div>
									</div>
								</div>
							</div>
						</c:if>		
					</c:forEach>
					<c:set var="totalPrice" value="0"/>
					<c:forEach var="orderItem" items="${orderItemList }">
						<c:if test="${order.orderIndex == orderItem.orderIndex }">
							<c:set var="totalPrice" value="${totalPrice + orderItem.optionPrice * orderItem.optionQty }"/>
						</c:if>
					</c:forEach>
				</div>
				<div id="orderInfo">
					<div id="orderInfoTitle">총 주문금액</div>
					<div id="orderTotalPrice"><fmt:formatNumber value="${totalPrice }" pattern="#,###" />원</div>
					<div id="orderInfoTitle">수령인</div>
					<div id="orderInfoContent">${order.recipient }</div>
					<div id="orderInfoTitle">배송주소</div>
					<div id="orderInfoContent">(${order.postCode})<br>${order.address } ${order.addressDetail } ${order.addressExtra }</div>
					<c:if test="${order.deliverRequest != '' }">
						<div id="orderInfoTitle">배송요청</div>
						<div id="orderInfoContent">${order.deliverRequest }</div>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</c:if>
</section>	