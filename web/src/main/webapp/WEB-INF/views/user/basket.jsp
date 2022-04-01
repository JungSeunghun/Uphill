<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장바구니</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/gnb.jsp" %>
	<%@ include file="../common/snb.jsp" %>
	<section>
		<c:forEach var="" items="${itemList }">
			<div>
				<div>
					<img src="">
				</div>
				<div>
					<p>1,000,000원</p>
				</div>
				<div>
					<p>★★★★☆(3)</p>
				</div>
				<div>
					<p>자전거 이름/색상/프레임/구동계/휠</p>
				</div>
				<div>
					<button></button>
					<div></div>
					<button></button>
				</div>
				<div>
					<p>주문금액</p>
				</div>
				<div>
					<p>1,000,000원</p>
				</div>
				<div>
					<input type="button" value="취소하기">
				</div>
			</div>
		</c:forEach>
		<form action="movePurchasePage.user" name="f" method="post">
			<div>			
				<div>
					<p>총 주문금액</p>
				</div>
				<div>
					<p>3,000,000원</p>
				</div>
				<div>
					<input type="button" value="구매하기">
				</div>
				<div>
					<input type="button" value="전체취소">
				</div>
			</div>
		</form>
	</section>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>