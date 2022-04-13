/**
 * 매인 배너 페이지 이동
 */

let bannerCount = 0;
function moveBanner(banner, path) {
	const bannerList = document.getElementsByClassName("mainBannerImage");
	const length = bannerList.length;
	
	if(banner === bannerList[bannerCount]){
		location.href = path;
	} else if(banner === bannerList[bannerCount+1]) {
		for(let i = 0; i < length; i++) {
			if(i === bannerCount) {
				if(bannerCount === length-2) {
					bannerList[i].style.width = "5%";
					bannerList[i+1].style.width = "95%";
					bannerList[i].style.transition = "1s";
					bannerList[i+1].style.transition = "1s";
					bannerCount++;
					break;
				} else {
					bannerList[i].style.width = "5%";
					bannerList[i+1].style.width = "90%";				
					bannerList[i+2].style.width = "5%";		
					bannerList[i].style.transition = "1s";
					bannerList[i+1].style.transition = "1s";
					bannerList[i+2].style.transition = "1s";
					bannerCount++;
					break;
				}
			}
			bannerList[i].style.width = "0%";
		}
	} else if(banner === bannerList[bannerCount-1]) {
		for(let i = length-1; i > 0; i--) {
			if(i === bannerCount) {
				if(bannerCount === 1) {
					bannerList[i].style.width = "5%";
					bannerList[i-1].style.width = "95%"
					bannerList[i].style.transition = "1s";
					bannerList[i-1].style.transition = "1s";;
					bannerCount--;
					break;
				} else {
					bannerList[i].style.width = "5%";
					bannerList[i-1].style.width = "90%";				
					bannerList[i-2].style.width = "5%";
					bannerList[i].style.transition = "1s";
					bannerList[i-1].style.transition = "1s";
					bannerList[i-2].style.transition = "1s";
					bannerCount--;
					break;
				}
			}
			bannerList[i].style.width = "0%";
		}
	}
}

/**
 * 매인배너 높이 조절
 */
window.onresize = function () {
	const bannerList = document.getElementsByClassName("mainBannerImage");
	for(let i = 0; i < bannerList.length; i++) {
		bannerList[i].style.height = window.innerWidth * 0.35 + "px";
		bannerList[i].style.transition = "0s";
	}
}

window.onload = function () {
	const bannerList = document.getElementsByClassName("mainBannerImage");
	for(let i = 0; i < bannerList.length; i++) {
		bannerList[i].style.height = window.innerWidth * 0.35 + "px";		
		bannerList[i].style.transition = "0s";
	}
}
