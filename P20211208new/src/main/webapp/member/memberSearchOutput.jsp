<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberSearchOutput.jsp</title>
</head>
<body>
	<%! public String concat(String a, String b){
		return a + ", " +b;
	}
	%>
	<%
	MemberVO vo = (MemberVO) request.getAttribute("member");
	%>
	<a href='index.jsp'>첫 페이지로 이동</a>
	<h2>회원 상세 정보</h2>
	<%
	if (vo == null) {
	%>
	<h3>조회된 정보가 없습니다.</h3>
	<%
	} else {
	%>
	<table>
		<tr>
			<th>회원아이디</th>
			<td><%=concat("아이디는 ", vo.getId()) %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=vo.getPasswd()%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=vo.getName()%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=vo.getMail()%></td>
		</tr>
	</table>
	<%
	}
	%>

</body>
</html>