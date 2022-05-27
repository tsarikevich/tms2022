function validateForm() {
    var errorCounter = 0;
    errorCounter += validateLogin();
    errorCounter += validateName();
    errorCounter += validateSurname();
    errorCounter += validateEmail();
    errorCounter += validatePass();
    errorCounter += validateRepeatPass();
    errorCounter += validateBrthday();

    if (errorCounter > 0) {
        return false;
    }

    return true;
}

function validateLogin() {
    var errorCounter = 0;
    var loginFld = document.getElementById("login");
    var loginErr = document.getElementById("loginError");

    if (loginFld.value.length <= 0) {
        loginFld.style.background = '#FF0000';
        loginErr.style.display = "block";
        loginErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        loginFld.style.background = '#90EE90';
        loginErr.style.display = "none";
    }
    return errorCounter;
}

function validateName() {
    var errorCounter = 0;
    var nameFld = document.getElementById("name");
    var nameErr = document.getElementById("nameError");

    if (nameFld.value.length <= 0) {
        nameFld.style.background = '#FF0000';
        nameErr.style.display = "block";
        nameErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        nameFld.style.background = '#90EE90';
        nameErr.style.display = "none";
    }
    return errorCounter;
}

function validateSurname() {
    var errorCounter = 0;
    var surnameFld = document.getElementById("surname");
    var surnameErr = document.getElementById("surnameError");

    if (surnameFld.value.length <= 0) {
        surnameFld.style.background = '#FF0000';
        surnameErr.style.display = "block";
        surnameErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        surnameFld.style.background = '#90EE90';
        surnameErr.style.display = "none";
    }

    return errorCounter;
}

function validateEmail() {
    var errorCounter = 0;
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    var emailFld = document.getElementById("email");
    var emailErr = document.getElementById("emailError");
    var validationErr = document.getElementById("validationErr");

    if (emailFld.value <= 0) {
        validationErr.style.display = "none";
        emailFld.style.background = '#FF0000';
        emailErr.style.display = "block";
        emailErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        if (!re.test(String(emailFld.value).toLowerCase())) {
            emailErr.style.display = "none";
            emailFld.style.background = '#FF0000';
            validationErr.style.display = "block";
            validationErr.style.color = "#FF0000";
            errorCounter++;
        } else {
            emailFld.style.background = '#90EE90';
            emailErr.style.display = "none";
            validationErr.style.display = "none";
        }
    }

    return errorCounter;
}

function validatePass() {
    var errorCounter = 0;
    var passFld = document.getElementById("password");
    var passErr = document.getElementById("passwordError");

    if (passFld.value.length <= 0) {
        passFld.style.background = '#FF0000';
        passErr.style.display = "block";
        passErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        passFld.style.background = '#90EE90';
        passErr.style.display = "none";
    }

    return errorCounter;
}

function validateRepeatPass() {
    var errorCounter = 0;
    var passFld = document.getElementById("password");
    var repeatPassFld = document.getElementById("repeatPswd");
    var repeatPassErr = document.getElementById("repeatPassError");
    var matchingErr = document.getElementById("matchingError");

    if (repeatPassFld.value.length <= 0) {
        matchingErr.style.display = "none";
        repeatPassFld.style.background = '#FF0000';
        repeatPassErr.style.display = "block";
        repeatPassErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        if (passFld.value.localeCompare(repeatPassFld.value) !== 0) {
            repeatPassErr.style.display = "none";
            repeatPassFld.style.background = '#FF0000';
            matchingErr.style.display = "block";
            matchingErr.style.color = "#FF0000";
            errorCounter++;
        } else {
            repeatPassFld.style.background = '#90EE90';
            matchingErr.style.display = "none";
        }
    }

    return errorCounter;
}

function validateBrthday() {
    var errorCounter = 0;
    var brthDay = document.getElementById("brthDays");
    var brthMonth = document.getElementById("brthMonths");
    var brthYearFld = document.getElementById("brthYears");
    var brthErr = document.getElementById("brthErr");

    if (!((new Date().getFullYear() - parseInt(brthYearFld.value)) >= 16)) {
        brthDay.style.background = '#FF0000';
        brthMonth.style.background = '#FF0000';
        brthYearFld.style.background = '#FF0000';
        brthErr.style.display = "block";
        brthErr.style.color = "#FF0000";
        errorCounter++;
    } else {
        brthDay.style.background = '#90EE90';
        brthMonth.style.background = '#90EE90';
        brthYearFld.style.background = '#90EE90';
        brthErr.style.display = "none";
    }

    return errorCounter;
}








