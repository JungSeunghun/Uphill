<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/user.css">

<section>
	<table>
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>등급</td>
				<td>구매액</td>
				<td>포인트</td>
				<td>가입일</td>
			</tr>
		</thead>
		<c:forEach var="user" items="${userList }">
			<tr onclick="location.href='${contextPath}/admin/user-info?userIndex=${user.userIndex }'">
				<td>${user.userId }</td>
				<td>${user.userName }</td>
				<c:if test="${user.gradeIndex == 1 }">
					<td>실버</td>
				</c:if>
				<c:if test="${user.gradeIndex == 2 }">
					<td>골드</td>
				</c:if>
				<c:if test="${user.gradeIndex == 3 }">
					<td>다이아</td>
				</c:if>
				<c:if test="${user.gradeIndex == 4 }">
					<td>매니저</td>
				</c:if>
				<td><fmt:formatNumber value="${user.purchase }" pattern="#,###" />원</td>
				<td>${user.point }</td>
				<td>${user.joinDate }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${userPage != 1 }">
			<a href="${contextPath }/admin/user?page=${userPage - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${userStartPage }" end="${userEndPage }">
			<c:if test="${userPage == i }">
				<span style="color:#9ccc65">${i }</span>
			</c:if>
			<c:if test="${userPage != i }">
				<a href="${contextPath }/admin/user?page=${i }">${i }</a>
			</c:if>
		</c:forEach>
		<c:if test="${userPage != userEndPage }">
			<a href="${contextPath }/admin/user?page=${userPage + 1}">[다음]</a>
		</c:if>
	</div>
</section>