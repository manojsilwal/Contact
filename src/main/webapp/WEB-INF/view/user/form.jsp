<form id="userForm" class="form-horizontal">
       <div class="modal-body">        
      		<div class="col-md-12">
				<fieldset>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">First Name :</label>  
					  <div class="col-md-4">
					  <input id="firstName" name="firstName" placeholder="placeholder" class="form-control input-md" type="text" >
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">Last Name :</label>  
					  <div class="col-md-4">
					  <input id="lastName" name="lastName" placeholder="placeholder" class="form-control input-md" type="text" >
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">Email :</label>  
					  <div class="col-md-4">
					  <input id="email" name="email" placeholder="placeholder" class="form-control input-md" type="text" >
					  </div>
					</div>
					
					<!-- Password input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="password">Password :</label>
					  <div class="col-md-4">
					    <input id="password" name="password" placeholder="placeholder" class="form-control input-md" type="password" >
					  </div>
					</div>
					
					<div class="form-group">
					  <label class="col-md-4 control-label" for="password confirm"> Confirm Password :</label>
					  <div class="col-md-4">
					    <input id="passwordUpdate" name="password" placeholder="placeholder" class="form-control input-md" type="password" >
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">Street</label>  
					  <div class="col-md-4">
					  <input id="addressUpdate" name="location.address" placeholder="placeholder" class="form-control input-md" type="text" readonly> 
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">City</label>  
					  <div class="col-md-4">
					  <input id="cityUpdate" name="location.city" placeholder="placeholder" class="form-control input-md" type="text" readonly>
					 
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">State</label>  
					  <div class="col-md-4">
					  <input id="stateUpdate" name="location.state" placeholder="placeholder" class="form-control input-md" type="text" readonly>
					  
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">Country</label>  
					  <div class="col-md-4">
					  <input id="countryUpdate" name="location.country" placeholder="placeholder" class="form-control input-md" type="text" readonly>
					  
					  </div>
					</div>
					
					<!-- Text input-->
					<div class="form-group">
					  <label class="col-md-4 control-label" for="textinput">Zip Code</label>  
					  <div class="col-md-4">
					  <input id="postalCodeUpdate" name="location.postalCode" placeholder="placeholder" class="form-control input-md" type="text" readonly>
					 
					  </div>
					</div>

					
				</fieldset>
			</div>
       </div>
       	<div class="modal-footer">
       		<div class="col-md-4">
       			 <button type="submit" class="btn btn-danger pull-left" id="submitUser" onClick="userAdd();return false;">Add</button>
	         
	         	<button type="submit" class="btn btn-info pull-left" data-dismiss="modal">Cancel</button>
       		</div>
	        
	     </div>
</form>