<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Status</title>
<style type="text/css">
p {
	text-align: center;
}
</style>

</head>
<body>
	<div class="container">
		<form
			action="updateCustomerStatusAndEmi/${loginData.customerLoginId }">

			<h4 align=center>ACTIVATE USER'S ACCOUNT</h4>
			<br> <br> <br>


			<c:if test="${ empty emicardno}">

			
			The user doesn't have an EMI card&nbsp; 
			<div class="form-group">
					<p>
						<b>EMICardNo </b><input type="text" name="emicardno">
					</p>
				</div>
			</c:if>

			<c:if test="${!empty emicardno}">
			The user already has an EMI card No.${emicardno}
				<div class="form-group">
					<p>
						<b>EMICardNo </b><input type="text" name="emicardno"
							value="${emicardno}" readonly="readonly">
					</p>
				</div>

			</c:if>
			<br> <br> <br> <br>
			<h4 align=center>ACTIVATE USER</h4>
			<p align="center">
				<label>Select ACTIVATION STATUS</label> <select name="status">
					<option value="NONE">-----Select-----</option>
					<option value="ACTIVATED">ACTIVATED</option>
					<option value="DEACTIVATED">DEACTIVATED</option>
				</select> <br> <br> <input type="submit" name="submit"
					class="btn btn-danger btn-xl" value="SUBMIT">
			</p>
		</form>
	</div>
</body>
</html>