$(document).ready(function() {
  // Get saved data from localStorage
  var email;
  var remember = localStorage.getItem('remember');

  if ($('#candidate-btn').hasClass('btn-style-seven')) {
    email = localStorage.getItem('email');
  } else if ($('#corp-btn').hasClass('btn-style-seven')) {
    email = localStorage.getItem('id');
  }
  console.log(email);
  // Check if remember checkbox was checked previously
  if (remember == 'true' && $('#candidate-btn').hasClass('btn-style-seven')) {
    // Set email and password fields to saved values
    $('#email').val(email);
    $('#remember').prop('checked', true);
  } else if (remember == 'true' && $('#corp-btn').hasClass('btn-style-seven')) {
    $('#id').val(email);
    $('#remember').prop('checked', true);
  }

  // Save email and password to localStorage on login
  $('#log-in').click(function() {
    var email;
    var remember = $('#remember').is(':checked');

    if ($('#candidate-btn').hasClass('btn-style-seven')) {
      // Set email and password fields to saved values
      email = $('#email').val();
      localStorage.setItem('email', email);
    } else if ($('#corp-btn').hasClass('btn-style-seven')) {
      email = $('#id').val();
      localStorage.setItem('id', email);
    }

    localStorage.setItem('remember', remember);
  });

  // Clear saved data from localStorage on logout
	$('#logout-btn').click(function() {
	  var remember = localStorage.getItem('remember');
	  
	  if ($('#candidate-btn').hasClass('btn-style-seven') && remember == 'false') {
	    localStorage.removeItem('email');
	  } else if ($('#corp-btn').hasClass('btn-style-seven') && remember == 'false') {
	    localStorage.removeItem('id');
	  }
	  localStorage.removeItem('remember');
});
});