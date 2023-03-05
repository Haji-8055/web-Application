<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>x-workz</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-lg  navbar-dark bg-primary">
		<div class="container-fluid">

			<a class="navbar-brand" href="#"> <img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="xworkz logo" width="120" height="60">
			</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>


				</ul>
				<form class="d-flex">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit"
						style="background: black;">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<form action="race" method="post">


		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">bike name
			</label> <input type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="bikeName" name="bikeName">

		</div>
		
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">bike
				owner</label> <input type="text" class="form-control"
				id="exampleInputPassword1" placeholder="bikeOwner"
				name="bikeOwner">
		</div>
		
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">bike
				brand</label> <input type="text" class="form-control"
				id="exampleInputPassword1" placeholder="bikeBrand" name="bikeBrand">
		</div>

		is bike fast
		<div class="form-check">
			<input class="form-check-input" type="radio" name="isFast"
				id="flexRadioDefault1" value="true"> <label
				class="form-check-label" for="flexRadioDefault1"> yes </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="isFast"
				id="flexRadioDefault2" value="false"> <label
				class="form-check-label" for="flexRadioDefault2"> No </label>
		</div>
		
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">bike
				cc</label> <input type="number" class="form-control"
				id="exampleInputPassword1" placeholder="bikeCC" name="bikeCC">
		</div>


		<input type="submit" value="submit" class="btn btn-dark btn-lg">


	</form>

</body>
</html>