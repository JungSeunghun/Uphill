<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/orderInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/admin/orderInfo.js" ></script>

<section>
	<form action="${contextPath }/admin/order-update-action" name="f" method="post">
		<input type="hidden" name="orderIndex" value="${orderVO.orderIndex }">
		<input type="hidden" name="orderState" value="">
		<table>
			<tr>
				<td>아이디</td>
				<td>${orderVO.userId }</td>
			</tr>			
			<tr>
				<td>수령인</td>
				<td>${orderVO.recipient }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>(${orderVO.postCode })${orderVO.address } ${orderVO.addressDetail } ${orderVO.addressExtra }</td>
			</tr>
			<tr>
				<td>통신사</td>
				<td>${orderVO.mobileCarrier }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${orderVO.phoneNumber }</td>
			</tr>
			<tr>
				<td>사용한 포인트</td>
				<td>${orderVO.usePoint }</td>
			</tr>
			<tr>
				<td>요청사항</td>
				<td>${orderVO.deliverRequest }</td>
			</tr>
			<tr>
				<td>결제수단</td>
				<td>${orderVO.payment }</td>
			</tr>
			<tr>
				<td>총 구매금액</td>
				<td>${orderVO.totalPrice }</td>
			</tr>
			<tr>
				<td>주문시간</td>
				<td>${orderVO.orderTime }</td>
			</tr>
			<tr>
				<td>주문상태</td>
				<c:if test="${orderVO.orderState == 0 }">
					<td>주문 대기</td>
				</c:if>
				<c:if test="${orderVO.orderState == 1 }">
					<td>주문 완료</td>
				</c:if>
				<c:if test="${orderVO.orderState == 2 }">
					<td>배송 완료</td>
				</c:if>
				<c:if test="${orderVO.orderState == 3 }">
					<td>주문 취소</td>
				</c:if>
			</tr>
			<c:forEach var="orderItem" items="${orderItemInfoList }">
				<tr>
					<td>카테고리</td>
					<td>${orderItem.itemCategoryName }</td>
				</tr>
				<c:if test="${orderItem.itemSubcategoryName != null }">
					<tr>
						<td>서브카테고리</td>
						<td>${orderItem.itemSubcategoryName }</td>
					</tr>
				</c:if>
				<tr>
					<td>이름</td>
					<td>${orderItem.itemCategoryName }</td>
				</tr>
				<tr>
					<td>옵션</td>
					<td>${orderItem.optionName }</td>
				</tr>
				<tr>
					<td>옵션가격</td>
					<td>${orderItem.optionPrice }</td>
				</tr>
				<tr>
					<td>수량</td>
					<td>${orderItem.optionQty }</td>
				</tr>
			</c:forEach>
		</table>
		<div>
			<button type="button" onclick="updateOrder()">주문확인</button>&nbsp;
			<button type="button" onclick="cancelOrder()">주문취소</button>
		</div>
	</form>
</section>