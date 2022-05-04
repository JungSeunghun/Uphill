<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/addItem.css">
<script type="text/javascript" src="${contextPath}/javascript/admin/addItem.js" ></script>

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
	<form action="${contextPath }/admin/item-add-action" name="f" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="itemName"></td>
			</tr>			
			<tr>
				<td>카테고리</td>
				<td>
					<select name="itemCategoryIndex" onchange="openSubcategory(this)">
						<option value="0">카테고리를 선택해주세요.</option>
						<option value="1">자전거</option>
						<option value="2">헬멧</option>
						<option value="3">라이트</option>
						<option value="4">자물쇠</option>
					</select>
				</td>
			</tr>
			<tr id="subcategory" style="display: none;">
				<td>서브카테고리</td>
				<td>
					<select id="itemSubcategoryIndex" name="itemSubcategoryIndex">
						<option value="0">서브카테고리를 선택해주세요.</option>
						<option value="1">MTB</option>
						<option value="2">Road</option>
						<option value="3">Minivelo</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="itemImage"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="number" name="itemPrice"></td>
			</tr>
			<tr>
				<td>할인가격</td>
				<td><input type="number" name="itemDiscountPrice"></td>
			</tr>
			<tr>
				<td>수량</td>
				<td><input type="number" name="itemTotalQty"></td>
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
		</table>
		
		<button type="button" onclick="checkAddItem()">추가하기</button>
	</form>
</section>