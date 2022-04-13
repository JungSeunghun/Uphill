/**
 * 
 */

function openCategory() {
	if(window.innerWidth < 1080) {
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
	if(mobileCategory.style.opacity === 0) {
		mobileCategory.style.opacity = 1;		
	} else {
		mobileCategory.style.opacity = 0;		
	}
}

function closeMobileCategory() {
	mobileCategory = document.getElementById("mobileCategory");
	mobileCategory.style.opacity = 0;		
	mobileCategory.style.width = "0px";	
}