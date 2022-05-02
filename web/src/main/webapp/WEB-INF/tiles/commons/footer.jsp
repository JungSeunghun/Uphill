<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<footer>
	<div id="up">
		<a href="${contextPath }/home/intro">회사소개</a>
		<a href="${contextPath }/home/policy">이용약관</a>
		<a href="${contextPath }/home/policy?id=policy2">개인정보취급방침</a>
		<a href="${contextPath }/home/policy?id=policy3">이메일주소무단수집거부</a>
	</div>
	<div id="down">
		<img alt="uphill_logo_black" src="${pageContext.request.contextPath}/images/logos/uphill_logo_black.svg">
		<p>
			상호 : (주)업힐자전거 l 사업자등록번호 : 000-00-00000<br>
			사업장주소 : 대구광역시 달서구 달구벌대로 251 안길 15 l TEL (053) 000-0000 l FAX : (053) 000-0000<br>
			개인정보 관리자 : 정승훈 l E-MAIL : uphill@uphill.com<br>
			Copyrightⓒ 2022. UpHill Corporation. All rights reserved.
		</p>
	</div>
</footer>