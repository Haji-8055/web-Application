<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="Bootstrap" width="120" height="60"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation"></button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>



					<li class="nav-item"><a class="nav-link" href="#">some
							item</a></li>
					<li class="nav-item"><a class="nav-link" href="#">some
							item</a></li>
				</ul>

				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>

			</div>
		</div>
	</nav>

	<h1 style="color: red">home page</h1>


	<form action="mail" method="get">
		<h1>${email}</h1>
		<input type="submit" value="submit for email">
	</form>

	<form action="mobile" method="get">
		<h1>${mobile}</h1>
		<input type="submit" value="submit for mobile number">
	</form>

	<form action="adhaar" method="get">
		<h1>${adhaar}</h1>
		<input type="submit" value="submit for adhaar">
	</form>

	<form action="age" method="get">
		<h1>${age}</h1>
		<input type="submit" value="submit for age">
	</form>

	<form action="DOB" method="get">
		<h1>${dateOFBirth}</h1>
		<input type="submit" value="submit for DOB">
	</form>


	<form action="desiredSalary" method="get">
		<h1>${desiredSalary}</h1>
		<input type="submit" value="submit for desiredSalary">
	</form>


	<form action="bestFriends" method="get">
		<h5>printing best friends list</h5>

		<input type="submit" value="submit for bestfriends">
		<c:forEach items="${bestfriends}" var="friend">
			<ul>
				<li>${friend}</li>
			</ul>
		</c:forEach>
	</form>

	<form action="mostVisitedPlace" method="get">
		<h5>printing MostVisitedPlace list</h5>

		<input type="submit" value="submit for MostVisitedPlace">
		<c:forEach items="${mostVisitedPlace}" var="place">
			<ul>
				<li>${place}</li>
			</ul>
		</c:forEach>
	</form>

	<form action="skillSet" method="get">
		<h5>printing skillSet list</h5>

		<input type="submit" value="submit for skillSet">
		<c:forEach items="${skillSet}" var="skill">
			<ul>
				<li>${skill}</li>
			</ul>
		</c:forEach>
	</form>


	<form action="educationDTO" method="get">
	<h5>printing education details</h5>
			<input type="submit" value="submit for educationDTO">
	
		<ul>
			<li>qualification : ${education.qualification}</li>
			<li>degreeCollege : ${education.degreeCollege}</li>
			<li>pucCollege : ${education.pucCollege}</li>
			<li>sslcSchool : ${education.sslcSchool}</li>
			<li>degreePercentage : ${education.degreePercentage}</li>
			<li>pucPercentage : ${education.pucPercentage}</li>
			<li>sslcPercentage : ${education.sslcPercentage}</li>
			<li>degreeBranch : ${education.degreeBranch}</li>
			<li>clgCity : ${education.clgCity}</li>
			<li>haveBacklogs : ${education.haveBacklogs}</li>
		</ul>

	</form>
	
	
	<form action="familyDTO" method="get">
	<h5>printing family details</h5>
			<input type="submit" value="submit for familyDTO">
	
		<ul>
			<li>fatherName : ${family.fatherName}</li>
			<li>fathersJob : ${family.fathersJob}</li>
			<li>brotherName : ${family.brotherName}</li>
			<li>familyCity : ${family.familyCity}</li>
			<li>fathersIncome : ${family.fathersIncome}</li>
			<li>fathersWt : ${family.fathersWt}</li>
			<li>cityDistance : ${family.cityDistance}</li>
			<li>fathersBike : ${family.fathersBike}</li>
			<li>fathersCar : ${family.fathersCar}</li>
			<li>mobileNumber : ${family.mobileNumber}</li>
		</ul>

	</form>
	
	<form action="mobile" method="get">
	<h5>printing family details</h5>
			<input type="submit" value="submit for familyDTO">
	
		<ul>
			<li>fatherName : ${family.fatherName}</li>
			<li>fathersJob : ${family.fathersJob}</li>
			<li>brotherName : ${family.brotherName}</li>
			<li>familyCity : ${family.familyCity}</li>
			<li>fathersIncome : ${family.fathersIncome}</li>
		</ul>

	</form>


</body>
</html>