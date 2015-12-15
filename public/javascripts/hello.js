if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

function checkPasswordMatch(){
    var password = $("#pwd").val();
    var confirmPassword = $("#pwd2").val();
    var message = document.getElementById('confirmMessage');
    var btn = document.getElementById('btn')

    if (password != confirmPassword){
        message.innerHTML ="Passwords do not match!";
        btn.disabled = true;
    }else{
        message.innerHTML ="Passwords match.";
        btn.disabled = false;
    }
}



