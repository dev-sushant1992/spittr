<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" session="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spittr</title>
<link rel="stylesheet" 
	type="text/css"
	href='<c:url value="/resources/style.css"/>'>
</head>
<body>
	<h1>Register</h1>
	<form method="post">
		First Name : <input type="text" name="firstName"/><br/>
		Last Name : <input type="text" name="lastName"/><br/>
		Username : <input type="text" name="username"/><br/>
		Password : <input type="text" name="password"/><br/>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>