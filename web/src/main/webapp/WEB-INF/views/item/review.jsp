<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/item/review.css">
<script type="text/javascript" src="${contextPath}/javascript/item/review.js" ></script>
    
<section>
	<div id="title">리뷰남기기</div>
	<form action="" name="f" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목</td>
				<td>
					<input id="reviewTitle" type="text">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="reviewContent"></textarea>
				</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<input type="file">
				</td>
			</tr>
			<tr>
				<td>별점</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<th>
					<button type="button">작성하기</button>
					<button type="button">이전으로</button>
				</th>
			</tr>
		</table>
	</form>
</section>