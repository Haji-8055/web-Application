<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

h4{

color: blue;

}

h1{
color: green

}

</style>


</head>
<body>

<h1> displaying fav persons details</h1>

<h4> name : ${firstName}</h4>
<h4> lastName : ${lastName}</h4>
<h4> gender : ${gender}</h4>
<h4> reason : ${reason}</h4>
<h4> address : ${address}</h4>

<a href="index.jsp">send another person details</a>

</body>
</html>