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
				alt="" width="80" height="30">
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
						aria-current="page" href="index.jsp">Home</a></li>

				</ul>


			</div>
		</div>
	</nav>

	<h3 style="color: red">
		<c:forEach items="${violations}" var="v">
			<p>${v.message}</p>
		</c:forEach>

	</h3>
	
	<h1 style="color: green;">${successMessage}</h1>

	<h1 style="color: red">${uniqueError}</h1>

	
<form action="save" method="post">

userId<input class="form-control form-control-lg" type="text" id="Id" name="userId" onchange="onUser()" value="${dto.userId}">
<span id="nameError" style="color: red"></span>
<span id="uniqueUser" style="color: red"></span><br>

email<input class="form-control form-control-lg" type="email" name="email" id="mail" onchange="onEmail()" value="${dto.email}"/>
<span id="mailError" style="color: red"></span><br>
<span id="uniqueMail" style="color: red"></span><br>

mobileNumber<input class="form-control form-control-lg" type="number"  name="mobileNumber" id="contact" onchange="onContact()" value="${dto.mobileNumber}"/> 
<span id="contactError" style="color: red"></span><br>
<span id="uniqueMobile" style="color: red"></span><br>

password<input class="form-control form-control-lg" type="password"  name="password" id="secure"  onchange="onPassword()"  value="${dto.password}"/>

Confirmpassword<input class="form-control form-control-lg" type="password"  name="ConfirmPassword" id="pass" onchange="onPassword()" value="${dto.password}"/>
<span id="passwordError" style="color: red"></span><br>




<input type="checkbox" id="agreement" onclick="onAgreement()">Accept Agreement
<br>
<input type="submit" id="submitId" disabled="true"/>


</form>


<script>

function onUser() {
	console.log("running onUser")
	var userInput=document.getElementById('Id');
	var userValue=userInput.value;
	console.log(userValue);
	if(userValue!=null && userValue!="" && userValue.length>3 && userValue.length<30)
		{
		const xhttp=new XMLHttpRequest();
		console.log('running in ajax');
		xhttp.open("GET","http://localhost:8082/Final_project/uniqueUser/"+userValue);
		xhttp.send();
		
		xhttp.onload=function(){
			
			console.log(this);
			document.getElementById('uniqueUser').innerHTML=this.responseText
		}
		
		console.log('valid user');
		var agreement=document.getElementById('agreement');
		if(agreement.checked){
			document.getElementById('submitId').disabled=false;
		}
		document.getElementById('nameError').innerHTML='';
		}
	
	else{
		console.log('invalid user');
		document.getElementById('submitId').disabled='disabled';
	
	document.getElementById('nameError').innerHTML='Invalid userId, please enter min 3 and max 30';
	}
	
}

function onPassword() {
	console.log("running onUser")
	var pInput=document.getElementById('secure'); 
	var pValue=pInput.value;
	var cInput=document.getElementById('pass')
	var cValue=cInput.value;
	console.log(pValue);
	console.log(cValue);
	if( cValue==pValue && pValue.length>3 && pValue.length<30)
		{
		
		console.log('valid password');
		var agrement=document.getElementById('agreement');
		if(agrement.checked){
			document.getElementById('submitId').disabled=false;
		}
		document.getElementById('passwordError').innerHTML='';
		}
	
	else{
		console.log('invalid password');
		document.getElementById('submitId').disabled='disabled';
	
	document.getElementById('passwordError').innerHTML='Invalid password,please confirm the entered password, please enter min 3 and max 30';
	}
	
	
	
	
}

function onEmail() {
	console.log("running onEmail")
	var mailsInput=document.getElementById('mail')
	var mailsValue=mailsInput.value
	console.log(mailsValue)
	if(mailsValue!=null && mailsValue!="" && mailsValue.length>3 && mailsValue.length<30){
		console.log('valid email');
		var agreements=document.getElementById('agreement');
		if(agreements.checked){
			document.getElementById('submitId').disabled=false;
		}
		
		document.getElementById('mailError').innerHTML='';
		
	}
	
	else{
		console.log('invalid email');
		document.getElementById('submitId').disabled='disabled';
		document.getElementById('mailError').innerHTML='Invalid email, please enter min 5 and max 40'
	}
}

function onContact() {
	console.log("running onContact")
	var mobileInput=document.getElementId('contact')
	var mobileValue=mobileInput.value
	console.log(mobileValue);
	if(mobileValue.length>5 && mobileValue.length<11 && mobileValue!=""){
		console.log('valid number')
		var agreements=document.getElementById('agreement');
		if(agreements.checked){
			document.getElementById('submitId').disabled=false;
		}
		document.getElementById('contactError').innerHTML='';
	}
	
	else{
		console.log('invalid number')
		document.getElementById('submitId').disabled='disabled';
		document.getElementById('contactError').innerHTML='invalid number , please enter min 5 and max 11'
	}
	
	
}


</script>
</body>
</html>