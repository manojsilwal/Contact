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
$(document).ready(function() {
$('#btnUpload').on('click', function() {
	var file = $('[name="file"]');
       var filename = $.trim(file.val());
       
       if (!(isJpg(filename) || isPng(filename))) {
           alert('Please browse a JPG/PNG file to upload ...');
           return;
       }
       
       console.log(new FormData(document.getElementById("fileForm")));
       
       $.ajax({
           url: 'saveFile',
           type: "POST",
           data: new FormData(document.getElementById("fileForm")),
           enctype: 'multipart/form-data',
           processData: false,
           contentType: false
         }).done(function(data) {
             imgContainer.html('');
             var img = '<img src="data:' + data.contenttype + ';base64,'
                 + data.base64 + '"/>';
   
             imgContainer.append(img);
         }).fail(function(jqXHR, textStatus) {
             //alert(jqXHR.responseText);
             alert('File upload failed ...');
         });
       
   });
});
/*}*/

