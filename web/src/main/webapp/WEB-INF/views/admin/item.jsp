<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/admin/item.css">

<section>
	<table>
		<thead>
			<tr>
				<td>이름</td>
				<td>카테고리</td>
				<td>서브카테고리</td>
				<td>가격</td>
				<td>할인가</td>
				<td>수량</td>
				<td>판매수량</td>
				<td>별점</td>
			</tr>
		</thead>
		<c:forEach var="item" items="${itemList }">
			<tr onclick="location.href='${contextPath}/admin/item-info?itemIndex=${item.itemIndex }'">
				<td>${item.itemName }</td>
				<td>${item.itemCategoryName }</td>
				<td>${item.itemSubcategoryName }</td>
				<td>${item.itemPrice }</td>
				<td>${item.itemDiscountPrice }</td>
				<td>${item.itemTotalQty }</td>
				<td>${item.itemSellCount }</td>
				<td>${item.starRating }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${itemPage != 1 }">
			<a href="${contextPath }/admin/item?page=${itemPage - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${itemStartPage }" end="${itemEndPage }">
			<c:if test="${itemPage == i }">
				<span style="color:#9ccc65">${i }</span>
			</c:if>
			<c:if test="${itemPage != i }">
				<a href="${contextPath }/admin/item?page=${i }">${i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${itemPage != itemEndPage }">
			<a href="${contextPath }/admin/item?page=${itemPage + 1}">[다음]</a>
		</c:if>
	</div>
</section>