<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/gnb.jsp" %>
	<%@ include file="../common/snb.jsp" %>
		<section>
		<form action="" name="" method="post">
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
	<%@ include file="../common/footer.jsp" %>
</body>
</html>