<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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



	<form class="form-horizontal" action="" method="POST">
		<fieldset>
			<div id="legend">
				<legend class="abc">Register</legend>
			</div>
			<div class="control-group">
				<!-- Username -->
				<label class="control-label" for="username">Username</label>
				<div class="controls">
					<input type="text" id="username" name="username"
						placeholder="Enter Username" class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="password">Password</label>
				<div class="controls">
					<input type="password" id="password" name="password"
						placeholder="Enter Password" class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- confirm Password -->
				<label class="control-label" for="password_confirm">
					(Confirm)</label>
				<div class="controls">
					<input type="password" id="password_confirm"
						name="password_confirm" placeholder="" class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- Password-->
				<label class="control-label" for="name">Name</label>
				<div class="controls">
					<input type="name" id="name" name="name"
						placeholder="Enter Your Name" class="input-xlarge">

				</div>
			</div>
			<div class="control-group">
				<!-- E-mail -->
				<label class="control-label" for="email">E-mail</label>
				<div class="controls">
					<input type="text" id="email" name="email"
						placeholder="Enter Email" class="input-xlarge">

				</div>
			</div>
			<div class="control-group">
				<!-- Contact -->
				<label class="control-label" for="contact">Contact</label>
				<div class="controls">
					<input type="text" id="contact" name="contact"
						placeholder="Enter Contact" class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- Bank Name -->
				<label class="control-label" for="bankName">Enter Bank</label>
				<div class="controls">
					<select>
						<option value="SBI">SBI</option>
						<option value="HSBC">HSBC</option>
						<option value="BOI">BOI</option>
						<option value="IDBI">IDBI</option>
					</select>
					<!-- <input type="text" id="bankName" name="bankName"
						placeholder="Enter Email" class="input-xlarge"> -->

				</div>
			</div>

			<div class="control-group">
				<!-- Account Number -->
				<label class="control-label" for="accountNo">Account Number</label>
				<div class="controls">
					<input type="accountNo" id="accountNo" name="accountNo"
						placeholder="Enter Account Number" class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- IFSC  -->
				<label class="control-label" for="ifsc">IFSC </label>
				<div class="controls">
					<input type="text" id="ifsc" name="ifsc" placeholder="IFSC"
						class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- IFSC  -->
				<label class="control-label" for="address">Address </label>
				<div class="controls">
					<input type="text" id="address" name="address" placeholder="IFSC"
						class="input-xlarge">

				</div>
			</div>

			<div class="control-group">
				<!-- IFSC  -->
				<label class="control-label" for="cardType">Card Type </label>
				<div class="controls">
					<select>
						<option value="NONE">-----Select----</option>
						<option value="GOLD">GOLD</option>
						<option value="TITANIUM">TITANIUM</option>	
					</select>

				</div>
			</div>

			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success">Register</button>
				</div>
			</div>
		</fieldset>

		<!--  <p class="help-block">Please provide your E-mail</p> -->
		<!-- <p class="help-block">Username can contain any letters or numbers, without spaces</p> -->
		<!--  <p class="help-block">Password should be at least 4 characters</p> -->
		<!--  <p class="help-block">Please confirm password</p> -->
	</form>

</body>
</html>