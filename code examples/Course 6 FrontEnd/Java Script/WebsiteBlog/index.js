function readComments(id){
    //console.log(id);
    //console.log(id.value)
    if ( id.value === ""){
        // if the comment isnt entered by the user
    }else{
        // comment is entered
        var comment = '<p>' + id.value + '</p>';
        document.getElementById('addEventNames').innerHTML += comment;
        document.getElementById('userComments').value = '';
    }
}