<!-- 교재 762p~768p 그림 보고 기능을 파악하기 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%> <!-- isELIgnored="false"(기본값) -->
<!-- JSTL 사용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>장바구니 목록</title>
	<style type="text/css">
		#listForm {
		   width: 640px;
		   border: 1px red solid;
		   margin: auto;
		   
		}
		
		h2 {
		   text-align: center;
		}
		
		table {
		   width: 550px;
		   margin: auto;
		}
		
		.tr_top {
		   background-color: lime;
		}
		
		.div_empty {
		   text-align: center;
		   background-color:
		}
		
		.td_command {
		   text-align: right;
		}
		#todayImageList{
		   text-align: center;
		}
		#productImage{
		   width:150px;
		   height:150px;
		   border:none;
		}
		#cartImage{
		   width:70px;
		   height:70px;
		   border:none;
		}
		#select{
			text-align: right;
		}
		#commandList{
			text-align: center;
		}
		#upImage{
			width: 15px;
		}
		#downImage{
			width: 15px;
		}
	</style>
	<script type="text/javascript">
		function checkAll(theForm) {
			if(theForm.remove.length == undefined) { // 장바구니 항목을 선택하는 체크박스가 1개일 때(즉, 개 상품이 1개일때) length는 undefined가 된다.(이유?length는 배열에만 존재)
				theForm.remove.checked = theForm.allCheck.checked; // true, 채크 해제하면 false
			} else { // 장바구니 항목을 선택하는 체크박스가 여러 개일 때(=배열객체(remove)일 때, 즉 개 상품이 2개 이상 담겼을 때)
				for(var i = 0; i < theForm.remove.length; i++) {
					theForm.remove[i].checked = theForm.allCheck.checked;
				}
			}
		}
		
		/*
		 - encodeURI(문자열) : 인터넷 주소에서 사용하는 특정문자(':', ';', '/', '=', '?', '&')를 제외하고 "UTF-8로 인코딩"하는 함수
		 - encoddeURIComponent(문자열) : 모든 문자를 "UTF-8"로 인코딩하는 함수
		 
		 - decodeURI(인코딩된 문자열) : "encodeURI()로 인코딩된 문자열"을 디코딩해주는 함수
		 - decoddeURIComponent(인코딩된 문자열) : "encoddeURIComponent()로 인코딩된 문자열"을 디코딩해주는 함수
		 */
		function checkQtyUp(kind, qty, startMoney, endMoney) {
			if(qty < 10) {
				location.href = "dogCartQtyUp.dog?kind=" + encodeURIComponent(kind) + "&startMoney=" + startMoney + "&endMoney=" +endMoney;
			}	 
		}

		 function checkQtyDown(kind, qty, startMoney, endMoney) {
			if(qty > 1) { // 현재 수량이 1보다 크면
				location.href = "dogCartQtyDown.dog?kind=" + encodeURIComponent(kind) + "&startMoney=" + startMoney + "&endMoney=" +endMoney;
			}
		}
		 
		 
	</script>
</head>
<body>
	<!-- 
	검색에 사용되는 startMoney(=최하)값과 endMoney(=최고)값을 속성으로 설정한다.
	이 때, 검색작업을 하지 않고 장바구니 목록 보기 페이지가 실행된 경우는 이 값들이 null이기 때문에  
	-->
	<c:if test="${startMoney != null }">
		<c:set var="startMoney" value="${startMoney }"/>
	</c:if>	
	
	<c:if test="${endMoney != null }">
		<c:set var="endMoney" value="${endMoney }"/>
	</c:if>	
	
	<section id="listForm">
		<c:if test="${cartList != null && cartList.size() > 0 }">
			<h2>장바구니 목록</h2>
			<form method="post"> <!-- action 제외한 이유 : 아래에서 요청을 각각 처리하기 위해서 -->
				<table>
					<tr id="select">
						<td colspan="6">
							<select name="startMoney" id="startMoney">
								<option value="">=최하=</option>
								<!-- JSTL 사이에 주석처리할 때 주의하기 -->
								<!-- switch() -->
								<c:choose>
									<c:when test="${startMoney==1000 }">
										<option selected="selected">1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
									</c:when>
									<c:when test="${startMoney==2000 }">
										<option>1000</option>
										<option selected="selected">2000</option>
										<option>3000</option>
										<option>4000</option>
									</c:when>
									<c:when test="${startMoney==3000 }">
										<option>1000</option>
										<option>2000</option>
										<option selected="selected">3000</option>
										<option>4000</option>
									</c:when>
									<c:when test="${startMoney==4000 }">
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option selected="selected">4000</option>
									</c:when>
									<c:otherwise>
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
									</c:otherwise>
								</c:choose>
							</select>
							
							<select name="endMoney" id="endMoney">
								<option value="">=최고=</option>
								<!-- JSTL 사이에 주석처리할 때 주의하기 -->
								<!-- switch() -->
								<c:choose>
									<c:when test="${endMoney==1000 }">
										<option selected="selected">1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
									</c:when>
									<c:when test="${endMoney==2000 }">
										<option>1000</option>
										<option selected="selected">2000</option>
										<option>3000</option>
										<option>4000</option>
									</c:when>
									<c:when test="${endMoney==3000 }">
										<option>1000</option>
										<option>2000</option>
										<option selected="selected">3000</option>
										<option>4000</option>
									</c:when>
									<c:when test="${endMoney==4000 }">
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option selected="selected">4000</option>
									</c:when>
									<c:otherwise>
										<option>1000</option>
										<option>2000</option>
										<option>3000</option>
										<option>4000</option>
									</c:otherwise>
								</c:choose>
							</select>
							
							<!-- [검색]버튼을 클릭하면 '최하가격~최고가격'으로 장바구니 항목을 검색하는 요청 -->
							<input type="submit" value="검색" formaction="dogCartSearch.dog">
						</td>
					</tr>
					
					<tr class="tr_top">
						<td>
						<!-- 
						전체 체크 박스 : 체크하면 모든 장바구니 항목의 체크박스가 체크, 
						체크 해제하면 모든 장바구니 항목의 체크박스가 체크해제
						-->
						<input type="checkbox" name="allCheck" onclick="checkAll(this.form)">
						</td>
						<td>번호</td>
						<td>상품 이미지</td>
						<td>상품명</td>
						<td>가격</td>
						<td>수량</td>
					</tr>
					<!-- 향상된 for문 시작 -->
					<c:forEach var="cart" items="${cartList }" varStatus="status">
						<tr>
							<!-- 삭제할 기준 : cart.kind(개품종=개 상품명) -->
							<td><input type="checkbox" name="remove" value="${cart.kind }"></td>
							<td>${status.index+1 }</td>
							<td><img src="images/${cart.image }" id="cartImage"></td>
							<td>${cart.kind }</td>
							<td>${cart.price }</td>
							<td>
								<!-- ▲ 클릭 시 : 장바구니 항목의 수량 증가 요청(이 때, kind 값을 파라미터로 전송해야 함) -->
								<a href="javascript:checkQtyUp('${cart.kind }','${cart.qty }','${startMoney }', '${endMoney }')"><img src="images/up.jpg" id="upImage" border="0"></a>
								<br>
								${cart.qty }<!-- 현재 수량 -->
								<br>
								<!-- ▼ 클릭 시 : 장바구니 항목의 수량 감소 요청하기 위해 checkQty()함수 호출(이 때, "kind값과 현재 수량"을 매개값으로 전송해야 함) -->
								<a href="javascript:checkQtyDown('${cart.kind }','${cart.qty }','${startMoney }', '${endMoney }')"><img src="images/down.jpg" id="downImage" border="0"></a>
							</td>
						</tr>
					</c:forEach>
					<!-- 향상된 for문 끝 -->
					<tr>
						<td colspan="6" align="center">총 금액 : ${totalMoney }원</td>
					</tr>
					<tr>
						<td colspan="6" align="center">
							<input type="submit" value="삭제" formaction="dogCartRemove.dog">
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		<!-------------------------------------------------------->
		<c:if test="${cartList == null || cartList.size() == 0 }">
			<section class="div_empty">장바구니가 비어있습니다.</section>
		</c:if>
		<!-------------------------------------------------------->
		<nav id="commandList">
			<!-- 개 상품목록보기 요청 -->
			<a href="dogList.dog">쇼핑 계속하기</a>
		</nav>
	</section>
</body>
</html>