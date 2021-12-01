//createTable.js => 타이틀 배열, 데이터 배열
function createTable(titleAry, dataAry) {
    //tr생성 함수
    function makeRow(obj) {
        var tr = document.createElement('tr');
		tr.setAttribute('id',obj.employeeId);
		//console.log(obj.employeeId);
        titleAry.forEach(field => {
            var td = document.createElement('td');
            td.textContent = obj[field];
            tr.appendChild(td);

        });
        //추가 컬럼
     
        return tr;
    }
    //table작성
    var table = document.createElement('table');
    table.setAttribute('border', '1');
    
    //thead 작성
    var thead = document.createElement('thead');
    var tr = document.createElement('tr');
    thead.appendChild(tr);
    titleAry.forEach(item => {
        var th = document.createElement('th');
        th.textContent = item;
        tr.appendChild(th);
    });
    //지도 표시


    //tbody작성
    var tbody = document.createElement('tbody');
    dataAry.forEach(item => {
        tbody.appendChild(makeRow(item));
    });
    table.append(thead, tbody);

    return table;
}