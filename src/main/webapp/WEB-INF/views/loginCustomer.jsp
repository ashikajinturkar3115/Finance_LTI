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
</style>

</head>
<body>
	<form id="signInForm" class="form-horizontal"
		data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
		data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
		data-bv-feedbackicons-validating="glyphicon glyphicon-refresh"
		action="customerLogin" method="POST">
		<div id="legend">
			<legend class="abc">Login</legend>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">Username</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="username" required
					data-bv-notempty-message="The username is required" />
			</div>
		</div>
		<br>
		<div id="clr">
			<c:if test="${!empty message }">${message }</c:if>
		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">Password</label>
			<div class="col-sm-4">
				<input type="password" class="form-control" name="password" required
					data-bv-notempty-message="The password is required" />
			</div>
		</div>
		<br>
		<div class="control-group">
			<!-- Button -->
			<div class="controls">
				<input type="submit" value="Login" name="Login">
			</div>
		</div>

	</form>

	<h4>
		<a href="/forgetpassword">Forget Password</a>
	</h4>
</body>
</html>