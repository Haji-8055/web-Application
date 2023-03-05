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
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="CoffeeSearch.jsp">Coffee
							search</a></li>


					<li class="nav-item"><a class="nav-link active" href="CompanySearch.jsp">searchByCompany</a>
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
	
	<h1 style="color: green;">${message}</h1>
	<div style="color: red;">
			<c:forEach items="${violations}" var="v">
				<p>${v.message}</p>
			</c:forEach>


		</div>
	

	<form action="update" method="post" class="bg-secondary container pt-9 border border-5 border border-info">

		<div class="col-sm-3">
			<label for="exampleInputEmail1" class="form-label">coffee company </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" value="${dto.company}" name="company" readonly> 
		</div>

		<div class="col-sm-3">
			<label for="exampleInputEmail1" class="form-label"> your name </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" value="${dto.name}" name="name">
		</div>

		<div class="col-sm-3">
			<label for="exampleInputEmail1" class="form-label">quantity </label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" value="${dto.quantity}" readonly name="quantity">
		</div>

		<div class="col-sm-2">

			select coffee type <select class="form-select"
				aria-label="Default select example" name="type">
				<option value="${dto.type}">${dto.type}</option>

				<c:forEach items="${type}" var="t">
					<option value="${t}">${t}</option>
				</c:forEach>

			</select>
		</div>


		<div class="col-sm-2">

			select outlet location <select class="form-select"
				aria-label="Default select example" name="outlet">
				<option value="${dto.outlet}">${dto.outlet}</option>

				<c:forEach items="${outlet}" var="c">
					<option value="${c}">${c}</option>
				</c:forEach>

			</select>
		</div>


		<input type="submit" value="submit" class="btn btn-dark btn-lg">

	</form>

</body>
</html>