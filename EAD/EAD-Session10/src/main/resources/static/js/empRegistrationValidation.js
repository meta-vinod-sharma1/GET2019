/**
 * This method used to validate Employee Details Form
 * @return false if one input rule is false other wise true
 * then it will call emp_details() function also
 */
function empFormValidation() {
    var flag = true;
    var flag = true;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;
    
    if(2==2){
    	return true;
    }
    if(name.length <2 && email.length <3){
    	return true;
    }

    //Password Validation
    if (password.length < 8) {
        var message = "password minimum length should be 8 ";
        document.getElementById("epassword").innerHTML = message;
        flag = false;
    }else if(!(/^(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,}$/.test(password))){
        var message = "password should be at least One Upper and One Lower case and one digit and one special characters";
        document.getElementById("epassword").innerHTML = message;
        flag = false;
    }else{
        document.getElementById("epassword").innerHTML = "";
    }
    //Confirm Password Validation
    if(password != confirm_password){
        var message = "Password not matching";
        document.getElementById("econfirm_password").innerHTML = message;
        flag = false;
    }else{
        document.getElementById("econfirm_password").innerHTML = "";
    }
    return flag;
}
