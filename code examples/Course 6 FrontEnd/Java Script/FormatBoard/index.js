var projectListObject = [
    {
        name: 'Javascript One'
    },
    {
        name: 'Javascript Two'
    }
];

function showProject(listId){
    projectListObject.forEach(function(value,index){
        var template = '<div class ="project-card">'+
        value.name+ 
        '<ul>'+
            '<li class="taskList">Task one</li>'+
            '<li class="taskList">Task two</li>'+
        '</ul>'+
        '</div>';
       
            document.getElementById(listId).innerHTML += template;
    })
}
    

function toggleMenu() {
    var toggleVariable = document.getElementsByClassName('menu-block')[0];
    if(toggleVariable.style.display == 'none') {
        toggleVariable.style.display = '';
    }else {
        toggleVariable.style.display = 'none'
    }
}

function removeCard(){
    document.getElementById('projectList').innerHTML = '';
}
var idName = 0;

function addBoard(id){
    if (id.value.length < 5) {
        alert("Board name can't be less than five characters!");
        return;
      } else {
        idName++;
        var listId = 'projectList_'+idName;
        var boardId = 'board_'+idName;
        var templateBlock = '<section class ="board-block" id = "'+boardId+'"style="display:none">'+
        '<div class="board-name">'+id.value+'<button id ="removeBoards" onclick="removeCard('+listId+')">Remove Card</button></div>'+
        '<div class="project-block" id ="'+listId+'">'+
            
        '</div>'+
        '</section>'
    
        document.getElementById('boardBlockList').innerHTML += templateBlock;
        showProject(listId);
    
        document.getElementById('menuList').innerHTML +="<li onClick=loadMenu('"+boardId+"')>"+id.value+"<hr></li>";
        alert("Board name" + id.value + " added!");
        id.value=id.defaultValue;
    
      }
}
var boardIdList = [];
function loadMenu(boardId){
   //Enter your code here
    boardIdList.forEach(function(value, index){
        document.getElementById(value).style.display = 'none';     
    });

    document.getElementById(boardId).style.display = 'block';
    boardIdList.push(boardId);
}