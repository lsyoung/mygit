var students = [];
//생성자 함수
function Student(sno, sname, sphone, sbirth, score) {
    this.sno = sno;
    this.sname = sname;
    this.sphone = sphone;
    this.sbirth = sbirth;
    this.score = score;
}

students[0] = new Student('S0001', '홍길동', '010-1111', '1990-01-01', 65);
students.push(new Student('S0002', '박문규', '010-2222', '1998-03-03', 73));
students.push(new Student('S0003', '김민수', '010-3333', '1997-05-03', 88));
students.unshift(new Student('S0004', '김철수', '010-5555', '1993-08-03', 91));

console.log(students);

window.addEventListener('DOMContentLoaded', windowLoad);

function windowLoad(){

    var studentsOver70 = students.filter(item => item.score > 70);

    document.write('<ul>');
    //배열의 요소 갯수 반복 => for(var i=0; i<ary.length; i++){}, for(var obj of ary){}
    studentsOver70.forEach(item =>{
        console.log(item);
    document.write('<li>'+ item.sno +' , '+ item.sname +'</li>')

}); //메소드의 매개값 함수가 들어오면 => 콜백함수
    document.write('</ul>');
}

function forEachCallBackFnc(item, ind, ary){
    document.write('<li>'+ item.sno +' , '+ item.sname +'</li>')
}