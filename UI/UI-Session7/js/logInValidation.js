
/**
 * This method used to validate login form 
 */
function logInValidation() {
    var flag = true;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    //(!(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9!@#\$%\^&]*$/.test(password)))
    // Email Validation
    if (!(/\S+@\S+\.\S+/.test(email))) {
        var message = "invalid email address";
        document.getElementById("eemail").innerHTML = message;
        flag = false;
    }else{
        document.getElementById("eemail").innerHTML = "";
    }
    //Password Validation
    if (password.length < 8) {
        var message = "password minimum length should be 8 ";
        document.getElementById("epassword").innerHTML = message;
        flag = false;
    }else if(!(/^(?=.*\d)(?=.*[a-zA-Z])[a-zA-Z0-9!@#\$%\^&]+$/.test(password))){
        var message = "password should be at least One Upper and One Lower case and one digit and one special characters";
        document.getElementById("epassword").innerHTML = message;
        flag = false;
    }else{
        document.getElementById("epassword").innerHTML = "";
    }
    
    return flag;
}
