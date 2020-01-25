<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/payNow/${description.productId }">

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
	</form>
	<script type="text/javascript">
		function getValue() {
			var price = document.getElementById("price").innerText;
			alert(price);
			var parsedPrice = parseFloat(price);
			alert(parsedPrice);
			var e = document.getElementById("val");
			var value = e.options[e.selectedIndex].value;
			alert(value);

			if (value == 3) {
				var monthly = parsedPrice / 3;
				document.getElementById("emi").innerHTML = monthly.toFixed(2);
			} else if (value == 6) {
				var monthly = parsedPrice / 6;
				document.getElementById("emi").innerHTML = monthly.toFixed(2);
			} else if (value == 9) {
				var monthly = parsedPrice / 9;
				document.getElementById("emi").innerHTML = monthly.toFixed(2);
			} else {
				var monthly = parsedPrice / 12;
				document.getElementById("emi").innerHTML = monthly.toFixed(2);
			}
		}
	</script>
</body>
</html>