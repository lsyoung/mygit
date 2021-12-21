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
		border: solid 1px;
	}


</style>

<body>
	<div class="member">
		<h1 align="center">회원가입완료</h1>
		<ul>
			<div class="member_info">
				<li><span>아이디</span><br><span>${member.id }</span></li>
				<li><span>비밀번호</span><br>${member.passwd }</li>
				<li><span>이름</span><br>${member.name }</li>
				<li><span>이메일</span><br>${member.mail }</li>
			</div>
		</ul>
		<input type='button' value='로그인하기' onclick="location.href='login.do'">
	</div>
</body>

</html>