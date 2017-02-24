function addUser(){
   	var dataToSend = JSON.stringify(serializeObject($('#categoryForm')));
   	 $.ajax({
		type: 'POST',
		url:'/Contact/user',
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(){
			alert("Sucess");
		},
 
		error: function(errorObject ){	
			alert("Error");
			if (errorObject.responseJSON.errorType == "validationError") {
	 			$('#result').html("");
	 			$('#result').html("");
	  			    var errorList = errorObject.responseJSON.errors;
	 	 	        $.each(errorList,  function(i,error) {			   
	 		    		$("#result").append( error.message + '<br>');
			    	});
	 	 	        $("#result").append( '</p>');
	 	 	        $('#result').show();
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
 		}
	});
}


function serializeObject (form)
{
	 
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;
    
}