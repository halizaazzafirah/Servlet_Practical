<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center><h1>New Student? Sign up below!</h1></center>
<form action="NewStudentForm" method="GET">
	<p>Student ID: <input type="text" name="id" /></p>
	<p>Password  : <input type="password" name="password" /></p>
	<p>Name      : <input type="text" name="name" /></p>
	<p>Department: <input type="text" name="department" ></p>
	<p><input type ="submit" value ="Sign Up" /> </p>
</form>

</body>
</html>