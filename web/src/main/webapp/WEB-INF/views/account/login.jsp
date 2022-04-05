<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<section>
	<div>
		<img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white">
	</div>
	<div>
		<h2>어서오세요</h2>
	</div>
	<div>
		<form action="/account/login-action" name="f" method="post">
			<div>
				<p>아이디</p>
				<input type="text" name="user_enter_id"> 
				<label><input type="checkbox" name="save_id_check">&nbsp;아이디 저장</label>
			</div>
			<div>
				<p>비밀번호</p>
				<input type="password" name="user_password"> 
				<a href="">아이디 또는 비밀번호 찾기</a>
			</div>
			<div>
				<input type="submit" value="로그인">
			</div>
		</form>
	</div>
	<div>
		<a href="/account/join1">회원가입</a>
	</div>
</section>	
