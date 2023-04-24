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