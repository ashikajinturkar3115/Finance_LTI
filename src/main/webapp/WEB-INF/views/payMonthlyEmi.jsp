<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<table class="table-striped" align="center" width="80%">
			<tbody>
				<tr>
					<td>${emides.emiCardNumber }</td>
					<td>${emides.totalAmount }</td>
					<td>${emides.monthlyAmount }</td>
					<td>${emides.deductionDate }</td>
					<td><a href="/payEmi/${emides.emiPurchaseDescpritionId}">Pay Now</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>