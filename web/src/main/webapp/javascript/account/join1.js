/**
 * 유효성검사
 */
function checkJoin1() {
	const regexpName = /^[가-힣a-zA-Z]{2,}$/;
	const regexpCallMiddleNumber = /^\d{3,4}$/;
	const regexpCallLastNumber = /^\d{4}$/;

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
	
	if (!f.gender.value) {
		alert("성별을 입력하세요.");
		return;
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
	} else if (!regexpCallMiddleNumber.test(f.middle_phone_number.value)) {
		alert("전화번호를 잘못입력했습니다.");
		return f.middlePhoneNumber.select();
	}
	
	if (!f.lastPhoneNumber.value) {
		alert("전화번호를 입력하세요.");
		return f.lastPhoneNumber.focus();
	} else if (!regexpCallLastNumber.test(f.last_phone_number.value)) {
		alert("전화번호를 잘못입력했습니다.");
		return f.lastPhoneNumber.select();
	}
	
	if (!f.personalAgree.value) {
		alert("개인 정보 수집 및 이용에 동의해야합니다.");
		return;
	}
	
	if (!f.uniqueAgree.value) {
		alert("고유식별 정보처리에 동의해야합니다.");
		return;
	}
	
	if (!f.mobileAgree.value) {
		alert("통신사 이용약관에 동의해야합니다.");
		return;
	}
	
	if (!f.useAgree.value) {
		alert("이용약관에 동의해야합니다.");
		return;
	}
	
	f.submit();
	
}

/**
 * 전체선택
 */
function agreeAll() {
	const agrees = document.querySelectorAll('input[type="checkbox"]');
	
	agrees.forEach((agree) => {
	    agree.checked = f.agree.checked;
	  });
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

function getDate() {
	const year = f.year.value;
	const month = f.month.value;
	const day = new Date(year, month, 0).getDate();
	
	f.day.options.length = 0;
	
	for(var i = 0; i < day; i++) {
		f.day.options[i] = new Option(i + 1, i + 1);
	}
}

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
