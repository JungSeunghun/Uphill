<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/home/intro.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fe035c8da71dcbd1c481b97383153aa6"></script>

<section>
	<div>
		<div>
			<h1>Uphill</h1>
			<img src="${contextPath }/images/intro/~.jpg"/>
			<h4></h4>
			<div>
			<p>글작성</p>
			</div>
			<div>
			<p>Uphill</p>
			<table width="" border="">회사주소</table>
			<table width="" border="">회사전화번호</table>
			<div id="map" style="width:500px;height:400px;"></div>
		</div>
	</div>	
</section>

<script type="text/javascript" src="${contextPath}/javascript/home/intro.js" ></script>