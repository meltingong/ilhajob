import * as View from "./view.js";
import * as Request from "./request.js";

$('.changeTag').click(function(e){
	console.log("펑션접근");
	/*
		url,method,contentType,sendData,function,async
	*/
	
		let sendData={
			tagId:$(this).val()
		};
	console.log(sendData);
	Request.ajaxRequest('getRecruitTag',
					    'POST',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						function(resultJson){
							console.log("제이슨 받아오기 성공");
								View.render("#recruit-tag-template",resultJson,"#recruit-main-list");
						},
						true); //비동기
	e.preventDefault();
});

//인서트
$(document).on('click','#tag-insert',function(){
	
		console.log("펑션접근");
		
		let tagId = $('#tagId option:selected').val();//스크랩등록시 이미지
		let reqId = $(this).val();
		let jsonData = {
			tagId: tagId,
			reqId: reqId,
		};
		console.log(JSON.stringify(jsonData));
			Request.ajaxRequest('recruit-tag-insert-action',
								'POST',
								'application/json;charset=UTF-8',
								JSON.stringify(jsonData),
								function(resultJson){
								console.log("제이슨 받아오기 성공");
								View.render("#recruit-tag-insert-delete-template",resultJson,"#recruit-tag-zone");
								},
								true);
			e.preventDefault();	
		});