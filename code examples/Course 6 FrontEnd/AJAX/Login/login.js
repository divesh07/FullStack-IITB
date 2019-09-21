var xhr = new XMLHttpRequest();

function login(email, password) {

    // Base 64 encode
    var param = window.btoa(email.value + ":" + password.value);
    console.log(param);

    var encodedString = "Basic " + param;
    console.log(encodedString);

    xhr.open('POST', "http://localhost:8080/api/v1/auth/login");
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.setRequestHeader('Authorization', encodedString);
    xhr.send();
    xhr.onreadystatechange = sendRequest;

    //Base 64 decode window.atob(encodedString)
}

function sendRequest(){
    console.log(xhr);
    console.log(xhr.readyState);
    if ( xhr.readyState ==4 ){
        sessionStorage.setItem('user-detail', xhr.responseText);
        sessionStorage.setItem('access-token', xhr.getResponseHeader('access-token'));
        xhr.responseText
    }
    
}