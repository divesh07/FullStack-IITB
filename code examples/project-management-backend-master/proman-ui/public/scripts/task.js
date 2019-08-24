function makeXHR() {
    var boardID = sessionStorage.getItem('boardID');
    var projectID = sessionStorage.getItem('projectID');

    var accessToken = sessionStorage.getItem('authToken');

    var param = {
    };
    
    xhr.open('POST', "http://localhost:8080/api/v1/boards/"+boardID+"/projects/"+projectID+"/tasks");
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.setRequestHeader('Authorization', "Bearer "+accessToken);
    xhr.send(JSON.stringify(param));
    xhr.onreadystatechange = function () {
        if(xhr.readyState == 4) {
            console.log(xhr.responseText);
        }
    };

}