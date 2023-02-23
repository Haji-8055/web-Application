<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
						aria-current="page" href="index.jsp">home</a></li>


					<li class="nav-item"><a class="nav-link active" href="#">Link</a>
					</li>


				</ul>
				<form class="d-flex" action="search" method="get">
					<input class="form-control me-2" type="search" placeholder="Search by id"
						aria-label="Search" name="id">
					<button class="btn btn-outline-success" type="submit"
						style="background: black;">Search</button>
				</form>
			</div>
		</div>
	</nav>
	
	<h1 style="color: red">valentine search</h1>
	<h3 style="color: red">${message}</h3>
	
	
	<h3>results for seach</h3>
	
<ul>
<li>name:${dto.name}</li>
<li>valentine name:${dto.valentineName}</li>
<li>place:${dto.meetingPlace}</li>
<li>gift:${dto.gift}</li>

</ul>	
	
	</body>
</html>