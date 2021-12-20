<%@page import="com.bread.vo.BreadMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>memberInfo.jsp</title>
</head>

<body>
	<c:choose>
		<c:when test="${sessionScope.id == null }">
			<c:redirect url="login.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
			<h1>내정보보기</h1>
			<fieldset>
				<table>
					<tr>
						<th>아이디: </th>
						<td>${member.id }</td>
					</tr>
					<tr>
						<th>비밀번호: </th>
						<td>${member.passwd }</td>
					</tr>
					<tr>
						<th>이름: </th>
						<td>${member.name }</td>
					</tr>
					<tr>
						<th>이메일: </th>
						<td>${member.mail }</td>
					</tr>
				</table>
				<input type='button' value='탈퇴하기' onclick="location.href='memberDelete.do?id=${member.id }'">
				<input type='button' value='돌아가기' onclick="location.href='index.jsp'">
			</fieldset>
		</c:otherwise>
	</c:choose>
</body>

</html>