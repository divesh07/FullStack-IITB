var getPromise = new Promise(function(resolve, reject){
    setTimeout(function(){
        resolve("Error!"); 
    }, 1000);
  });
  
getPromise
.then(function(successMessage){
console.log(successMessage);
}).catch(function(errorMessage){
console.log(errorMessage);
});