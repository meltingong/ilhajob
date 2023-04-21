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
//Open modal in AJAX callback
$('.call-modal-apply').on('click', function(event) {
  event.preventDefault();
  this.blur();
  
  $.get(this.href, function(data) {
	console.log(data.cvList);
	console.log(data.cvList[0].id);
	console.log(data.html.type);
	$('.modal').remove();
	
    $(data.html).appendTo('body').modal({
    	closeExisting: true,
		fadeDuration: 300,
		fadeDelay: 0.15
    });
    
	let select = document.querySelector('.chosen-select');
	console.log(select);
	// 새로운 option 요소 생성
	$.each(data.cvList, function(index, value) {
		console.log(index,value);
		let option = document.createElement('option');
		option.value = value.id; // option 요소의 값 설정
		option.textContent = value.cvName; // option 요소의 텍스트 설정
		select.appendChild(option);
	});
	// 새로운 option 요소를 select 요소에 추가
	
  });
  
});

function apply() {
	window.confirm("지원하시겠습니까?");
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}

 /**************** edu ****************/
