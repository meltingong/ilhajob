// 'remember me' 체크박스가 변경될 때마다, localStorage에 값을 저장 또는 삭제합니다.
$(document).on('change', '#remember', function() {
  let emailInput = document.getElementById('email');
  let emailValue = emailInput.value.trim();

  if (this.checked) {
    localStorage.setItem('loginEmail', emailValue);
  } else {
    localStorage.removeItem('loginEmail');
  }
});

// 페이지가 로드될 때, localStorage에 저장된 값을 확인하여, 로그인 아이디를 채웁니다.
$(document).ready(function() {
  let emailInput = document.getElementById('email');
  let loginEmail = localStorage.getItem('loginEmail');

  if (loginEmail !== null) {
    emailInput.value = loginEmail;
    document.getElementById('remember').checked = true;
  }
});