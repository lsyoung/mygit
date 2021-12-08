<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="../error.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력정보</title>
</head>
<body>
<%
		String id = (String) session.getAttribute("id");
		if(id == null){
			response.sendRedirect("../login.jsp");
		} else {
	%>
	     <h2><%=session.getAttribute("name") %>님, 환영합니다.</h2>
         <!-- 입력.jsp-> 컨트롤러 -> 출력jsp -->
         <a href='../index.jsp'>첫 페이지로 이동</a>
	     <form action='../memberInsert.do' method='get'>
			ID: <input type='text' name='id'><br>
			비밀번호: <input type='password' name='passwd'><br>
			이름: <input type='text' name='name'><br>
			E-mail: <input type='email' name='mail'><br>
			<input type='submit' value='가입'> 
         </form>
	<% 
		} 
	%>
	
</body>
</html>