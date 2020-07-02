<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/include/header.jsp"%>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>

</head>
<body>
	<!-- nav -->
	<%@ include file="/WEB-INF/view/include/nav.jsp"%>
	<!-- content -->
	<!-- 광고베너 -->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="images/01.jpg" />
				</div>
				<div class="item">
					<img src="images/02.jpg" />
				</div>
				<div class="item">
					<img src="images/03.jpg" />
				</div>
				<div class="item">
					<img src="images/04.jpg" />
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel"	data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<!-- 인기상품 리스트 출력 -->
	<section class="trending_items">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="section_tittle text-left">
						<h4>인기 상품</h4>
						<a href="${pageContext.request.contextPath}/store" >전체보기</a>
						<hr>
					</div>
				</div>
			</div>
			<div class="pdList">
			<ul class="clearfix">
				<c:set var="path" value="${pageContext.request.contextPath }" />
				<c:forEach var="itemC" items="${itemCommandList}">
				<li>
					<a href="<c:url value="/itemDetail?itemNo=${itemC.item.itemNo }"/>">
						<div class="imgArea">
							<img alt="" src="${path }${itemC.itemImg.thumbUrl}">
						</div>
						<div class="infoArea">
						 	<p class="brand"><c:out value="${itemC.categorie.categorieName}" /></p>
						 	<p class="ttl"><c:out value="${itemC.item.itemName}" /></p>
						 	<p class="pdSum"><c:out value="${itemC.item.price}" />원</p>
						</div>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
		</div>
	</section>
	<!-- 게시판 글 리스트 출력 -->
	<section class="trending_items">
	      <div class="container">
	         <div class="row">
	            <div class="col-lg-12">
	               <div class="section_tittle text-left">
	                  <h4>커뮤니티</h4>
	                  <a href="${pageContext.request.contextPath}/community">전체보기</a>
	                  <hr>
	               </div>
	            </div>
	         </div>
	        <article class="blog_item">
				<div class="pdList">
					<ul class="clearfix">
						<c:forEach var="article" items="${articleList}">
							<li>
								<div class="imgArea" onclick="location.href='community/readArticle/${article.articleNo}'">
				                    <img src="${pageContext.request.contextPath }${article.articleThumbUrl}">
								</div>
								<div class="blog_details">
									<h5 onclick="location.href='community/readArticle/${article.articleNo}'">${article.articleTitle}</h5>
									<div class="blog-info-link">
										<a href="<c:url value="/community/writerPage/${article.writerId }" />">
											<i class="far fa-user"></i><c:out value="${article.writerId}" />
										</a></br>
										<i class="far fa-comments"></i>조회수 ${article.readCount}
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</article>
	      </div>
	   </section>
	<!-- footer -->
	<%@ include file="/WEB-INF/view/include/footer.jsp"%>
</body>
</html>
