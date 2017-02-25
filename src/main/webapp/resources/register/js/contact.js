	// pathname is contextRoot/path/path/ so we want to get [1] 
    // that is where contextRoot is
	// [0] has "" as a result of split 
	var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function userFormSubmit(){
   	var dataToSend = createObject();
   //	console.log(dataToSend);
   	 $.ajax({
		type: 'POST',
		url: contextRoot + '/user',
		dataType: false,           // Accept header
 		data:dataToSend,
 		enctype: 'multipart/form-data',
 		contentType: false,   // Sends - Content-type
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

function collectFormData(fields) {
    var formData = new FormData();

    for (var i = 0; i < fields.length; i++) {
        var $item = $(fields[i]);

        if ($item.attr('type') =="file"){
            var file = $('input[type=file]')[0].files[0];
            formData.append( $item.attr('name') , file);

        } else {
            formData.append( $item.attr('name') , $item.val());
        }
    }
    return formData;
}

// Translate form to array
// Then put in JSON format
 function createObject (){
	 var data = new FormData();
	 $.each($('#file')[0].files, function(i, file) {
	     data.append('file-'+i, file);
	     console.log(file);
	 });
	 console.log(data);
	 
	/* var firstName = document.getElementById('firstName').value;
	 var lastName = document.getElementById('lastName').value;
	 var email = document.getElementById('email').value;
	 var phone = document.getElementById('phone').value;
	 var file = document.getElementById('file').value;
	 
	 console.log(file);
	 
    var jsonObject = {
    		"profile" : {
				"email":email,
				"firstName":firstName,
				"lastName":lastName,
				"gender":null,
				"dob":null,
				"phone":phone
    		},
    		"image":file,
    		"post" : null
    };
    */
    return data;

};


