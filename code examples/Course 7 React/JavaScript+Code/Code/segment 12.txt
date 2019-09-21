class Boards {
    constructor() {
      this.name = "JS Board";
    }
}

class Projects extends Boards {
    constructor() {
        super(name)
    }
}

var result = new Projects();
console.log(result.name);