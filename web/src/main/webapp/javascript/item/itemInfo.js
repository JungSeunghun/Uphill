/*
 * cancel option
 */
function cancelOption() {
	
}



/**
 * option 전부 선택시 selectedOrderItem에 선택한 옵션 보여주기
 */

function addOption(name) {
	const optionList = document.getElementsByClassName("itemOptionSelect");
	const selectedOrderItemOption = document.getElementById("selectedOrderItemOption");
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
			optionName += "/" + optionNameArray[i];
			optionPrice += Number(document.getElementById(optionNameArray[i]).value);
		}
		optionNameValue = document.createTextNode(optionName);
		
		const orderPrice = document.getElementById("orderPrice");
		
		orderPrice.innerText = optionPrice + Number(orderPrice.innerText);	
		
		selectedOrderItemOption.appendChild(optionNameValue);
		
		for(let i = 0; i < optionList.length; i++) {
			optionList[i].options[0].selected = true;
		}
	}
}