// Function as a part of object
var obj1 = {
    "sum" : function ( x , y ){
        return x + y ; 
    }
}

// returns number
function f(x){
    return x * x;
}
var y = typeof( f(2) );
console.log(y);


// To check the return type of the functon use type of
var x = 3;
function f(){
    x  = x * x;
};
var z = typeof(f);
console.log(z);
// returns undefined

var x = function(){
    return 4*4;
};
console.log(typeof(x));