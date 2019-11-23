<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Status</title>
</head>
<body>
	<form action="updateCustomerStatusAndEmi/${loginData.customerLoginId }">
		
		<h3 align=center>ACTIVATE USER'S ACCOUNT</h3>
		<br> <br> <br>
		<p align=center>
			<b>EMICardNo </b><input type="text" name="emicardno">
		</p>
		<br>
		<h4 align=center>ACTIVATE USER</h4>
		<p align="center">
			<label>Select ACTIVATION STATUS</label> <select name="status">
				<option value="NONE">-----Select-----</option>
				<option value="ACTIVATED">ACTIVATED</option>
				<option value="DEACTIVATED">DEACTIVATED</option>
			</select> <br> <br> <input type="submit" name="submit"
				value="SUBMIT">
		</p>
	</form>
</body>
</html>