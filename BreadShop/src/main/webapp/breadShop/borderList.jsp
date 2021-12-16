<%@page import="com.bread.dao.BreadBorderDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.bread.vo.BreadBorderVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>borderList.jsp</title>
</head>
<%
BreadBorderDAO dao = new BreadBorderDAO();
%>
<body>
	<button onclick="location.href='breadShop/borderInsert.jsp'">글쓰기</button>
	<table border="1">
		<thead>
			<tr>
				<th>No</th>
				<th>Title</th>
				<th>Name</th>
			</tr>
		</thead>
			<%
				List<BreadBorderVO> list = (List<BreadBorderVO>) request.getAttribute("borderList");
				for(BreadBorderVO vo : list) {
			%>	
		<tbody>
			<tr>
				<td><a href="#" id="<%=vo.getBorderId()%>"><%=vo.getBorderId()%></a></td>
				<td><%=vo.getBorderTitle() %></td>
				<td><%=vo.getBorderWriter()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<form name='breadshop' action='borderOne.do' method='post'>
		<input type='hidden' name='borderId'>
	</form>
	<script>
		let btns = document.querySelectorAll('td>a');
		console.log(btns);
		for(let i=0; i<btns.length; i++) {
			btns[i].addEventListener('click', function(e) {
				e.preventDefault();
				let id = e.target.id;
				console.log(id)
				document.forms.breadshop.borderId.value = id;
				document.forms.breadshop.submit();
			});
		}
	</script>
</body>
</html>