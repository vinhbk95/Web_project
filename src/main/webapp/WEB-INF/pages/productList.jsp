<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<title>Product List</title>

<link rel="stylesheet" type="text/css" href="styles.css">

<script src="jquery.js"></script>
<script src="slider.js"></script>
<script src="jqueryy.js"></script>

</head>
<body>

	<div id="website">


		<jsp:include page="_header.jsp" />
		<jsp:include page="_menu.jsp" />

		<div id="qc">

			<div id="slider">
				<ul>
					<li><a href="#"><img src="image/dt1.jpg" /></a></li>
					<li><a href="#"><img src="image/dt2.jpg" /></a></li>
					<li><a href="#"><img src="image/dt3.jpg" /></a></li>
					<li><a href="#"><img src="image/dt4.jpg" /></a></li>
				</ul>
			</div>
			<div id="quangcao">
				<img src="image/sale.jpg" />
			</div>

		</div>

		<div id="main">
			<div id="main-left">
				<div id="menu-left">
					<ul>
						<li><a>ĐIỆN THOẠI</a>
							<ul class="submenu">
								<li><a href="${pageContext.request.contextPath}/iphone">IPHONE</a></li>
								<li><a href="${pageContext.request.contextPath}/samsung">SAMSUNG</a></li>
								<li><a href="${pageContext.request.contextPath}/oppo">OPPO</a></li>
								<li><a href="${pageContext.request.contextPath}/xiaomi">XIAOMI</a></li>
								<li><a href="${pageContext.request.contextPath}/lkdt">LINH
										KIỆN ĐT</a></li>
							</ul></li>
						<li><a>LAPTOP</a>
							<ul class="submenu">
								<li><a href="${pageContext.request.contextPath}/macbook">MACBOOK</a></li>
								<li><a href="${pageContext.request.contextPath}/dell">DELL</a></li>
								<li><a href="${pageContext.request.contextPath}/hp">HP</a></li>
								<li><a href="${pageContext.request.contextPath}/asus">ASUS</a></li>
								<li><a href="${pageContext.request.contextPath}/lklt">LINH
										KIỆN LAPTOP</a></li>
							</ul></li>
					</ul>
				</div>
				<script src="jqueryy.js" type="text/javascript"></script>

				<div style="margin-top: 40px;" id="menu-left">
					<ul class = "submenu">
						<li style="border-bottom: none;"><a href="productListSortName">Name Sort</a></li>
						<li style="border-bottom: none;"><a href="productListSort">Price Sort</a></li>
						<li><a href="productList">Date Sort</a></li>
					</ul>				
				</div>
			</div>
			<div id="main-right">
				<c:forEach items="${paginationProducts.list}" var="prodInfo">
					<div id="products">
						<ul>
							<li>
								<div class="content">
									<a
										href="${pageContext.request.contextPath}/productDetail?code=${prodInfo.code}"><img
										class="product-image"
										src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}" /></a>
									<p class="title">${prodInfo.name}</p>
									<p class="price">
										<fmt:formatNumber value="${prodInfo.price}" type="currency" />
									</p>
									<!-- For Manager edit Product -->
									<security:authorize access="hasRole('ROLE_MANAGER')">
										<p style="text-align: center;">
											<a style="color: red;"
												href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">
												Edit Product</a>
										</p>
									</security:authorize>
								</div>
							</li>
						</ul>
					</div>

					<%-- <div class="product-preview-container">
					<ul>
						<li><img class="product-image"
							src="${pageContext.request.contextPath}/productImage?code=${prodInfo.code}" /></li>
						<li>Code: ${prodInfo.code}</li>
						<li>Name: ${prodInfo.name}</li>
						<li>Price: <fmt:formatNumber value="${prodInfo.price}"
								type="currency" /></li>
						<li><a
							href="${pageContext.request.contextPath}/buyProduct?code=${prodInfo.code}">
								Buy Now</a></li>
						<li><a href ="${pageContext.request.contextPath}/productDetail?code=${prodInfo.code}">Chi tiet</a></li>		
						<!-- For Manager edit Product -->
						<security:authorize access="hasRole('ROLE_MANAGER')">
							<li><a style="color: red;"
								href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">
									Edit Product</a></li>
						</security:authorize>
					</ul>
				</div> --%>

				</c:forEach>
				<br />
			</div>
		</div>

		<%-- <fmt:setLocale value="en_US"/> dÃÂ¹ng ÃÂÃ¡Â»Â biÃ¡Â»Âu thÃ¡Â»Â tiÃ¡Â»Ân theo USA($) --%>
		<!-- scope="section" :PhÃ¡ÂºÂ¡m vi biÃ¡ÂºÂ¿n ÃÂÃ¡Â»Â lÃÂ°u giÃ¡Â»Â¯ sÃ¡Â»Â ÃÂÃÂ£ ÃÂÃ¡Â»Ânh dÃ¡ÂºÂ¡ng -->
		<fmt:setLocale value="en_US" scope="session" />

		<div id="page-navigato">
			<c:if test="${check == 5}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="productListSort?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 4}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="productList?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 7}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="natureProductList?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>



			<c:if test="${check == 6}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="searchProduct?page=${page}&name=${buff}"
									class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 11}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="iphone?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 12}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="samsung?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 13}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="oppo?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 14}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="xiaomi?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 15}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="lkdt?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 16}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="macbook?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 17}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="dell?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 18}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="hp?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 19}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="asus?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

			<c:if test="${check == 20}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="lklt?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>
			
			<c:if test="${check == 22}">
				<c:if test="${paginationProducts.totalPages > 1}">
					<div class="page-navigator">
						<c:forEach items="${paginationProducts.navigationPages}"
							var="page">
							<c:if test="${page != -1}">
								<a href="productListSortName?page=${page}" class="nav-item">${page}</a>
							</c:if>
							<c:if test="${page == -1 }">
								<span class="nav-item"> ... </span>
							</c:if>
						</c:forEach>

					</div>
				</c:if>
			</c:if>

		</div>

		<a href="productList?name=java">CHeck</a> <a
			href="productList?name=codesort">CodeSort</a>
			 <a href="productListSort">Frice Sort</a> <br>


		<jsp:include page="_footer.jsp" />
	</div>
</body>
</html>