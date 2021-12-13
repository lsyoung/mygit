<%@page import="java.util.List"%>
<%@page import="com.bread.vo.BreadBorderVO"%>
<%@page import="com.bread.vo.BreadBorderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>borderList.jsp</title>
</head>
<body>
	<button onclick="location.href='borderInsert.jsp'">글쓰기</button>
		<form id='breadshop' action='../borderOne.do' method='post'>
		<input type='hidden' name='borderId'>
		<table border="1">
			<thead>
				<tr>
					<th>No</th>
					<th>Title</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<BreadBorderVO> list = (List<BreadBorderVO>) request.getAttribute("borderList");
				for(BreadBorderVO vo : list) {
				%>
				<tr>
					<td><a href="borderOutput.jsp?borderId=<%=vo.getBorderId()%>"><%=vo.getBorderId()%></a></td>
					<td><%=vo.getBorderTitle()%></td>
					<td><%=vo.getBorderWriter()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</form>
</body>
</html>