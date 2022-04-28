<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<link rel="stylesheet" type="text/css" href="${contextPath}/css/item/itemInfo.css">
<script type="text/javascript" src="${contextPath}/javascript/item/itemInfo.js" ></script>
    
<section>	
	<div id="itemInfo">
		<div id="itemImage">
			<img src="${contextPath }/images/items/${item.itemImage}">
		</div>
		
		<div id="itemNav">
			<a href="#itemInfo">제품 설명</a>
			<a href="#itemReview">제품 후기</a>
			<a href="#itemAsk">제품 문의</a>
			<a href="#itemGuide">안내사항</a>
		</div>
		
		<div id="itemPost">
			<c:if test="${itemPost.imageFile != null }">
				<img src="${contextPath }/images/itemposts/${itemPost.imageFile}">
			</c:if>
			<div>${itemPost.content }</div>
		</div>
		
		<div id="itemReview">
			<div id="itemReviewTitle">제품 후기</div>
			<table>
				<tr>
					<th>아이디</th>
					<th>제목</th>
					<th>작성일</th>
					<th>추천수</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="review" items="${reviewList }">
					<tr>
						<th>${review.userId }</th>
						<th>${review.title }(${review.starRating })</th>
						<th>${review.postDate }</th>
						<th>${review.recommend }</th>
						<th>${review.hits }</th>
					</tr>
				</c:forEach>
			</table>
			<button onclick="href='${contextPath }/item/review'">후기남기기</button>
		</div>
		
		<div id="itemAsk">
			<div id="itemAskTitle">제품 문의</div>
			<table>
				<tr>
					<th>아이디</th>
					<th>제목</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="ask" items="${askList }">
					<tr>
						<th>${ask.userId }</th>
						<th>${ask.title }</th>
						<th>${ask.postDate }</th>
						<th>${ask.hits }</th>
					</tr>
				</c:forEach>
			</table>
			<button onclick="href='${contextPath }/item/ask'">문의하기</button>
		</div>
		
		<div id="itemGuide">
			<div id="itemGuideTitle">안내사항</div>
			<div>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nec tellus accumsan, tellus arcu et convallis in eget quam. Eget pellentesque facilisi lacus fringilla ultrices. Pellentesque accumsan, dapibus at eget in pharetra, pretium, morbi in. Id enim ut enim, duis mauris porttitor. Iaculis eu dolor sed scelerisque. Aenean varius urna felis, nulla amet, malesuada. Tincidunt volutpat nibh viverra egestas id velit fames scelerisque dictum. Risus lacus vitae vel urna diam lacus nunc, diam. Velit lacus non in rutrum tincidunt.
				<br><br>
				Aliquam tempus massa mauris urna. Augue lacinia habitasse nunc, libero, amet auctor viverra nunc vitae. Adipiscing tellus enim, luctus ut molestie et. Pharetra, egestas ut vitae, amet nec a. Mauris sodales vitae quisque diam. Purus id mattis sem lorem sodales mi malesuada proin. Arcu lorem egestas aenean scelerisque morbi faucibus est diam.
				<br><br>
				Placerat mi rhoncus lobortis convallis eu. Tortor id cursus non potenti praesent sed duis enim tellus. Massa felis ac consequat dolor, sit luctus semper interdum venenatis. Enim vitae est sed sit bibendum nisi, id consectetur nibh. Risus aliquet in orci molestie odio interdum. Lectus volutpat ut egestas varius eget pharetra orci. Et vulputate eu sed porttitor id dolor. Tristique at proin vitae mauris id nunc mi lacus. Sed dui, et enim massa dictumst tortor. Tellus eget ut libero ultricies sit nunc aenean id. Libero libero posuere egestas tristique risus in interdum bibendum. Facilisis massa massa lobortis sapien aliquet.
			</div>
		</div>
	</div>
	<div id="itemOption">
		<c:if test="${item.itemSubcategoryName == null }">
			<div id="categoryName">${item.itemCategoryName }</div>
		</c:if>
		<c:if test="${item.itemSubcategoryName != null }">
			<div id="categoryName">${item.itemSubcategoryName }</div>
		</c:if>
		<div id="itemName">${item.itemName }</div>
		<c:if test="${item.itemDiscountPrice != 0 }">
			<div id="itemPrice"><fmt:formatNumber value="${item.itemDiscountPrice }" pattern="#,###" />원</div>
			<div id="itemDiscountPrice"><fmt:formatNumber value="${item.itemPrice }" pattern="#,###" />원</div>
		</c:if>
		<c:if test="${item.itemDiscountPrice == 0 }">
			<div id="itemPrice"><fmt:formatNumber value="${item.itemPrice }" pattern="#,###" />원</div>
		</c:if>
		<div id="starDiv">
			<div id="emptyStar">
				<c:forEach begin="1" end="5">
					<img alt="empty star" src="${contextPath }/images/icons/empty_star.svg">
				</c:forEach>
			</div>
			<div id="greenStar" style="width:${100 * item.starRating/5}%">
				<div id="starWrap">
					<c:forEach begin="1" end="5">
						<img alt="green star" src="${contextPath }/images/icons/green_star.svg">
					</c:forEach>
				</div>
			</div>
		</div>
		<c:forEach var="itemOptionName" items="${itemOptionNameList }">
			<div>
				<c:if test="${item.itemDiscountPrice == 0 }">
					<select id="itemOptionSelect" class="itemOptionSelect" onchange="addOption('${item.itemName }','${item.itemPrice }');">
						<option value="" selected disabled="disabled">${itemOptionName } 선택</option>
						<c:forEach var="itemOption" items="${itemOptionList }">
							<c:if test="${itemOptionName == itemOption.itemOptionName}">
								<option value="${itemOption.itemOptionContent }">${itemOption.itemOptionContent }/<fmt:formatNumber value="${itemOption.itemOptionPrice }" pattern="#,###" />원/${itemOption.itemOptionQty }개</option>
							</c:if>
						</c:forEach>
					</select>
					<c:forEach var="itemOption" items="${itemOptionList }">
						<input type="hidden" id="${itemOption.itemOptionContent }" value="${itemOption.itemOptionPrice }">
					</c:forEach>
				</c:if>
				<c:if test="${item.itemDiscountPrice != 0 }">
					<select id="itemOptionSelect" class="itemOptionSelect" onchange="addOption('${item.itemName }','${item.itemDiscountPrice }');">
						<option value="" selected disabled="disabled">${itemOptionName } 선택</option>
						<c:forEach var="itemOption" items="${itemOptionList }">
							<c:if test="${itemOptionName == itemOption.itemOptionName}">
								<option value="${itemOption.itemOptionContent }">${itemOption.itemOptionContent }/<fmt:formatNumber value="${itemOption.itemOptionPrice }" pattern="#,###" />원/${itemOption.itemOptionQty }개</option>
							</c:if>
						</c:forEach>
					</select>
					<c:forEach var="itemOption" items="${itemOptionList }">
						<input type="hidden" id="${itemOption.itemOptionContent }" value="${itemOption.itemOptionPrice }">
					</c:forEach>
				</c:if>
			</div>
		</c:forEach>
		<!-- clone -->
		<div id="selectedOrderItem">
			<div id="selectedOrderItemOption" class="selectedOrderItemOption"></div>
			<input type="hidden" name="optionName" id="optionName" value="">
			<input type="number" name="optionQty" id="optionQty" value="1" min="1" max="10" onchange="multiplyPrice(this); this.oldvalue = this.value;">
			<button id="cancelButton" onclick="cancelOption(this);">취소</button>
			<input type="hidden" name="optionPrice" id="optionPrice" value="">
		</div>
		<form name="f" method="post">
			<input type="hidden" name="itemIndex" value="${item.itemIndex }">
			<input type="hidden" name="userIndex" value="${userVO.userIndex }">
			<div id="selectedOrderItemList"></div>
			<div id="orderPriceTitle">주문금액</div>
			<span id="orderPrice">0</span>원<br>
			<div><button type="button" id="buyButton" onclick="checkBuy('${contextPath }');">구매하기</button></div>
			<div><button type="button" id="basketButton" onclick="checkBasket('${contextPath }');">장바구니</button></div>
		</form>
	</div>
</section>