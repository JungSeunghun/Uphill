/**
 * option 전부 선택시 selectedOrderItem에 선택한 옵션 보여주기
 */

function addOption(name) {
	const optionList = document.getElementsByClassName("itemOptionSelect");
	const selectedOrderItem = document.getElementById("selectedOrderItem");
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
		for(let i = 0; i < optionNameArray.length; i++) {
			optionName = optionName + "/" + optionNameArray[i];
		}
		optionNameValue = document.createTextNode(name + optionName);
		
		var cancelButton = document.createElement('button');
		cancelButton.id = 'cancelButton';
		var cancelButtonText = document.createTextNode('cancel');
		cancelButton.appendChild( cancelButtonText );
		
		selectedOrderItem.appendChild(optionNameValue);
		selectedOrderItem.appendChild(cancelButton);
	}
}