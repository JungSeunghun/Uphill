/**
 * 회원 수정
 */
function userUpdate() {
	const regexpId = /^[a-zA-Z0-9_]{4,20}$/;
	const regexpPassword = /^[a-zA-Z0-9!@#$%^&*()?_~]{6,20}$/;
	const regexpName = /^[가-힣a-zA-Z]{2,}$/;
	const regexpCallMiddleNumber = /^\d{3,4}$/;
	const regexpCallLastNumber = /^\d{4}$/;
	
	if(!f.userName.value) {
		alert("이름을 입력하세요.");
		return f.userName.focus();
	} else if (!regexpName.test(f.userName.value)) {
		alert("이름을 잘못입력했습니다.");
		return f.userName.select();
	}
	
	if(!f.userPassword.value) {
		alert("비밀번호를 입력하세요.");
		return f.userPassword.focus();
	} else if(!regexpPassword.test(f.userPassword.value)) {
		alert("비밀번호는 6~20자리의 영어 대소문자와 숫자 그리고 일부 특수문자(!@#$%^&*()?_~)로만 입력가능합니다.");
		return f.userPassword.select();
	}
	
	if(f.userPassword.value !== f.userPasswordCheck.value) {
		alert("비밀번호가 다릅니다.");
		return f.userPasswordCheck.select();
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
	
	if (!f.address.value) {
		alert("주소 입력하세요.");
		return f.address.focus();
	}

	if (!f.addressDetail.value) {
		alert("상세주소를 입력하세요.");
		return f.addressDetail.focus();
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