/**
 * 
 */
$(document).ready(function() {
	// 폼 제출 이벤트를 캐치합니다.
	$('#login-f').submit(function(event) {
		// 기본 제출 이벤트를 중지합니다.
		event.preventDefault();

		// serialize() 함수를 사용하여 폼 데이터를 JSON으로 변환합니다.
		var formData = $(this).serialize();

		// AJAX를 사용하여 JSON 데이터를 컨트롤러에 전송합니다.
		$.ajax({
			type: 'POST',
			url: '/ajaxLogin',
			data: formData,
			dataType: 'json',
			success: function(response) {
				// 컨트롤러에서 전달된 데이터를 처리합니다.
			},
			error: function(xhr, status, error) {
				// 오류가 발생한 경우 오류를 처리합니다.
			}
		});
	});
});