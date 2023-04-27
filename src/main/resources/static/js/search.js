$(function() {
	$(document).on("click", function(event) {
		// 이벤트가 발생한 대상이 ul이나 li가 아닌 경우
		if (!$(event.target).closest(".search-results, .search-results li").length) {
			// search-results 내의 모든 li를 삭제
			$(".search-results").empty();
			$('.job-search-form form, .banner-section-four .job-search-form form').css({
				'border-bottom-left-radius': '50px',
				'border-bottom-right-radius': '50px'
			});
		}
	});
	
	const data = [
		"Apple",
		"Banana",
		"Blueberry",
		"Cherry",
		"Grape",
		"Lemon",
		"Mango",
		"Orange",
		"Peach",
		"Plum",
		"Raspberry",
		"Strawberry",
		"Watermelon",
	];
	
	function search(query) {
		return data.filter(item => item.toLowerCase().includes(query.toLowerCase()));
	}

	// 검색 결과 업데이트
	function updateSearchResults(results) {
		const searchResults = $(".search-results");
		searchResults.empty();
		results.forEach(result => {
			const listItem = $("<li>").text(result);
			listItem.on("click", function() {
				$("#searchInput").val($(this).text());
				$('.job-search-form form, .banner-section-four .job-search-form form').css({
					'border-bottom-left-radius': '50px',
					'border-bottom-right-radius': '50px'
				});
			});
			searchResults.append(listItem);
		});
	}

	// input 이벤트 리스너
	$("#searchInput").on("input", function() {
		if($(".search-select").val()==='recruit'){
			const query = $(this).val();
			if (query.trim() === "") {
				// searchInput의 값이 없을 경우, search-results 내의 모든 li를 삭제
				$(".search-results").empty();
				$('.job-search-form form, .banner-section-four .job-search-form form').css({
					'border-bottom-left-radius': '50px',
					'border-bottom-right-radius': '50px'
				});
			} else {
				const jsonData = {
					keyword: query
				}
				console.log(JSON.stringify(jsonData))
				let promise = $.ajax({
					type: 'POST',
					url: 'keywordSearch',
					data: JSON.stringify(jsonData),
					contentType: 'application/json',
					dataType: 'json'
				});

				// Promise 객체를 사용하여 Ajax 요청 처리
				promise.then(function(response) {
					console.log(response.message);	
				})
				.fail(function(xhr) {
						console.log(xhr);
				});
				const results = search(query);
				updateSearchResults(results);
				$('.job-search-form form, .banner-section-four .job-search-form form').css({
					'border-bottom-left-radius': '0',
					'border-bottom-right-radius': '0'
				});
			}
		}else if($(".search-select").val()==='corp'){
			
		}
		
	});
	
	$("#searchInput").on("click focus", function() {
			$(this).trigger('input');
	});
	
	
	
});
