<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/item/itemList.css">

<section>
	<c:if test="${itemList != null }">
		<c:forEach var="item" items="${itemList }">
			<div id="itemDiv" onclick="location.href='${contextPath}/item/item-info?id=${item.itemIndex }'">
				<div id="itemImageDiv"><img id="itemImage" alt="${item.itemImage }" src="${contextPath }/images/items/${item.itemImage }"></div>
				<div id="itemInfo">
					<div id="itemName">${item.itemName }</div>
					<c:if test="${item.itemDiscountPrice != 0 }">
						<div id="itemPrice"><fmt:formatNumber value="${item.itemDiscountPrice }" pattern="#,###" />원</div>
						<div id="itemBeforePrice"><fmt:formatNumber value="${item.itemPrice }" pattern="#,###" />원</div>
					</c:if>
					<c:if test="${item.itemDiscountPrice == 0 }">
						<div id="itemPrice"><fmt:formatNumber value="${item.itemPrice }" pattern="#,###" />원</div>
					</c:if>					
					<div id="starDiv">
						<div id="emptyStar">
							<c:forEach begin="1" end="5">
								<img alt="empty star" src="${contextPath }/images/icons/empty_star.svg">
							</c:forEach>
						</div>
						<div id="greenStar" style="width:${100 * item.starRating/5}%">
							<div id="starWrap">
								<c:forEach begin="1" end="5">
									<img alt="green star" src="${contextPath }/images/icons/green_star.svg">
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${itemList == null }">
		<div>현재 등록된 상품이 없습니다.</div>
	</c:if>
</section>