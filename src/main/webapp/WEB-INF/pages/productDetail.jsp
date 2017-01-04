<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Detail Info</title>
<link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	
	<div id="website">
	<jsp:include page="_header.jsp" />
    <jsp:include page="_menu.jsp" />
 
    <fmt:setLocale value="en_US" scope="session"/>
    
    <div class="page-title">Product Detail Info</div>
    
    <div class="product-preview-container">
			<ul>
				<li><img class="product-image"
					src="${pageContext.request.contextPath}/productImage?code=${showProductInfo.code}" /></li>
				<li><img class="product-image"
					src="${pageContext.request.contextPath}/productImage1?code=${showProductInfo.code}" /></li>
				<li>Code: ${showProductInfo.code}</li>
				<li>Name: ${showProductInfo.name}</li>
				<li>Price: <fmt:formatNumber value="${showProductInfo.price}"
						type="currency" /></li>
				<li><a
					href="${pageContext.request.contextPath}/buyProduct?code=${showProductInfo.code}">
						Buy Now</a></li>
				<!-- For Manager edit Product -->
<!-- 				<security:authorize access="hasRole('ROLE_MANAGER')"> -->
<!-- 					<li><a style="color: red;" -->
<%-- 						href="${pageContext.request.contextPath}/product?code=${showProductInfo.code}"> --%>
<!-- 							Edit Product</a></li> -->
<!-- 				</security:authorize> -->
			</ul>
		</div>
	
	<div>
		<div class="fb-comments"
			data-href="http://localhost:8080/SpringMVCAnnotationShoppingCart/productDetail?code=${showProductInfo.code}"
			data-width="850" data-numposts="5"></div>

	</div>
	
	<jsp:include page="_footer.jsp" />
	</div>
	
</body>
</html>