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

	<form action="cm" method="post">


		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">cm name </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="bikeName" name="cmName">

		</div>

		State <select class="form-select" aria-label="Default select example"
			name="state">
			<option value="">select state</option>
			<option>karnataka</option>
			<option>maharsahtra</option>
			<option>delhi</option>
		</select> party <select class="form-select" aria-label="Default select example"
			name="party">
			<option value="">select party</option>
			<option>bjp</option>
			<option>congress</option>
			<option>aap</option>
		</select> tenure <select class="form-select"
			aria-label="Default select example" name="tenure">
			<option value="">select tenure</option>
			<option>1</option>
			<option>2</option>
			<option>3</option>
			<option>5</option>
			<option>7</option>
			<option>10</option>
		</select> <input type="submit" value="submit" class="btn btn-dark btn-lg">


	</form>

</body>
</html>