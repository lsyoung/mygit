<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
	<a href='../index.jsp'>첫 페이지로 이동</a>
	<h2>회원검색</h2>
	<form action='../memberSearch.do' method='get'>
	ID: <input type='text' name='id'><br>
	<input type='hidden' name='job' value='update'>
	<input type='submit' value='검색'>
	</form>
</body>
</html>