/**
 * join2 유효성검사
 */
function checkJoin2() {
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
	const regexpPassword = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,20}$/;
	
	if(!f.userId.value){
		alert("아이디를 입력하세요.");
		return f.userId.focus();
	} else if(!regexpId.test(f.userId.value)) {
		alert("아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return f.userId.select();
	}
	
	if(f.canUseId.value !== "true") {
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
		return f.address.focus();
	}

	if (!f.addressDetail.value) {
		alert("상세주소를 입력하세요.");
		return f.addressDetail.focus();
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
	
	if (f.canUseEmail.value !== "true") {
		alert("보안코드를 다시 전송하세요.");
		return;
	}

	if (!f.secureCode.value) {
		alert("보안코드를 입력하세요.");
		return;
	}

	if (f.isSecureCode.value !== "true") {
		alert("보안코드를 잘못 입력하셨습니다.");
		return;
	}
	
	f.submit();
}

function findAddress() {
	// 현재 scroll 위치를 저장해놓는다.
	var element_wrap = document.getElementById('wrap');
    var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
    new daum.Postcode({
        oncomplete: function(data) {
            // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addressExtra").value = extraAddr;
            
            } else {
                document.getElementById("addressExtra").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postCode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addressDetail").focus();

            // iframe을 넣은 element를 안보이게 한다.
            // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
            element_wrap.style.display = 'none';

            // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
            document.body.scrollTop = currentScroll;
        },
        // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
        onresize : function(size) {
            element_wrap.style.height = size.height+'px';
        },
        width : '100%',
        height : '100%'
    }).embed(element_wrap);

    // iframe을 넣은 element를 보이게 한다.
    element_wrap.style.display = 'block';
}

function foldDaumPostcode() {
    // iframe을 넣은 element를 안보이게 한다.
	document.getElementById('wrap').style.display = 'none';
}

function checkDuplicateId() {
	const httpRequest = new XMLHttpRequest();
	const userId = document.getElementById("userId").value;
	
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
	if(userId==="") {
		alert("아이디를 입력하세요.");
		return;
	} else if(!regexpId.test(userId.value)) {
		alert("아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return f.userEnterId.select();
	}
	
	var reqJson = new Object();
	reqJson.userId = userId;
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
		    	var result = httpRequest.response;
		    	if(result.isDuplicateId.at(0) === "false") { // 존재하지 않는 아이디일 경우
		    		document.getElementById("checkDuplicateIdResult").innerText = "사용가능한 아이디 입니다.";		    		
		    		document.getElementById("canUseId").value = "true";		    		
		    	} else { // 존재하는 아이디일 경우
		    		document.getElementById("checkDuplicateIdResult").innerText = "이미 존재하는 아이디 입니다.";			    					    		
		    		document.getElementById("canUseId").value = "false";		    		
		    	}			    	
		    } else {
		    	alert('request error');
		    }
		}		
    };
    
    document.getElementById("checkDuplicateIdResult").innerText = "잠시만 기다려 주세요.";	
    httpRequest.open('POST', 'check-duplicate-id-action', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));
}

function changedId() {
	document.getElementById("canUseId").value = "false";
}

function sendSecureCode() {
	const httpRequest = new XMLHttpRequest();
	const emailId = document.getElementById("emailId").value;
	const emailAddress = document.getElementById("emailAddress").value;
	
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
		
	if(emailId==="") {
		alert("이메일을 입력하세요.");
		return;
	} else if(!regexpId.test(emailId.value)) {
		alert("이메일 아이디는 4~20자리의 영어 대소문자와 숫자 그리고 _로만 입력가능합니다.");
		return f.userEnterId.select();
	}
	
	if(emailAddress==="") {
		alert("이메일 주소를 선택하세요.");
		return;
	}

	var reqJson = new Object();
	reqJson.email = emailId + emailAddress;
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
		    	var result = httpRequest.response;
		    	if(result.isDuplicateEmail.at(0) === "false") { // 존재하지 않는 이메일일 경우
		    		document.getElementById("checkDuplicateEmailResult").innerText = "보안코드를 이메일로 전송했습니다.";		    		
		    		document.getElementById("canUseEmail").value = "true";		    		
		    	} else { // 존재하는 이메일일 경우
		    		document.getElementById("checkDuplicateEmailResult").innerText = "이미 존재하는 이메일 입니다.";			    					    		
		    		document.getElementById("canUseEmail").value = "false";		    		
		    	}			    	
		    } else {
		    	alert('request error');
		    }
		}		
    };
    document.getElementById("checkDuplicateEmailResult").innerText = "잠시만 기다려주세요.";
    httpRequest.open('POST', 'check-duplicate-email-action', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));
}

function changedEmail() {
	document.getElementById("canUseEmail").value = "false";
}

function checkSecureCode() {
	const httpRequest = new XMLHttpRequest();
	
	const secureCode = document.getElementById("secureCode").value;
	if(secureCode == "") {
		alert("보안코드를 입력해주세요.");
		return f.secureCode.select();
	}
	
	var reqJson = new Object();
	reqJson.secureCode = secureCode;
	httpRequest.onreadystatechange = () => {
		if (httpRequest.readyState === XMLHttpRequest.DONE) {
			if (httpRequest.status === 200) {
		    	var result = httpRequest.response;
		    	if(result.isSecureCodeCheck.at(0) === "true") {
		    		document.getElementById("checkSecureCodeResult").innerText = "확인되었습니다.";		    		
		    		document.getElementById("isSecureCode").value = "true";		    		
		    	} else {
		    		document.getElementById("checkSecureCodeResult").innerText = "잘못된 보안코드입니다.";			    					    		
		    		document.getElementById("isSecureCode").value = "false";		    		
		    	}			    	
		    } else {
		    	alert('request error');
		    }
		}		
    };
    document.getElementById("checkSecureCodeResult").innerText = "잠시만 기다려주세요.";
    httpRequest.open('POST', 'check-secure-code-action', true);
    httpRequest.responseType = "json";
    httpRequest.setRequestHeader('Content-Type', 'application/json');
    httpRequest.send(JSON.stringify(reqJson));
}