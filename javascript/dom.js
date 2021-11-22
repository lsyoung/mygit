//document 1) createElement(tag)=> tag생성
//         2) getElementsByTagName(tag) => element선택
function createList(){
var ul = document.createElement('ul');
var li = document.createElement('li');
li.textContent = 'banana';
ul.appendChild(li);

li = document.createElement('li');
li.textContent = 'cherry';

ul.appendChild(li);

var bd = document.getElementsByTagName('body');

console.log(bd[0].appendChild(ul));
//<body><ul><li>banana</li></ul></body>
}

// var tbl = window.document.createElement('table');
// tbl.setAttribute('border', '1');
// tbl.setAttribute('id', 'tbl');


 
        var div = document.createElement('div');
        div.setAttribute('id', 'main');
        var ulTag = document.createElement('ul');
        var liTag = document.createElement('li');
        liTag.textContent = 'Apple';
        ulTag.appendChild(liTag);
        div.appendChild(ulTag);
        var bd = document.getElementsByTagName('body');
        bd[0].appendChild(div);
