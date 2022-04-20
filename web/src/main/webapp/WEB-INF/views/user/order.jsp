<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/order.css">
<script type="text/javascript" src="${contextPath}/javascript/user/order.js" ></script>
    
<section>
	<c:if test="${fn:length(orderItemList) < 1}">
		<div id="orderItem">구매할 물건이 없습니다.</div>
	</c:if>
	<c:if test="${fn:length(orderItemList) > 0 }">
		<div>
			<c:forEach var="orderItem" items="${orderItemList }">
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
					<div id="orderInfo">
						<div id="orderInfoTop">
							<div id="orderOptionName">${orderItem.optionName }</div>
							<div id="orderInfoTopDiv">
								<input id="optionQty" value="${orderItem.optionQty }" readonly>
							</div>
						</div>
						<div id="orderInfoBottom">
							<div id="orderPriceTitle">주문금액</div>
							<div id="orderPrice"><fmt:formatNumber value="${orderItem.optionPrice * orderItem.optionQty }" pattern="#,###" />원</div>
						</div>
					</div>
				</div>
			</c:forEach>
			<c:forEach var="orderItem" items="${orderItemList }">
				<c:set var="totalPrice" value="${totalPrice + orderItem.optionPrice * orderItem.optionQty }"/>
			</c:forEach>
			<div id="orderUserInfo">
				<form action="/user/order-action" name="f" method="post">
					<div>
						<p>수령인</p>
						<input type="text" name="" size="">
					</div>
					<div>
						<p>주소</p>
						<input type="text" name="" size="">
					</div>
					<div>
					 	<p>이동통신사</p>
					 	<label><input type="radio" name="" value="">&nbsp;skt</label>
					 	<label><input type="radio" name="" value="">&nbsp;kt</label>
					 	<label><input type="radio" name="" value="">&nbsp;LGU+</label>
					 	<label><input type="radio" name="" value="">&nbsp;알뜰폰</label>
					</div>
					<div>
						<p>전화번호</p>
						<input type="text" name="" size="">
						<input type="text" name="" size="">
						<input type="text" name="" size="">
					</div>
					<div>
						<p>사용가능한포인트</p>
						<input type="text" name="" size="">
					</div>
					<div>
						<p>배송요청</p>
						<input type="text" name="" size="">
					</div>
					<div>
						<p>총 주문금액</p>
					</div>
					<div>
						<p>3,000,000원</p>
					</div>
					<div>
						<p>포인트적립액</p>
					</div>
					<div>
						<p>300000p(silver)</p>
					</div>
					<div>
					 	<p>결제수단</p>
					 	<label><input type="radio" name="" value="">&nbsp;신용카드</label>
					 	<label><input type="radio" name="" value="">&nbsp;계좌이체</label>
					 	<label><input type="radio" name="" value="">&nbsp;휴대폰</label>			 	
					</div>
					<div>
						<input type="button" name="" size="" value="결제하기" onclick="">
					</div>
				</form>		
				<div id="orderTotalPriceTitle">총 주문금액</div>
				<div id="orderTotalPrice"><fmt:formatNumber value="${totalPrice }" pattern="#,###" />원</div>
				<div>
					<button id="buyButton" type="button">구매하기</button>
				</div>
				<div>
					<button id="cancelAllButton" type="button" onclick="location.href='${contextPath}/user/basket-cancel-all-action'">전체취소</button>
				</div>
			</div>
		</div>	
	</c:if>
</section>