<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section>
	<form action="/account/join-action" name="f" method="post">
		<div>
			<img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white">
		</div>
		<div>
			<h2>회원가입</h2>
		</div>
		<div>
			<p>아이디</p>
			<input type="text" name="user_id" size="">
			<input type="button" value="중복확인" onclick="idDuplicationCheck();">
		</div>
		<div>
			<p>비밀번호</p>
			<input type="password" name="user_password" size="20">
		</div>
		<div>
			<p>비밀번호 확인</p>
			<input type="password" name="user_password" size="20">
		</div>
		<div>
			<p>주소</p>
			<input type="text" name="address1" size="40"><br/>
			<input type="text" name="address2" size="40">
		</div>
		<div>
			<p>이메일</p>
				<input type="text" name="email" size="">@
				<select name="email">
					<option value="naver.com">naver.com</option>
					<option value="daum.net">daum.net</option>
					<option value="gmail.com">gmail.com</option>
				</select>
		</div>
		<div>
			<input type="submit" value="회원가입">
		</div>
		<div>
			<a href="/account/join1">이전으로</a>
		</div>
	</form>
</section>