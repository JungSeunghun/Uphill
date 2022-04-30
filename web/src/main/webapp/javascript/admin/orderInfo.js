/**
 * 주문 확인
 */
function updateOrder() {
	if(confirm("주문을 확인하시겠습니까?")) {
		f.orderState.value = 1;
		f.submit();
	}
}

/**
 * 주문 취소
 */
function cancelOrder() {
	if(confirm("주문을 취소하시겠습니까?")) {
		f.orderState.value = 3;
		f.submit();
	}
}
