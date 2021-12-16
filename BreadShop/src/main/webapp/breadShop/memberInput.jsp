<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInput.jsp</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action='../memberinsert.do' method='get'>
		<table>
			<tr>
				<th><p align="right">아이디</p></th>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<th><p align="right">비밀번호</p></th>
				<td><input type='password' name='passwd'></td>
			</tr>
			<tr>
				<th><p align="right">이름</p></th>
				<td><input type='text' name='name'></td>
			</tr>
			<tr>
				<th><p align="right">이메일</p></th>
				<td><input type='email' name='mail'></td>
			</tr>
			<tr>
				<th><p align="right">&nbsp;</p></th>
				<td><input type="submit" value="가입하기"></td>
				<td><input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
</body>
</html>