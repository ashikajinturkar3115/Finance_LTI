<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
	<h2>Welcome -</h2>
	<h3>${customerLogin.customerUserName }</h3>
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
	<div class="container">
		<h3 align="left">
			<a href="/productlist">Products</a>
		</h3>
		<h3 align="right">
			<a href="<%=request.getContextPath()%>/logout">Logout</a>
		</h3>
		<br />
		<c:if test="${not empty emiDes}">
			<c:if test="${emiDes.status == 'PENDING'}">
				<a href="/payMonthlyEmi/${emiDes.emiPurchaseDescpritionId }">PAY
					NOW</a>
			</c:if>
		</c:if>
		
		<br />
		<p>TOTAL CREDIT : ${emi.totalBalance}</p>
		<p>CREDIT USED : ${emi.totalBalance - emi.availableBalance }</p>
		<p>REMAINING CREDIT : ${emi.availableBalance}</p>

	</div>
	<c:if test="${not empty emiTable}">
		<div class="container">
			<table>
				<thead>
					<tr>
						<th>totalAmount</th>
						<th>monthlyAmount</th>
						<th>deductionDate</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emid" items="${ emiTable}">
						<tr>

							<td>${emid.totalAmount }</td>
							<td>${emid.monthlyAmount }</td>
							<td>${emid.deductionDate }</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>
</body>
</html>