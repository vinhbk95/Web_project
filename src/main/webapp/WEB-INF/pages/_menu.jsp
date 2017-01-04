<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>   
 
 
 <div id="cssmenu">
 	<ul>
 		<img src="image/home.png"/>
 		<li style="border-left: 1px dotted #999999;"><a href="http://localhost:8080/SpringMVCShoppingCart/productList">Trang chủ</a></li>
 		<li><a href="#">Điện thoại</a></li>
 		<li><a href="#">Lap top</a></li>
 		<li><a href="#">Linh kiện</a></li>
 		<li><a href="#">Liên hệ</a></li>
 		<li><a href="#">Trợ giúp</a></li>
 		<li style="border-right:none;"><a href="#">Quản trị</a></li>
 	</ul>
 </div>
 
  <div>
   <a href="${pageContext.request.contextPath}/natureProductList">NatureProduct</a>
   |
   <a href="${pageContext.request.contextPath}/productList">
      Product List
   </a>
   |
   <a href="${pageContext.request.contextPath}/shoppingCart">
      My Cart
   </a>
   |
   <security:authorize  access="hasAnyRole('ROLE_MANAGER','ROLE_EMPLOYEE')">
     <a href="${pageContext.request.contextPath}/orderList">
         Order List
     </a>
     |
   </security:authorize>
   
   <security:authorize  access="hasRole('ROLE_MANAGER')">
         <a href="${pageContext.request.contextPath}/product">
                        Create Product
         </a>
         |
   </security:authorize>
  