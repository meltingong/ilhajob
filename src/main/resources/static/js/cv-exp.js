/**
 * 
 */
 
 // addEdu() : 새로운 학력 영역을 추가
function addExp() {
  // 새로운 요소를 생성하고 클래스 이름을 추가
  var newEduBlock = document.createElement("div");
  newEduBlock.classList.add("exp-block");
  // 새로운 요소의 내부 HTML을 설정
  newEduBlock.innerHTML = `
  <div class="resume-block" th:each="exp:${expList}">
  <input type="hidden" name="expId">
    <div class="inner">
      <span class="name">S</span>
      <div class="title-box">
          <div class="col-lg-10 col-md-10"></div>
          <div class="edit-btns form-group col-lg-2 col-md-2">
            <button><span class="la la-check-circle-o" th:id="createExp" th:onclick="createExp()"></span></button>
          </div>
      </div>
      <div class="row">
		      <div class="form-group col-lg-6 col-md-6">
			        <label>회사</label><br>
			        <input type="text" id="expCorpName" name="expCorpName" placeholder=" 근무했던 회사명을 입력하세요.">
		      </div>
		      <div class="form-group col-lg-6 col-md-6">
		            <label>직무</label>
			        <input type="text" id="expPosition" name="expPosition" placeholder="직무를 입력하세요.">
		      </div>
        
	      <div class="form-group col-lg-12 col-md-12">
	        <label>경력상세</label>
	        <input type="text" name="" placeholder="경력의 상세 내용을 입력하세요.">
	      </div>
      
        <div class="edit-box">
	        <div class="form-group col-lg-6 col-md-6">
		     <label>경력 시작일</label><br>
	          <input type="date" id="expStartDate" class="year edit-box">
	        </div>
	        <div class="form-group col-lg-6 col-md-6">
		     <label>경력 종료일</label><br>
	          <input type="date" id="expEndDate" class="year edit-box">
	        </div>
        </div>
     	 </div> <!-- row end -->
   		</div>
      </div>
    </div>
  </div>
  `;

  var expList = document.getElementById("exp-block");
  console.log(">>>>>>>>>> 추가영역 생성 성공 " + expList);
  var lastEduBlock = expList.lastElementChild;
  expList.insertBefore(newEduBlock, lastEduBlock.nextSibling);
}

// createExp() : 새로운 경력을 추가
function createExp() {
    let expDto = {
	
}
    $.ajax({
        url: "/exp-create",
        data: {
			expCorpName : expCorpName,
			expPosition : expPosition,
			expContent : expContent,
			expStartDate : expStartDate,
			expEndDate : expEndDate,
			  },
        type:"POST",
        cache: false
    })
}

function editExp(expId) {
	$('#expId'+expId).val(expId);
	console.log(">>>>>>>>>>>> " + expId);
	const inputs = document.querySelectorAll('#exp-block input[type="text"]');
	inputs.forEach(input => input.removeAttribute('readonly'));
	document.querySelectorAll('#exp-block input[type="date"]').forEach(input => input.style.display = 'block');
	document.querySelectorAll('#exp-block .year-span').forEach(span => span.style.display = 'none');
}
