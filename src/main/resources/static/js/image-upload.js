import *  as View from "./view.js";
//=================ajax rendering=====================
/*$('#init-page').click(function(e){
	console.log(e.target);
	View.render("#image-upload-form",{},"#image-content");
	e.preventDefault();
});*/

//$('#init-page').trigger('click');
//====================================================

$('#upload').change(function(){
	let input = this;
	if (input.files && input.files[0]) {
		let reader = new FileReader();
		reader.onload = function(e) {
			$('#preview')
				.attr('src', e.target.result);
		};
		reader.readAsDataURL(input.files[0]);
	}
});
//이미지 여러개
$('#upload-btn').click(function() {
	let formData = new FormData();
	let files = $('input[name="images"]').get(0).files;
	if (files.length > 0) {
		for (let i = 0; i < files.length; i++) {
			formData.append("images", files[i]);
		}
		$.ajax({
			url: "image-upload-action",
			type: "POST",
			data: formData,
			async: false,
			processData: false,
			contentType: false,
			success: function(data) {
				alert(data);
				window.location.href="/final-project-team1-ilhajob/dashboard-company-profile"
				//View.render("#image-upload-form",data,"#image-content");
			},
			error: function() {
				alert("이미지 업로드 error");
			}
		});
	} else {
		alert("No images selected.");
	}
});
	

