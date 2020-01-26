<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<style type="text/css">
p {
	text-align: center;
}
</style>

</head>
<body>
	<div class="container">
		<h3 align=center>Login Page</h3>
		<form id="signInForm" action="customerLogin" method="POST">
			<br> <br> <br>
			<div class="form-group">
				<p>
					Username &nbsp;<input type="text" name="username" required />
				</p>

				<c:if test="${!empty message }">${message }</c:if>
			</div>

			<br>
			<div class="form-group">
				<p>
					Password &nbsp;&nbsp;<input type="password" name="password"
						required />
				</p>
			</div>
			<br>

			<p>
				<input type="submit" value="Login" name="Login"
					class="btn btn-success btn-xl">
			</p>
			<p>
				<a href="/forgetpassword">Forget Password</a>
			</p>
			<p>
				Not a Member?&nbsp; <a href="/registerPage">Register Here</a>
			</p>


		</form>
	</div>
</body>
</html>