/**
 * edu
 */
 
 // addEdu() : 새로운 학력 영역을 추가
function addEdu() {
  // 새로운 요소를 생성하고 클래스 이름을 추가
  var newEduBlock = document.createElement("div");
  newEduBlock.classList.add("edu-block");
  // 새로운 요소의 내부 HTML을 설정
  newEduBlock.innerHTML = `
  <div class="resume-block" th:object="${eduList}" th:each="edu:${eduList}">
	  <div class="inner">
	  <span class="name">E</span>
	  	<div class="title-box">
	  		  <div class="col-lg-11 col-md-11"></div>
		      <div class="edit-btns col-lg-1 col-md-1">
			      <button type="button" onclick="createEdu()"><span class="la la-check-circle-o"></span></button>
			      <button type="button" onclick="deleteEdu()" name="eduId"><span class="la la-trash"></span></button>
	      	  </div>
	     </div>
	      	  <div class="row">
			  
			  	<div class="form-group col-lg-6 col-md-6">
		        <label>학교명</label>
				  <input type=text id="eduName" name="eduName" placeholder="학교명">
			    </div>
			  	<div class="form-group col-lg-6 col-md-6">
		        <label>전공</label>
				  <input type=text id="eduMajor" name="eduMajor" placeholder="전공">
				</div>
			    <div class="form-group col-lg-6 col-md-6">
			    <label>학점</label>
			    <input type="text" id="eduScore" name="eduScore" placeholder="학점을 입력하세요.">
			    </div>
			    <div class="form-group col-lg-6 col-md-6">
			    <label>추가 정보 입력</label>
			    <input type="text" id="eduContent" name="eduContent" placeholder="학력 관련 추가 정보를 입력하세요.">
			    </div>
			    
			    <div class="edit-box">
			  	<div class="form-group col-lg-6 col-md-6">
			    <label>입학일</label><br>
			      <input type="date" id="eduStartDate" name ="eduStartDate" class="year edit-box">
			    </div>
			  	<div class="form-group col-lg-6 col-md-6">
			    <label>졸업일</label><br>
			      <input type="date" id="eduEndDate" name ="eduEndDate" class="year edit-box">
			    </div>
		        </div>
		  </div>
	 	</div>
    </div>
  `;

  var eduList = document.getElementById("edu-block");
  console.log(">>>>>>>>>> 추가영역 생성 " + eduList);
  var lastEduBlock = eduList.lastElementChild;
  eduList.insertBefore(newEduBlock, lastEduBlock.nextSibling);
}

// deleteEdu() : 학력 삭제
function deleteEdu(eduId) {
	//confirm(">>>>>>> eduId : " + eduId + "typeof : " + typeof eduId);
	$('#eduId'+eduId).val(eduId);
	console.log($('#eduId'+eduId).attr('value'));
	
		$.ajax({
    	url: "edu/" + eduId,
    	type: "DELETE",
    	data: $('.default-form').serialize(),
    	success: function(response) {
      	console.log(response);
      	alert("success");
   	 },
    	error: function(xhr, status, error) {
     	console.log(error);
      	alert("fail");
    }
  });
}

// createEdu() : 새로운 학력을 추가
function createEdu() {
    let eduName = $('#eduName').val();
    let eduMajor = $('#eduMajor').val();
    let eduScore = $('#eduScore').val();
    let eduContent = $('#eduContent').val();
    let eduStartDate = $('#eduStartDate').val();
    let eduEndDate = $('#eduEndDate').val();
    var cvId = document.querySelector('.chosen-select').value;
    document.querySelector('#cvId').value = cvId;

/*
  console.log(">>>>>>>>> " + eduDto.eduName);
  console.log(">>>>>>>>> " + eduDto.eduMajor);
  console.log(">>>>>>>>> " + eduDto.eduScore);
  console.log(">>>>>>>>> " + eduDto.eduContent);
  console.log(">>>>>>>>> " + eduDto.eduStartDate);
  console.log(">>>>>>>>> " + eduDto.eduEndDate);
  console.log(">>>>>>>>> eduName type " + typeof eduDto.eduName);
  console.log(">>>>>>>>> eduMajor type " + typeof eduDto.eduMajor);
  console.log(">>>>>>>>> eduScore type " + typeof eduDto.eduScore);
  console.log(">>>>>>>>> eduContent type " + typeof eduDto.eduContent);
  console.log(">>>>>>>>> start date type " + typeof eduDto.eduStartDate);
  console.log(">>>>>>>>> end date type " + typeof eduDto.eduEndDate);
*/

  $.ajax({
    url: "edu",
    type: "POST",
    data: {
      eduName: eduName,
      eduMajor: eduMajor,
      eduScore: eduScore,
      eduContent: eduContent,
      eduStartDate: eduStartDate,
      eduEndDate: eduEndDate,
      id : cvId
    },
    success: function(response) {
      alert("success");
      //render("#eduForm",resultJson,"#edu-template");
    },
    error: function(xhr, status, error) {
      alert("fail");
    }
  });
}

// editEdu() : 학력을 수정하기 위해 input 태그로 변경
function editEdu(eduId) {
	$('#eduId'+eduId).val(eduId);
	console.log($('#eduId'+eduId).attr('value'));
	console.log(document.getElementById("eduName(" + eduId + ")"));
	function replaceWithInputElements(elements) {
		console.log(">>>>>>> elements : " + elements)
	  for (let i = 0; i < elements.length; i++) {
	    const div = elements[i];
	    const text = div.textContent;
	    const input = document.createElement("input");
	    
	    if (div.id === "eduStartDate(" + eduId + ")" || div.id === "eduEndDate(" + eduId + ")") {
	      input.type = "date";
	    }
	    
	    input.value = text;
	    input.name = div.id;
	    input.style.border = "1px solid red";
	    input.style.borderRadius = "5px";
	    div.replaceWith(input);
	  }
	}
  // 호출할 때 요소들을 배열로 전달합니다.
  replaceWithInputElements([ 
	document.getElementById("eduName(" + eduId + ")"), 
	document.getElementById("eduMajor(" + eduId + ")"), 
	document.getElementById("eduScore(" + eduId + ")"), 
	document.getElementById("eduContent(" + eduId + ")"), 
	document.getElementById("eduStartDate(" + eduId + ")"), 
	document.getElementById("eduEndDate(" + eduId + ")")
	]);
}

// updateEdu() : 학력 수정(작업중)
function updateEdu(eduId) {
	let eduName = document.getElementsByName("eduName(" + eduId + ")")[0].value;
	let eduMajor = document.getElementsByName("eduMajor(" + eduId + ")")[0].value;
	let eduScore = document.getElementsByName("eduScore(" + eduId + ")")[0].value;
	let eduContent = document.getElementsByName("eduContent(" + eduId + ")")[0].value;
	let eduStartDate = document.getElementsByName("eduStartDate(" + eduId + ")")[0].value;
	let eduEndDate = document.getElementsByName("eduEndDate(" + eduId + ")")[0].value;
    var cvId = document.querySelector('.chosen-select').value;
    document.querySelector('#cvId').value = cvId;
    
	console.log(">>>>> eduId : " + eduId);
    console.log(">>>>> eduName : " + eduName);
    console.log(">>>>> eduMajor : " + eduMajor);
    console.log(">>>>> eduScore : " + eduScore);
    console.log(">>>>> eduContent : " + eduContent);
    console.log(">>>>> eduStartDate : " + eduStartDate);
    console.log(">>>>> eduEndDate : " + eduEndDate);
    
    $.ajax({
    url: "edu-update",
    type: "PUT",
    data: {
	  eduId : eduId,
      eduName: eduName,
      eduMajor: eduMajor,
      eduScore: eduScore,
      eduContent: eduContent,
      eduStartDate: eduStartDate,
      eduEndDate: eduEndDate,
      id : cvId
    },
    success: function(response) {
      alert("success");
      //render("#eduForm",resultJson,"#edu-template");
    },
    error: function(xhr, status, error) {
      alert("fail");
    }
  });
}
