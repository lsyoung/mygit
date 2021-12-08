<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
<h3>다음과 같은 에러가 발생했습니다.</h3>
<h4>에러타입: <%=exception.getClass().getName() %></h4>
<h4>에러내용: <%=exception.getMessage() %></h4>
</body>
</html>