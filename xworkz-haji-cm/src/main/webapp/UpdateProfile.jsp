<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


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
						aria-current="page" href="#"></a>about</li>
						

				</ul>


			</div>
		</div>
	</nav>

	
		<h3 style="color: green">${updateSuccess }</h3>


	

	<div class="col-sm-3" style="margin: 80px 550px">
	
	<form action="updateProfile" method="post" enctype="multipart/form-data" class="bg-info container pt-9 border border-5 border border-dark">

email<input class="form-control form-control-lg" type="email" name="email" id="mail" onchange="onEmail()" value="${dto.email}" readonly="readonly"/> <span
			id="mailError" style="color: red"></span><br> 
			
		userId<input class="form-control form-control-lg " type="text" id="Id"
			name="userId" onblur="onUser()" > <span
			id="nameError" style="color: red"></span> <br>
			
			
			
			mobileNumber<input class="form-control form-control-lg" type="number" name="mobileNumber" id="contact" onchange="onContact()" /> 
			<span id="contactError" style="color: red"></span><br> 
			
			upload your image<input type="file" name="image"/> <br>	
			<span style="color: red">${message}</span>
			
			
		 <br> <input type="submit" id="submitId" disabled="disabled" class="btn btn-dark btn-lg"/>


	 		</form>
		</div>




	<script>


		
		function onUser() {
			console.log("running onUser")
			var userInput = document.getElementById('Id');
			var userValue = userInput.value;
			console.log(userValue);
			if (userValue != null && userValue != "" && userValue.length > 3
					&& userValue.length < 30) {
				
				console.log('valid user');
				document.getElementById('nameError').innerHTML = '';
				
					document.getElementById('submitId').disabled = false;
				

				const xhttp = new XMLHttpRequest();
				console.log('running in ajax');
				xhttp.open("GET",
						"http://localhost:8080/xworkz-haji-cm/uniqueUser/"
								+ userValue);
				xhttp.send();

				xhttp.onload = function() {

					console.log(this);
					document.getElementById('nameError').innerHTML = this.responseText
					var resp = this.responseText

					if (resp != "") {
							document.getElementById('submitId').disabled = 'disabled';
					}
				}
			}

			else {
				console.log('invalid user');
				document.getElementById('submitId').disabled = 'disabled';

				document.getElementById('nameError').innerHTML = 'Invalid userId, please enter min 3 and max 30';
			}
		}

		

		function onContact() {
			console.log("running onContact")
			var mobileValue = document.getElementById('contact').value

			if (mobileValue.length > 5 && mobileValue.length < 11) {
				console.log('valid number')
				document.getElementById('contactError').innerHTML = '';
					document.getElementById('submitId').disabled = false;
				

				const xhttp = new XMLHttpRequest();
				console.log('running in ajax');
				xhttp.open("GET",
						"http://localhost:8080/xworkz-haji-cm/uniqueNumber/"
								+ mobileValue);
				xhttp.send();

				xhttp.onload = function() {

					console.log(this);
					document.getElementById('contactError').innerHTML = this.responseText

					var resp = this.responseText

					if (resp != "") {
							document.getElementById('submitId').disabled = 'disabled';
						
					}

				}

			}

			else {
				console.log('invalid number')
				document.getElementById('submitId').disabled = 'disabled';
				document.getElementById('contactError').innerHTML = 'invalid number , please enter min 6 and max 10'
			}
		}

		
		
		
		
		
		
				
		
	</script>
</body>
</html>