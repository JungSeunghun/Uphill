<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 찾기</title>
</head>
<body>
	<div>
		<img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white">
	</div>
	<section>
		<form action="/account/find-id-action" name="" method="post">
			<h2>아이디 찾기</h2>
			<div>
				<p>이름</p>
				<input type="text" name="" size="">
			</div>
			<div>
				<p>생년월일</p>
				<input type="text" name="" size="">
				<input type="text" name="" size="">
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
				<p>이메일</p>
				<input type="text" name="" size="">
			</div>
			<div>
				<input type="submit" value="아이디 찾기">
			</div>
		</form>
	</section>
</body>
</html>