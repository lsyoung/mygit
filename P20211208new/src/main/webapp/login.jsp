<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
<%@ include file="menu.jsp" %>
	<h2>로그인 화면</h2>
	<form action='login.do' method='post'>
		ID: <input type='text' name='id'><br>
		PW: <input type='password' name='passwd'><br>
		<input type='submit' value='Login'>
	</form>
	<%@ include file="footer.jsp" %>
</body>
</html>