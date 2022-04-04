<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
	<form action="purchase.user" name="f" method="post">
		<c:forEach var="" items="${itemList }">			
			<div>
				<div>
					<img src="">
				</div>
				<div>
					<p>1,000,000원</p>
				</div>
				<div>
					<p>★★★★☆(3)</p>
				</div>
				<div>
					<p>자전거 이름/색상/프레임/구동계/휠</p>
				</div>
				<div>
					<p>1</p>
				</div>
				<div>
					<p>주문금액</p>
				</div>
				<div>
					<p>1,000,000원</p>
				</div>
			</div>
		</c:forEach>
		<div>
			<p>수령인</p>
			<input type="text" name="" size="">
		</div>
		<div>
			<p>주소</p>
			<input type="text" name="" size="">
		</div>
		<div>
		 	<p>이동통신사</p>
		 	<label><input type="radio" name="" value="">&nbsp;skt</label>
		 	<label><input type="radio" name="" value="">&nbsp;kt</label>
		 	<label><input type="radio" name="" value="">&nbsp;LGU+</label>
		 	<label><input type="radio" name="" value="">&nbsp;알뜰폰</label>
		</div>
		<div>
			<p>전화번호</p>
			<input type="text" name="" size="">
			<input type="text" name="" size="">
			<input type="text" name="" size="">
		</div>
		<div>
			<p>사용가능한포인트</p>
			<input type="text" name="" size="">
		</div>
		<div>
			<p>배송요청</p>
			<input type="text" name="" size="">
		</div>
		<div>
			<p>총 주문금액</p>
		</div>
		<div>
			<p>3,000,000원</p>
		</div>
		<div>
			<p>포인트적립액</p>
		</div>
		<div>
			<p>300000p(silver)</p>
		</div>
		<div>
		 	<p>결제수단</p>
		 	<label><input type="radio" name="" value="">&nbsp;신용카드</label>
		 	<label><input type="radio" name="" value="">&nbsp;계좌이체</label>
		 	<label><input type="radio" name="" value="">&nbsp;휴대폰</label>			 	
		</div>
		<div>
			<input type="button" name="" size="" value="결제하기" onclick="">
		</div>
	</form>
</section>