<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Shopping Cart</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	<div id="website">
		<jsp:include page="_header.jsp" />

		<jsp:include page="_menu.jsp" />

		<fmt:setLocale value="en_US" scope="session" />

		<div class="page-title">
			<h1 style="margin-bottom: 10px;">My Cart</h1>
		</div>

		<!--  trường hợp cart chưa đc tạo ra, cartFOrm = null -->
		<c:if test="${empty cartForm or empty cartForm.cartLines}">
			<h2 style="text-align: center;margin-bottom: 10px;">There is no items in Cart</h2>
			<h3 style="text-align: center;"><a href="${pageContext.request.contextPath}/productList">Show Product List</a></h3>
		</c:if>

		<c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
			<form:form method="POST" modelAttribute="cartForm"
				action="${pageContext.request.contextPath}/shoppingCart">
				<%--             Muốn lấy số thứ tự hiện thời của vòng lặp khi thao tác với forEach tag trong JSTL --%>
				<c:forEach items="${cartForm.cartLines}" var="cartLineInfo"
					varStatus="varStatus">
					<div class="product-preview-container">
						<ul>
							<li><img class="product-image"
								src="${pageContext.request.contextPath}/productImage?code=${cartLineInfo.productInfo.code}" />
							</li>
							<li>Code: ${cartLineInfo.productInfo.code} <form:hidden
									path="cartLines[${varStatus.index}].productInfo.code" />

							</li>
							<li>Name: ${cartLineInfo.productInfo.name}</li>
							<li>Price: <span class="price"> <fmt:formatNumber
										value="${cartLineInfo.productInfo.price}" type="currency" />

							</span></li>
							<li>Quantity: <form:input
									path="cartLines[${varStatus.index}].quantity" /></li>
							<li>Subtotal: <span class="subtotal"> <fmt:formatNumber
										value="${cartLineInfo.amount}" type="currency" />

							</span>
							</li>
							<li><a
								href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?code=${cartLineInfo.productInfo.code}">
									Delete </a></li>
						</ul>
					</div>
				</c:forEach>
				<div style="clear: both"></div>
				<input class="button-update-sc" type="submit"
					value="Update Quantity" />
				<a class="navi-item"
					href="${pageContext.request.contextPath}/shoppingCartCustomer">Enter
					Customer Info</a>
				<a class="navi-item"
					href="${pageContext.request.contextPath}/productList">Continue
					Buy</a>
			</form:form>


		</c:if>


		<jsp:include page="_footer.jsp" />
	</div>
</body>
</html>