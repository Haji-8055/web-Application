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

	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<div class="container-fluid">

			<a class="navbar-brand" href="#"> <img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="xworkz logo" width="120" height="60">
			</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="SignUp.jsp">SignUp</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="SignIn.jsp">SignIn</a></li>
				</ul>


				<div class="d-flex">

					<a class="form-control me-2" aria-current="page" href="SignUp.jsp">SignUp</a>
					<a class="form-control me-2" aria-current="page" href="SignIn.jsp">SignIn</a>
				</div>
			</div>
		</div>
	</nav>
	<h1 style="color: green;">${successMessage}</h1>

	<h1 class="text-center ">home page</h1>




</body>
</html>