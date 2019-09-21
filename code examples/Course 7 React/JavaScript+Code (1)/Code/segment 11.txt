//ES5
var name = 'Hello board';
var boards = {
    name: 'New board',
    print: function() {
        console.log(this.name);
    }
}

boards.print();

//ES6
var name = 'Hello board';
var boards = {
    name: 'New board',
    print: () => console.log(this.name)
}

boards.print();