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
			<a href="#itemPost">제품 설명</a>
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
			<table id="postTable">
				<thead>
					<tr>
						<td>아이디</td>
						<td>제목</td>
						<td>작성일</td>
						<td>추천수</td>
						<td>조회수</td>
					</tr>
				</thead>
				<c:forEach var="review" items="${reviewList }" varStatus="status">
					<tr id="post" onclick="showPost('r-${review.reviewIndex}')">
						<td>${review.userId }</td>
						<td>${review.title }(${review.starRating })</td>
						<td>${review.postDate }</td>
						<td>${review.recommend }</td>
						<td>${review.hits }</td>
					</tr>
					<tr id="r-${review.reviewIndex }" style="display:none;">
						<td colspan="5" style="height: 100px; border: 1px solid #c4c4c4;">
							<c:if test="${review.imageFile != null }">
								<img src="${contextPath }/images/reviews/${review.imageFile }" height="100px">
							</c:if>
							<div>${review.content }</div>
							<c:if test="${review.userId == userVO.userId }">
								<div>
									<form name="deleteReviewForm${status.index }" action="${contextPath }/item/delete-review-action" method="post">
										<input type="hidden" name="reviewIndex" value="${review.reviewIndex }">
										<input type="hidden" name="itemIndex" value="${item.itemIndex }">
										<button type="button" onclick="if(confirm('정말 삭제하시겠습니까?')){deleteReviewForm${status.index }.submit()}">삭제</button>
									</form>
								</div>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="center" style="position:relative">
						<c:if test="${reviewPage != 1 }">
							<a href="${contextPath }/item/item-info?id=${item.itemIndex}&reviewPage=${reviewPage-1}#itemReview">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${reviewStartPage }" end="${reviewEndPage }">
							<c:if test="${reviewPage == i }">
								<span style="color:#9ccc65">${i }</span>
							</c:if>
							<c:if test="${reviewPage != i }">
								<a href="${contextPath }/item/item-info?id=${item.itemIndex}&reviewPage=${i}#itemReivew">${i }</a>
							</c:if>
						</c:forEach>
						<c:if test="${reviewPage != reviewEndPage }">
							<a href="${contextPath }/item/item-info?id=${item.itemIndex}&askPage=${askPage+1}#itemReview">[다음]</a>
						</c:if>
						<c:if test="${item.itemCategoryIndex == 1 }">
							<button type="button" id="postButton" onclick="location.href='${contextPath }/item/bicycle/review?id=${item.itemIndex }'">후기남기기</button>
						</c:if>
						<c:if test="${item.itemCategoryIndex != 1 }">
							<button type="button" id="postButton" onclick="location.href='${contextPath }/item/item/review?id=${item.itemIndex }'">후기남기기</button>
						</c:if>
					</td>
				</tr>
			</table>			
		</div>
		
		<div id="itemAsk">
			<div id="itemAskTitle">제품 문의</div>
			<table id="postTable">
				<thead>
					<tr>
						<td>아이디</td>
						<td>제목</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<c:forEach var="ask" items="${askList }" varStatus="status">
					<tr id="post" onclick="showPost('a-${ask.askIndex}')">
						<td>${ask.userId }</td>
						<td><c:forEach var="i" begin="1" end="${ask.askGroupLevel }">↳</c:forEach>${ask.title }</td>
						<td>${ask.postDate }</td>
						<td>${ask.hits }</td>
					</tr>
					<tr id="a-${ask.askIndex }" style="display:none;">
						<td colspan="4" style="height: 100px; border: 1px solid #c4c4c4;">
							<c:if test="${ask.imageFile != null }">
								<img src="${contextPath }/images/asks/${ask.imageFile }" height="100px">
							</c:if>
							<div>${ask.content }</div>
							<c:if test="${ask.userId == userVO.userId }">
								<form name="deleteAskForm${status.index }" action="${contextPath }/item/delete-ask-action" method="post">
									<input type="hidden" name="askIndex" value="${ask.askIndex }">
									<input type="hidden" name="itemIndex" value="${item.itemIndex }">
									<button type="button" onclick="if(confirm('정말 삭제하시겠습니까?')){deleteAskForm${status.index }.submit()}">삭제</button>
								</form>
							</c:if>
							<c:if test="${userVO.gradeIndex == 4 }">
								<c:if test="${item.itemCategoryIndex == 1 }">
									<form name="replyAskForm${status.index }" action="${contextPath }/item/bicycle/ask" method="post">
										<input type="hidden" name="askIndex" value="${ask.askIndex }">
										<input type="hidden" name="askGroupIndex" value="${ask.askGroupIndex }">
										<input type="hidden" name="askGroupLevel" value="${ask.askGroupLevel }">
										<input type="hidden" name="id" value="${item.itemIndex }">
										<button type="button" onclick="replyAskForm${status.index}.submit()">문의하기</button>
									</form>
								</c:if>
								<c:if test="${item.itemCategoryIndex != 1 }">
									<form name="replyAskForm${status.index }" action="${contextPath }/item/item/ask" method="post">
										<input type="hidden" name="askIndex" value="${ask.askIndex }">
										<input type="hidden" name="askGroupIndex" value="${ask.askGroupIndex }">
										<input type="hidden" name="askGroupLevel" value="${ask.askGroupLevel }">
										<input type="hidden" name="id" value="${item.itemIndex }">
										<button type="button" onclick="replyAskForm${status.index}.submit()">문의하기</button>
									</form>
								</c:if>
							</c:if>
						</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="center" style="position:relative">
						<c:if test="${askPage != 1 }">
							<a href="${contextPath }/item/item-info?id=${item.itemIndex}&askPage=${askPage-1}#itemAsk">[이전]</a>
						</c:if>
						<c:forEach var="i" begin="${askStartPage }" end="${askEndPage }">
							<c:if test="${askPage == i }">
								<span style="color:#9ccc65">${i }</span>
							</c:if>
							<c:if test="${askPage != i }">
								<a href="${contextPath }/item/item-info?id=${item.itemIndex}&askPage=${i}#itemAsk">${i }</a>
							</c:if>
						</c:forEach>
						<c:if test="${askPage != askEndPage }">
							<a href="${contextPath }/item/item-info?id=${item.itemIndex}&askPage=${askPage+1}#itemAsk">[다음]</a>
						</c:if>
						<c:if test="${item.itemCategoryIndex == 1 }">
							<button type="button" id="postButton" onclick="location.href='${contextPath }/item/bicycle/ask?id=${item.itemIndex }'">문의하기</button>
						</c:if>
						<c:if test="${item.itemCategoryIndex != 1 }">
							<button type="button" id="postButton" onclick="location.href='${contextPath }/item/item/ask?id=${item.itemIndex }'">문의하기</button>
						</c:if>
					</td>
				</tr>
			</table>
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