<%@page import="com.dev.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>
	<c:choose>
		<c:when test="${sessionScope.id == null }">
			<c:redirect url="login.jsp"></c:redirect>
		</c:when>
		<c:otherwise>
			<!-- <h2session.getAttribute("name")e") %>님, 환영합니다~~!</h2> -->
			<h2>${sessionScope.name}님,환영합니다.</h2>
			<a href="Logout.do">로그아웃</a><br>
			<a href='member/memberInput.jsp'>회원등록</a><br>
			<a href='memberList.do'>회원목록</a><br>
			<!-- memberList.do, memberListControll, memberList.jsp -->
			<a href='member/memberSearch.jsp'>회원검색</a><br>
			<a href='member/memberUpdate.jsp'>회원수정</a><br>
			<a href='member/memberDelete.jsp'>회원삭제</a><br>
		</c:otherwise>
	</c:choose>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>