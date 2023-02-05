<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body {
	background: black;
}

h2 {
	color: blue;
}

a {
	margin: 50px;
}
</style>
</head>
<body>
	<h1 style="color: green">beach details success</h1>

	<h2>beachName : ${beachName}</h2>
	<h2>location : ${location}</h2>
	<h2>isClean : ${isClean}</h2>
	<h2>games : ${games}</h2>

	<a href="index.jsp"> home</a>
	<a href="Beach.jsp">Beach page</a>

</body>
</html>