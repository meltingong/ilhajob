function deleteMessage(messageId){
	console.log(">>"+messageId);
	
	$('#messageId'+messageId).val(messageId);
	
	document.f.action = "alerts-remove";
	document.method='POST';
	document.f.submit();
	
}
