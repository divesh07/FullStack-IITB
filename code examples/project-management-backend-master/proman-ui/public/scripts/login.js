var xhr = new XMLHttpRequest();

function login(email, password) {
    var param = window.btoa(email.value +":"+password.value);
    xhr.open('POST', "http://localhost:8080/api/v1/auth/login");
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.setRequestHeader('Authorization', "Basic "+param);
    xhr.send();
    xhr.onreadystatechange = sendRequest;
}


function sendRequest() {
    if(xhr.status == 200){
        if(xhr.readyState == 4) {
            var jsonResponse = JSON.parse(xhr.responseText);
            sessionStorage.setItem('user-detail', JSON.stringify(jsonResponse));
            sessionStorage.setItem('access-token', jsonResponse.access_token);
            window.location.href = "./home.html";
        }
    }
    else if(xhr.status == 401) {
        console.error(xhr.responseText);
        window.alert("Authentication failed");
    }
    else {
        console.error("Something went wrong. Response code is "+xhr.status);
    }
}