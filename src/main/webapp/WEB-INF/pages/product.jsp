<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
 
<link rel="stylesheet" type="text/css" href="styles.css">
 
</head>
<body>
 <div id="website">
    <jsp:include page="_header.jsp" />
    <jsp:include page="_menu.jsp" />
 
    <div style="margin-bottom: 10px;" class="page-title"><h1>Create Product</h1></div>
    
    <c:if test="${not empty errorMessage }">
      <div class="error-message">
          ${errorMessage}
      </div>
    </c:if>
 
 <div id="create-pro">
 	<div id="create-pro1">
    <form:form modelAttribute="productForm" method="POST" enctype="multipart/form-data">
        <table style="text-align:left;">
            <tr>
                <td>Code *</td>
                <td style="color:red;">
                   <c:if test="${not empty productForm.code}">
                        <form:hidden path="code"/>
                       <h3> ${productForm.code}</h3>
                   </c:if>
                   <c:if test="${empty productForm.code}">
                        <form:input path="code" />
                        <form:hidden path="newProduct" />
                   </c:if>
                </td>
                <td><form:errors path="code" class="error-message" /></td>
            </tr>
 
            <tr>
                <td>Name *</td>
                <td><form:input style="height: 20px;" path="name" /></td>
                <td><form:errors path="name" class="error-message" /></td>
            </tr>
 
            <tr>
                <td>Price *</td>
                <td><form:input style="height: 20px;" path="price" /></td>
                <td><form:errors path="price" class="error-message" /></td>
            </tr>
            <tr>
                <td>Image</td>
                <td>
                <img src="${pageContext.request.contextPath}/productImage?code=${productForm.code}" width="100"/></td>
                <td> </td>
            </tr>
            <tr>
                <td>Upload Image</td>
                <td><form:input style="height: 25px;" type="file" path="fileData"/></td>
                <td> </td>
            </tr>
            <tr>
                <td>Upload Image 1</td>
                <td><form:input style="height: 25px;" type="file" path="fileData1"/></td>
                <td> </td>
            </tr>
  
 
            <tr>
                <td>&nbsp;</td>
                <td><input style="height: 25px; width: 50px;" type="submit" value="Submit" /> <input style="height: 25px; width: 50px;" type="reset"
                    value="Reset" /></td>
            </tr>
        </table>
    </form:form>
 </div>
 </div>
 
 
    <jsp:include page="_footer.jsp" />
 </div>
</body>
</html>