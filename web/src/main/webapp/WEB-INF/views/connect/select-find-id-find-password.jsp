<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>아이디 비밀번호 찾기 선택</title>
	<script>
		function moveFindId() {
			f.action = "moveFindIdPage.connect";
			f.submit;
		}
		function moveFindPassword() {
			f.action = "moveFindPasswordPage.connect";
			f.submit;
		}
	</script>
</head>
<body>
	<div>
		<img src="" alt="이미지를 표시할 수 없을때  출력할 내용" width="" height="" loading="이미지 로딩 방식">
	</div>
	<div>
		<h2>아이디 또는 비밀번호를 찾으시겠습니까?</h2>
	</div>
	<form name="f" method="post">
		<div>
			<input type="button" name="" value="아이디찾기" onclick="moveFindId()">
		</div>
		<div>
			<input type="button" name="" value="비밀번호 찾기" onclick="moveFindPassword()">
		</div>
	</form>	
</body>
</html>