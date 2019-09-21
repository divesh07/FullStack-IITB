
var xhr = new XMLHttpRequest();

function sendPutRequest(userName,userJob) {

    var params = {
        name : userName.value,
        Job : userJob.value
    }
    
    
    console.log(params);

    xhr.open('PUT', "https://reqres.in/api/users/2");
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(params));
    xhr.onreadystatechange = sendRequest;

    //Base 64 decode window.atob(encodedString)
}

function sendRequest(){
    
    console.log(xhr.readyState);
    console.log(xhr.status);
    
    if ( xhr.readyState == 4){
        
        console.log(xhr.response);
        console.log(xhr.responseText);
        
        var json = JSON.parse(xhr.response);
        console.log(json.updatedAt);
        sessionStorage.setItem('updatedAt', json.updatedAt);
    
    }
    
}