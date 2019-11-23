<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Page</title>
</head>
<body>
	<h2>${message}</h2>

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
	<h3 align="right">
		<a href="<%=request.getContextPath()%>/logout">Logout</a>
	</h3>
</body>
</html>