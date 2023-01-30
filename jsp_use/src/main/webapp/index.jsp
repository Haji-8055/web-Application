<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="display" method="post">
		<pre>
firstName <input type="text" name="fName">
lastName <input type="text" name="lName">
gender <input type="radio" name="gender" value="male">male
	   <input type="radio" name="gender" value="female">female
	   
	   
reason <textarea rows="5" cols="20" name="reason"></textarea>
address <textarea rows="5" cols="20" name="address"></textarea>

<input type="submit" value="send">
 

</pre>


	</form>

</body>
</html>