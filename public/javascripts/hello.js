if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

function checkPasswordMatch(){
    var password = $("#pwd1").val();
    var confirmPassword = $("#pwd2").val();

    if (password != confirmPassword)
//        $("#divCheckPasswordMatch").html("Passwords do not match!");
      alert('confirm password not match');
    else
     alert('confirm password  match');
//        $("#divCheckPasswordMatch").html("Passwords match.");
}

