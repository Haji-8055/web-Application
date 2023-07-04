<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>X-workz</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

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
						aria-current="page" href="AddCars.jsp">add cars</a></li>

				</ul>
				
				<div class="d-flex">
					<h3 style="color: blue;">${userId}</h3>

				</div>

			</div>
		</div>
	</nav>

<br>
<form action="searchCar?userId=${userId}" method="post">
search<input type="text" name="param" placeholder="search for car">
 <input type="submit" >
</form>


	<br>

	<table class="table table-hover active">
		<tr class="table-dark">
			<th>Car Company</th>
			<th>Car Name</th>
			<th>Car Model</th>
			<th>No Of Owners</th>
		</tr>


		<c:forEach items="${list}" var="car">
			<tr>
				<td>${car.carCompany}</td>
				<td>${car.carName}</td>
				<td>${car.carModel}</td>
				<td>${car.noOfOwners}</td>
			</tr>
		</c:forEach>


	</table>





</body>
</html>