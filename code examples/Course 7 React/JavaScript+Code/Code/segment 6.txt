var name = "JavaScript";
function board(name) {
    var name = "New name"
    console.log(name);
}
console.log(name);
board();

var name = "JavaScript";
function board(name) {
    var name = "New name"
    function innerFunction() {
        console.log(name);
    }
    innerFunction();
}
console.log(name);
board();


var name = "JavaScript";
function board(name) {
    var name = "New name"
    function innerFunction() {
        this.name = 'inner funciton';
        console.log(this.name);
    }
    innerFunction();
}
console.log(name);
board();