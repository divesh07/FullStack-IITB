// Map
var numbers = [6,8,12];

var squares = numbers.map(function(x) {
    return x * x ;
});
console.log(squares);

// Filter
var numbers = [23, 49, 343, 71];
var seven = numbers.filter(function(x){
    return (x % 7 == 0);
});
console.log(seven);

//Sum of first 1000 numbers which are multiple fof 3 and 5
var f = () => {
    var ans = 0;
    for(var i=0; i<1000; i++){
       if ((i%3==0) || (i%5==0)){
       ans = ans + i;
     }
  }
 return ans;
 }
 console.log(f());