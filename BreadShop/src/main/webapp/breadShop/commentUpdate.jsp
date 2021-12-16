<%@page import="com.bread.vo.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commentUpdate.jsp</title>
</head>
<body> 
	<%
	CommentVO vo = (CommentVO) request.getAttribute("comment");
	%>
	<script>
		window.open("commentUpdateForm.do?commentNo=<%=vo.getCommentNo()%>",
				   "updateForm","width=570, height=350, resizable = no, scrollbars = no");
	</script>
	

</body>
</html>