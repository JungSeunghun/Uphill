<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<input type="text" name="userPassword">
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">비밀번호 확인</div>
			<input type="text" name="userPasswordCheck">
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
			<div id="updateFormDivTitle">전화번호</div>
			<select name="firstPhoneNumber">
				<option value="010">010</option>
				<option value="011">011</option>
			</select> -
			<input type="text" name="middlePhoneNumber" maxlength="4" onkeydown="moveNumber(event)"> -
			<input type="text" name="lastPhoneNumber" maxlength="4" onkeydown="moveNumber(event)">
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">주소</div>
			<input type="text" name="postCode" id="postCode" onclick="findAddress();" placeholder="우편번호" readonly="readonly"><br>
			<input type="text" name="address" id="address" onclick="findAddress();" placeholder="주소" readonly="readonly"><br>
			<div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
				<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
			</div>
			<div id="addressForm">
				<input type="text" name="addressDetail" id="addressDetail" placeholder="상세주소" maxlength="45">
				<input type="text" name="addressExtra" id="addressExtra" placeholder="추가주소" readonly="readonly">
			</div>
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">이메일</div>
			<input type="text" id="emailId" name="emailId" onchange="changedEmail()"> @
			<select id="emailAddress" name="emailAddress">
				<option value="">이메일을 선택하세요.</option>
				<option value="@naver.com">naver.com</option>
				<option value="@daum.net">daum.net</option>
				<option value="@gmail.com">gmail.com</option>
			</select>
			<button type="button" onclick="sendSecureCode();">보안코드 전송</button>
			<div id="checkDuplicateEmailResult"></div>
			<input type="hidden" id="canUseEmail" value="false">
		</div>
		<div id="updateFormDiv">
			<div id="updateFormDivTitle">보안코드 입력</div>
			<input type="text" id="secureCode">
			<button type="button" onclick="checkSecureCode();">확인</button>
			<div id="checkSecureCodeResult"></div>
			<input type="hidden" id="isSecureCode" value="false">
		</div>
		<div>
		<button type="button" id="updateButton" onclick="userUpdate();">수정하기</button>
	</div>
	</form>
</section>