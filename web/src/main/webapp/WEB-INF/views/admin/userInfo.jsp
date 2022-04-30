<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/admin/userInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/admin/userInfo.js" ></script>

<section>
	<form action="${contextPath }/admin/user-delete-action" name="f" method="post">
		<input type="hidden" name="userIndex" value="${userInfo.userIndex }">
		<table>
			<tr>
				<td>아이디</td>
				<td>${userInfo.userId }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${userInfo.userName }</td>
			</tr>
			<tr>
				<td>등급</td>
				<c:if test="${userInfo.gradeIndex == 1 }">
					<td>실버</td>
				</c:if>
				<c:if test="${userInfo.gradeIndex == 2 }">
					<td>골드</td>
				</c:if>
				<c:if test="${userInfo.gradeIndex == 3 }">
					<td>다이아</td>
				</c:if>
				<c:if test="${userInfo.gradeIndex == 4 }">
					<td>매니저</td>
				</c:if>
			</tr>
			<tr>
				<td>성별</td>
				<td>${userInfo.gender }</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>${userInfo.birth }</td>
			</tr>
			<tr>
				<td>통신사</td>
				<td>${userInfo.mobileCarrier }</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${userInfo.phoneNumber }</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>(${userInfo.postCode })${userInfo.address } ${userInfo.addressDetail } ${userInfo.addressExtra }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${userInfo.email }</td>
			</tr>
			<tr>
				<td>구매금액</td>
				<td>${userInfo.purchase }</td>
			</tr>
			<tr>
				<td>포인트</td>
				<td>${userInfo.point }</td>
			</tr>
			<tr>
				<td>가입일</td>
				<td>${userInfo.joinDate }</td>
			</tr>
			<tr>
				<td>
					<button type="button" onclick="deleteUser()">회원삭제</button>
				</td>
			</tr>		
		</table>
	</form>
</section>