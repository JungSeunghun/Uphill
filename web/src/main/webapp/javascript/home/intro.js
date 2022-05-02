var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(35.85292255936242, 128.50608955414165),
	level: 3
};

var map = new kakao.maps.Map(container, options);

var markerPosition  = new kakao.maps.LatLng(35.85292255936242, 128.50608955414165); 

//마커를 생성
var marker = new kakao.maps.Marker({
 position: markerPosition
});

//마커가 지도 위에 표시되도록 설정
marker.setMap(map);