<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/order.css">
<script type="text/javascript" src="${contextPath}/javascript/admin/order.js" ></script>

<section>
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>수령인</td>
				<td>사용한 포인트</td>
				<td>구매액</td>
				<td>주문시간</td>
				<td>주문상태</td>
			</tr>
		</thead>
		<c:forEach var="order" items="${orderList }">
			<tr onclick="location.href='${contextPath}/admin/order-info?orderIndex=${order.orderIndex }'">
				<td>${order.userId }</td>
				<td>${order.recipient }</td>
				<td>${order.usePoint }</td>
				<td>${order.totalPrice }</td>
				<td>${order.orderTime }</td>
				<c:if test="${order.orderState == 0 }">
					<td>주문 대기</td>
				</c:if>
				<c:if test="${order.orderState == 1 }">
					<td>주문 완료</td>
				</c:if>
				<c:if test="${order.orderState == 2 }">
					<td>배송 완료</td>
				</c:if>
				<c:if test="${order.orderState == 3 }">
					<td>주문 취소</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${orderPage != 1 }">
			<a href="${contextPath }/admin/order?page=${orderPage - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${orderStartPage }" end="${orderEndPage }">
			<c:if test="${orderPage == i }">
				<span style="color:#9ccc65">${i }</span>
			</c:if>
			<c:if test="${orderPage != i }">
				<a href="${contextPath }/admin/order?page=${i }">${i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${orderPage != orderEndPage }">
			<a href="${contextPath }/admin/order?page=${orderPage + 1}">[다음]</a>
		</c:if>
	</div>
</section>