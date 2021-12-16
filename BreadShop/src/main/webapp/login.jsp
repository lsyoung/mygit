<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>	
	<h2>로그인화면</h2>
	<form action='login.do' method='post'>
		ID: <input type='text' name='id' placeholder='아이디'><br>
		PW: <input type='password' name='passwd' placeholder='비밀번호'><br>
		<input type='submit' value='LOGIN'>
	</form>
</body>
</html>