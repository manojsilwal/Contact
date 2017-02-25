<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="resources/register/js/fileUpload.js"></script>
</head>
<body>
<h1>SpringMVC - File Upload with/without Ajax</h1> 
 
<!--  Form 1 -->
<!--  Form 2 -->
<i>Uploading File With Ajax</i><br/>
<form id="form2" method="post" action="/Contact/saveFile" enctype="multipart/form-data">
  <!-- File input -->    
  <input name="file2" id="file2" type="file" /><br/>
</form>
 
<button value="Submit" onclick="uploadJqueryForm()" >Upload</button><i>Using JQuery Form Plugin</i><br/>
<button value="Submit" onclick="uploadFormData()" >Upload</button><i>Using FormData Object</i>
 
<div id="result"></div>
</body>
</html>