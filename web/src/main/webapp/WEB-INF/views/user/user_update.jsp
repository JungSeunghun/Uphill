<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
     
<section>
	<form action="/user/update-action" name="f" method="post">
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