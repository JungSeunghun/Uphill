/**
 * option 전부 선택시 selectedOrderItem에 선택한 옵션 보여주기
 */
function addOption(name, itemPrice) {
	const optionList = document.getElementsByClassName("itemOptionSelect");
	const optionNameArray = [];
	let isEmpty = false;
	
	for(let i = 0; i < optionList.length; i++) {
		optionNameArray[i] = optionList[i].value;
		if(optionList[i].value == '') {
			isEmpty = true;
		}
	}
	
	if(isEmpty === false) {
		let optionName = "";
		let optionPrice = 0;
		for(let i = 0; i < optionNameArray.length; i++) {
			optionName += optionNameArray[i] + "/";
			optionPrice += Number(document.getElementById(optionNameArray[i]).value);
		}
		optionName = optionName.substring(0, optionName.length-1);
		const selectedOrderItemOption = document.getElementsByClassName("selectedOrderItemOption");
		for(let i = 0; i < selectedOrderItemOption.length; i++) {
			if(selectedOrderItemOption[i].innerText === optionName) {
				alert("이미 선택하셨습니다.");
				return;				
			}
		}
		optionNameValue = document.createTextNode(optionName);
		
		const selectedOrderItemList = document.getElementById("selectedOrderItemList");
		const selectedOrderItem = document.getElementById("selectedOrderItem").cloneNode(true);
		selectedOrderItem.style.display = "block";
		selectedOrderItemList.appendChild(selectedOrderItem);
		
		const orderPrice = document.getElementById("orderPrice");		
		orderPrice.innerText = (Number(itemPrice) + optionPrice + parseInt(orderPrice.innerText.replace(/,/g, ''))).toLocaleString('ko-KR');	
		
		selectedOrderItem.firstElementChild.appendChild(optionNameValue);
		selectedOrderItem.lastElementChild.value = Number(itemPrice) + optionPrice;
				
		for(let i = 0; i < optionList.length; i++) {
			optionList[i].options[0].selected = true;
		}
	}
}

/*
 * cancel option
 */
function cancelOption(cancelButton) {
	const itemOptionNumber = cancelButton.previousElementSibling.value;
	const optionsPrice = cancelButton.nextElementSibling.value;	
	const orderPrice = document.getElementById("orderPrice");		
	orderPrice.innerText = Number(orderPrice.innerText.replace(/,/g, '')) - Number(optionsPrice) * itemOptionNumber;	
	cancelButton.parentNode.remove();
}

/*
 * multiply price
 */
function multiplyPrice(number) {
	const orderPrice = document.getElementById("orderPrice");
	const optionPrice = number.nextElementSibling.nextElementSibling;
	
	if(!number.oldvalue) {
		orderPrice.innerText = parseInt(orderPrice.innerText.replace(/,/g, '')) - optionPrice.value;		
	} else {
		orderPrice.innerText = parseInt(orderPrice.innerText.replace(/,/g, '')) - optionPrice.value*number.oldvalue;				
	}
	price = optionPrice.value * number.value;
	
	orderPrice.innerText = (Number(orderPrice.innerText) + Number(price)).toLocaleString('ko-KR');
}