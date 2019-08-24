var projectListObject = [
    {
        name:'JavaScript One'
    },
    {
        name:'JavaScript Two'
    }
];

function showProjects(listId){
    
    projectListObject.forEach(function(value, index){
        console.log(value);
        var template = '<div class="project-card">'+ value.name +
        '<ul>'+
            '<li>Task one</li>'+
            '<li>Task two</li>'+
        '</ul>'+
    '</div>';
    document.getElementById(listId).innerHTML += template;
    });

}

function toggleMenu(){
    var toggleVariable = document.getElementsByClassName('menu-block')[0];
    
    if ( toggleVariable.style.display == 'none'){
        toggleVariable.style.display = '';
    }else{
        toggleVariable.style.display = 'none';
    }
}

function removeCard(){
    document.getElementById('project-list').innerHTML = '';
}

var idName = 1;
function addBoard(id){
    idName++;
    var listId = 'project-list_' + idName;
    var boarId = 'board_' + idName;
    var templateBlock = '<section class="board-block" id=' + boarId + ' >'+
        '<div> ' + id.value + '<button onclick="removeCard()">Remove card</button></div>'+
        '<div class="project-block" id= ' + listId +'>'+
        '</div>'+
    '</section>';
    document.getElementById('boardBlockList').innerHTML += templateBlock;
    showProjects(listId);
    document.getElementById('menuList').innerHTML += '<li onclick="loadMenu('+ boarId +')">' + id.value +'</li>';
}

function loadMenu(element){
    console.log(element.id);
    document.getElementById(element.id).style.display = 'block';
}