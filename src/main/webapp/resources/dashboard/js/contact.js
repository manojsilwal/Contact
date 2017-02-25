
function postSubmit(id){
   	var dataToSend = JSON.stringify(serializeObject($('#postForm')));
   	 $.ajax({
		type: 'POST',
		url:'/Contact/post/'+id,
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(){
			location.reload(true); 
		},
 
		error: function(errorObject ){	
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
function categoryRemove(id){
	
	var dataToSend = JSON.stringify(id);
   	 $.ajax({
		type:'DELETE',
		url:'/deals/admin/deleteCategory?'+csrf,
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(){
			location.reload(true);
		},
 
		error: function(errorObject ){
 		}
	});
}



function serializeObject (form){
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};