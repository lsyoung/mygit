<%@page import="com.bread.vo.BreadBorderVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>borderUpdateOutput.jsp</title>
</head>
<style>
	* {
		margin: 0;
		padding: 0;
	}

	.border {
		width: 800px;
		margin: auto;
		margin-top: 50px;
	}

	#detailBoard {
		margin-bottom: 10px;
	}

	tr>td>textarea {
		width: 700px;
		height: 280px;
	}
</style>

<body>
	<%
	BreadBorderVO vo = (BreadBorderVO) request.getAttribute("border");
	%>
	<div class='border'>
		<table id="detailBoard" width="800" border="3" bordercolor="lightgray">
			<tr>
				<th>NAME</th>
				<td><%=vo.getBorderWriter()%></td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><%=request.getAttribute("newTitle") %></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows='12' cols='88' readonly="readonly"><%=request.getAttribute("newContent")%></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type='button' value='목록' onclick="location.href='borderList.do'">
				</td>
			</tr>
		</table>
	</div>
</body>

</html>