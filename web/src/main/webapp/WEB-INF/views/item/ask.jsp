<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/item/ask.css">
<script type="text/javascript" src="${contextPath}/javascript/item/ask.js" ></script>
    
<section>
	<div id="mainTitle">문의하기</div>
	<form action="${contextPath }/item/ask-action?id=${itemIndex}" name="f" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목</td>
				<td>
					<input name="title" id="title" type="text">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" id="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>이미지</td>
				<td>
					<input type="file" name="imageFile">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="button" onclick="checkAsk()">작성하기</button>
					<button type="button" onclick="history.back()">이전으로</button>
				</th>
			</tr>
		</table>
	</form>
</section>