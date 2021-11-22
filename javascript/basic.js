var v1;
window.console.log(typeof v1);
v1 = 10;
window.console.log(typeof v1);
v1 ='hello';
window.console.log(typeof v1);
v1 = true;
window.console.log(typeof v1);
v1 = null;
window.console.log(typeof v1);

var result= 10+20;
console.log(result);

var Result = 30;

if(result == Result){
    console.log('같습니다');
}else{
    console.log('다릅니다');
}

var strTag = '<h1>Hello</h1>';
strTag += '<ul><li>Apple</li>';
strTag += '<li><Banana></li>';
strTag += '</ul>';

strTag = "result 변수에 들어있는 값"+result;
strTag = `result 변수에 들어있는 값 ${result}<br>`;
window.document.write(strTag);

result = 6/4;
document.write(result);

if(result>1){
    document.write(`1보다 큽니다.<br>`)
}else{
    document.write(`1보다 작습니다.<br>`);
}

var cnt = 10;
for(var i = 1; i<=10 ; i++){
    document.write(`${i}<br>`);
}

document.write(`<ul>`);
    while(cnt>0){
        document.write(`<li>cnt의값: ${cnt}</li>`);
        cnt--;
    }
    document.write(`</ul>`);

var obj = {};//new object();
obj.id='user1';
obj.name ='hong';
obj[`phone`]='010-123-1234';

obj ={
    id: 'user2',
    name:'Hwang',
    phone:'010-111-2222'
}
var filed ='phone';
console.log(typeof obj);

document.write(`<p>id: ${obj.id}</p>`);
document.write(`<p>name: ${obj[`name`]}</p>`);
document.write(`<p>phone: ${obj[filed]}</p>`);

var ary = []; //new Array();
ary[0] = 'Hong';
ary[1] = 'Hwang';
ary[2] = 'Park';
ary[3] = 100;
ary[4] ={
    name: 'Amy',
    age: 15
}
delete ary[1];
for(var i = 0; i<ary.length; i++){
    if(ary[i]!= undefined){
        console.log(ary[i]);
    }
}

var a= b =10;
a = 20;

console.log(a,b);

var obj1 = {
    name: 'Hwang'
}
var obj2 = obj1;
obj2 = {
    name: 'Kim'
}
console.log(obj1);

var kim = {
    name: 'Kim',
    age: 25,
    phone: '010-1111-2222'
}

var lee = {
    name: 'Lee',
    age: 28,
    phone: '010-1111-3333'

}

var park = {
    name: 'Park',
    age: 33,
    phone: '010-1111-5555'
}

for( var field in park){
    console.log(field, park[field]);
}

console.clear();

var objAry = [kim,lee,park];

//배열일 경우 for..of반복문
document.write('<table border="1">');

for( var obj of objAry){//향상폴문..
    document.write('<tr>');
    for(var field in obj){
        console.log(`${field},${obj[field]}`);
        document.write('<td>');
        document.write(`${obj[field]}`);
        document.write('</td>');
    }
    console.log('----------------------------');
    document.write('</tr>');
}
document.write('</table>');
