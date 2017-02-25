
function userFormSubmit(){
   	var dataToSend = JSON.stringify(createObject());
   	console.log(dataToSend);
   	 $.ajax({
		type: 'POST',
		url: 'user',
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(data){
			
			$('#errors').html("");
 			$("#result").append( '<H3 align="center"> OKAY!! <H3>');                
	 	    $('#result').show();
		},
 
		error: function(errorObject ){	
//			error: function(jqXHR,  textStatus,  HTTPStatus ){	
// jqXHR = jQuery XMLHttpRequest superset of  XMLHttpRequest
//	EXAMPLE values:		error: function(jQuery XMLHttpRequest,  "error",  "Bad Request" ){	
// 	see http://api.jquery.com/jquery.ajax/
			console.log(errorObject);
			if (errorObject.responseJSON.errorType == "ValidationError") {
	 			$('#success').html("");
	 			$('#errors').html("");
	 			$("#errors").append( '<H3 align="center"> Error(s)!! <H3>');                
	  			    $("#result").append( '<p>');
	  	
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#errors").append( error.message + '<br>');
			    	});
	 	 	        $("#errors").append( '</p>');
	 	 	        $('#result').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}


// Translate form to array
// Then put in JSON format
 function createObject (){
	 var firstName = document.getElementById('firstName').value;
	 var lastName = document.getElementById('lastName').value;
	 var email = document.getElementById('email').value;
	 var phone = document.getElementById('phone').value;
	 //var file = document.getElementById('file').value;
	 
	// console.log(file);
	 
    var jsonObject = {
    		"profile" : {
				"email":email,
				"firstName":firstName,
				"lastName":lastName,
				"gender":null,
				"dob":null,
				"phone":phone,
				"location":null
    		},
    		"posts":null
    };
    
    return jsonObject;

};


function updateUser(id){
		//get user with id
		var user = getUser(id);
		document.getElementById('idUpdate').value = id;
		document.getElementById('fnameUpdate').value = user.profile.firstName;
		document.getElementById('lnameUpdate').value = user.profile.lastName;
		document.getElementById('emailUpdate').value = user.profile.email;
		document.getElementById('addressUpdate').value = user.profile.location.address;
		document.getElementById('cityUpdate').value = user.profile.location.city;
		document.getElementById('stateUpdate').value = user.profile.location.state;
		document.getElementById('countryUpdate').value = user.profile.location.country;
}


//display users

function getUser(id) {
	
	$.ajax({
		url: '/Contact/user',
 		type: 'GET',
 		async:false,
		dataType: "json",
		data:'id=' + id,
	 	 success: function (user) {
	 		console.log(user);
	 		
	 	 },
			error: function(data){
		 	 } 
   });
}

function getUsers() {
	
	$.ajax({
		url: '/Contact/users',
 		type: 'GET',
 		async:false,
		dataType: "json",
	 	 success: function (users) {
	 		console.log(users);
	 		
	 	 },
			error: function(data){
		 	 } 
   });
}


