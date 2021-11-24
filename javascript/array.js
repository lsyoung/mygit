
var checkedAry = [];
//sno, sname, sphone, sbirth => students
var fields = {
    sno: '학번',
    sname:'이름',
    sphone:'연락처',
    sbirth:'생년월일'
};

var str =`
    <form action ='basic.html' name='myname' id='myform' onsubmit='submitFnc(event)'>
        학번: <input type = 'text' name='sno'><br>
        이름: <input type = 'text' name='sname'><br>
        연락처: <input type = 'text' name='sphone'><br>
        생년월일: <input type = 'text' name='sbirth'><br>
        <input type ='submit' value='저장'>
    </form>
    <form action='basic.html' name='secondName' id='secondForm'>
        <input type ="text" name="id">
    </form>    
`;
document.write(str);
document.write('<div id="show"</div>');

createTableList();

//저장버튼 클릭=> 입력값이 화면에 추가
function submitFnc(e){
    e.preventDefault();
    // var s_no =  document.querySelector('form>input[name="sno"]').value;
    // var s_name = document.querySelector('form>input[name="sname"]').value;
    // var s_phone = document.querySelector('form>input[name="sphone"]').value;
    // var s_birth = document.querySelector('form>input[name="sbirth"]').value;

    console.log(document.forms['myform'].elements)
    console.log(document.forms['myform'].elements['sno'].value)

    var s_no = document.forms['myform'].elements['sno'].value;
    var s_name = document.forms['myform'].elements['sname'].value;
    var s_phone = document.forms['myform'].elements['sphone'].value;
    var s_birth = document.forms['myform'].elements['sbirth'].value;
    
    //console.log(sno, sname, sphone, sbirth);
    var std = {
        sno: s_no, 
        sname: s_name, 
        sphone: s_phone, 
        sbirth: s_birth
    }

    document.getElementById('tby').appendChild(getTrStudent(std));
}

function getTrStudent(student){

    var tr = document.createElement('tr');
    tr.onmouseover = mounseOverFnc;
    tr.onmouseout = mounseOutFnc; 
     //체크박스 추가
    var td = document.createElement('td');
    var chkbox = document.createElement('input');
    chkbox.onchange = changeFnc;
    chkbox.setAttribute('type','checkbox');
    td.appendChild(chkbox);
    tr.appendChild(td);
    //기존 필드
    for( field in fields){
        var td = document.createElement('td');
        td.textContent = student[field];
        tr.appendChild(td);
    }
    //추가내용
    td = document.createElement('td');
    var btn = document.createElement('button');
    btn.textContent = '복사';
    btn.onclick = clickFnc;
    td.appendChild(btn);
    tr.appendChild(td);
    return tr;
}

var checkedAry = [];
//sno, sname, sphone, sbirth => students
var fields = {
    sno: '학번',
    sname:'이름',
    sphone:'연락처',
    sbirth:'생년월일'
};

function createTableList(){
    var table = document.createElement('table');
    table.setAttribute('border','1')
    //타이틀부분 생성
    var thead = makeHead();
    table.appendChild(thead);
    //데이터 부분 생성
    var tbody = makeBody();
    table.appendChild(tbody);
    //div 하위요소로 출력
    document.getElementById('show').appendChild(table);
}

function mounseOverFnc(){
    this.style.backgroundColor = 'aqua';
}
function mounseOutFnc(){
    this.style.backgroundColor = '';
}
function clickFnc(e){
    //1.삭제
    //console.log(this); //this object최상위 객체( window )불러옴
    //console.log(e.path[2].remove());
    //console.log(this.parentNode.parentNode.remove());
    //2.복제
    var no = this.parentNode.parentNode.children[1].textContent;
    var name = this.parentNode.parentNode.children[2].textContent;
    var phone = this.parentNode.parentNode.children[3].textContent;
    var birth = this.parentNode.parentNode.children[4].textContent;
    var obj = {
        sno:no, 
        sname: name, 
        sphone: phone,
        sbirth: birth
    }
    // var selected_tr = this.parentNode.parentNode;
    // var clone_tr = selected_tr.cloneNode();
    // console.log(clone_tr);
    document.getElementById(getTrStudent('tby')).appendChild(getTrStudent(obj));

}

function changeFnc(){
    var searchSno =  this.parentNode.nextSibling.nextSibling.textContent;
    //console.log(this.parentNode.nextSibling.textContent);
    if (this.checked == true){
        var lnth = checkedAry.length;
        //checkedAry[lnth] = searchSno;
        checkedAry.splice(lnth, 0, searchSno);
    } else {
        for (var i = 0; i < checkedAry.lenth; i++){
            if(checkedAry[i] == searchSno){
                //delete checkedAry[i];
                checkedAry.splice(i, 1);
                break;
            }
       }
    }
    console.log(checkedAry);
}
function makeBody(){
    var tbody = document.createElement('tbody');
    tbody.setAttribute('id', 'tby');
    for( var student of students){
        getTrStudent(student);
    }   
    tbody.appendChild(tr);
    return tbody;
}

function makeHead(){
    var thead = document.createElement('thead');
    var tr = document.createElement('tr');
    //추가 컬럼
    var td = document.createElement('th');
    td.textContent = '선택';
    tr.appendChild(td);
    //기존필드
    for( var field in fields){
        var td = document.createElement('th');
        td.textContent = fields[field];
        tr.appendChild(td);
    }
    
    td = document.createElement('th');
    td.textContent = '버튼';
    tr.appendChild(td);

    thead.appendChild(tr);
    return thead;//<thead><tr><th>sno</th><th>sname</th>..</tr></thead>
}