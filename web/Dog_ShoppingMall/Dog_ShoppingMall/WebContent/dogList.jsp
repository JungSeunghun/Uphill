<!-- 개 상품 목록(dogList)과 오늘 본 개 상품 목록(todayImageList)을 출력해주는 뷰 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%> <!-- EL 사용 -->

<!-- [JSTL 사용] 먼저, 3개의 jar를 다운받아 lib에 붙여넣기 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
// ★★[EL언어 사용하므로 필요없음]
// String dogList = (String)request.getAttribute("dogList");
// String todayImageList = (String)request.getAttribute("todayImageList");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		#listForm{
			width:700px;
			height:500px;
			border:1px solid red;
			margin:auto;
		}
		h2{
			text-align:center;
		}
		
		table{
			margin:auto;
			width:550px;
		}
	
		.div_empty{
			background-color:red;
			width: 100%;
			height: 100%;
			text-align: center;
		}
	
		#todayImageList{
			text-align: center;
		}
		#productImage{
			width: 150px;
			height: 150px;
			border: none;
		}
		#todayImage{
			width: 100px;
			height: 100px;
			border: none;
		}
	</style>
</head>
<body>
	<section id="listForm">
	
		<c:if test="${dogList != null }"> <!-- 1. 개상품목록이 있으면 -->
			<h2>개 상품 목록 <a href="dogRegistForm.dog">개상품목록(관리자모드)</a></h2>
			<table>
				<tr>
					<c:forEach var="dog" items="${dogList }" varStatus="status"> <!-- 향상된 for문 -->
						<td><!-- dogView.dog : 개 상품 하나의 상세보기 요청 -->
							<a href="dogView.dog?id=${dog.id }"><img src="images/${dog.image }" id="productImage"></a>
							상품명 : ${dog.kind }<br>
							가격 : ${dog.price }<br>
						</td>
						<!-- 
						개 상품 목록을 출력할 때 1줄에 4개씩만 나란히 출력되도록 하기 위해
						
						index 0부터 시작 , count 1부터 시작
						1 mod 4 == 1, 2 mod 4 == 2, 3 mod 4 == 3(거짓) </tr><tr>실행안되고 
						4 mod 4 == 0(참) </tr>실행되어 줄만드는 것을 마무리한 후 다시 <tr>로 줄만들기 시작 후 for문 실행..
						-->
						<c:if test="${((status.index+1) mod 4) == 0 }">
							</tr>
							<tr>
						</c:if>
					</c:forEach>
				</tr>
			</table>
		</c:if>
		
		<c:if test="${dogList == null }"> <!-- 1. 개상품목록이 없으면 -->
			<div class="div_empty">개 상품이 없습니다. 분양불가</div>
		</c:if>
		
		<!-- [아래쪽부분]오늘 본 개 상품 이미지 -->
		<c:if test="${(todayImageList != null)&&(dogList != null) }">
			<div id="todayImageList">
				<h2>오늘 본 개 상품 목록</h2>
				<table>
					<tr>
						<c:forEach var="todayImage" items="${todayImageList }" varStatus="status">
							<td>
								<img src="images/${todayImage }" id="todayImage">
							</td>
							<c:if test="${(status.count mod 4) == 0 }">
								</tr>
								<tr>
							</c:if>
						</c:forEach>
					</tr>
				</table>
			</div>
		</c:if>
		
	</section>
</body>
</html>