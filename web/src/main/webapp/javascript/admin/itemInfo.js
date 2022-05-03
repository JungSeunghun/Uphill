/**
 * 옵션 수정 체크
 */
function checkUpdateItem() {
	if(!f.itemName.value) {
		alert("이름을 입력해주세요.");
		return f.itemName.focus();
	}
	if(!f.itemImage.value) {
		alert("이미지를 등록해주세요.");
		return false;
	}
	if(!f.itemPrice.value) {
		alert("가격을 입력해주세요.");
		return f.itemPrice.focus();
	}
	if(!f.itemDiscountPrice.value) {
		alert("할인 가격을 입력해주세요.");
		return f.itemDiscountPrice.focus();
	}
	if(!f.itemTotalQty.value) {
		alert("수량을 입력해주세요.");
		return f.itemTotalQty.focus();
	}
	
	if(!f.itemCategory == 0) {
		alert("카테고리를 선택해주세요.");
		return false;
	}
	
	if(f.itemCategory == 1 && f.itemSubcategory == 0) {
		alert("서브카테고리를 선택해주세요.")
	}
	
	f.submit();
}

/**
 * 서브카테고리 열기
 */
function openSubcategory(index) {
	if(index.value == 1){
		const subcategory = document.getElementById("subcategory");
		subcategory.style.display = "table-row";
	} else {
		subcategory.style.display = "none";
		const itemSubcategoryIndex = document.getElementById("itemSubcategoryIndex");
		itemSubcategoryIndex.value = 0;
	}
	
}

/**
 * 옵션추가
 */
function addOption() {
	const optionTable = document.getElementById("optionTable");
	const optionRow = document.getElementById("optionRowClone").cloneNode(true);
	optionRow.id = "optionRow";
	optionTable.appendChild(optionRow);
}

/**
 * 옵션삭제
 */
function deleteOption(optionRow) {
	optionRow.parentNode.parentNode.remove();
}
