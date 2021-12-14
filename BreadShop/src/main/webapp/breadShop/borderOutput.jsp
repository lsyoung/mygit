
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
	CommentVO vo1 = (CommentVO) request.getAttribute("comment");
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
				<input type='button' value='수정' onclick="location.href='borderUpdateForm.do?borderId=<%=vo.getBorderId()%>'">
				<input type='button' value='삭제' onclick="location.href='borderDelete.do?borderId=<%=vo.getBorderId()%>'">
				<input type='button' value='목록' onclick="location.href='borderList.do'">
			</td>
		</tr>
	</table>

	<form action='' method='post'>
	<h3>댓글</h3>
	<input type='hidden' name='borderNo' value='<%=vo1.getBorderNo()%>'>
			<textarea cols='40' rows='2' name='commentContent'></textarea>
			<input type="submit" value="댓글등록" onclick='commentList.do'>
			<table>
		
			</table>
	</form>

</body>
</html>