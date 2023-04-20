/**
 * cv
 */
 // cv write
 function writeCv() {
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
	document.cvForm.action = "cv-update-action";
	document.cvForm.method='POST';
	document.cvForm.submit();
}

// cv delete
function deleteCv() {
	if (window.confirm("정말 삭제하시겠습니까?")) {
	  document.cvForm.action = "cv-delete-action";
	  document.cvForm.method='POST';
	  document.cvForm.submit();
	}
}

// cv change
function changeCv() {
  var cvId = document.querySelector('.chosen-select').value;
  //window.confirm("cvId = " + cvId);
  document.querySelector('#cvId').value = cvId;
  document.cvForm.action = "cv-detail";
  document.cvForm.method='POST';
  document.cvForm.submit();
}

// cv apply(예정)
function apply() {
	window.confirm("지원하시겠습니까?");
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}

 /**************** edu ****************/
