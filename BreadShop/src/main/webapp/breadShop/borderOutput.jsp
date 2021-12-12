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
				<td><%=vo.getBorderWriter() %></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><%=vo.getBorderTitle() %></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows='10' cols='60' readonly="readonly"><%=vo.getBorderContent() %></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button onclick="location.href='borderUpdate.jsp'">수정</button>&nbsp;&nbsp;
					<button onclick="location.href='borderDelete.do?borderId=<%=vo.getBorderId() %>'">삭제</button>&nbsp;&nbsp;
					<button onclick="location.href='borderList.jsp'">목록</button>&nbsp;&nbsp;
				</td>
			</tr>
		</table>
	<form action='../commentInsert.do’' method='get'>
		<input type="hidden" name="no" value="<%=vo.getBorderId()%>">
		<table border='1'>
			<tr>
				<th colspan=”2” align=”left”>댓글</th>
			</tr>
			<tr>
				<td><textarea row=’2’ cols=’20’ name=’commentContent’’></textarea></td>
				<td><input type="submit" value="등록"></td>
			</tr>
			<tr>
				<td><%=vo1.getCommentWriter() %></td>
				<td><%=vo1.getCommentContent() %></td>
				<td><%=vo1.getCommentDay() %></td>
				<td><input type='button' value="삭제"></td>
			</tr>
		</table>
	</form>
		
</body>
</html>