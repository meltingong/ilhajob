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
		const query = $(this).val();
		if (query.trim() === "") {
			// searchInput의 값이 없을 경우, search-results 내의 모든 li를 삭제
			$(".search-results").empty();
			$('.job-search-form form, .banner-section-four .job-search-form form').css({
			'border-bottom-left-radius': '50px',
			'border-bottom-right-radius': '50px'
		});
		} else {
			const results = search(query);
			updateSearchResults(results);
			$('.job-search-form form, .banner-section-four .job-search-form form').css({
				'border-bottom-left-radius': '0',
				'border-bottom-right-radius': '0'
			});
		}
	});
	
	$("#searchInput").on("click focus", function() {
			$(this).trigger('input');
	});
	
	
	
});
