<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style type="text/css">
</style>
</head>
<body>


	<div class="container">
		<div class="row text-center">
			<div class="col-sm-6 col-sm-offset-3">
				<br> <br>
				<h2 style="color: #0fad00">Success</h2>


				<p style="font-size: 20px; color: #5C5C5C;">Thank you for
					Registering. Please Login To see Products. Our Representative will
					contact you for the manual verification</p>
				<a href="<%=request.getContextPath() %>/loginCustomer" class="btn btn-success">     Log in     </a> <br> <br>
			</div>

		</div>

		<%-- <c:forEach var="img" items="${fileName }">
			<img src="${pageContext.request.contextPath}/getimage/${img}"
				height="250px;" width="200px;">
		</c:forEach> --%>


	</div>
</body>
</html>