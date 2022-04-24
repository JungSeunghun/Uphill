<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userUpdate.css">
<script type="text/javascript" src="${contextPath}/javascript/user/userUpdate.js" ></script>
  
<section>
	<form action="/user/update-action" name="f" method="post">
		<div>
			<div>이름</div>
			<input type="text" name="">
		</div>
		<div>
			<div>비밀번호</div>
			<input type="text" name="">
		</div>
		<div>
			<div>비밀번호 확인</div>
			<input type="text" name="">
		</div>
		<div>
		 	<div>이동통신사</div>
		 	<label><input type="radio" name="" value="">&nbsp;skt</label>
		 	<label><input type="radio" name="" value="">&nbsp;kt</label>
		 	<label><input type="radio" name="" value="">&nbsp;LGU+</label>
		 	<label><input type="radio" name="" value="">&nbsp;알뜰폰</label>
		</div>
		<div>
			<div>전화번호</div>
			<input type="text" name="">
			<input type="text" name="">
			<input type="text" name="">
		</div>
		<div>
			<div>주소</div>
			<input type="text" name="">
		</div>
		<div>
			<div>이메일</div>
			<input type="text" name="">
		</div>
		<div>
		<button type="button" onclick="userUpdate();">수정하기</button>
	</div>
	</form>
</section>