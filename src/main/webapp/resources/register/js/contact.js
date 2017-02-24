function userFormSubmit(){
   	var dataToSend = JSON.stringify(createObject());
   //	console.log(dataToSend);
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/user',
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
	 
	 console.log(firstName);
	 
    var jsonObject = {
    		"profile" : {
				"email":email,
				"firstName":firstName,
				"lastName":lastName,
				"gender":null,
				"dob":null,
				"phone":phone
    		},
    		"post" : null
    };
    
    return jsonObject;

};


