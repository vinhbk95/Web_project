<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>

<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>
	<div id="website">

		<jsp:include page="_header.jsp" />
		<jsp:include page="_menu.jsp" />



		<div class="page-title">
			<h1>Login (For Employee, Manager)</h1>
		</div>

		<div class="login-container">

			<h3>Enter username and password</h3>
			<br>
			<!-- /login?error=true -->
			<c:if test="${param.error == 'true'}">
				<div style="color: red; margin: 10px 0px;">

					Login Failed!!!<br /> Reason :
					${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

				</div>
			</c:if>

			<div id="form-css">
				<form method="POST"
					action="${pageContext.request.contextPath}/j_spring_security_check">
					<table>
						<tr>
							<td>User Name *</td>
							<td><input style="height: 20px;" name="userName" /></td>
						</tr>

						<tr>
							<td>Password *</td>
							<td><input style="height: 20px;" type="password" name="password" /></td>
						</tr>

						<tr>
							<td>&nbsp;</td>
							<td><input style="height: 30px; width: 45px;" type="submit" value="Login" /> <input
								style="height: 30px; width:45px;" type="reset" value="Reset" /></td>
						</tr>
					</table>
				</form>
			</div>

			<span class="error-message">${error }</span>

		</div>


		<jsp:include page="_footer.jsp" />
	</div>
</body>
</html>