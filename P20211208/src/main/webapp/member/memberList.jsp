<%@page import="java.util.List"%>
<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../menu.jsp" %>
	<a href='index.jsp'>첫 페이지로</a>
	<h2>회원목록</h2>
	<table border='1'>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
			for (MemberVO vo : list) {
			%>
			<tr>
				<td><%=vo.getId()%></td>
				<td><%=vo.getPasswd()%></td>
				<td><%=vo.getName()%></td>
				<td><%=vo.getMail()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<%@ include file="../footer.jsp" %>
</body>
</html>