<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>





<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<!-- <div id="fb-root"></div> -->
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.7&appId=539833932874209";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>


</head>
<body>

	<div class="top">

		<div class="top-left">
			<ul>
				<li><a href="facebook.com"><img src="image/facebook.png"/></a></li>
				<li><a href="google.com"><img src="image/google.png"/></a></li>
				<li><a href="yahoo.com"><img src="image/yahoo.png"/></a></li>
				<li><a href="login.me.zing.vn/"><img src="image/zing.png"/></a></li>
			</ul>		
		</div>

		<div class="top-right">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
		        <ul>
		        	<li>Hello</li>
		        	<li><a href="${pageContext.request.contextPath}/accountInfo">
							${pageContext.request.userPrincipal.name} </a></li>
					<li><a href="${pageContext.request.contextPath}/logout">| Logout</a></li>		
		        </ul>
			</c:if>
			
			<c:if test="${pageContext.request.userPrincipal.name == null}">
				<ul>
					<li><img src="image/login.png"/></li>
					<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
				</ul>
				
			</c:if>
		</div>
	</div>
	
	<div id="header">
		<div style="float:left; width:250px; height:54px; margin:65px 0 0 35px;">
			<a href="http://localhost:8080/SpringMVCShoppingCart/productList"><img src="image/nameShop.png"/></a>
		</div>
		<div style="float:right; width:400px; height:93px;">
			<div style="float:left; margin:40px 0px 0px 200px;">
				<a href="http://localhost:8080/SpringMVCShoppingCart/shoppingCart"><img src="image/shopcart.png"/></a></div>
			</div>
		
		<div style="float:right; width:400px; height:60px;">
			<div id="header-phone">SUPPORT: 01639134132</div>
			<div id="search-box">
				<form action = "${pageContext.request.contextPath}/searchProduct" method = "get">
					<input id="textsearch" type="text" value="" name="search" placeholder="Search for here..."  />
					<button id="search-button" type="submit"></button>
				</form>			
			</div>
		</div>
	</div>


</body>
</html>