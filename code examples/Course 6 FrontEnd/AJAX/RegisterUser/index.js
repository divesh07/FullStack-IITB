var xhr = new XMLHttpRequest();

function sendPostRequest(userName,userJob){
    console.log(userName.value);
    var params = {
        name: userName.value,
        Job : userJob.value
    }
    var uri = 'https://reqres.in/api/users';
    xhr.open('POST', uri);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify(params));
    
    xhr.onreadystatechange = function(){
        console.log(xhr.response);
        if (xhr.readyState ===4 && xhr.status === 201){
            console.log(xhr.response);
        }
    }
}
