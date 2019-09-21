var xhr = new XMLHttpRequest();

function enterTheCode(country){
    var queryParam = 'https://api.openaq.org/v1/cities?country='+country.value;
    xhr.open('GET', queryParam);
    xhr.send();
    xhr.onreadystatechange = function(){
        if (xhr.readyState ===4 && xhr.status === 200){
            console.log(xhr.response);
        }
    }
}