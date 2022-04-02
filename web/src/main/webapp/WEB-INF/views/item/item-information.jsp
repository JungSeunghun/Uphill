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
		<div>
			<div>
				<img src="">
			</div>
			
			<div>
				<button>제품 설명</button>
				<button>제품 후기</button>
				<button>제품 문의</button>
				<button>안내사항</button>
			</div>
			
			<div>
					
			</div>
			
			<div>
				<div>제품 후기</div>
				<c:forEach var="" items="">
				</c:forEach>
				<a href="reviewPage.item">후기남기기</a>
			</div>
			
			<div>
				<div>제품 문의</div>
				<c:forEach var="" items="">
				</c:forEach>
				<a href="askPage.item">문의하기</a>
			</div>
			
			<div>
				<div>안내사항</div>
			</div>
		</div>
		<div>
			<div></div>
			<div></div>
			<div></div>
			<div></div>
			<c:forEach var="" items="">
			</c:forEach>
			<c:forEach var="" items="">
				<select></select>
			</c:forEach>
			<button>확인하기</button>
			<c:forEach var="" items="">
				<div></div>
				<button></button>
				<div></div>
				<button></button>
			</c:forEach>
			<a href="buy">구매하기</a>
			<a href="">장바구니</a>
		</div>
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>