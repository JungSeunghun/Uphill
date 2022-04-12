/**
 * 매인 배너 페이지 이동
 */

let bannerCount = 0;
function moveBanner(banner) {
	const bannerList = document.getElementsByClassName("mainBannerImage");
	const length = bannerList.length;
	
	if(banner === bannerList[bannerCount+1]) {
		for(let i = 0; i < length; i++) {
			if(i === bannerCount) {
				if(bannerCount === length-2) {
					bannerList[i].style.width = "5%";
					bannerList[i+1].style.width = "95%";
					bannerCount++;
					break;
				} else {
					bannerList[i].style.width = "5%";
					bannerList[i+1].style.width = "90%";				
					bannerList[i+2].style.width = "5%";				
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
					bannerList[i-1].style.width = "95%";
					bannerCount--;
					break;
				} else {
					bannerList[i].style.width = "5%";
					bannerList[i-1].style.width = "90%";				
					bannerList[i-2].style.width = "5%";				
					bannerCount--;
					break;
				}
			}
			bannerList[i].style.width = "0%";
		}
	}
}