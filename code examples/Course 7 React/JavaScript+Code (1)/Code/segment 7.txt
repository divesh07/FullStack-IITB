function colors(name, callback) {
  console.log('You like color '+ name);
  callback();
}

colors('red', function() {
    console.log("Callback executed!");
});