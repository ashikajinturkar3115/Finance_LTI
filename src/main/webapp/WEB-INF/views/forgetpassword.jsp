<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot_Password</title>
<meta charset="utf-8">
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

	<section class="container">
		<div class="row justify-content-center ">

			<div class="col-6 rounded border bg-white " id="col-Login">
				<p class="text-center">
					<strong>Forgot Password</strong>
				</p>

				<form action="getotp" method="get">

					<div class="password">
						<label>Enter Email ID:</label><input type="Text"
							class="form-control" name="emailid" placeholder="user@email.com"
							required><br>
						<div
							style="color: Red; font-family: monospace; font-size: x-large;">

							<strong> <c:if test="${ !empty msgemail}">${msgemail} </c:if>
								<strong> </strong></strong>
						</div>
					</div>
					<br>
					<div class="col-md-12 text-center">
						<button type="Submit" id="sub" name="getmail"
							class="btn btn-primary btn-lg">Get OTP</button>
						<div
							style="color: Red; font-family: monospace; font-size: x-large;">

							<strong> <c:if test="${ !empty msg}">${msg} </c:if> <strong>

							</strong></strong>
						</div>

					</div>


				</form>
				<form action="getotp" method="post">
					<div class="OTP">
						<label>Enter OTP:</label><input type="Text" name="userotp"
							class="form-control" placeholder="Password" required><br>
					</div>
					<br>
					<div class="col-md-12 text-center">



						<button type="submit" name="changeotp"
							class="btn btn-success btn-lg">Verify OTP</button>
						<br> <strong> <c:if test="${ !empty otpmsg}">${otpmsg} </c:if>
							<strong> </strong></strong>
					</div>
			</div>
			</form>
		</div>
		</div>
	</section>


</body>
</html>