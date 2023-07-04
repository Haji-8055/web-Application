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
						aria-current="page" href="index.jsp">logout</a></li>

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>

				</ul>


				<form class="d-flex">
					<h3 style="color: blue;">${userId}</h3>

				</form>

				<form class="d-flex" style="padding-left: 25px">
					<div class="navbar-brand" > 
					
					
				 	<img  src="display?fileName=${userImage}" height="80" width="80">
						
					</div>
					
					

				</form>
			</div>
		</div>
	</nav>
	
	
	<nav class="navbar bg-light">

  <!-- Links -->
  <ul class="navbar-nav bg-dark">
    <li class="nav-item">
      <a class="nav-link" href="updateProfile?userId=${userId}">UpdateProfile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="AddCars.jsp">Add cars</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="ViewCars?userId=${userId}" >view cars</a>
    </li>
  </ul>

</nav>


	<h1 style="color: green">${successMessage}</h1>
	
	<div style="margin-left: 600px">
		<h1>SignIn success page</h1>
	</div>
	
	




</body>
</html>