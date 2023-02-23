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
				src="https://www.aeroindia.gov.in/front/updated_assets/aeroIndia_logo.png"
				alt="xworkz logo" width="120" height="60"
				style="background-color: white;">
			</a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">home</a></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="AeroplaneSearch.jsp">AeroPlane
							search</a></li>


					<li class="nav-item"><a class="nav-link active" href="#">Link</a>
					</li>


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
	
	<div style="color: red;">
			<c:forEach items="${violations}" var="v">
				<p>${v.message}</p>
			</c:forEach>


		</div>
	

	<form action=fly method="post" class="bg-info container pt-9 border border-5 border border-danger">

		<div class="col-sm-3">
			<label for="exampleInputEmail1" class="form-label">company </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="company" name="company">
		</div>

		<div class="col-sm-3">
			<label for="exampleInputEmail1" class="form-label">name </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="name" name="name">
		</div>

		<div class="col-sm-3">
			<label for="exampleInputEmail1" class="form-label">cost </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="cost" name="cost">
		</div>

		<div class="col-sm-2">

			select plane type <select class="form-select"
				aria-label="Default select example" name="type">
				<option value="">select type</option>

				<c:forEach items="${type}" var="t">
					<option value="${t}">${t}</option>
				</c:forEach>

			</select>
		</div>


		<div class="col-sm-2">

			select country <select class="form-select"
				aria-label="Default select example" name="country">
				<option value="">select country</option>

				<c:forEach items="${country}" var="c">
					<option value="${c}">${c}</option>
				</c:forEach>

			</select>
		</div>


		<input type="submit" value="submit" class="btn btn-dark btn-lg">

	</form>

</body>
</html>