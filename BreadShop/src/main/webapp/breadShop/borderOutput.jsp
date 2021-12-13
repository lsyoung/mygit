
<%@page import="com.bread.vo.BreadBorderDAO"%>
<%@page import="com.bread.service.BreadBorderService"%>
<%@page import="com.bread.vo.CommentVO"%>
<%@page import="com.bread.vo.BreadBorderVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>borderOutput.jsp</title>
</head>
<body>
	<%
	BreadBorderVO vo = (BreadBorderVO) request.getAttribute("border");
	%>
	<table border='1'>
		<tr>
			<th>NAME</th>
			<td><%=vo.getBorderWriter()%></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=vo.getBorderTitle()%></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows='10' cols='60' readonly="readonly"><%=vo.getBorderContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type='button' value='수정' onclick="location.href='breadShop/borderUpdate.jsp?borderId=<%=vo.getBorderId()%>'">
				<input type='button' value='삭제' onclick="location.href='borderDelete.do?borderId=<%=vo.getBorderId()%>'">
				<input type='button' value='목록' onclick="location.href='breadShop/borderList.jsp'">
			</td>
		</tr>
	</table>

</body>
</html>