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
		<%-- <c:if test="${itemList != null }">
				<c:forEach var="item" items="${itemList }">
					<img alt="best item" src="${contextPath }/images/items/${item.name }.svg">
					<div>${item.name }</div>
					<div>${item.price }</div>
					<div>${item.discountPrice }</div>
					<c:forEach begin="0" end="4">
						<img alt="empty star" src="${contextPath }/images/icons/empty_star.svg">
					</c:forEach>
					<c:forEach begin="0" end="${item.starRating}">
						<img alt="green star" src="${contextPath }/images/icons/green_star.svg">
					</c:forEach>
				</c:forEach>
			</c:if> --%>
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>