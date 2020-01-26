<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
#status {
	display: none;
}
</style>
<%@include file="header.jsp"%>
</head>
<body>

	<div class="jumbotron text-center">
		<h1>PRODUCTS</h1>
	</div>

	<!----------------------------------------------------------------------------------  -->
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<h3>
					<b>DISPLAY</b>
				</h3>
				<div>
					<img src="/images/redmi.png" alt="image" class="img-rounded"
						width="200" height="150">
				</div>
				<br>
				<div>
					<img src="/images/xiaomi.jpg" alt="image" class="img-rounded"
						width="200" height="180">
				</div>
				<br>
				<div>
					<img src="/images/samsung.png" alt="image" class="img-rounded"
						width="150" height="180">
				</div>
				<br>
				<div>
					<img src="/images/vivo.jpg" alt="image" class="img-rounded"
						width="200" height="180">
				</div>
				<br>
			</div>
			<div class="col-sm-6">
				<h3>
					<b>DETAILS</b>
				</h3>
				<table>
					<c:forEach var="products" items="${products }">
						<h4>
							<b>PRODUCT:</b>
							<mark>${products.productName }</mark>
						</h4>
						<h4>
							<b>TYPE:</b>
							<p>${products.productType }</p>
						</h4>
						<h4>
							<b>PRICE:</b>
							<p>Rs. ${products.productPrice }</p>
						</h4>
						<a href="/loginCustomer" id="lnk" class="btn btn-info">Buy Now</a>
						<br>
						<br>
					</c:forEach>
				</table>
			</div>

		</div>
	</div>

	<!-- -------------------------------------------------------------------------------- -->

	<%-- <c:forEach var="products" items="${products }">
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
	</c:forEach> --%>
	<%@include file="footer.jsp"%>
</body>
<!-- <script type="text/javascript">
	function disableBack() {
		var status = document.getElementById("status").innerHTML;

		if (status === "DEACTIVATED") {
			var lnk = document.getElementById("lnk");
			if (window.addEventListener) {
				document
						.addEventListener(
								'click',
								function(e) {
									if (e.target.id === lnk.id) {
										e.preventDefault();
										alert("Please Contact Your Administrator for Activation of Your EMI CARD");

									}
								});
			}

		}
	}
</script> -->

</html>