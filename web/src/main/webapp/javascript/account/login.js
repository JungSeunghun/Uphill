/**
 * 로그인 
 */
function loginCheck() {
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
	const regexpPassword = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,20}$/;
	
	if(!f.userEnterId.value){
		alert("아이디를 입력하세요.");
		return f.userEnterId.focus();
	} else if(!regexpId.test(f.userEnterId.value)) {
		alert("아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return f.userEnterId.select();
	}
	
	if(!f.userPassword.value){
		alert("비밀번호를 입력하세요.");
		return f.userPassword.focus();
	} else if(!regexpPassword.test(f.userPassword.value)) {
		alert("비밀번호는 6~20자리의 영어 대소문자와 숫자 그리고 일부 특수문자(!@#$%^&*()?_~)로만 입력가능합니다.");
		return f.userPassword.select();
	}
	
	f.submit();
}