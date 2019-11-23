<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form method="post" action="uploadFile" enctype="multipart/form-data">
			<input type="hidden" value="${userId }" name="customerId">
			<div id="legend" align="center">
				<legend class="abc">Upload Documents</legend>
			</div>
			<table align="center" class="table-striped">
				<tr>
					<td>
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroupFileAddon01">Upload
								Adhar</span>
						</div>
					</td>
					<td>
						<div class="custom-file">
							<input type="file" class="custom-file-input" id="file"
								name="file" aria-describedby="inputGroupFileAddon01"> <label
								class="custom-file-label" for="inputGroupFile01">Choose
								file</label>
						</div>
					</td>
				</tr>
				<tr>
					<td><div class="input-group-prepend">
							<span class="input-group-text" id="inputGroupFileAddon01">Upload
								Cheque</span>
						</div></td>
					<td><div class="custom-file">
							<input type="file" class="custom-file-input" id="file2"
								name="file2" aria-describedby="inputGroupFileAddon01"> <label
								class="custom-file-label" for="inputGroupFile01">Choose
								file</label>
						</div></td>
				</tr>
				<tr>
					<td><div class="input-group-prepend">
							<span class="input-group-text" id="inputGroupFileAddon01">Upload
								PAN</span>
						</div></td>
					<td><div class="custom-file">
							<input type="file" class="custom-file-input" id="file3"
								name="file3" aria-describedby="inputGroupFileAddon01"> <label
								class="custom-file-label" for="inputGroupFile01">Choose
								file</label>
						</div></td>
				</tr>
			</table>

			<!-- <div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroupFileAddon01">Upload
						Adhar</span>
				</div>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="file" name="file"
						aria-describedby="inputGroupFileAddon01"> <label
						class="custom-file-label" for="inputGroupFile01">Choose
						file</label>
				</div>

			</div> -->

			<!-- <div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroupFileAddon01">Upload
						Cheque</span>
				</div>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="file2"
						name="file2" aria-describedby="inputGroupFileAddon01"> <label
						class="custom-file-label" for="inputGroupFile01">Choose
						file</label>
				</div>

			</div> -->

			<!-- <div class="input-group">
				<div class="input-group-prepend">
					<span class="input-group-text" id="inputGroupFileAddon01">Upload
						PAN</span>
				</div>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="file3"
						name="file3" aria-describedby="inputGroupFileAddon01"> <label
						class="custom-file-label" for="inputGroupFile01">Choose
						file</label>
				</div>

			</div> -->
			<br />
			<div align="center">

				<button type="submit" class="btn-success">Upload</button>
			</div>

		</form>
	</div>
</body>
</html>