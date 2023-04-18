import * as View from "./view.js";
import * as Request from "./request.js";

$('#changeTag').click(function(){
	console.log("펑션접근");
	/*
		url,method,contentType,sendData,function,async
	*/
	
		let sendData={
			tagId=$('#changeTag').value()
		};
	console.log(sendData);
	Request.ajaxRequest('/getTagData',
					    'GET',
						'application/json;charset=UTF-8',
						JSON.stringify(sendData),
						console.log('컨트롤러보내기직전'),
						function(resultJson){
							if(resultJson.data!=null){
								console.log('요청 URL 성공');
								//ajaxRequest();
								View.render("#tag-filter-template",resultJson,"#corp-main-list");
							}else{
								alert(resultJson);
							}
						},
						true); //비동기
	e.preventDefault();
});