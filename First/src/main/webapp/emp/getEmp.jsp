<%@page import="com.edu.vo.EmployeeVO"%>
<%@page import="com.edu.service.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("eid");
	EmpService service = new EmpService();
	EmployeeVO vo = service.getOne(id);
%>
	<h3>사원상세정보</h3>
	<table border='1'>
		<tr>
			<th>사원번호</th>
			<td><%=vo.getEmployeeId()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=vo.getFirstName()+ ", "+vo.getLastName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type='text' value=<%=vo.getEmail() %> name='email'></td>
		</tr>
		<tr>
			<th>급여</th>
			<td><input type='number' value=<%=vo.getSalary() %> name='salary'></td>
		</tr>
		<tr>
			<th>입사일자</th>
			<td><%=vo.getHireDate() %></td>
		</tr>
	</table>
	<div><a href='../deleteEmp.do?eid=<%=vo.getEmployeeId()%>'>삭제</a></div>
	<div><a href='' id='updateEmp'>수정</a></div>
	<div><a href='../emplist.do'>목록으로가기</a></div>
	
	<script>
		document.getElementById('updateEmp').addEventListener('click', function(e){
			e.preventDefault();
			var email = document.querySelector('input[name="email"]').value;
			var salary = document.querySelector('input[name="salary"]').value;
			
			var xhtp = new XMLHttpRequest();
			xhtp.open('post', '../updateEmp.do');
			xhtp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhtp.send('eid=<%=vo.getEmployeeId()%>&email='+email+'&salary='+salary);
			xhtp.onload = function() {
				location.href = '../emplist.do';
			}
		})
		
		

	</script>
</body>
</html>