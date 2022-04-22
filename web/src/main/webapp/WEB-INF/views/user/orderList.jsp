<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section>
	<c:forEach var="itemList" items="${orderList }" varStatus="status">		
		<c:forEach var="item" items="${itemList[status.index] }">		
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
		</div>
		<div>
			<p>이순신</p>
		</div>
		<div>
			<p>배송주소</p>
		</div>
		<div>
			<p>대구광역시 달서구 달구벌대로 251 안길 15</p>
		</div>
		<div>
			<p>배송요청</p>
		</div>
		<div>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
			 Potenti quam lorem faucibus at consectetur id consequat vel amet.
			 Varius nibh cursus ante in pretium. Volutpat, ultricies posuere consequat interdum etiam amet.
			 Odio id rhoncus risus aliquet amet cursus volutpat nunc.</p>
		</div>
	</c:forEach>
</section>	