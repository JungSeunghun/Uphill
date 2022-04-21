<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/order.css">
<script type="text/javascript" src="${contextPath}/javascript/user/order.js" ></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<section>
	<c:if test="${fn:length(orderItemList) < 1}">
		<div id="orderItem">구매할 물건이 없습니다.</div>
	</c:if>
	<c:if test="${fn:length(orderItemList) > 0 }">
		<div>
			<form action="/user/order-action" name="f" method="post">
				<div>
					<c:forEach var="orderItem" items="${orderItemList }">
						<div id="orderItem">
							<input type="hidden" name="itemIndex" value="${orderItem.itemIndex }">
							<input type="hidden" name="itemName" value="${orderItem.itemName }">
							<input type="hidden" name="optionName" value="${orderItem.optionName }">
							<input type="hidden" name="optionPrice" value="${orderItem.optionPrice }">
							<input type="hidden" name="optionQty" value="${orderItem.optionQty }">
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
				</div>			
				<div id="orderUserInfo">
					<div id="orderUserInfoDiv">
						<div id="orderUserInfoTitle">수령인</div>
						<input type="text" name="recipient" value="${userVO.userName }">
					</div>
					<div id="orderUserInfoDiv">
						<div id="orderUserInfoTitle">주소</div>
						<input type="text" name="postCode" id="postCode" onclick="findAddress();" placeholder="우편번호" readonly="readonly" value="${userVO.postCode }"><br>
						<input type="text" name="address" id="address" onclick="findAddress();" placeholder="주소" readonly="readonly"  value="${userVO.address }"><br>
						<div id="wrap" style="display:none;border:1px solid;width:304px;height:300px;margin:5px 0;position:relative">
							<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
						</div>
						<div id="addressForm">
							<input type="text" name="addressDetail" id="addressDetail" placeholder="상세주소" maxlength="45" value="${userVO.addressDetail }">
							<input type="text" name="addressExtra" id="addressExtra" placeholder="추가주소" readonly="readonly" value="${userVO.addressExtra }">
						</div>
					</div>
					<div id="orderUserInfoDiv">
					 	<div id="orderUserInfoTitle">이동통신사</div>
					 	<c:if test="${userVO.mobileCarrier == 'SKT' }">
						 	<label><input type="radio" name="mobileCarrier" value="SKT" checked="checked">skt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="KT">kt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;</label>
					 	</c:if>
					 	<c:if test="${userVO.mobileCarrier == 'KT' }">
						 	<label><input type="radio" name="mobileCarrier" value="SKT">skt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="KT" checked="checked">kt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;</label>
					 	</c:if>
					 	<c:if test="${userVO.mobileCarrier == 'LGU+' }">
						 	<label><input type="radio" name="mobileCarrier" value="SKT">skt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="KT">kt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="LGU+" checked="checked">LGU+&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;</label>
					 	</c:if>
					 	<c:if test="${userVO.mobileCarrier == '알뜰폰' }">
						 	<label><input type="radio" name="mobileCarrier" value="SKT">skt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="KT">kt&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+&nbsp;</label>
						 	<label><input type="radio" name="mobileCarrier" value="알뜰폰" checked="checked">알뜰폰&nbsp;</label>
					 	</c:if>
					</div>
					<div id="orderUserInfoDiv">
						<div id="orderUserInfoTitle">전화번호</div>
						<c:if test="${fn:substring(userVO.phoneNumber, 0, 3) == '010'}">
							<select name="firstPhoneNumber">
								<option value="010" selected="selected">010</option>
								<option value="011">011</option>
							</select> -
						</c:if>
						<c:if test="${fn:substring(userVO.phoneNumber, 0, 3) == '011'}">
							<select name="firstPhoneNumber">
								<option value="010">010</option>
								<option value="011" selected="selected">011</option>
							</select> -
						</c:if>
						<input type="text" name="middlePhoneNumber" maxlength="4" value="${fn:substring(userVO.phoneNumber, 3, 7) }" onkeydown="moveNumber(event)"> -
						<input type="text" name="lastPhoneNumber" maxlength="4" value="${fn:substring(userVO.phoneNumber, 7, 11) }" onkeydown="moveNumber(event)">
					</div>
					<div id="orderUserInfoDiv">
						<div id="orderUserInfoTitle">사용가능한포인트(${userVO.point })</div>
						<input type="number" name="usePoint" value="0" min="0" max="${userVO.point }">
					</div>
					<div id="orderUserInfoDiv">
						<div id="orderUserInfoTitle">배송요청</div>
						<input type="text" name="deliverRequest" id="deliverRequest">
					</div>
					<div id="orderUserInfoDiv">
					 	<div id="orderUserInfoTitle">결제수단</div>
					 	<label><input type="radio" name="payment" value="신용카드">신용카드&nbsp;</label>
					 	<label><input type="radio" name="payment" value="계좌이체">계좌이체&nbsp;</label>
					 	<label><input type="radio" name="payment" value="휴대폰">휴대폰&nbsp;</label>			 	
					</div>
					<c:forEach var="orderItem" items="${orderItemList }">
						<c:set var="totalPrice" value="${totalPrice + orderItem.optionPrice * orderItem.optionQty }"/>
					</c:forEach>
					<div id="orderUserInfoDiv">
						<div id="orderUserInfoTitle">포인트적립액</div>
						<c:if test="${userVO.gradeIndex == 1 }">
							<div id="point"><fmt:formatNumber type="number" maxFractionDigits="0" value="${totalPrice * 0.01 }"/>(silver)</div>
						</c:if>
						<c:if test="${userVO.gradeIndex == 2 }">
							<div id="point"><fmt:formatNumber type="number" maxFractionDigits="0" value="${totalPrice * 0.02 }"/>(gold)</div>
						</c:if>
						<c:if test="${userVO.gradeIndex == 3 }">
							<div id="point"><fmt:formatNumber type="number" maxFractionDigits="0" value="${totalPrice * 0.03 }"/>(diamond)</div>
						</c:if>
					</div>
					<div id="orderUserInfoDiv">
						<div id="orderTotalPriceTitle">총 주문금액</div>
						<div id="orderTotalPrice"><fmt:formatNumber value="${totalPrice }" pattern="#,###" />원</div>
						<input type="hidden" name="totalPrice" value="${totalPrice }">
					</div>
					<button type="button" id="buyButton" onclick="checkOrder();" >결제하기</button>
				</div>
			</form>		
		</div>	
	</c:if>
</section>