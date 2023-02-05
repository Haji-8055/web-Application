<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"> <img
				src="‪spring_webMvc(mapping)/src/main/webapp/image/x-workz.png"
				alt="Bootstrap" width="30" height="24"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation"></button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>

					<li class="nav-item"><a class="nav-link" href="index.jsp">
							Home page</a></li>
				</ul>

				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>

			</div>
		</div>
	</nav>

	<form action="eat" method="post">

		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">your name</span> <input
				type="text" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" name="name">
		</div>

		select food <select class="form-select"
			aria-label="Default select example" name="food">
			<option selected>Open this select menu</option>
			<option value="dosa">dosa</option>
			<option value="idli">idli</option>
			<option value="vada">vada</option>
		</select>
		<div>
			<label for="customRange2" class="form-label">quantity</label> <input
				type="range" class="form-range" min="0" max="5" id="customRange2" name="range">
		</div>

		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">food price</span> <input
				type="text" class="form-control" placeholder="Username"
				aria-label="Username" aria-describedby="basic-addon1" name="price">
		</div>

		<input type="submit" value="submit">

	</form>



</body>
</html>