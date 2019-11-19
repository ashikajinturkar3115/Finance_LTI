<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<body>

<div style="margin:50px">
<h1> Get User Details </h1>

<form method="get" action="userdetails">

    <div style="margin-bottom:10px">

       <span>Id</span>
        <input type="number" name="id"  required/>
    </div>

    <input type="submit" value="Get Details"/>

</form>

</div>

</body>
</html>