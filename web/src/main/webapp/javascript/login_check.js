/**
 * 로그인 
 */
function login_check() {
	const regId = /^[a-zA-Z0-9_]{4,20}$/;
	const regPassword = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,20}$/;
	
	if(!f.user_enter_id.value){
		alert("아이디를 입력하세요.");
		return document.f.user_enter_id.focus();
	} else if(!regId.test(f.user_enter_id.value)) {
		alert("아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return document.f.user_enter_id.select();
	}
	
	if(!f.user_password.value){
		alert("비밀번호를 입력하세요.");
		return document.f.user_password.focus();
	} else if(!regPassword.test(f.user_password.value)) {
		alert("비밀번호는 6~20자리의 영어 대소문자와 숫자 그리고 일부 특수문자(!@#$%^&*()?_~)로만 입력가능합니다.");
		return document.f.user_password.select();
	}
	
	f.submit();
}