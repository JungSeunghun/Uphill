<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/community/road.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fe035c8da71dcbd1c481b97383153aa6"></script>
<section>
	<h1>산책로</h1>
	<h1>두류공원로</h1>
	<div id="map1" style="width:100%; max-width:1024px; height:400px;"></div>
	<p>거리가 약 880m정도로 조용한 산책로다 </p>
	<h1>수성못</h1>
	<div id="map2" style="width:100%; max-width:1024px; height:400px;"></div>
	<p>거리가 2km정도로 사람이 많은 산책로다 </p>
	<script>
		var container = document.getElementById('map1');
		var options = {
			center: new kakao.maps.LatLng(35.848709122076606, 128.55476420433092),
			level: 4 //값이 증가할수록 축소
		};

		var map = new kakao.maps.Map(container, options);
		
		var linePath = [
		    new kakao.maps.LatLng(35.85078704334387, 128.55991857516668),
		    new kakao.maps.LatLng(35.84996950876503, 128.55659854865448),
		    new kakao.maps.LatLng(35.848721991477554, 128.55481426405126),
		    new kakao.maps.LatLng(35.84802756407561, 128.55485604779335),
		    new kakao.maps.LatLng(35.84591841960664, 128.55314911118253) 
		];

		var polyline = new kakao.maps.Polyline({
		    path: linePath, // 선을 구성하는 좌표배열 입니다
		    strokeWeight: 5, // 선의 두께 입니다
		    strokeColor: '#ef5350', // 선의 색깔입니다
		    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		    strokeStyle: 'solid' // 선의 스타일입니다
		});

		polyline.setMap(map);
	</script>
	
	<script>
		var container = document.getElementById('map2');
		var options = {
			center: new kakao.maps.LatLng(35.827283017038894, 128.61732545621203),
			level: 4 //값이 증가할수록 축소
		};

		var map = new kakao.maps.Map(container, options);
		
		var linePath = [
		    new kakao.maps.LatLng(35.82872568842167, 128.61458278729268 ),
		    new kakao.maps.LatLng(35.82832199938138, 128.62147401078573 ),
		    new kakao.maps.LatLng(35.826837136793216, 128.6219915357254 ),
		    new kakao.maps.LatLng(35.82560360123975, 128.62124719161093 ),
		    new kakao.maps.LatLng(35.82645154581888, 128.61717026554783 ),
		    new kakao.maps.LatLng(35.82625950422722, 128.61369185837864 ),
		    new kakao.maps.LatLng(35.82858540877375, 128.61429223833406 ),
		    new kakao.maps.LatLng(35.82872155553305, 128.61455503939828  ),
		];

		var polyline = new kakao.maps.Polyline({
		    path: linePath, // 선을 구성하는 좌표배열 입니다
		    strokeWeight: 5, // 선의 두께 입니다
		    strokeColor: '#ef5350', // 선의 색깔입니다
		    strokeOpacity: 0.7, // 선의 불투명도 입니다 1에서 0 사이의 값이며 0에 가까울수록 투명합니다
		    strokeStyle: 'solid' // 선의 스타일입니다
		});

		polyline.setMap(map);
	</script>
</section>