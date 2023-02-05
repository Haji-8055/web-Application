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

<style type="text/css">
.form-check {

margin-left: 50px;
}
.option{

margin-left: 40px

}

</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand"> <img
				src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png"
				alt="Bootstrap" width="120" height="60"></a>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>

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

	<form action="swim" method="post">

		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">beach name</span> <input
				type="text" class="form-control" placeholder="beach name"
				aria-label="Username" aria-describedby="basic-addon1" name="beachName">
		</div>
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">location</span> <input
				type="text" class="form-control" placeholder="location"
				aria-label="Username" aria-describedby="basic-addon1" name="location">
		</div>


		

          <span class="option">is clean ?</span>
		<div class="form-check">
			 <input class="form-check-input" type="radio" name="isClean"
				id="flexRadioDefault1" value="true"> <label class="form-check-label"
				for="flexRadioDefault1"> Yes </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="isClean"
				id="flexRadioDefault2" value="false" > <label
				class="form-check-label" for="flexRadioDefault2"> No </label>
		</div>
		
		<span class="option">games available ?</span>
		<div class="form-check">
			 <input class="form-check-input" type="radio" name="games"
				id="flexRadioDefault1" value="available"> <label class="form-check-label"
				for="flexRadioDefault1"> available </label>
		</div>
		<div class="form-check">
			<input class="form-check-input" type="radio" name="games"
				id="flexRadioDefault2" value="not available" > <label
				class="form-check-label" for="flexRadioDefault2"> not available </label>
		</div>

		<input type="submit" value="submit">

	</form>




</body>
</html>