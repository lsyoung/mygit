<%@page import="com.bread.vo.BreadBorderVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>borderUpdate.jsp</title>
</head>
<body>
	<%
	BreadBorderVO vo = (BreadBorderVO) request.getAttribute("border");
	%>
	<form action='borderUpdate.do' method='get'>
		<input type='hidden' name='borderId' value='<%=vo.getBorderId()%>'>
		<table border='1'>
			<tr>
				<th>NAME</th>
				<td><%=vo.getBorderWriter()%></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type='text' name='borderTitle' value='<%=vo.getBorderTitle()%>'></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows='10' cols='60' name='borderContent'><%=vo.getBorderContent()%></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type='submit' value='수정'> 
				<input type='button' value='목록' onclick="location.href='borderList.do'"></td>
			</tr>
		</table>
	</form>

</body>
</html>