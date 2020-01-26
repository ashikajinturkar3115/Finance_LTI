<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

#paynowstatus {
	display: block;
}
</style>
<body onload="disablePayNowButton();">

	<span id="paynowstatus">${disable}</span>

	<div class="jumbotron text-center">
		<h1>PRODUCT DESCRIPTION</h1>
	</div>
	<!-- -------------------------------------------------------------------------------------- -->
	<form action="/payNow/${description.productId }" method="post">
		<div class="container">
			<div class="row">
				<div class="col-sm-5">
					<div>
						<img src="/images/redmi.png" alt="image" class="img-rounded"
							width="250" height="200">
					</div>
					<br> <br>
				</div>
				<div class="col-sm-7">
					<h4>
						<b>Product Id:</b>
						<p>${description.productId}</p>
					</h4>
					<h4>
						<b>Product Details:</b>
						<p>${description.productDetailsDescription1}</p>
						<p>${description.productDetailsDescription2}</p>
						<p>${description.productDetailsDescription3}</p>
						<p>${description.productDetailsDescription4}</p>
						<p>${description.productDetailsDescription5}</p>
					</h4>

					<h4>

						<b> Price: Rs. <span id="price">${description.productPrice}</span>
						</b>
					</h4>


				</div>
			</div>
			<div class="ctr" class="dropdown">
				<label><h4>
						<b>EMI Period:</b>
					</h4></label> <select name="choice" class="btn btn-primary dropdown-toggle"
					id="val" onchange="getValue();">
					<option value="NONE">EMI Period</option>
					<option value="3">3 Months</option>
					<option value="6">6 Months</option>
					<option value="9">9 Months</option>
					<option value="12">12 Months</option>

				</select> <b><h3 class="text-info" class="ctr" id="emi"></h3></b> <input
					type="submit" class="btn btn-info" value="Pay Now" id="disab"><br>
				<br>
			</div>
		</div>
	</form>
	<!-- -------------------------------------------------------------------------------------- -->


	<%-- <form action="/payNow/${description.productId }">

		<div>
			<b> ${description.productDetailsDescription1 } </b>
			${description.productDetailsDescription2 } <br /> <b>
				${description.productDetailsDescription3 } </b><br /> <b>
				${description.productDetailsDescription4 }</b> <br />
			${description.productDetailsDescription5 } <br /> <b id="price">${description.productPrice }</b>
			<select name="choice" id="val" onchange="getValue();">
				<option value="NONE">----Select----</option>
				<option value="3">3</option>
				<option value="6">6</option>
				<option value="9">9</option>
				<option value="12">12</option>
			</select> <input type="submit" value="submit">

			<p id="emi"></p>
		</div>
	</form> --%>
	<script type="text/javascript">
		function getValue() {
			var price = document.getElementById("price").innerText;

			var parsedPrice = parseFloat(price);

			var e = document.getElementById("val");
			var value = e.options[e.selectedIndex].value;

			if (value == 3) {
				var monthly = parsedPrice / 3;
				document.getElementById("emi").innerHTML = "Rs. "
						+ monthly.toFixed(2);
			} else if (value == 6) {
				var monthly = parsedPrice / 6;
				document.getElementById("emi").innerHTML = "Rs. "
						+ monthly.toFixed(2);
			} else if (value == 9) {
				var monthly = parsedPrice / 9;
				document.getElementById("emi").innerHTML = "Rs. "
						+ monthly.toFixed(2);
			} else {
				var monthly = parsedPrice / 12;
				document.getElementById("emi").innerHTML = "Rs. "
						+ monthly.toFixed(2);
			}
		}
	</script>

	<script type="text/javascript">
		function disablePayNowButton() {

			var val = document.getElementById("paynowstatus").textContent;

			if (val === "yes") {
				document.getElementById("disab").disabled = true;

			}
		}
	</script>
</body>
</html>