<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/itemInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/admin/itemInfo.js" ></script>

<section>
	<form action="${contextPath }/admin/order-update-action" name="f" method="post">
		<input type="hidden" name="itemIndex" value="${itemVO.itemIndex }">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="itemName" value="${itemVO.itemName }"></td>
			</tr>			
			<tr>
				<td>카테고리</td>
				<td>
					<select name="itemCategoryIndex">
						<option value="1">자전거</option>
						<option value="2">헬멧</option>
						<option value="3">라이트</option>
						<option value="4">자물쇠</option>
					</select>
				</td>
			</tr>
			<c:if test="${itemVO.itemCategoryIndex == 1 }">
				<tr>
					<td>서브카테고리</td>
					<td>
						<select name="itemSubcategoryIndex">
							<option value="1">MTB</option>
							<option value="2">Road</option>
							<option value="3">Minivelo</option>
						</select>
					</td>
				</tr>
			</c:if>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="itemImage"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="itemPrice" value="${itemVO.itemPrice }"></td>
			</tr>
			<tr>
				<td>할인가격</td>
				<td><input type="number" name="itemPrice" value="${itemVO.itemDiscountPrice }"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="itemPrice" value="${itemVO.itemTotalQty }"></td>
			</tr>
		</table>
		
		<table>
			<thead>
				<tr>
					<td>옵션이름</td>
					<td>옵션내용</td>
					<td>옵션가격</td>
					<td>옵션갯수</td>
				</tr>
			</thead>
			<c:forEach var="itemOption" items="${itemOptionList }">
				<tr>
					<td><input type="text" name="itemOptionName" value=${itemOption.itemOptionName }></td>
					<td><input type="text" name="itemOptionContent" value="${itemOption.itemOptionContent }"></td>
					<td><input type="number" name="itemOptionPrice" value="${itemOption.itemOptionPrice }"></td>
					<td><input type="number" name="itemOptionQty" value="${itemOption.itemOptionQty }"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</section>