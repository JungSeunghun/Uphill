<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
	<c:if test="${itemList != null }">
		<c:forEach var="item" items="${itemList }">
			<div>
				<a href=""><img alt="best item" src="${contextPath }/images/items/${item.name }.svg"></a>
				<div>${item.name }</div>
				<div>${item.price }</div>
				<div>${item.discountPrice }</div>
				<c:forEach begin="0" end="4">
					<img alt="empty star" src="${contextPath }/images/icons/empty_star.svg">
				</c:forEach>
				<c:forEach begin="0" end="${item.starRating}">
					<img alt="green star" src="${contextPath }/images/icons/green_star.svg">
				</c:forEach>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${itemList != null }">
		<div>현재 등록된 상품이 없습니다.</div>
	</c:if>
</section>