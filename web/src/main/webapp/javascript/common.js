function emptySearch() {
const searchNameList = document.getElementById("searchNameList");
	
	while (searchNameList.hasChildNodes()) {
		searchNameList.removeChild(searchNameList.firstChild);
	}
}

/*
 * 검색어
 */
function getSearch() {
	const httpRequest = new XMLHttpRequest();
	const search = document.getElementById("search").value;
	const searchNameList = document.getElementById("searchNameList");
	
	while (searchNameList.hasChildNodes()) {
		searchNameList.removeChild(searchNameList.firstChild);
	}
	
	if(search == '') {
		
		return;
	}
	 
	var reqJson = new Object();
	reqJson.search = search;
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
				while (searchNameList.hasChildNodes()) {
					searchNameList.removeChild(searchNameList.firstChild);
				}
		    	const result = httpRequest.response;
		    	console.log(result.searchNameList);
		    	result.searchNameList[0].forEach(
		    		(name)=>{
		    			var nameDiv = document.createElement('div');
		    			var nameNode = document.createTextNode(name);
		    			nameDiv.style.color = '#ffffff';
		    			nameDiv.appendChild(nameNode);
		    			searchNameList.appendChild(nameDiv);
		    		}
		    	);
			} else {
		    	alert('request error');
		    }
		}		
    };
    
    httpRequest.open('POST', window.location.origin + '/web/item/search-action', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));
}

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
	closeCategory();
	gnb=document.getElementById("gnb");

	if(window.innerWidth >= 1024) {
		if(scrollHeight < 36) {
			gnb.style.position = "relative";
		} else {
			// 휠을 내렸을 때
			if(scrollHeight < document.documentElement.scrollTop) {
				gnb.style.height = 0;			
				gnb.style.overflow = "hidden";			
			} else { // 휠을 올렸을 때
				gnb.style.height = "56px";
				gnb.style.overflow = "visible";			
			}
			gnb.style.position = "fixed";
			gnb.style.top = "0px";
		}
	} else {
		gnb.style.height = "56px";
		gnb.style.overflow = "visible";	
		gnb.style.position = "fixed";
		gnb.style.top = "0px";
	}
	scrollHeight = document.documentElement.scrollTop;
}
