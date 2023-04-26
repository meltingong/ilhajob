import * as View from "./view.js";
import * as Request from "./request.js";

$('.changeTag').click(function(e){
	/*
		url,method,contentType,sendData,function,async
	*/
	
		let sendData={
			tagId:$(this).val()
		};
	console.log(sendData);
	Request.ajaxRequest('getTagData',
					    'POST',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						function(resultJson){
								View.render("#tag-filter-template",resultJson,"#corp-main-list");
						},
						true); //비동기
	e.preventDefault();
});

$(document).ready(function() {
	  $('#searchInput').on('input', function() {
	    var corpName = $('#searchInput').val();
	    var job = $('select[name="job"]').val();
	    $.ajax({
	      url: '/search',
	      method: 'GET',
	      data: {
	        corpName: corpName,
	        job: job
	      },
	      success: function(data) {
	        var results = data.results;
	        var rcCountMap = data.rcCountMap;
	        var template = Handlebars.compile($('#searchTemplate').html());
	        if (results.length > 0) {
	          $('#searchResults').html(template({ results: results, rcCountMap: rcCountMap }));
	        } else {
	          $('#searchResults').html('');
	          $('#searchResults').append('<div class="alert alert-warning">검색 결과가 없습니다.</div>');
	        }
	      }
	    });
	  });
	});
