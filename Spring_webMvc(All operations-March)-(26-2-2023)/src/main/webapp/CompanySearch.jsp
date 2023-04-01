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
				<form class="d-flex" action="SearchByCom" method="get">
					<input class="form-control me-2" type="search"
						placeholder="Search by company" aria-label="Search" name="company">
					<button class="btn btn-outline-success" type="submit"
						style="background: black;">Search</button>
				</form>
			</div>
		</div>
	</nav>

	<h3 style="color: red">${message}</h3>
	<h3 style="color: green">${deleted}</h3>

	<table class="table table-bordered">
		<tr 	>
			<th>id</th>
			<th>company</th>
			<th>name</th>
			<th>quantity</th>
			<th>type</th>
			<th>outlet</th>

		</tr>

		<c:forEach items="${dto}" var="v">
			<tr>
				<td>${v.id}</td>

				<td>${v.company}</td>
				<td>${v.name}</td>
				<td>${v.quantity}</td>
				<td>${v.type}</td>
				<td>${v.outlet}</td>
				<td><a href="update?id=${v.id}">Edit</a></td>
				<td><a href="delete?id=${v.id}">delete</a></td>

			</tr>


		</c:forEach>

	</table>



</body>
</html>