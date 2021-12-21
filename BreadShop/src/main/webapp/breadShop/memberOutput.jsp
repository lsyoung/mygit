<%@page import="com.bread.vo.BreadMemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>memberOutput.jsp</title>
</head>
<style>
	* {
		margin: 0;
		padding: 0;
		list-style: none;
	}

	body {
		background-color: #F5F6F7;
	}

	.member {
		width: 500px;
		margin: auto;
		margin-top: 50px;
	}

	.member_info {
		width: 500px;
		margin-top: 10px;
	}

	.member_main {
		height: 300px;
	}

	.member_main>tr>th {
		font-size: 22px;
		text-align: center;
	}

	.member_main>tr>td {
		font-size: 20px;
	}

	.login_button {
		margin-top: 20px;
	}
	.login_button > input[type=button]{
		width: 100px;
		height: 50px;
		position: relative;
		left: 200px;
	}
</style>

<body>
	<div class="member">
		<h1 align="center">회원가입완료</h1>
		<table class="member_info">
			<tbody class="member_main">
				<tr>
					<th>아이디</th>
					<td>${member.id }</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>${member.passwd }</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>${member.name }</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${member.mail }</td>
				</tr>
			</tbody>
		</table>
		<div class="login_button"> 
			<input type='button' value='로그인하기' onclick="location.href='login.do'">
		</div>
	</div>
</body>

</html>