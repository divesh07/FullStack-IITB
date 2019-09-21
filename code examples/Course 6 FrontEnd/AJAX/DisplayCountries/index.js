
var xhr = new XMLHttpRequest();
enterTheCode();
function enterTheCode(){
    xhr.open('GET', 'https://api.openaq.org/v1/countries');
    xhr.send();
    xhr.onreadystatechange = function(){
        if (xhr.readyState ===4){
            //console.log(xhr.response);
            var json = JSON.parse(xhr.response);
            //console.log(json);
            document.getElementById('country_data').innerHTML += '<p> Country Country code</p>';
            json.results.forEach(function(value,index){ 
                //console.log(value.name);
                document.getElementById('country_data').innerHTML += '<div>' + value.name  + " " + value.code + '</div>' ;    
            });
            
                
                
            
            
        }
    }
}
