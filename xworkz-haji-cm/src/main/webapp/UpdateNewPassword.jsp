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
	<h3 style="color: blue">${userId}</h3>
	
	
	<div class="col-sm-3" style="margin: 80px 550px">
	<form action="updatePassword?userId=${userId}" method="post" class=" container pt-9 border border-5 border border-dark">
	
	new password<input class="form-control form-control-lg" type="password"  id="secure" onchange="onPassword()" />
			
	confirm new password<input class="form-control form-control-lg" type="password" name="password" id="pass" onchange="onPassword()" />
						<span id="passwordError" style="color: red"></span> <br>
			
			
			<input type="submit" id="submitId" value="update" disabled="disabled" class="btn btn-dark btn-lg"/>	
	</form>
	
	<h2 style="color: blue">please set your new passwrod</h2>
	<br>
	
	</div>
	<span style="color: red" id="passwordError"> </span>
	
		<h3 style="color: red">${error}</h3>
	
	
	<script>
	
	
	function onPassword() {
		console.log("running onUser")
		var pInput = document.getElementById('secure');
		var pValue = pInput.value;
		var cInput = document.getElementById('pass')
		var cValue = cInput.value;
		console.log(pValue);
		console.log(cValue);
		if (pValue.length > 3 && pValue.length < 30) {

			console.log('valid password');
			
				document.getElementById('submitId').disabled = false;
			
			document.getElementById('passwordError').innerHTML = '';

			

			if (cValue != pValue) {
				document.getElementById('passwordError').innerHTML = 'Invalid password,new password and confirm password is not same ';
				document.getElementById('submitId').disabled = 'disabled';

			}
		}

		else {
			console.log('invalid password');
			document.getElementById('submitId').disabled = 'disabled';

			document.getElementById('passwordError').innerHTML = 'Invalid password  please enter min 3 and max 30';
		}

	}
	
	</script>
	




</body>
</html>