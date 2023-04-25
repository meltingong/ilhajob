import *  as View from "./view.js";
//=================ajax rendering=====================
/*$('#init-page').click(function(e){
	console.log(e.target);
	View.render("#image-upload-form",{},"#image-content");
	e.preventDefault();
});*/

//$('#init-page').trigger('click');
//====================================================

//업로드전 프리뷰 썸네일
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
			},
			error: function() {
				alert("이미지 업로드 error");
			}
		});
	} else {
		alert("No images selected.");
	}
});

//유저 프로필 이미지 업로드
$('#user-profile-upload-btn').click(function() {
	let formData = new FormData();
	let files = $('input[name="images"]').get(0).files;
	if (files.length > 0) {
		for (let i = 0; i < files.length; i++) {
			formData.append("images", files[i]);
		}
		$.ajax({
			url: "user-profile-upload-action",
			type: "POST",
			data: formData,
			async: false,
			processData: false,
			contentType: false,
			success: function(data) {
				alert(data);
				window.location.href="/final-project-team1-ilhajob/candidate-dashboard-profile"
			},
			error: function() {
				alert("이미지 업로드 error");
			}
		});
	} else {
		alert("No images selected.");
	}
});

//블로그 이미지 업로드
$('#board-main-upload-btn').click(function() {
	let formData = new FormData();
	let files = $('input[name="images"]').get(0).files;
	if (files.length > 0) {
		for (let i = 0; i < files.length; i++) {
			formData.append("images", files[i]);
		}
		let blogId = $(this).data('recruit-id');
		$.ajax({
			url: "board-main-upload-action",
			type: "POST",
			data: formData,
			async: false,
			processData: false,
			contentType: false,
			success: function(data) {
				alert(data);
				window.location.href="/final-project-team1-ilhajob/dashboard-company-profile"
			},
			error: function() {
				alert("이미지 업로드 error");
			}
		});
	} else {
		alert("No images selected.");
	}
});







