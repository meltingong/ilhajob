(function($) {
	$('.call-order-modal').on('click', function(e) {
		e.preventDefault();
		if ($('.order-model.modal').length > 0) {
			// 모달이 존재하는 경우
			$('.order-model.modal').remove();
		}
		let productId = $(this).data('product-id');
		let productIdJson = JSON.stringify({id: productId});
		let promise = $.ajax({
			type: 'POST',
			url: 'order-popup',
			data: productIdJson,
			contentType: 'application/json',
			dataType: 'json'
		});

		// Promise 객체를 사용하여 Ajax 요청 처리
		promise.then(function(responseData) {
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
			$('#product-id').val(product.id);
			$('.product-name').text(product.productName);
			$('.product-total').text(product.productPrice);
			$('.amount').text(product.productPrice);
		})
		.fail(function(xhr) {
				// Ajax 요청 실패 시 처리
				window.location.href = 'errorPage';
		});
			
	});
		
	$(document).on('click', '#pay-btn', function(e) {
		e.preventDefault();
		const productData = {
			id: $('#product-id').val(),
			productName: $('.product-name').text(),
			productPrice: $('.product-total').text(),
			orderTotal: $('.amount').text()
		};

		const userData = {
			userName: $('#order-name').val(),
			userPhone: $('#order-phone').val(),
			userEmail: $('#order-email').val()
		};

		const paymentData = {
			paymentMethod: $('input[name="payment-group"]:checked').val(),
		};
		
		const currentDate = new Date();
		const orderId = 'ORDER_' + currentDate.getFullYear() 
		+ (currentDate.getMonth() + 1) + currentDate.getDate() 
		+ currentDate.getHours() + currentDate.getMinutes() 
		+ currentDate.getSeconds();
		const orderData = {
			orderId: orderId
		};
		$('.order-model.modal').remove();
		const formData = {
			productData: productData,
			userData: userData,
			paymentData: paymentData,
			orderData: orderData
		};
		const jsonData = JSON.stringify(formData);
		IMP.init("imp21102268");
		//결제 api
		IMP.request_pay({
			pg: 'html5_inicis.INIBillTst',
			pay_method: paymentData.paymentMethod,
			merchant_uid: orderData.orderId, //상점에서 생성한 고유 주문번호
			name: '주문명:' + productData.productName,
			amount: 100,
			buyer_email: userData.userEmail,
			buyer_name: userData.userName,
			buyer_tel: userData.userPhone,
		}, function(rsp) { // callback 로직
			console.log(rsp);
			if (rsp.success) {
				alert('결제가 완료되었습니다.');
				// 결제 성공 시 처리할 로직을 추가하세요.
				/*let promise = $.ajax({
					type: 'POST',
					url: 'order',
					data: jsonData,
					contentType: 'application/json',
					dataType: 'json'
				});

				// Promise 객체를 사용하여 Ajax 요청 처리
				promise.then(function(response) {
					// 로그인 성공 시 처리
					window.location.href = '/order-completed';
				})
				.fail(function(xhr) {
						// Ajax 요청 실패 시 처리
						alert("실패");
				});*/
			} else {
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
				alert(msg);
				// 결제 실패 시 처리할 로직을 추가하세요.
			}
		});
		
		
	});
	





})(window.jQuery);