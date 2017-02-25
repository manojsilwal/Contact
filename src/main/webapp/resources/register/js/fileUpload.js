/*function fileUpload(){
	var formData = new FormData();
	var file = $('#file')[0].files[0];
    formData.append('file', file);
    console.log(file);
   console.log(new FormData(document.getElementById("#file")));
   //	console.log(dataToSend);
*/   
    
var isJpg = function(name) {
    return name.match(/jpg$/i)
};
    
var isPng = function(name) {
    return name.match(/png$/i)
};
function fileUpload() { 
    	   var fd = new FormData();
    	   
    	   fd.append( 'file', $('#file').prop("files")[0] );
    	   console.log($('#file').prop("files")[0] );

    	   $.ajax({
    	     url: '/Contact/saveFile',
    	     data: fd,
    	     processData: false,
    	     contentType: false,
    	     type: 'POST',
    	     success: function(data){
    	       alert(data);
    	     }
    	   })
}

/*}*/

