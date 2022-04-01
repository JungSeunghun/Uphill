<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/gnb.jsp" %>
	<%@ include file="../common/snb.jsp" %>	
	<section>
		<div>
			<h2>홍길동 회원님 반갑습니다!</h2>
		</div>
		<div>
			<p>등급:실버</p>
		</div>
		<div>
			<p>포인트:10,000</p>
		</div>
		<div>
			<input type="button" value="탈퇴하기">
		</div>
	</section>	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>