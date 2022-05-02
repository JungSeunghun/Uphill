/**
 * checkReview
 */
function checkAsk() {
	if(!f.title.value) {
		alert("제목을 입력하세요.");
		return false;
	}
	
	if(!f.content.value) {
		alert("내용을 입력하세요.");
		return false;
	}
	
	f.submit();
}

