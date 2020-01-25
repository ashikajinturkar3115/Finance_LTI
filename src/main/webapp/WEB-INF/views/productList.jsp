<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="disableBack();">${customerLogin.customerLoginId }

	<p id="status">${customerLogin.customerStatus }</p>
	<c:forEach var="products" items="${products }">
		<br />
		<b>${products.productID }</b>
		<br />
		<b>${products.productName }</b>
		<br />
		<b>${products.productType }</b>
		<br />
		<b>${products.productPrice }</b>
		<br />
		<b><a href="/buyProduct/${products.productID}" id="lnk">Buy
				Product</a></b>
	</c:forEach>
</body>
<script type="text/javascript">
	function disableBack() {
		var status = document.getElementById("status").innerHTML;
		alert(status);
		if (status === "DEACTIVATED") {
			var lnk = document.getElementById("lnk");
			if (window.addEventListener) {
				document.addEventListener('click', function(e) {
					if (e.target.id === lnk.id) {
						e.preventDefault();
						alert("Please Contact Your Administrator for Activation of Your EMI CARD");
							
					}
				});
			}

		}
	}
</script>

</html>