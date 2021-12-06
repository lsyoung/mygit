<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int num1 = 30;
	int num2 = 50;
	
	int sum = num1 + num2;
	int div = num1 / 2;
%>

<h1>두수의 합 30+50 = <%= sum %></h1>
<h1>나눗셈의 결과 30 / 2 = <%= div %></h1>
</body>
</html>