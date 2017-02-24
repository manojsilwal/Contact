<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="resources/register/js/contact.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<form name="form" id="userFrom">
	
		<input type="text" id="firstName" name="firstName" placeholder="firstName" />
		<input type="text" name="lastName" placeholder="lastName" id="lastName"/>
		<input type="email" name="email" placeholder="email" id="email"/>
		<input type="number" name="phone" placeholder="phone" id="phone"/>
		
		<input type="button" value="submit" onclick="userFormSubmit();"/>
	</form>
	
	<div id="result">
		<div id="errors"></div>
		<div id="success"></div>
	</div>
	
</body>
</html>