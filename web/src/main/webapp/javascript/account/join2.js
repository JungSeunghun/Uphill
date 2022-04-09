/**
 * join2 유효성검사
 */
function checkJoin2() {
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
	const regexpPassword = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,20}$/;
	
	if(!f.userEnterId.value){
		alert("아이디를 입력하세요.");
		return f.userEnterId.focus();
	} else if(!regexpId.test(f.userEnterId.value)) {
		alert("아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return f.userEnterId.select();
	}
	
	if(f.canUseId.value === "false") {
		alert("아이디 중복확인을 눌러주세요.");
		return;
	}
	
	if(!f.userPassword.value){
		alert("비밀번호를 입력하세요.");
		return f.userPassword.focus();
	} else if(!regexpPassword.test(f.userPassword.value)) {
		alert("비밀번호는 6~20자리의 영어 대소문자와 숫자 그리고 일부 특수문자(!@#$%^&*()?_~)로만 입력가능합니다.");
		return f.userPassword.select();
	}
	
	if(!f.checkUserPassword.value){
		alert("비밀번호를 입력하세요.");
		return f.checkUserPassword.focus();
	} else if(!regexpPassword.test(f.checkUserPassword.value)) {
		alert("비밀번호는 6~20자리의 영어 대소문자와 숫자 그리고 일부 특수문자(!@#$%^&*()?_~)로만 입력가능합니다.");
		return f.checkUserPassword.select();
	}
	
	if(f.userPassword.value != f.checkUserPassword.value) {
		alert("비밀번호가 서로 다릅니다.");
		return f.checkUserPassword.select();
	}
	
	if (!f.address.value) {
		alert("주소 입력하세요.");
		return;
	}

	if (!f.addressDetail.value) {
		alert("상세주소를 입력하세요.");
		return;
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

function checkDuplicateId() {
	const httpRequest = new XMLHttpRequest();
	const userEnterId = document.getElementById("userEnterId").value;
	
	if(userEnterId==="") {
		alert("아이디를 입력하세요.");
		return;
	}

	var reqJson = new Object();
	reqJson.userEnterId = userEnterId;
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
		    	var result = httpRequest.response;
		    	if(result.isDuplicateId.at(0) === "false") {
		    		document.getElementById("checkDuplicateIdResult").innerText = "사용가능한 아이디 입니다.";		    		
		    		document.getElementById("canUseId").value = "true";		    		
		    	} else {
		    		document.getElementById("checkDuplicateIdResult").innerText = "이미 존재하는 아이디 입니다.";			    					    		
		    		document.getElementById("canUseId").value = "false";		    		
		    	}			    	
		    } else {
		    	alert('request error');
		    }
		}		
    };
    
    httpRequest.open('POST', 'check-duplicate-id-action', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));
}

function changedId() {
	document.getElementById("canUseId").value = "false";
}

function sendSecureCode() {
	
}