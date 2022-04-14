/**
 * 
 */

function openCategory() {
	if(window.innerWidth < 1024) {
		return;
	}
	category = document.getElementById("category");
	categoryDiv = document.getElementById("categoryDiv");
	
	category.style.opacity = 1;
	category.style.height = "168px";
	categoryDiv.style.height = "168px";
}

function closeCategory() {
	category = document.getElementById("category");
	categoryDiv = document.getElementById("categoryDiv");
	
	category.style.opacity = 0;	
	category.style.height = "0px";
	categoryDiv.style.height = "0px";
}

function mobileCategoryToggle() {
	mobileCategory = document.getElementById("mobileCategory");
	if(mobileCategory.style.width !== "144px") {
		mobileCategory.style.opacity = 1;		
		mobileCategory.style.width = "144px";		
	} else {
		mobileCategory.style.opacity = 0;		
		mobileCategory.style.width = "0px";		
	}
}

var scrollHeight = document.documentElement.scrollTop;
window.onscroll = function() {
	gnb=document.getElementById("gnb");

	if(scrollHeight < 36) {
		gnb.style.position = "relative";
	} else {
		if(scrollHeight < document.documentElement.scrollTop && window.innerWidth >= 1024) {
			gnb.style.height = 0;			
			gnb.style.overflow = "hidden";			
		} else {
			gnb.style.height = "56px";
			gnb.style.overflow = "visible";			
		}
		gnb.style.position = "fixed";
		gnb.style.top = "0px";
	}
	scrollHeight = document.documentElement.scrollTop;
}
