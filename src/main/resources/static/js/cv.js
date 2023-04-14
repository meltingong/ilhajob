/**
 * cv
 */
 
 // cv write
 function writeCv() {
	/*
	console.log(document.f.cvName.value);
	console.log(document.f.cvDescription.value);
	console.log(document.f.cvPortfolio.value);
	console.log(document.f.userSeq.value);
	*/
	if (document.f.cvName.value == "") {
		alert("이력서 제목을 입력하세요.");
		document.f.cvName.focus();
		return false;
	}
	if (document.f.cvDescription.value == "") {
		alert("자기소개를 입력하세요.");
		document.f.cvDescription.focus();
		return false;
	}
	if (document.f.cvPortfolio.value == "") {
		alert("포트폴리오를 입력하세요.");
		document.f.cvPortfolio.focus();
		return false;
	}
	document.f.action = "cv-write-action";
	document.f.method='POST';
	document.f.submit();
}

// cv update
function updateCv() {
	/*
	console.log('dddddddd');
	console.log(document.f.cvId.value);
	console.log(document.f.cvName.value);
	console.log(document.f.cvDescription.value);
	console.log(document.f.cvPortfolio.value);
	console.log(document.f.userId.value);
	*/
	if (document.f.cvName.value == "") {
		alert("이력서 제목을 입력하세요.");
		document.f.cvName.focus();
		return false;
	}
	if (document.f.cvDescription.value == "") {
		alert("자기소개를 입력하세요.");
		document.f.cvDescription.focus();
		return false;
	}
	if (document.f.cvPortfolio.value == "") {
		alert("포트폴리오를 입력하세요.");
		document.f.cvPortfolio.focus();
		return false;
	}
	document.f.action = "cv-update-action";
	document.f.method='POST';
	document.f.submit();
}

// cv update
function deleteCv() {
	// 나중에 모달 등으로 수정하기
	if (window.confirm("정말 삭제하시겠습니까?")) {
		  document.f.action = "cv-delete-action";
		  document.f.method='POST';
		  document.f.submit();
	}
}

// cv change
function changeCv() {
  var cvId = document.querySelector('.chosen-select').value;
  window.confirm("cvId = " + cvId);
  document.querySelector('#cvId').value = cvId;
  document.f.action = "cv-detail";
  document.f.method='POST';
  document.f.submit();
}

// cv apply(예정)
function apply() {
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}


// edu
/*
function deleteEdu(eduSeq) {
	$('#eduSeq'+eduSeq).val(eduSeq);
	console.log($('#eduSeq'+eduSeq).attr('value'));
	console.log($('.default-form').serialize());
	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}
*/
/**
function deleteEdu(eduSeq) {
	document.f.value=eduSeq;
	$('#eduSeq'+eduSeq).value=eduSeq;
	console.log(document.f.value);
	console.log(">>>>"+$('#eduSeq'+eduSeq).value);

	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}
*/
function deleteEdu(eduId) {
	document.f.value=eduId;
	$('#eduId'+eduId).value=eduId;
	console.log(document.f.value); // ok
	console.log(">>>>"+$('#eduId'+eduId).value); // undefined

	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();

function addEdu() {

}

// exp
function deleteExp(expSeq) {
	$('#expSeq'+expSeq).val(expSeq);
	console.log($('#expSeq'+expSeq).attr('value'));
	console.log($('.default-form').serialize());
}
}

function deleteExp() {
	document.f.action = "exp-delete-action";
	document.f.method='POST';
	document.f.submit();
}
