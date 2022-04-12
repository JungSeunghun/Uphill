/**
 * 
 */

function openCategory() {
	category = document.getElementById("category");
	
	category.style.display = "block";
}

function openCategoryToggle() {
	category = document.getElementById("category");
	if(category.style.display !== "block") {
		category.style.display = "block";		
	} else {
		category.style.display = "none";
	}
}

function closeCategory() {
	category = document.getElementById("category");
	
	category.style.display = "none";
}