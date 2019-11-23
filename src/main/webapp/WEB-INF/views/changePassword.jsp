<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<section class="container-fluid">
		<div class="row justify-content-center ">

			<div class="col-6 rounded border bg-white " id="col-Login">
				<p class="text-center">
					<strong>Change Password</strong>
				</p>

				<form class="change-password" method="get" action="changepassword">

					<div>
						<label>Enter UserName:</label><input type="Text"
							class="form-control" name="username" placeholder="Username"
							required>
					</div>

					<div class="password">
						<label>Enter New Password:</label> <input type="text"
							class="form-control" id="new" name="newpassword"
							placeholder="new password" required>
					</div>

					<br>

					<div class="password">
						<label>Confirm Password:</label> <input type="password"
							class="form-control" id="confirmpassword" name="confirmpassword"
							placeholder="confirm password" required>
							<br>
							<div style="color: red"> <strong>  <c:if test="${ !empty message}">${message} </c:if>	<strong>
					</div>
					<br>
					<div class="col-md-12 text-center">
						<button type="submit" class="btn btn-success btn-lg">Save</button>
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>