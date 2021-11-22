
var year = 2021;
var month = 9;

// createCalendar(2019, 2);

function createCalendar(year,month){
var thisMonth = new Date(year,month-1);//year month 01
var thisMonthDay = thisMonth.getDay();
console.log(thisMonth.getDay());//getday요일

var today = new Date();
var todate =today.getDate();
var days = ["일", "월", "화", "수", "목", "금", "토"];
var str="";
str += "<table border='1'>";
str += "<caption>"+year+"년"+month+"월"+"<caption>";
str += "<thead>";
for (var day of days){
    str += "<th>"+day+"</th>"
}
str += "</thead>";
str += "<tbody>";
str += "<tr>";
for(var i = 0; i<thisMonthDay; i++){
    str += "<td></td>";
}

var lastDay = getLastDate(year,month);
for (var i = 1; i <= lastDay; i++){
    if( i == todate){
        str += "<td onclick='clickFnc(event)' class='active'>"+ i +"</td>";
    }else{
        str += "<td onclick='clickFnc(event)'>"+ i +"</td>";
    }
    // str +="<td>"+i+"</td>";
    if ((i + thisMonthDay) % 7 == 0){
        str += "</tr><tr>";
    }
}
str += "</tr>";
str += "</tbody>";
str += "</table>";

window.document.write(str);
}
function getLastDate(year,month){
    var result = -1;
    switch(month){
        case 1:
        case 3:
        case 5:    
        case 7:
        case 8:
        case 10:
        case 12:    
            result = 31;
            break;
        case 2:
            result = getYunYear(year)? 29 : 28;
            break;
        case 4:
        case 6:
        case 9:
        case 11:    
            result = 30;
            break; 
        default:
            result = 30;       
    }
    return result;
}//end of getLastDate()

function getYunYear(year){
    //4로나눠지고 400으로나눠진다
    if(year%4 ==0 && year%400==0 ){
        return true;
    }else if(year%100 == 0){
        return false;
    }
}
function clickFnc(e){ //onclick event 를 e매개변수로 받음
    console.log(this);
    window.console.log(e.target.textContent);//this->window객체
    window.alert(e.target.textContent+"를 선택했습니다");
}

//object 는 값을 가지고 속성(필드)
//object 는 기능 가지고 메소드(메소드)


var obj ={
    name:"홍길동",
    age: 15,
    getInfo: function(){
        return "이름은 " + this.name +", 나이는" + this.age 
    }
}
console.log(obj.getInfo());