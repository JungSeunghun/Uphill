<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원수정</title>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<%@ include file="../common/gnb.jsp" %>
	<%@ include file="../common/snb.jsp" %>
	<section>
	<div>
		<img src="" alt="이미지를 표시할 수 없을때  출력할 내용" width="" height="" loading="이미지 로딩 방식">
	</div>
		<form action="" name="" method="post">
			<div>
				<p>비밀번호</p>
				<input type="text" name="" size="">
			</div>
			<div>
				<p>비밀번호 확인</p>
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
				<p>주소</p>
				<input type="text" name="" size="">
			</div>
			<div>
				<p>이메일</p>
				<input type="text" name="" size="">
			</div>
			<div>
			<input type="button" name="" size="" value="수정하기" onclick="">
		</div>
		</form>
	</section>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>