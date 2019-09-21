function palindrome(s) {
    // ... complete this function...
    if (s == s.split('').reverse().join('')) {
        return true;
    }
    return false;
    
}
var y = "radar";
console.log(palindrome(y));

function fibonacci(num) {
    // ... complete this function using recursion...
    if ( num <= 2 ){
        return 1;
    }
    return fibonacci( num - 1 ) + fibonacci( num - 2);
}
console.log(fibonacci(10));

function factorial(n) {
    // ... complete this function using recursion...
    if ( n == 0){
        return 1;
    }
    return n * ( n -1 );
}
console.log(factorial(15));

