document.getElementById('yesButton').addEventListener('click', function(){
    alert('Thank you for your feedback');
});

document.getElementById('noButton').addEventListener('click', function(){
    document.getElementById('commentContainer').style.display = 'inline';
});

document.getElementById('submitButton').addEventListener('click', function(){
    if ( document.getElementById('commentBox').value == "" ){
        alert('The comments section cannot be empty');
    }else{
        document.getElementById('commentBox').value = "";
        alert('Thank you for taking your time to give us feedback. We hope you have a better experience next time');
    }
});