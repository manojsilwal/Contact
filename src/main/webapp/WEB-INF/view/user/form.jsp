<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript" src="resources/register/js/contact.js"></script>
<script type="text/javascript" src="resources/register/js/fileUpload.js"></script>
</head>
<body>

<form id="userForm" class="form-horizontal">    
	<div class="col-md-12">
		<fieldset>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textinput">First Name :</label>  
			  <div class="col-md-4">
			  <input id="firstName" name="profile.firstName" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textinput">Last Name :</label>  
			  <div class="col-md-4">
			  <input id="lastName" name="profile.lastName" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="textinput">Email :</label>  
			  <div class="col-md-4">
			  <input id="email" name="profile.email" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<!-- Password input-->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="password">Password :</label>
			  <div class="col-md-4">
			    <input id="password" name="profile.password" placeholder="placeholder" class="form-control input-md" type="password" >
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="password confirm"> Confirm Password :</label>
			  <div class="col-md-4">
			    <input id="passwordUpdate" name="password" placeholder="placeholder" class="form-control input-md" type="password" >
			  </div>
			</div>
			<div class="form-group">
			 <div class="col-md-4">
               <input type="file" name="image" id="file" class="form-control input-md"  onchange="fileUpload();"/>
             </div>
             </div>
			<div class="form-group">
			  <label class="col-md-4 control-label" for="dob"> Date of Birth :</label>
			  <div class="col-md-4">
			    <input id="dob" name="dob" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="phone number"> Phone Number :</label>
			  <div class="col-md-4">
			    <input id="phone" name="phoneNumber" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<!-- Multiple Radios -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="radios">Multiple Radios</label>
			  <div class="col-md-4">
				<div class="radio">
				    <label for="radios-0">
				      <input name="gender" id="radios-0" value="0" checked="checked" type="radio">
				      Male
				    </label>
				</div>
				<div class="radio">
				    <label for="radios-1">
				      <input name="gender" id="radios-1" value="1" type="radio">
				      Female
				    </label>
				</div>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group" name="profile.location">
			
			  <label class="col-md-4 control-label" for="textinput">Street</label>  
			  <div class="col-md-4">
			  	<input id="street" name="street" placeholder="placeholder" class="form-control input-md" type="text" > 
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">City</label>  
			  <div class="col-md-4">
			  	<input id="city" name="city" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">State</label>  
			  <div class="col-md-4">
			  	<input id="state" name="state" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">Country</label>  
			  <div class="col-md-4">
			  	<input id="country" name="country" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">Zip Code</label>  
			  <div class="col-md-4">
			  	<input id="zipCode" name="zipCode" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			</div>

			
	</fieldset>
	</div>
	<div class="col-md-4">
		 <button type="button" class="btn btn-danger pull-left" id="submitUser" onclick="userFormSubmit();">Add</button>
	 
	 	<button type="button" class="btn btn-info pull-left" data-dismiss="modal">Cancel</button>
	</div>
</form>

<div id="userList">
		<button onclick="getUsers();">getUsers</button>
	</div>
</body>


<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/register/js/contact.js"></script>
<script type="text/javascript" src="resources/register/js/fileUpload.js"></script>
</body>
</html>