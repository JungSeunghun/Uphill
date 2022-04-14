<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/item/itemInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/item/itemInfo.js" ></script>
    
<section>
	<div id="itemInfo">
		<div id="itemImage">
			<img src="${contextPath }/images/items/${item.itemImage}">
		</div>
		
		<div>
			<a href="#itemInfo">제품 설명</a>
			<a href="#itemReview">제품 후기</a>
			<a href="#itemAsk">제품 문의</a>
			<a href="#itemGuide">안내사항</a>
		</div>
		
		<div id="itemInfo">
			<c:if test="${itemPost.imageFile != null }">
				<img src="${contextPath }/images/items/${itemPost.imageFile}">
			</c:if>
			<div>${itemPost.content }</div>
		</div>
		
		<div id="itemReview">
			<div>제품 후기</div>
			<c:forEach var="i" items="">
			</c:forEach>
			<button onclick="href='${contextPath }/item/review'">후기남기기</button>
		</div>
		
		<div id="itemAsk">
			<div>제품 문의</div>
			<c:forEach var="i" items="">
			</c:forEach>
			<button onclick="href='${contextPath }/item/ask'">문의하기</button>
		</div>
		
		<div id="itemGuide">
			<div>안내사항</div>
			<div>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nec tellus accumsan, tellus arcu et convallis in eget quam. Eget pellentesque facilisi lacus fringilla ultrices. Pellentesque accumsan, dapibus at eget in pharetra, pretium, morbi in. Id enim ut enim, duis mauris porttitor. Iaculis eu dolor sed scelerisque. Aenean varius urna felis, nulla amet, malesuada. Tincidunt volutpat nibh viverra egestas id velit fames scelerisque dictum. Risus lacus vitae vel urna diam lacus nunc, diam. Velit lacus non in rutrum tincidunt.
				<br>
				Aliquam tempus massa mauris urna. Augue lacinia habitasse nunc, libero, amet auctor viverra nunc vitae. Adipiscing tellus enim, luctus ut molestie et. Pharetra, egestas ut vitae, amet nec a. Mauris sodales vitae quisque diam. Purus id mattis sem lorem sodales mi malesuada proin. Arcu lorem egestas aenean scelerisque morbi faucibus est diam.
				<br>
				Placerat mi rhoncus lobortis convallis eu. Tortor id cursus non potenti praesent sed duis enim tellus. Massa felis ac consequat dolor, sit luctus semper interdum venenatis. Enim vitae est sed sit bibendum nisi, id consectetur nibh. Risus aliquet in orci molestie odio interdum. Lectus volutpat ut egestas varius eget pharetra orci. Et vulputate eu sed porttitor id dolor. Tristique at proin vitae mauris id nunc mi lacus. Sed dui, et enim massa dictumst tortor. Tellus eget ut libero ultricies sit nunc aenean id. Libero libero posuere egestas tristique risus in interdum bibendum. Facilisis massa massa lobortis sapien aliquet.
			</div>
		</div>
	</div>
	<div id="itemOption">
		<c:if test="${item.itemSubcategoryName == null }">
			<div>${item.itemCategoryName }</div>
		</c:if>
		<c:if test="${item.itemSubcategoryName != null }">
			<div>${item.itemSubcategoryName }</div>
		</c:if>
		<div>${item.itemName }</div>
		<c:if test="${item.itemDiscountPrice != 0 }">
			<div>${item.itemDiscountPrice }</div>
			<div>${item.itemPrice }</div>
		</c:if>
		<c:if test="${item.itemDiscountPrice == 0 }">
			<div>${item.itemPrice }</div>
		</c:if>
		<c:forEach var="itemOptionName" items="${itemOptionNameList }">
			<div>
				<select>
					<option value="">${itemOptionName }</option>
					<c:forEach var="itemOption" items="${itemOptionList }">
						<c:if test="${itemOptionName == itemOption.itemOptionName}">
							<option>${itemOption.itemOptionContent }/${itemOption.itemOptionPrice }/${itemOption.itemOptionQty }</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
		</c:forEach>
		<c:if test="${fn:length(itemOptionNameList) != 0 }">
			<div><button>확인하기</button></div>
		</c:if>
		<c:forEach var="i" items="">
			<div></div>
			<button></button>
			<div></div>
			<button></button>
			<button>취소하기</button>
		</c:forEach>
		<div><button>구매하기</button></div>
		<div><button>장바구니</button></div>
	</div>
</section>