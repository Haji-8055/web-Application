<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2 style="color: green;"> bakery data saved </h2>
<h2>details</h2>

<ul>
<li>bakeryName : ${bakery.bakeryName} </li>
<li>bakeryOwner : ${bakery.bakeryOwner} </li>
<li>ownerWife : ${bakery.ownerWife} </li>
<li>isMarried : ${bakery.isMarried} </li>
<li>bakeryfamousFor : ${bakery.bakeryfamousFor} </li>
<li>bakerySince : ${bakery.bakerySince} </li>

</ul>

<a href="index.jsp">home page </a>or send again <a href="Bakery.jsp">bakery form</a>

</body>
</html>