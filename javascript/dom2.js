

{/* <input type="text" id="user_id" value="12345"><br>
    <button onclick="getIdFunc()">id값가져오기</button>


    <button onclick="drawTable()">클릭</button>
    <div id = 'show'>
    </div> */}

function getIdFunc(){
    var userId = document.getElementById('user_id');
    console.log(userId.value);
}

var students = [{
name: "홍길동",
math: 80,
eng: 90,
grade: '1학년1반',
avg: 85
},
{
name: "김수미",
math: 85,
eng: 85,
grade: '1학년2반',
avg: 90
},
{
name: "김민수",
math: 90,
eng: 75,
grade: '1학년3반',
avg: 80
}

];




function drawTable(){
    var table = document.createElement('table');
    table.setAttribute('border','1');
    var thead = document.createElement('thead');

    //타이틀 생성
    var tr = document.createElement('tr');
    for(var val in students[0]){
        var td = document.createElement('th');
        td.textContent=val;
        tr.appendChild(td);
    }
    thead.appendChild(tr);
    table.appendChild(thead);

    //데이터 부분
    var tbody = document.createElement('tbody');
    for(student of students){
        var tr = document.createElement('tr');
        for( var field in student){
            var td =document.createElement('td');
            td.textContent =student[field];
            tr.appendChild(td);
        }
        tbody.appendChild(tr);
    }
    table.appendChild(tbody);

    //화면 보여주기
    var divShow = document.getElementsByTagName('div');
    divShow[0].appendChild(table);
}