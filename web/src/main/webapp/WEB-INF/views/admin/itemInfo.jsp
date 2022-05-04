<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/itemInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/admin/itemInfo.js" ></script>

<section>
	<table style="display: none;">
		<tr id="optionRowClone">
			<td><input type="text" name="itemOptionName"></td>
			<td><input type="text" name="itemOptionContent"></td>
			<td><input type="number" name="itemOptionPrice"></td>
			<td><input type="number" name="itemOptionQty"></td>
			<td><button type="button" onclick="deleteOption(this)">옵션삭제</button></td>
		</tr>
	</table>
	<form action="${contextPath }/admin/item-update-action" name="f" method="post" enctype="multipart/form-data">
		<input type="hidden" name="itemIndex" value="${itemVO.itemIndex }">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="itemName" value="${itemVO.itemName }"></td>
			</tr>			
			<tr>
				<td>카테고리</td>
				<td>
					<select name="itemCategoryIndex" onchange="openSubcategory(this)">
						<c:if test="${itemVO.itemCategoryIndex == 1 }">
							<option value="0">카테고리를 선택해주세요.</option>
							<option value="1" selected="selected">자전거</option>
							<option value="2">헬멧</option>
							<option value="3">라이트</option>
							<option value="4">자물쇠</option>
						</c:if>
						<c:if test="${itemVO.itemCategoryIndex == 2 }">
							<option value="0">카테고리를 선택해주세요.</option>
							<option value="1">자전거</option>
							<option value="2" selected="selected">헬멧</option>
							<option value="3">라이트</option>
							<option value="4">자물쇠</option>
						</c:if>
						<c:if test="${itemVO.itemCategoryIndex == 3 }">
							<option value="0">카테고리를 선택해주세요.</option>
							<option value="1">자전거</option>
							<option value="2">헬멧</option>
							<option value="3" selected="selected">라이트</option>
							<option value="4">자물쇠</option>
						</c:if>
						<c:if test="${itemVO.itemCategoryIndex == 4 }">
							<option value="0">카테고리를 선택해주세요.</option>
							<option value="1">자전거</option>
							<option value="2">헬멧</option>
							<option value="3">라이트</option>
							<option value="4" selected="selected">자물쇠</option>
						</c:if>
					</select>
				</td>
			</tr>
			<c:if test="${itemVO.itemCategoryIndex == 1 }">
				<tr id="subcategory">
					<td>서브카테고리</td>
					<td>
						<select id="itemSubcategoryIndex" name="itemSubcategoryIndex">
							<c:if test="${itemVO.itemSubcategoryIndex == 1 }">
								<option value="0">서브카테고리를 선택해주세요.</option>
								<option value="1" selected="selected">MTB</option>
								<option value="2">Road</option>
								<option value="3">Minivelo</option>
							</c:if>
							<c:if test="${itemVO.itemSubcategoryIndex == 2 }">
								<option value="0">서브카테고리를 선택해주세요.</option>
								<option value="1">MTB</option>
								<option value="2" selected="selected">Road</option>
								<option value="3">Minivelo</option>
							</c:if>
							<c:if test="${itemVO.itemSubcategoryIndex == 3 }">
								<option value="0">서브카테고리를 선택해주세요.</option>
								<option value="1">MTB</option>
								<option value="2">Road</option>
								<option value="3" selected="selected">Minivelo</option>
							</c:if>
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
				<td><input type="number" name="itemDiscountPrice" value="${itemVO.itemDiscountPrice }"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="itemTotalQty" value="${itemVO.itemTotalQty }"></td>
			</tr>
		</table>
		<br><br>
		<table id="optionTable">
			<thead>
				<tr>
					<td>옵션이름</td>
					<td>옵션내용</td>
					<td>옵션가격</td>
					<td>옵션갯수</td>
					<td><button type="button" onclick="addOption()">옵션추가</button></td>
				</tr>
			</thead>			
			<c:forEach var="itemOption" items="${itemOptionList }">
				<tr id="optionRow">
					<td><input type="text" name="itemOptionName" value=${itemOption.itemOptionName }></td>
					<td><input type="text" name="itemOptionContent" value="${itemOption.itemOptionContent }"></td>
					<td><input type="number" name="itemOptionPrice" value="${itemOption.itemOptionPrice }"></td>
					<td><input type="number" name="itemOptionQty" value="${itemOption.itemOptionQty }"></td>
					<td><button type="button" onclick="deleteOption(this)">옵션삭제</button></td>
				</tr>
			</c:forEach>
		</table>
		
		<button type="button" onclick="checkUpdateItem()">수정하기</button>
	</form>
	<form name="deleteForm" action="${contextPath }/admin/item-delete-action">
		<input type="hidden" name="itemIndex" value="${itemVO.itemIndex }">
		<button type="button" onclick="if(confirm('정말 삭제하시겠습니까?')){deleteForm.submit();}">삭제하기</button>
	</form>
</section>