<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/user/userUpdate.css">
<script type="text/javascript" src="${contextPath}/javascript/user/userUpdate.js" ></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
  
<section>
	<form action="${contextPath }/user/user-update-action" name="f" method="post">
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">이름</div>
			<input type="text" name="userName" value="${userVO.userName }">
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">비밀번호</div>
			<input type="password" name="userPassword">
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">비밀번호 확인</div>
			<input type="password" name="userPasswordCheck">
		</div>
		<div id="updateFormDiv">
		 	<div id="updateFormDivTitle">이동통신사</div>
		 	<c:if test="${userVO.mobileCarrier == 'SKT' }">
			 	<label><input type="radio" name="mobileCarrier" value="SKT" checked="checked">SKT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="KT">KT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+&nbsp;&nbsp;</label>
		 		<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;&nbsp;</label>
		 	</c:if>
		 	<c:if test="${userVO.mobileCarrier == 'KT' }">
			 	<label><input type="radio" name="mobileCarrier" value="SKT">SKT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="KT" checked="checked">KT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+&nbsp;&nbsp;</label>
		 		<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;&nbsp;</label>
		 	</c:if>
		 	<c:if test="${userVO.mobileCarrier == 'LGU+' }">
			 	<label><input type="radio" name="mobileCarrier" value="SKT">SKT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="KT">KT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="LGU+" checked="checked">LGU+&nbsp;&nbsp;</label>
		 		<label><input type="radio" name="mobileCarrier" value="알뜰폰">알뜰폰&nbsp;&nbsp;</label>
		 	</c:if>
		 	<c:if test="${userVO.mobileCarrier == '알뜰폰' }">
			 	<label><input type="radio" name="mobileCarrier" value="SKT">SKT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="KT">KT&nbsp;&nbsp;</label>
			 	<label><input type="radio" name="mobileCarrier" value="LGU+">LGU+&nbsp;&nbsp;</label>
		 		<label><input type="radio" name="mobileCarrier" value="알뜰폰" checked="checked">알뜰폰&nbsp;&nbsp;</label>
		 	</c:if>
		</div>
		<div id="updateFormDiv">
			<c:set var="firstPhoneNumber" value="${fn:substring(userVO.phoneNumber,0,3) }"/>
			<c:set var="middlePhoneNumber" value="${fn:substring(userVO.phoneNumber,3,7) }"/>
			<c:set var="lastPhoneNumber" value="${fn:substring(userVO.phoneNumber,7,11) }"/>
			<div id="updateFormDivTitle">전화번호</div>
			<select name="firstPhoneNumber">
				<c:if test="${firstPhoneNumber == '010' }">
					<option value="010" selected="selected">010</option>
					<option value="011">011</option>
				</c:if>
				<c:if test="${firstPhoneNumber == '011' }">
					<option value="010">010</option>
					<option value="011" selected="selected">011</option>
				</c:if>
			</select> -
			<input type="text" name="middlePhoneNumber" value="${middlePhoneNumber }" maxlength="4" onkeydown="moveNumber(event)"> -
			<input type="text" name="lastPhoneNumber" value="${lastPhoneNumber }" maxlength="4" onkeydown="moveNumber(event)">
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">주소</div>
			<input type="text" name="postCode" id="postCode" onclick="findAddress();" value="${userVO.postCode }" placeholder="우편번호" readonly="readonly"><br>
			<input type="text" name="address" id="address" onclick="findAddress();" value="${userVO.address }" placeholder="주소" readonly="readonly"><br>
			<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
			</div>
			<div id="addressForm">
				<input type="text" name="addressDetail" id="addressDetail" value="${userVO.addressDetail }" placeholder="상세주소" maxlength="45">
				<input type="text" name="addressExtra" id="addressExtra" value="${userVO.addressExtra }" placeholder="추가주소" readonly="readonly">
			</div>
		</div>
		<div>
			<button type="button" id="updateButton" onclick="userUpdate();">수정하기</button>
		</div>
	</form>
</section>