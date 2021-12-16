<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상품검색</h3>
	<form action="../productSearch.do" method="get">
		상품명 : <input type='text' name='name'> <br>
		<input type='hidden' name ='job' value='delete'>
		<input type='submit' value='검색'>
	</form>

</body>
</html>