var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(35.85292255936242, 128.50608955414165),
	level: 3
};

var map = new kakao.maps.Map(container, options);