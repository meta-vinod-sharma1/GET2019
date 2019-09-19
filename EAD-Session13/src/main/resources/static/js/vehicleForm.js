function vehicleFormValidation(){

}

function planValidation(){

}

function vehicle_details() {
    document.getElementById("message").innerHTML = "Congratulation You register the vehicle : " + document.getElementById("vehicle_number").value + " Successfully";
    document.getElementById("vehicle_form_div").style.display = "none"
    document.getElementById("plan_div").style.display = "block";
    var vehicle_type = document.getElementById("select_vehicle").value;
    document.getElementById("selected_vehicle").innerHTML = vehicle_type;
    switch (vehicle_type) {
        case "Cycle":
            daily = 0.070;
            monthly = 1.39;
            yearly = 6.96;
            break;
        case "Motorcycle":
            daily = 0.14;
            monthly = 2.79;
            yearly = 13.93;
            break;
        case "Car":
            daily = 0.28;
            monthly = 6.96;
            yearly = 48.75;
            break;
        default:
            break;
    }
    document.getElementById("sign").innerHTML = "USD"
    document.getElementById("daily_price").innerHTML = daily;
    document.getElementById("dprice").value = "D"+daily;

    document.getElementById("monthly_price").innerHTML = monthly;
    document.getElementById("mprice").value = "M"+ monthly;

    document.getElementById("year_price").innerHTML = yearly;
    document.getElementById("yprice").value = "Y" + yearly;
}

function changeCurrency() {
    var currencyType = document.getElementById("currency").value;
    if (currencyType == "INR") {
        document.getElementById("sign").innerHTML = "INR"
        document.getElementById("daily_price").innerHTML =  convertINR(daily);
        document.getElementById("monthly_price").innerHTML = convertINR(monthly);
        document.getElementById("year_price").innerHTML = convertINR(yearly);

    } else if (currencyType == "YEN") {
        document.getElementById("sign").innerHTML = "YEN"
        document.getElementById("daily_price").innerHTML = convertYEN(daily);
        document.getElementById("monthly_price").innerHTML = convertYEN(monthly);
        document.getElementById("year_price").innerHTML = convertYEN(yearly);
    } else {
        document.getElementById("sign").innerHTML = "USD"
        document.getElementById("daily_price").innerHTML = daily;
        document.getElementById("monthly_price").innerHTML = monthly;
        document.getElementById("year_price").innerHTML = yearly;
    }
}

/**
* Function to convert usd to INR
*/
function convertINR(usd) {
    return Math.round(71.78 * usd);
}
/**
 * Function to convert usd to YEN
 */
function convertYEN(usd) {
    return Math.round(106.17 * usd);
}
/**
 * fUNCTION will used when get pass button click this will show final price of pass
 */

 