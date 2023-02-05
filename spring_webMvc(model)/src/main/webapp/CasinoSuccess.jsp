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
	<h1 style="color: green">casino details success</h1>

	<h2>casinoName : ${casinoName}</h2>
	<h2>cruise : ${cruise}</h2>
	<h2>entryFee : ${entryFee}</h2>
	<h2>freeFood : ${freeFood}</h2>
	<h2>freeAlcohol : ${freeAlcohol}</h2>

	<a href="index.jsp"> home</a>
	<a href="Casino.jsp">casino page</a>

</body>
</html>