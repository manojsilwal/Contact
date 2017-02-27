function postSubmit(){
	console.log("inside postsubmit");
   	var dataToSend = JSON.stringify(createObject());
   	console.log(dataToSend);
   	//alert("postSub"+dataTosend);
   //	console.log(dataToSend);
   	 $.ajax({
		type: 'POST',
		url: 'post',
		dataType: "json",           // Accept header
 		data:dataToSend,
 		contentType: 'application/json',   // Sends - Content-type
		success: function(data){
			alert("sucess");
			$('#errors').html("");
 			$("#result").append( '<H3 align="center"> OKAY!! <H3>');                
	 	    $('#result').show();
		},
 
		error: function(errorObject ){	
			alert("error");
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
function postList(){
	alert("postList");
	$.ajax({
		type:'GET',
		url:'posts',
		async:false,
		dataType: "json",
		data:'',
		success: function (posts) {
			$.each(posts,  function(i,post) {
				console.log(post);
				var userImg= post.user.imageUrl;
				var userName=post.user.profile.firstName+" "+post.user.profile.lastName;
				var title=post.title;
				var postImg= "";
				var comments="";
				console.log(userName);
				if(post.imageUrl!=null){
					postImg='<img src="'+post.imageUrl+'" />';
				}
				if(post.comments.size>0){
					$each(post.comments, function(i,comment){
						comments+='<p>'+comment.content+'</p>';
					});
				}
				alert("post collection");
				$("#postCollection").append( '<div class="panel panel-default"> \
					<div class="panel-heading"><a href="#" class="">View all</a> \
					<img src="'+userImg+'" class="img-circle pull-right">  \
			           	<h4>'+userName+'</h4> \
			           </div> \
			   			<div class="panel-body">  \
			            <div class="clearfix"></div> \
			            <hr>'+title+'<hr>'+postImg+''+comments+'</div></div>\
			            <form class="form-horizontal">\
						<div class="form-group">\
						  <input id="textinput" name="post.comment" type="text" placeholder="Comment..." class="form-control input-md"> \
						 </div>\
						</div>\
						</form>');                
			});
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
function postDelete(id){
   	var dataToSend = createObject();
   //	console.log(dataToSend);
   	 $.ajax({
		type: 'DELETE',
		url: 'user/'+id,
		dataType: false,           // Accept header
 		data:dataToSend,
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


// Translate form to array
// Then put in JSON format
 function createObject (){
	 
	 var title = document.getElementById('postTitle').value;
	 alert("title");
	 console.log(title);
    var jsonObject = {
    		"title": title,
    		"date": null,
    		"user": null,
    		"comments":null
    };
    //alert(jsonObject+"create");
    return jsonObject;

};