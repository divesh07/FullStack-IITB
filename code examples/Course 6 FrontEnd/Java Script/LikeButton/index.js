function addComments(id){
    var addEventName = id.value +'<br>';
    var a = document.getElementById('userComments');
    document.getElementById('addEventNames').innerHTML += '<p>'+addEventName+'</p>';          
    a.value=a.defaultValue;
}
//Enter your code here
postLiked.likes = 1;
function postLiked(){
    var count = postLiked.likes++;
    console.log(count);
    document.getElementById('likeBlog').innerHTML = "Liked!";
    if (  count == 1){
        document.getElementById('commentCount').innerHTML = '<span>'+ count +' person likes this!</span>';
    }else{
        document.getElementById('commentCount').innerHTML = '<span>'+ count +' people have liked this!</span>';
    }
}
