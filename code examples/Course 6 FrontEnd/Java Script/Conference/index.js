showTemplate();

function showTemplate(){
    var addText = '<p>For attending our conference on Frontend Development.</p>'+
        '<p>Hope all of you found it informative!!!</p>'+
        '<p>We look forward to see you all in future conferences.</p>'+
        '<p>Best Regards,</p>'+
        '<h2>Team Upgrad</h2>';
        document.getElementById('addTemplate').innerHTML += addText;
}