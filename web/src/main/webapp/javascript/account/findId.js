/**
 * 유효성검사
 */
function checkFindId() {
	const regexpName = /^[가-힣a-zA-Z]{2,}$/;
	const regexpCallMiddleNumber = /^\d{3,4}$/;
	const regexpCallLastNumber = /^\d{4}$/;
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
	
	if (!f.userName.value) {
		alert("이름을 입력하세요.");
		return f.userName.focus();
	} else if (!regexpName.test(f.userName.value)) {
		alert("이름을 잘못입력했습니다.");
		return f.userName.select();
	}
	
	if (!f.year.value) {
		alert("생년월일을 입력하세요.");
		return false;
	}
	
	if (!f.month.value) {
		alert("생년월일을 입력하세요.");
		return false;
	}
	
	if (!f.day.value) {
		alert("생년월일을 입력하세요.");
		return false;
	}
	
	if (!f.mobileCarrier.value) {
		alert("이동통신사를 입력하세요.");
		return;
	}

	if (!f.firstPhoneNumber.value) {
		alert("전화번호를 입력하세요.");
		return;
	}	
	
	if (!f.middlePhoneNumber.value) {
		alert("전화번호를 입력하세요.");
		return f.middlePhoneNumber.focus();
	} else if (!regexpCallMiddleNumber.test(f.middlePhoneNumber.value)) {
		alert("전화번호를 잘못입력했습니다.");
		return f.middlePhoneNumber.select();
	}
	
	if (!f.lastPhoneNumber.value) {
		alert("전화번호를 입력하세요.");
		return f.lastPhoneNumber.focus();
	} else if (!regexpCallLastNumber.test(f.lastPhoneNumber.value)) {
		alert("전화번호를 잘못입력했습니다.");
		return f.lastPhoneNumber.select();
	}
	
	if(!f.emailId.value){
		alert("이메일아이디를 입력하세요.");
		return f.emailId.focus();
	} else if(!regexpId.test(f.emailId.value)) {
		alert("이메일아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return f.emailId.select();
	}
	
	if (!f.emailAddress.value) {
		alert("이메일주소를 선택하세요.");
		return;
	}
	
	f.submit();
	
}

/**
 * 전화번호 입력시 자동으로 넘어가기
 */
function moveNumber(event) {
	if(f.middlePhoneNumber.value.length === f.middlePhoneNumber.maxLength) {
		f.lastPhoneNumber.focus();
	}
	
	if(event.keyCode === 8) { // keyCode 8 = backspace
		if(f.lastPhoneNumber.value.length === 0) {
			f.middlePhoneNumber.focus();
		}
	}
}

/**
 * 년도와 달을 구하여 마지막 날짜가 몇일인지 계산
 */
function getDate() {
	const year = f.year.value;
	const month = f.month.value;
	const day = new Date(year, month, 0).getDate();
	
	f.day.options.length = 0;
	
	for(var i = 0; i < day; i++) {
		f.day.options[i] = new Option(i + 1, i + 1);
	}
}

/**
 * 화면이 로드되면 년도와 달과 몇일인지 초기화
 */
window.onload = function setDate() {
	const startYear = 1900;
	const today = new Date();
	const todayYear = today.getFullYear();
	const selectYear = (todayYear - startYear)/2;
	
	for(var i = 0; i < todayYear - startYear + 1; i++) {
		f.year.options[i] = new Option(i + startYear, i + startYear);
	}
	
	f.year.options[(todayYear - startYear)/2].selected = true;
	
	for(var i = 0; i < 12; i++) {
		f.month.options[i] = new Option(i + 1, i + 1);
	}
	
	const day = new Date(selectYear, 1, 0).getDate();
	
	for(var i = 0; i < day; i++) {
		f.day.options[i] = new Option(i + 1, i + 1);
	}
}
