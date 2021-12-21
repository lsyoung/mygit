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
<style>
	* {
		margin: 0;
		padding: 0;
		list-style: none;
	}

	.info {
		width: 500px;
		margin: auto;
		margin-top: 50px;
	}

	.my_info {
		width: 500px;
		margin-top: 10px;
	}

	.my_main {
		height: 300px;
	}

	.my_main>tr>th {
		font-size: 22px;
		text-align: right;
		padding-right: 10px;
	}

	.my_main>tr>td {
		font-size: 20px;
	}

	.my_button {
		margin-top: 20px;
	}

	.my_button>input[type=button] {
		width: 100px;
		height: 50px;
		position: relative;
		left: 150px;
	}
</style>

<body>
	<div class="info">
		<c:choose>
			<c:when test="${sessionScope.id == null }">
				<c:redirect url="login.jsp"></c:redirect>
			</c:when>
			<c:otherwise>
				<h1 align="center">내정보보기</h1>
				<table class="my_info">
					<tbody class="my_main">
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
					</tbody>
				</table>
				<div class="my_button">
					<input type='button' value='탈퇴하기' onclick="location.href='memberDelete.do?id=${member.id }'">
					<input type='button' value='돌아가기' onclick="location.href='index.jsp'">
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>

</html>