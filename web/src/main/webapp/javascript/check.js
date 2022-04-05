/**
 * 유효성검사
 */

function checkJoin1() {
	const regName = /^[가-힣a-zA-Z]{2,}$/;
	const regCall2 = /^\d{3,4}$/;
	const regCall3 = /^\d{4}$/;

	if (!f.user_name.value.trim()) {
		alert("이름을 입력하세요.");
		f.u_id.focus();
		return false;
	} else if (!regName.test(document.f.user_name.value.trim())) {
		alert("이름을 잘못입력했습니다.");
		f.u_id.select();
		return false;
	}

	if (!f.birth.value) {
		alert("생년월일을 선택하세요.");
		return false;
	}
	/*
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
	*/

	if (!f.gender.value) {
		alert("성별을 입력하세요.");
		return false;
	}

	if (!f.mobile_carrier.value) {
		alert("이동통신사를 입력하세요.");
		return false;
	}

	if (!f.phone_number1.value) {
		alert("전화번호를 입력하세요.");
		return false;
	}
	
	if (!f.phone_number2.value.trim()) {
		alert("전화번호를 입력하세요.");
		f.phone_number2.focus();
		return false;
	} else if (!regPhone2.test(document.f.phone_number2.value.trim())) {
		alert("전화번호를 잘못입력했습니다.");
		f.phone_number2.select();
		return false;
	}
	
	if (!f.phone_number3.value.trim()) {
		alert("전화번호를 입력하세요.");
		f.phone_number3.focus();
		return false;
	} else if (!regPhone3.test(document.f.phone_number3.value.trim())) {
		alert("전화번호를 잘못입력했습니다.");
		f.phone_number3.select();
		return false;
	}
	
	if (!f.agree1.value) {
		alert("개인 정보 수집 및 이용에 동의해야합니다.");
		return false;
	}
	if (!f.agree2.value) {
		alert("고유식별 정보처리에 동의해야합니다.");
		return false;
	}
	if (!f.agree3.value) {
		alert("통신사 이용약관에 동의해야합니다.");
		return false;
	}
	if (!f.agree4.value) {
		alert("이용약관에 동의해야합니다.");
		return false;
	}

}