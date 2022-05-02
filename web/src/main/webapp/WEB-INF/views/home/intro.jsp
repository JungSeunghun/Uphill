<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/home/intro.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fe035c8da71dcbd1c481b97383153aa6"></script>
<section class="container">
		<div class="total">
		<!-- content -->
			<div class="content">
				<h2>소개</h2>
				<ul>
					<li>			
						<a href="">회사소개</a>
					</li>
				</ul>
			</div>
			<!-- main -->
			<div class="total_main">
				<div class="total_body">
					<h1 class="h3_body">Up-Hill</h1>
					<img src="${contextPath }/images/intro/bike.png" class="content_img">
					<div>
					<h4 style="font-size:24pt; padding:30px 0 20px 0;">
					<strong>라이더 중심의 자전거,Up-Hill</strong>
					</h4>
					<div  class="main_p">
					<p>Up-Hill은 자전거를 조립 및 판매하는 브랜드입니다.<br>
					Up-Hill은 독보적 상품 기획력과 디자인 역량을 기반으로 국내 자전거 수출 1위를<br>
					달성하며, 세계적 수준의 종합 바이크 전문기업으로 성장했습니다.<br>
					변화에 대응하는 빠른 판단을 통해 이룬 '전기자전거 국내 1위'를 넘어 스마트모빌리티<br>
					선도 기업으로의 도약을 준비합니다. 
					</p>
					</div>
					</div>
					<!-- 주소 -->
					<div class="address">
						<div class="address-left">
						<p class="p_title">Uphill</p>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
								<th width="70">주소</th>
								<td>대구광역시 달서구 달구벌대로251안길 15</td>
								</tr>
							</tbody>
						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
								<th width="70">전화번호</th>
								<td>(053)000-0000</td>
								</tr>
							</tbody>
						</table>						
						</div>
						<div id="map" style="width:100%; max-width:500px; height:400px;"></div>
					</div>
				</div>
			</div>
		</div>
	
</section>
<script type="text/javascript" src="${contextPath}/javascript/home/intro.js" ></script>
