<%@page import="com.bread.vo.BreadMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo.jsp</title>
</head>
<body>
	<%
		BreadMemberVO vo = (BreadMemberVO) request.getAttribute("member");
	%>
	<h1>내정보보기</h1>
		<fieldset>
		<table>
			<tr>
				<th>아이디: </th>
				<td><%=vo.getId() %></td>
			</tr>
			<tr>
				<th>비밀번호: </th>
				<td><%=vo.getPasswd() %></td>
			</tr>
			<tr>
				<th>이름: </th>
				<td><%=vo.getPasswd() %></td>
			</tr>
			<tr>
				<th>이메일: </th>
				<td><%=vo.getMail()%></td>
			</tr>
		</table>
		<input type='button' value='탈퇴하기' onclick="location.href='memberDelete.do?id=<%=vo.getId() %>'">
		<input type='button' value='돌아가기' onclick="location.href='index.jsp'">
	</fieldset>
</body>
</html>