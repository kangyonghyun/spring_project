<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/header.jsp" %>
<c:set var="path" value="${pageContext.request.contextPath }" />
</head>
<body>

<%@ include file="/WEB-INF/view/include/nav.jsp"%>

<div class=" orderSec">
	<div class="inner clearfix">
		<div class="leftSec mycenter">
			<ul class="depth1">
				<div class="myorder_title">주문 내역</div>
				<c:forEach var="orderCommand" items="${orderCommandList}" >
					<li class="my_li">
						<!-- 주문번호, 주문일자, 이미지, 상품명  -->
						<div class="orderPd clearfix">
							<div class ="myorder_ttl">주문번호: ${ orderCommand.historyNo} | 주문일자 : ${orderCommand.orderDate}</div>
							<div class="imgSec">
								<img alt="" src="${path }${orderCommand.thumbUrl}">
							</div>
							<div class="infoSec myleft">
								<div class="txt"><c:out value="${orderCommand.itemName}" /></div>
								<div class="dv">무료배송</div>
							</div>
						</div>
						<!-- 옵션1, 옵션2, 수량, 개당 가격 -->
						<div class="uldepth">
							<ul class="depth2">
								<li>
									<c:choose >
										<c:when test="${empty orderCommand.option1Name && empty orderCommand.option2Name}">
											<div class="txt">옵션1: 없음 / 옵션2: 없음</div>
										</c:when>
										<c:when test="${not empty orderCommand.option1Name && empty orderCommand.option2Name}">
											<div class="txt">옵션1: ${orderCommand.option1Name} / 옵션2: 없음</div>
										</c:when>
										<c:when test="${empty orderCommand.option1Name && not empty orderCommand.option2Name}">
											<div class="txt">옵션1: 없음 / 옵션2: ${orderCommand.option2Name}</div>
										</c:when>
										<c:otherwise>
											<div class="txt">옵션1: ${orderCommand.option1Name} / 옵션2: ${orderCommand.option2Name}</div>
										</c:otherwise>
									</c:choose>
									<span class="txt"><c:out value="${orderCommand.amount}" />개</span>
									<span class="price" >개당 <c:out value="${orderCommand.price}" />원</span>
								</li>
							</ul>
						</div>
						<!-- 총가격 -->
						<div class="pdTotal">
							<div class="dv">배송중</div>
							<div><span class="totalPrice">총 <c:out value="${orderCommand.price * orderCommand.amount}" />원</span></div>
						</div>
						<div align="right">
							<button class="conBtn" onclick="finalize()">구매 확정</button>
							<button class="cancelBtn" onclick="cancelReq('${pageContext.request.contextPath}/mypage/myOrderDel/${orderCommand.historyNo}')">취소 요청</button>
						</div>
						<!-- <span class="alert-finalize" style="display: none; color: #0000FF; font-weight: bold;">구매가 완료되었습니다. 이용해주셔서 감사합니다.</span>
						<span class="alert-cancelReq" style="display: none; color: #d92742; font-weight: bold;">취소 요청 중입니다...</span> -->
					</li>
				</c:forEach>
			</ul>
			<!-- 페이징  -->
			<div align="center">
				<c:if test="${pagination.curRange ne 1 }">
				        	<a href="#" onClick="fn_paging(1)">[처음]</a> 
				</c:if>
				<c:if test="${pagination.curPage ne 1}">
					<a href="#" onClick="fn_paging('${pagination.prevPage }')">[이전]</a> 
				</c:if>
				<c:forEach var="pageNum" begin="${pagination.startPage }" end="${pagination.endPage }">
			       <c:choose>
			        	<c:when test="${pageNum eq  pagination.curPage}">
			          		<span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
			        	</c:when>
			        	<c:otherwise>
			          		<a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
			        	</c:otherwise>
			       </c:choose>
				</c:forEach>
				<c:if test="${pagination.curPage ne pagination.pageCnt && pagination.pageCnt > 0}">
					<a href="#" onClick="fn_paging('${pagination.nextPage }')">[다음]</a> 
				</c:if>
				<c:if test="${pagination.curRange ne pagination.rangeCnt && pagination.rangeCnt > 0}">
					<a href="#" onClick="fn_paging('${pagination.pageCnt }')">[끝]</a> 
				</c:if>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function fn_paging(curPage) {
		location.href = "myOrder?curPage=" + curPage;
	}
	function cancelReq(url) {
		if(confirm("취소 요청하시겠습니까?")){      
		   location.href=url;
		}
	}
	/*  function finalize() {
		 var h = document.getElementsByClassName('my_li')[0];
		if(confirm("구매 확정하시겠습니까?")){
			h
			$('.dv').text("");
			$('.dv').text("구매확정");
			$('.conBtn').css('display', 'none');
			$('.cancelBtn').css('display', 'none');
		} */
	}
</script>
          
<%@ include file="/WEB-INF/view/include/footer.jsp"%>

</body>
</html>