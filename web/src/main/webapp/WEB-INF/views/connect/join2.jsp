<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 페이지 2단계</title>
	<script>
		function idDuplicationCheck() {
			
		}
	</script>
</head>
<body>
<div>
	<img src="" alt="이미지를 표시할 수 없을때  출력할 내용" width="" height="" loading="이미지 로딩 방식">
</div>
	<section>
		<form action="join2.connect" name="f" method="post">
			<div>
				<h2>회원가입</h2>
			</div>
			<div>
				<p>아이디</p>
				<input type="text" name="" size="">
				<input type="button" name="" size="" value="중복확인" onclick="idDuplicationCheck();">
			</div>
			<div>
				<p>비밀번호</p>
				<input type="text" name="" size="">
			</div>
			<div>
				<p>비밀번호 확인</p>
				<input type="text" name="" size="">
			</div>
			<div>
				<p>주소</p>
				<input type="text" name="" size=""><br/>
				<input type="text" name="" size="">
			</div>
			<div>
				<input type="submit" value="회원가입">
			</div>
			<div>
				<input type="button" value="이전으로" onclick="">
			</div>
		</form>
	</section>
</body>
</html>