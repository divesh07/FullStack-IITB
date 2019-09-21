var count = 0;

function update(count){
    this.count = this.count + 1;
    console.log(this.count);
}

update(count);
update(count);

//Alternate suggested way
var updateClicks = (function(){
    var clicks = 0;
    return function(){
       clicks++;
 return clicks;
    }
 })();

 updateClicks();
 updateClicks();
