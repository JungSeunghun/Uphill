<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript" src="/javascript/account/join2.js"></script>

<section>
	<form action="/account/join-action" name="f" method="post">
		<div>
			<a href="/home/home"><img src="/images/logos/uphill_logo_white.svg" alt="uphill_logo_white"></a>
		</div>
		<div>
			<h2>회원가입</h2>
		</div>
		<div>
			<p>아이디</p>
			<input type="text" name="userEnterId" maxlength="20">
			<input type="button" value="중복확인" onclick="">
		</div>
		<div>
			<p>비밀번호</p>
			<input type="password" name="userPassword" maxlength="20">
		</div>
		<div>
			<p>비밀번호 확인</p>
			<input type="password" name="checkUserPassword" maxlength="20">
		</div>
		<div>
			<p>주소</p>
			<input type="text" name="address" maxlength="100"><br/>
			<input type="text" name="addressDetail" maxlength="50">
		</div>
		<div>
			<p>이메일</p>
			<input type="text" name="emailId">@
			<select name="emailAddress">
				<option value="">이메일을 선택하세요.</option>
				<option value="@naver.com">naver.com</option>
				<option value="@daum.net">daum.net</option>
				<option value="@gmail.com">gmail.com</option>
			</select>
			<input type="button" value="중복확인" onclick="">
		</div>
		<div>
			<input type="submit" value="회원가입" onclick="checkJoin2(); return false;">
		</div>
		<div>
			<a href="/account/join1">이전으로</a>
		</div>
	</form>
</section>