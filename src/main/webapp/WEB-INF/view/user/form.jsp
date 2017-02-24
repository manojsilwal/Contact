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
			  <label class="col-md-4 control-label" for="dob"> Date of Birth :</label>
			  <div class="col-md-4">
			    <input id="dob" name="dob" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<div class="form-group">
			  <label class="col-md-4 control-label" for="phone number"> Phone Number :</label>
			  <div class="col-md-4">
			    <input id="phoneNumber" name="phoneNumber" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			</div>
			
			<!-- Multiple Radios -->
			<div class="form-group">
			  <label class="col-md-4 control-label" for="radios">Multiple Radios</label>
			  <div class="col-md-4">
				<div class="radio">
				    <label for="radios-0">
				      <input name="profile.gender" id="radios-0" value="0" checked="checked" type="radio">
				      Male
				    </label>
				</div>
				<div class="radio">
				    <label for="radios-1">
				      <input name="profile.gender" id="radios-1" value="1" type="radio">
				      Female
				    </label>
				</div>
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group" name="profile.location">
			
			  <label class="col-md-4 control-label" for="textinput">Street</label>  
			  <div class="col-md-4">
			  	<input id="addressUpdate" name="street" placeholder="placeholder" class="form-control input-md" type="text" > 
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">City</label>  
			  <div class="col-md-4">
			  	<input id="cityUpdate" name="city" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">State</label>  
			  <div class="col-md-4">
			  	<input id="stateUpdate" name="state" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">Country</label>  
			  <div class="col-md-4">
			  	<input id="countryUpdate" name="country" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			  <label class="col-md-4 control-label" for="textinput">Zip Code</label>  
			  <div class="col-md-4">
			  	<input id="postalCodeUpdate" name="zipCode" placeholder="placeholder" class="form-control input-md" type="text" >
			  </div>
			  
			</div>

			
	</fieldset>
	</div>
	<div class="col-md-4">
		 <button type="submit" class="btn btn-danger pull-left" id="submitUser" onClick="addUser();return false;">Add</button>
	 
	 	<button type="submit" class="btn btn-info pull-left" data-dismiss="modal">Cancel</button>
	</div>
</form>