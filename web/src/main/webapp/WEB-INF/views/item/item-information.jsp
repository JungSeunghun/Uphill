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
				<button>후기남기기</button>
			</div>
			
			<div>
				<div>제품 문의</div>
				<c:forEach var="" items="">
				</c:forEach>
				<button>문의하기</button>
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
			<button>구매하기</button>
			<button>장바구니</button>
		</div>
	</section>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>