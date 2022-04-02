<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Up-Hill 고객센터</title>
	<c:set var="contextPath" value="${pageContext.request.contextPath }" />
	<link rel="stylesheet" type="text/css" href="${contextPath }/css/common.css">
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/gnb.jsp" %>
	
	<section>
		<div>고객센터 페이지 입니다.</div>
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>