(function($) {
	$('.call-order-modal').on('click', function(e) {
		e.preventDefault();
		let productId = $(this).data('product-id');
		let productIdJson = JSON.stringify({id: productId});
		console.log(productIdJson);
		let promise = $.ajax({
			type: 'POST',
			url: 'order-popup',
			data: productIdJson,
			contentType: 'application/json',
			dataType: 'json'
		});

		// Promise 객체를 사용하여 Ajax 요청 처리
		promise.then(function(responseData) {
			console.log(responseData);
			let product = responseData.product;
            // HTML 파일 추가
			$(responseData.html).appendTo('body').modal({
				closeExisting: true,
				fadeDuration: 300,
				fadeDelay: 0.15
			});
			$('#order-name').val(responseData.user.userName);
			$('#order-phone').val(responseData.user.userPhone);
			$('#order-email').val(responseData.user.userEmail);
			$('.product-name').text(product.productName);
			$('.product-total').text(product.productPrice);
			$('.amount').text(product.productPrice);
		})
		.fail(function(xhr) {
				// Ajax 요청 실패 시 처리
				window.location.href = 'errorPage';
		});
			
	});
	
	//신용/체크카드 선택시
	$(document).on('change', '#credit-card', function(){
		$(".payment-options").append("<div id='card-select'>카드사 선택<select name='select-credit' class='select2 sortby-select'><option value=''>--카드사 선택--</option><option value='KB국민카드'>KB국민카드</option><option value='신한카드'>신한카드</option><option value='삼성카드'>삼성카드</option></select></div>");
	});

	//계좌이체 선택시
	$(document).on('change', '#bank-transfer', function(){
		$(".payment-options").append("<div id='bank-select'>은행 선택<select name='select-bank' class='select2 sortby-select'><option value=''>--은행 선택--</option><option value='국민은행'>국민은행</option><option value='신한은행'>신한은행</option><option value='우리은행'>우리은행</option></select></div>");
	});

	//라디오 버튼 클릭 이벤트에서 생성된 div 요소 제거
	$(document).on('click', 'input[name="payment-method"]', function(e){
		$("#card-select, #bank-select").remove();
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

