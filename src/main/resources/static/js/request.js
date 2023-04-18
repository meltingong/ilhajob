/**
 * request.js
 */
 
function ajaxRequest(url, method, contentType, sendData, callBackFunction, async){
	console.log(ajax도착);
	$.ajax({
		url:url,
		method:method,
		contentType:contentType,
		data:sendData,
		success:function(resultJson){
			console.log(ajax실행);
			callBackFunction(resultJson);
		},
		async:async
	});
	
}

export{ajaxRequest};