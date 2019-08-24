function addComments(id){
        var addEventName = id.value +'<br>';
        var a = document.getElementById('userComments');
        document.getElementById('addEventNames').innerHTML += '<p>'+addEventName+'</p>';          
        a.value=a.defaultValue;
    }
    var numberOfClicks=0;
    function postLiked(){
        document.getElementById("likeBlog").innerHTML = "<i class='fa fa-thumbs-up'></i> Liked!";
        numberOfClicks += 1;
        if(numberOfClicks!=0){
            if (numberOfClicks==1){
                document.getElementById('commentCount').innerHTML = numberOfClicks + " person likes this!";
            }
            else {
                document.getElementById('commentCount').innerHTML = numberOfClicks + " people have liked this!";
            }
            }
        }