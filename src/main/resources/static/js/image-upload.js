import *  as View from "./view.js";
//=================ajax rendering=====================
/*$('#init-page').click(function(e){
	console.log(e.target);
	View.render("#image-upload-form",{},"#image-content");
	e.preventDefault();
});*/

//$('#init-page').trigger('click');
//====================================================
var uploadButtonCorp = {
        $button: $('.uploadButton-input-corp'),
        $nameField: $('.uploadButton-file-name-corp')
    };
uploadButtonCorp.$button.on('change', function() {
    _populateFileField($(this));
});

function _populateFileField($button) {
    var selectedFile = [];
    for (var i = 0; i < $button.get(0).files.length; ++i) {
        selectedFile.push($button.get(0).files[i].name + '<br>');
    }
    uploadButtonCorp.$nameField.html(selectedFile);
}

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

$('#corp-image-upload').change(function(){
	let input = this;
	if (input.files && input.files[0]) {
		let reader = new FileReader();
		reader.onload = function(e) {
			$('#corp-image-preview')
				.attr('src', e.target.result);
		};
		reader.readAsDataURL(input.files[0]);
	}
});
//기업 로고 이미지 업로드
$('#corp-logo-upload-btn').click(function() {
	let formData = new FormData();
	let files = $('input[name="images"]').get(0).files;
	if (files.length > 0) {
		for (let i = 0; i < files.length; i++) {
			formData.append("images", files[i]);
		}
		$.ajax({
			url: "corp-logo-upload-action",
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

//기업 이미지 여러장 업로드
$('#corp-logo-upload-btn').click(function() {
	let formData = new FormData();
	let files = $('input[name="corp-images"]').get(0).files;
	if (files.length > 0) {
		for (let i = 0; i < files.length; i++) {
			formData.append("corp-images", files[i]);
		}
		$.ajax({
			url: "corp-image-upload-action",
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

