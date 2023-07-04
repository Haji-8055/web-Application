<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>cars available</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://www.x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="" width="120" height="60">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="SignInSuccess.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="ViewCars?userId=${userId}">view cars</a></li>

				</ul>


			</div>
		</div>

		<div class="d-flex">
			<h3 style="color: blue;">${userId}</h3>

		</div>
	</nav>

	<h3 style="color: green;">${msg}</h3>

	<div class="col-sm-3" style="margin: 80px 550px">
		<h3 class="form-control form-control-lg bg-danger">add cars
			available in your showroom</h3>

		<form action="addCars" method="post"
			class="bg-info container pt-9 border border-5 border border-dark">



			<input class="form-control form-control-lg" name="userId" id="mail"
				value="${userId}" type="hidden" /> Enter car company<input
				type="text" name="carCompany" id="carCompany"
				class="form-control form-control-lg" onchange="onCompany()">
			<span id="companyError" style="color: red"></span> <br> car name<input
				type="text" name="carName" id="carName"
				class="form-control form-control-lg" onchange="onName()"> <span
				id="nameError" style="color: red"></span> <br> car model<input
				type="text" name="carModel" id="carModel"
				class="form-control form-control-lg" onchange="onModel()"> <span
				id=modelError " style="color: red"></span> <br> no of owners<input
				type="number" name="noOfOwners" id="noOfOwners"
				class="form-control form-control-lg" onchange="onOwners"> <span
				id="ownersError" style="color: red"></span> <br> add <input
				type="submit" id="submitId" class="btn btn-dark btn-lg" />

		</form>
	</div>

</body>
</html>