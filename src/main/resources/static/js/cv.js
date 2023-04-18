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

// cv delete
function deleteCv() {
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
	window.confirm("지원하시겠습니까?");
	document.f.action = "cv-apply-action";
	document.f.method='POST';
	document.f.submit();
}

/**************** edu ****************/
function addEdu() {
  // 새로운 요소를 생성하고 클래스 이름을 추가합니다.
  var newEduBlock = document.createElement("div");
  newEduBlock.classList.add("edu-block");
  // 새로운 요소의 내부 HTML을 설정합니다.
  newEduBlock.innerHTML = `
  <div class="resume-block" th:object="${eduList}" th:each="edu:${eduList}">
	  <div class="inner">
	  <span class="name">E</span>
		      <div class="edit-btns">
			      <button type="button" onclick="createEdu()"><span class="la la-pencil"></span></button>
			      <button type="button" onclick="updateEdu()"><span class="la la-pencil"></span></button>
			      <button type="button" onclick="deleteEdu()" name="eduId"><span class="la la-trash"></span></button>
	      	  </div>
	      	  <div class="row">
			  
			  	<div class="form-group col-lg-6 col-md-12">
		        <label>학교명</label>
				  <input type=text th:field="*{eduDto.eduName}" name="eduName" placeholder="학교명">
			    </div>
			  	<div class="form-group col-lg-6 col-md-12">
		        <label>전공</label>
				  <input type=text name="eduMajor" placeholder="전공">
				</div>
			    <div class="form-group col-lg-6 col-md-12">
			    <label>학점</label>
			    <input type="text" name="eduScore" placeholder="학점을 입력하세요.">
			    </div>
			    <div class="form-group col-lg-6 col-md-12">
			    <label>추가 정보 입력</label>
			    <input type="text" name="eduContent" placeholder="학력 관련 추가 정보를 입력하세요.">
			    </div>
			    
			    <div class="edit-box">
			  	<div class="form-group col-lg-6 col-md-12">
			    <label>입학일</label><br>
			      <input type="date" name ="eduStartDate">
			    </div>
			  	<div class="form-group col-lg-6 col-md-12">
			    <labe>졸업일</label><br>
			      <input type="date" name ="eduEndDate">
			    </div>
		        </div>
		  </div>
	 	</div>
    </div>
  `;

  var eduList = document.getElementById("edu-block");
  console.log(">>>>>>>>>> " + eduList);
  var lastEduBlock = eduList.lastElementChild;
  eduList.insertBefore(newEduBlock, lastEduBlock.nextSibling);
}

function deleteEdu(eduId) {
	confirm(">>>>>>> eduId : " + eduId + "typeof : " + typeof eduId);
	$('#eduId'+eduId).val(eduId);
	console.log($('#eduId'+eduId).attr('value'));
	console.log($('.default-form').serialize());

	document.f.action = "edu-delete-action";
	document.f.method='POST';
	document.f.submit();
}


function createEdu() {
	/*
	console.log(">>>>>>>>>>" + typeof document.getElementsByName("eduStartDate")[0].value);
	var eduStartDate = new Date(document.getElementsByName("eduStartDate")[0].value + "T00:00:00");
    console.log(">>>>>>>>>>" + eduStartDate);
    console.log(">>>>>>>>>>" + typeof eduStartDate);
    var eduEndDate = new Date(document.getElementsByName("eduEndDate")[0].value + "T00:00:00");
    console.log(">>>>>>>>>>" + eduEndDate);
    
    var eduDto = {
        eduName: document.getElementsByName("eduName")[0].value,
        eduMajor: document.getElementsByName("eduMajor")[0].value,
        eduStartDate: eduStartDate.toISOString(),
        eduEndDate: eduEndDate.toISOString(),
        eduScore: document.getElementsByName("eduScore")[0].value,
        eduContent: document.getElementsByName("eduContent")[0].value
    };
    */
    
	document.f.action = "edu-create";
	document.f.method='POST';
	document.f.submit();

	/*
	const eduDto = {
    eduName: $("#eduName").val(),
    eduMajor: $("#eduMajor").val(),
    eduStartDate: $("#eduStartDate").val() + "T00:00:00.000",
    eduEndDate: $("#eduEndDate").val() + "T00:00:00.000",
    eduContent: $("#eduContent").val()
  };

  $.ajax({
    type: "POST",
    url: "/edu-create",
    contentType: "application/json",
    data: JSON.stringify(eduDto),
    success: function(response) {
      // success callback function
      alert("success");
    },
    error: function(xhr, status, error) {
      // error callback function
    }
  });
  */
}

/*
// exp
function deleteExp(expSeq) {
	$('#expSeq'+expSeq).val(expSeq);
	console.log($('#expSeq'+expSeq).attr('value'));
	console.log($('.default-form').serialize());
}

function deleteExp() {
	document.f.action = "exp-delete-action";
	document.f.method='POST';
	document.f.submit();
}
*/