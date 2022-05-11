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
		    new kakao.maps.LatLng(35.85081371174837, 128.55994676968777),
		    new kakao.maps.LatLng(35.85062876046185, 128.55892204927704),
		    new kakao.maps.LatLng(35.85001816335204, 128.55666867928784),
		    new kakao.maps.LatLng(35.8493220841345, 128.55579448598687),
		    new kakao.maps.LatLng(35.84875109248019,128.55482866793665),
		    new kakao.maps.LatLng(35.84842822781692,128.55470891180337),
		    new kakao.maps.LatLng(35.84814228864703,128.55486935627036),
		    new kakao.maps.LatLng(35.84778724720198,128.55479878064415),
		    new kakao.maps.LatLng(35.84734890899979,128.55454948583483),
		    new kakao.maps.LatLng(35.846839715278215,128.55403040505453),
		    new kakao.maps.LatLng(35.84651166693511,128.55378880353942),
		    new kakao.maps.LatLng(35.84627514003507,128.5536126315882),
		    new kakao.maps.LatLng(35.84605867010431,128.5532791304117),
		    new kakao.maps.LatLng(35.84595370627856,128.5530335836382),
		    new kakao.maps.LatLng(35.84597258348389,128.55261889553577),
		    new kakao.maps.LatLng(35.846061710393684,128.55234669568597),
		    new kakao.maps.LatLng(35.846247042867226,128.55212617707673),
		    new kakao.maps.LatLng(35.846354366864524,128.55201481951602),
		    new kakao.maps.LatLng(35.84644864142982,128.55186723560675),
		    new kakao.maps.LatLng(35.84649050518243,128.55176567016483)
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
		    new kakao.maps.LatLng(35.828396845914334, 128.62143680409088),
		    new kakao.maps.LatLng(35.82803078811066, 128.6215178804687),
		    new kakao.maps.LatLng(35.82760370849344, 128.62178029514885),
		    new kakao.maps.LatLng(35.8270741450521, 128.62195763052856),
		    new kakao.maps.LatLng(35.826538484217316, 128.6219190653132),
		    new kakao.maps.LatLng(35.826050928831265, 128.62165464150684),
		    new kakao.maps.LatLng(35.82587380942234, 128.62142419979108),
		    new kakao.maps.LatLng(35.82575268353185, 128.62105105000845),
		    new kakao.maps.LatLng(35.82622741142295, 128.61892510183742),
		    new kakao.maps.LatLng(35.826467013741954, 128.61786216346323),
		    new kakao.maps.LatLng(35.82645193400328, 128.61663913692988),
		    new kakao.maps.LatLng(35.826287075056335, 128.6138196678851),
		    new kakao.maps.LatLng(35.826473691152614, 128.6136795972372),
		    new kakao.maps.LatLng(35.82853863164256, 128.61425256102282),
		    new kakao.maps.LatLng(35.82866703289805, 128.61442114686486),
		    new kakao.maps.LatLng(35.82872232128734, 128.6146657115441),
		    new kakao.maps.LatLng(35.828420874202635, 128.62149262103839),
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