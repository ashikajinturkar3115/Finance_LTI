<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!-- to enable expression language -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer List</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<style>
.ctr {
	text-align: center;
}
</style>
<body>

<h4><a href="/adminLogout">Logout</a></h4>



	<div class="container">
		<table class="table table-striped" align="center" border="2">
			<thead>
				<tr>
					<th colspan=11><h4 class="ctr">USER DETAILS DATABASE</h4></th>
				</tr>
				<tr>
					<th>Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Bank Name</th>
					<th>Account Number</th>

					<th>Address</th>
					<th>Username</th>
					<th>Card Type</th>
					<th>Check Documents</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="x" items="${listOfCustomers}">
					<!-- key interlinked to admin login logic -->
					<tr>
						<td>${x.name}</td>
						<td>${x.contact}</td>
						<td>${x.email}</td>
						<td>${x.bankName}</td>
						<td>${x.accountNo}</td>
						<td>${x.address}</td>
						<td>${x.username}</td>
						<td>${x.cardType}</td>
						<td><a href="/getUserDocuments/${x.customerId}">See
								Doucuments</a></td>
						<td><a href="/customerEdit/${x.customerLoginId}">Edit</a></td>
						<td><a href="/customerlist/${x.customerId}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
€‹

