//bind
var name = 'javascript';
var boardName = {
    name: 'New name',
    getName: function () {
        return this.name;
    }
};

var getBoardName = boardName.getName;
console.log(getBoardName()); 

var getBoardName = getBoardName.bind(boardName);
getBoardName(); 


//call and apply
var boardName = {
    name: 'This is a ',
    getName: function () {
        return this.name;
    }
};

var boardList = function(firstName, lastName) {
    console.log(this.getName() + firstName +  lastName);
};

boardList.call(boardName,'javascript', ' call!'); 
boardList.apply(boardName,['javascript', ' apply!'])
