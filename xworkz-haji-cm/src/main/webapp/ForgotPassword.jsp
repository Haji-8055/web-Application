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
						aria-current="page" href="index.jsp">Home</a></li>
						
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
	
		<div class="col-sm-3 bg-warning" style="margin: 80px 550px" >
	<form action="forgotPassword" method="post" class=" container pt-9 border border-5 border border-dark">
	
	Email<input class="form-control form-control-lg" type="email" id="email" name="email" placeholder="enter your registered email" />
	<br>
		<input type="submit" id="submitId" value="Send" class="btn btn-dark btn-lg"/>	
	</form>
	</div>
	<div class="container" style="margin: 80px 550px">
	<a href="SignIn.jsp">${resetMsg}</a>
		<h4 style="color: red">${note}</h4>
	
	
	<h3>${resetError}</h3>
	</div>
	
	
</body>
</html>
