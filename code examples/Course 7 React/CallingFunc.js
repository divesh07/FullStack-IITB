// invoke func -> Method, const . Apply or a func call 

// 1) Functional invocation
function board(){
    console.log("Board name");
}
board();

// Nethod invocation
var board = {
    "print" : function(){
        console.log("Method invocation");
    }
}
board.print;

// Constructor invocation
var board = function(name){
    this.name = name;

}

var boardName = new board("Constructor invocation");
console.log(boardName);

// Apply invocation

var board = function(firstName , lastName){
    return firstName + lastName;
}
var boardName = board.apply(null, ['New', 'Board']);
console.log(boardName);

