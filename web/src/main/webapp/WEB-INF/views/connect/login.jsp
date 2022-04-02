<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>로그인 페이지</title>
</head>
<body>
	<div>
		<img src="" alt="이미지를 표시할 수 없을때  출력할 내용">
	</div>
	<div>
		<h2>어서오세요</h2>
	</div>
	<section>
		<form action="login.connect" name="f" method="post">
				<div>
					<p>아이디</p>
					<input type="text" name="" size="">
					<label><input type="checkbox" name="" value="">&nbsp;아이디 저장</label><br/>
				</div>
				<div>
					<p>비밀번호</p>
					<input type="text" name="" size="">
					<a href="">아이디 또는 비밀번호 찾기</a>
				</div>
				<div>
					<input type="submit" value="로그인">
				</div>
		</form>	
	</section>
	<section>
		<div>
			<form action="joinPage.connect" name="f2" method="post">
				<input type="submit" value="회원가입">
			</form>
		</div>
	</section>	
</body>
</html>