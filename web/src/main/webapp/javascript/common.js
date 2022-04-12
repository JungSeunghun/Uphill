/**
 * 
 */

function openCategory() {
	if(window.innerWidth < 1080) {
		return;
	}
	category = document.getElementById("category");
	
	category.style.display = "block";
}

function mobileCategoryToggle() {
	mobileCategory = document.getElementById("mobileCategory");
	if(mobileCategory.style.display !== "block") {
		mobileCategory.style.display = "block";		
	} else {
		mobileCategory.style.display = "none";
	}
}

function closeCategory() {
	category = document.getElementById("category");
	
	category.style.display = "none";
}