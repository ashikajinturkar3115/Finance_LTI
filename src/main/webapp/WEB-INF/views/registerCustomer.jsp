<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.fnt {
	font-size: 20px;
	text-align: center;
	margin-left: 50px;
}
</style>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" action="registerCustomer" method="post"
			modelAttribute="customerRegistration" onsubmit="return call();">
			<fieldset>
				<table align="center" style="width: 50%" class="table-striped">
					<caption>

						<div id="legend">
							<legend class="abc">Register</legend>
						</div>

					</caption>
					<tbody>
						<!-- Username -->
						<tr>
							<td><label class="control-label" for="username"><b
									class="fnt">Username</b></label></td>
							<td>

								<div class="controls">
									<input type="text" id="username" name="username"
										placeholder="Enter Username" class="input-xlarge"> <span
										id="user"></span>
								</div>

							</td>
						</tr>

						<tr>
							<td><label class="control-label" for="password"><b
									class="fnt">Password</b></label></td>
							<td>

								<div class="controls">
									<input type="password" id="password" name="password"
										placeholder="Enter Password" class="input-xlarge" required>
									<span id="pass"></span>
								</div>

							</td>
						</tr>
						<tr>
							<td>
								<!-- confirm Password --> <label class="control-label"
								for="confirmPassword"><b class="fnt">Confirm
										Password</b></label>

							</td>
							<td><div class="controls">
									<input type="password" id="confirmPassword"
										name="confirmPassword" placeholder="" class="input-xlarge"
										required>
								</div> <span id="confirm"></span></td>
						</tr>
						<tr>
							<td><label class="control-label" for="name"><b
									class="fnt">Name</b></label></td>
							<td>

								<div class="controls">
									<input type="text" id="name" name="name"
										placeholder="Enter Your Name" class="input-xlarge"> <span
										id="nm"></span>
								</div>

							</td>
						</tr>

						<tr>
							<td><label class="control-label" for="email"><b
									class="fnt">Email</b></label></td>
							<td>
								<div class="controls">
									<input type="text" id="email" name="email"
										placeholder="Enter Email" class="input-xlarge" required /> <span
										id="eml"></span>

								</div>
							</td>
						</tr>
						<tr>
							<td>
								<!-- Contact --> <label class="control-label" for="contact"><b
									class="fnt">Contact</b></label>
							</td>
							<td>
								<div class="controls">
									<input type="text" id="contact" name="contact"
										placeholder="Enter Contact" class="input-xlarge" required>
									<span id="cntct"></span>

								</div>
							</td>
						</tr>
						<tr>
							<td>
								<!-- Bank Name --> <label class="control-label" for="bankName"><b
									class="fnt">Enter Bank</b></label>
							</td>
							<td>
								<div class="controls">
									<select name="bankName">
										<option value="SBI">SBI</option>
										<option value="HSBC">HSBC</option>
										<option value="BOI">BOI</option>
										<option value="IDBI">IDBI</option>
									</select>
									<!-- <input type="text" id="bankName" name="bankName"
						placeholder="Enter Email" class="input-xlarge"> -->
									<span id="bnkname"></span>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<!-- Account Number --> <label class="control-label"
								for="accountNo"><b class="fnt">Account Number</b></label>

							</td>
							<td>

								<div class="controls">
									<input type=text id="accountNo" name="accountNo"
										placeholder="Enter Account Number" class="input-xlarge">
									<span id="acc"></span>

								</div>
							</td>
						</tr>
						<tr>
							<td>
								<!-- IFSC  --> <label class="control-label" for="ifsc"><b
									class="fnt">IFSC</b> </label>
							</td>
							<td>

								<div class="controls">
									<input type="text" id="ifsc" name="ifsc" placeholder="IFSC"
										class="input-xlarge" required> <span id="ifs"></span>
								</div>

							</td>
						</tr>

						<tr>
							<td>
								<!-- IFSC  --> <label class="control-label" for="address"><b
									class="fnt">Address</b> </label>
							</td>
							<td>

								<div class="controls">
									<input type="text" id="address" name="address"
										placeholder="IFSC" class="input-xlarge" required> <span
										id="addr"></span>
								</div>

							</td>
						</tr>
						<tr>
							<td>
								<!-- IFSC  --> <label class="control-label" for="cardType"><b
									class="fnt">Card Type</b> </label>

							</td>
							<td>
								<div class="controls">
									<select name="cardType" required>
										<option value="NONE">-----Select----</option>
										<option value="GOLD">GOLD</option>
										<option value="TITANIUM">TITANIUM</option>
									</select> <span id="crdtpe"></span>

								</div>
							</td>
						</tr>

					</tbody>
				</table>

				<div class="controls" align="center">
					<button type="submit" class="btn-success">Upload</button>

				</div>
				<!-- <div class="control-group">
				Upload File 
				<label class="control-label" for="fileUpload">Upload File </label>
				<div class="controls">
					<input type="file" id="fileUpload" name="fileUpload"
						class="input-xlarge" required> <span id="filep"></span>
				</div>
			</div> -->



			</fieldset>

			<!--  <p class="help-block">Please provide your E-mail</p> -->
			<!-- <p class="help-block">Username can contain any letters or numbers, without spaces</p> -->
			<!--  <p class="help-block">Password should be at least 4 characters</p> -->
			<!--  <p class="help-block">Please confirm password</p> -->
		</form>
	</div>
	<script type="text/javascript">
		function validatePass() {

			alert("in pass");
			var password = document.getElementById("password").value;
			var confirmPassword = document.getElementById("confirmPassword").value;

			alert("in pass()");
			var ok = true;
			if (password != confirmPassword) {
				document.getElementById("confirm").textContent = "Password Doesn't Match";
				document.getElementById("confirm").style.color = 'red';

				ok = false;
			}

			else {
				document.getElementById("confirm").textContent = "";
				return ok;
			}
			return ok;

		}
	</script>

	<script type="text/javascript">
		function validateEmail() {
			alert("in email()");
			var email = document.getElementById("email").value;
			atpos = email.indexOf("@");
			dotpos = email.lastIndexOf(".");
			var ok = true;
			if (atpos < 1 || (dotpos - atpos < 2)) {
				document.getElementById("eml").textContent = "Provide Valid Email ID";
				document.getElementById("eml").style.color = "red";
				ok = false;
			} else {
				document.getElementById("eml").textContent = "";
				return ok;
			}
			return ok;

		}
	</script>

	<script type="text/javascript">
		function validateContact() {
			var contact = document.getElementById("contact").value;
			var ok = true;
			if (contact.length != 10) {
				document.getElementById("cntct").textContent = "Enter Valid Contact Number";
				ok = false;
			} else {
				document.getElementById("cntct").textContent = "";
				return ok;
			}
			return ok;
		}
	</script>

	<script type="text/javascript">
		function call() {
			var ok = true;
			alert("in call");
			var statusa = validatePass();
			var statusb = validateEmail();
			var statusc = validateContact();
			if (statusa == true && statusb == true && statusc == true) {
				return ok;
			} else {
				ok = false;
			}
			return false;

		}
	</script>




</body>
</html>