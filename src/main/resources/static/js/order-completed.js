(function($) {
	
	$(document).ready(function() {
		// localStorage에서 데이터를 불러오기
		const data = JSON.parse(localStorage.getItem("data"));

		// 데이터를 사용하여 DOM을 변경
		$("#order-id").text(data);
		$("#order-date").text(data.age);
		$("#order-total").text(data.age);
		$(".product-name").text(data.age);
		$(".product-total").text(data.age);
		$(".order-period").text(data.age);
		$(".amount").text(data.age);

		// localStorage 데이터를 삭제
		localStorage.removeItem("data");
	});


})(window.jQuery);