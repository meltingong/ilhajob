(function($) {
	$('.auto-container').on('click',function(e){
		e.preventDefault();
		console.log(e.target);
		/*$.get(this.href, function(html) {
	    	$(html).appendTo('body').modal({
	    		closeExisting: true,
				fadeDuration: 300,
				fadeDelay: 0.15
	    });
	  });*/
	});
	
	
	/*$(document).on('click', '#log-in', function(e) {
		e.preventDefault();
		let formData = {};
		$.each($('#login-f').serializeArray(), function() {
			formData[this.name] = this.value;
		});
		let jsonData = JSON.stringify(formData);
		// Promise 객체 생성
		let promise = $.ajax({
			type: 'POST',
			url: 'ajaxLogin',
			data: jsonData,
			contentType: 'application/json',
			dataType: 'json'
		});

		// Promise 객체를 사용하여 Ajax 요청 처리
		promise.then(function(response) {
			// 로그인 성공 시 처리
			if (response.success) {
				window.location.href = '/final-project-team1-ilhajob';
			}
			// 로그인 실패 시 처리
			else {
				alert(response.message);
				window.location.href = response.location;
			}
		})
			.fail(function(xhr) {
				// Ajax 요청 실패 시 처리
				let errorMsg = document.createElement('p');
				errorMsg.style.textAlign = 'center';
				errorMsg.style.color = 'red';
				errorMsg.textContent = xhr.responseText;
				let passwordInput = document.getElementById('password-field');
				passwordInput.insertAdjacentElement('afterend', errorMsg);
				if (xhr.status === 5000 || xhr.status === 5300) {
					$('#email').focus();
				} else if (xhr.status === 5301 || xhr.status === 5301) {
					$('#id').focus();
				}
			});
	});*/




})(window.jQuery);