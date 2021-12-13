<%@page import="java.util.List"%>
<%@page import="com.bread.vo.BreadBorderVO"%>
<%@page import="com.bread.vo.BreadBorderDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<c:forEach var="vo" items="${requestScope.borderList }">
					<tr>
						<td><a href='borderOutput.jsp?borderId=${vo.borderId }'>${vo.borderId }</a></td>
						<td>${vo.borderTitle }</td>
						<td>${vo.borderWriter }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
</body>
</html>
