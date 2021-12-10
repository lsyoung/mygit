<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberUpdate.jsp</title>
</head>
<body>
	 <jsp:include page="../menu.jsp"></jsp:include>
	 <c:choose>
	 	<c:when test="${sessionScope.id == null }">
			<c:redirect url="../login.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
		<a href='../index.jsp'>첫 페이지로 이동</a>
		<h2>회원검색</h2>
		<form action='../memberSearch.do' method='get'>
		ID: <input type='text' name='id'><br>
		<input type='hidden' name='job' value='update'>
		<input type='submit' value='검색'>
		</form>
		</c:otherwise>
	 </c:choose>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>