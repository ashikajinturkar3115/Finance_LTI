<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<title>Bootstrap Example</title>
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
<head>
<meta charset="ISO-8859-1">
<title>Hello Page</title>
<style type="text/css">
#lucida {
	font-family: "Lucida Console", Monaco, monospace;
}

#border123 {
	border-radius: 25px;
}
</style>
</head>
<body>
	<%-- 	<h2>Welcome -</h2>
	<h3>${customerLogin.customerUserName }</h3> --%>
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		/* 	response.setHeader("Cache-Control", "no-store");
			response.setHeader("Cache-Control", "must-revalidate");
			 */

		if (session.getAttribute("hello") == null) {
			response.sendRedirect(request.getContextPath() + "/loginCustomer");

		}
	%>
	<div class="container" align="center">
		<br />
		<c:if test="${not empty emiDes}">
			<c:if test="${emiDes.status == 'PENDING'}">
				<h4>
					Payment is pending. Click <a
						href="/payMonthlyEmi/${emiDes.emiPurchaseDescpritionId }">here</a>
					to pay now!
				</h4>
			</c:if>
		</c:if>
	</div>
	<br>
	<br>

	<c:if test="${cardType == 'GOLD'}">
		<div class="container" align="center">
			<div class="card img-fluid" style="width: 500px">
				<img class="card-img-top" src="images/gold.jpg" alt="Card image"
					style="width: 100%" id="border123">
				<div class="card-img-overlay">
					<br /> <br /> <br /> <br /> <br /> <br>
					<p class="lead">
					<h4 align="left" id="lucida" style="color: black;">CARD NO.
						${emi.emiCardNo}</h4>
					</p>
					<h4 class="card-title" align="left" style="color: black;">NAME:
						${custName}</h4>
					<c:if test="${customerLogin.customerStatus == 'ACTIVATED'}">
						<h4 class="card-text" style="color: green;" align="center">${customerLogin.customerStatus }
						</h4>
					</c:if>
					<c:if test="${customerLogin.customerStatus == 'DEACTIVATED'}">
						<h4 class="card-text" style="color: red;" align="center">${customerLogin.customerStatus }
						</h4>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${cardType == 'TITANIUM'}">
		<div class="container" align="center">
			<div class="card img-fluid" style="width: 500px">
				<img class="card-img-top" src="images/titanium.jpg" alt="Card image"
					style="width: 100%" id="border123">
				<div class="card-img-overlay">
					<br /> <br /> <br /> <br /> <br /> <br>
					<p class="lead">
					<h4 align="left" id="lucida" style="color: white;">CARD NO.
						${emi.emiCardNo}</h4>
					</p>
					<h4 class="card-title" align="left" style="color: white;">NAME:
						${custName}</h4>
					<c:if test="${customerLogin.customerStatus == 'ACTIVATED'}">
						<h4 class="card-text" style="color: green;" align="center">${customerLogin.customerStatus }
						</h4>
					</c:if>
					<c:if test="${customerLogin.customerStatus == 'DEACTIVATED'}">
						<h4 class="card-text" style="color: red;" align="center">${customerLogin.customerStatus }
						</h4>
					</c:if>
				</div>
			</div>
		</div>
	</c:if>
	<br>
	<div class="container">
		<table class="table table-striped" align="center" border="2">
			<thead>
				<tr>
					<th colspan=11><h4 class="ctr" align="center">EMI BALANCE
							DETAILS</h4></th>
				</tr>
				<tr>
					<th>TOTAL CREDIT</th>
					<th>CREDIT USED</th>
					<th>REMAINING CREDIT</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td>${emi.totalBalance}</td>
					<td>${emi.totalBalance - emi.availableBalance }</td>
					<td>${emi.availableBalance}</td>

				</tr>

			</tbody>
		</table>
	</div>
	<c:if test="${not empty emiTable}">
		<div class="container">
			<table class="table table-striped" align="center" border="2">
				<thead>
					<tr>
						<th colspan=11><h4 class="ctr" align="center">TRANSACTION
								DETAILS</h4></th>
					</tr>
					<tr>
						<th>REMAINING AMOUNT</th>
						<th>MONTHLY AMOUNT</th>
						<th>DEDUCTION DATE</th>
						<th>PAYMENT STATUS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emid" items="${ emiTable}">
						<tr>

							<td>${emid.totalAmount }</td>
							<td>${emid.monthlyAmount }</td>
							<td>${emid.deductionDate }</td>
							<td>${emid.status}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${not empty list }">
		<div class="container">
			<table class="table table-striped" align="center" border="2">
				<thead>
					<tr>
						<th colspan=11><h4 class="ctr" align="center">PURCHASED
								PRODUCT DETAILS</h4></th>
					</tr>
					<tr>
						<th>PRODUCT ID</th>
						<th>PRODUCT NAME</th>
						<th>PRODUCT TYPE</th>
						<th>PRODUCT PRICE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ppid" items="${list}">
						<tr>

							<td>${ppid.productID }</td>
							<td>${ppid.productName }</td>
							<td>${ppid.productType }</td>
							<td>${ppid.productPrice}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</c:if>
</body>
<%@ include file="footer.jsp"%>
</html>