<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<%
		String id = (String) session.getAttribute("id");
		if(id == null){
			response.sendRedirect("login.jsp");
		} else {
	%>	
		<h2><%=session.getAttribute("name") %>님, 환영합니다~~!</h2>
		<a href="Logout.do">로그아웃</a><br>
	    <a href='member/memberInput.jsp'>회원등록</a><br>
	    <a href='memberList.do'>회원목록</a><br><!-- memberList.do, memberListControll, memberList.jsp -->
		<a href='member/memberSearch.jsp'>회원검색</a><br>
		<a href='member/memberUpdate.jsp'>회원수정</a><br>
		<a href='member/memberDelete.jsp'>회원삭제</a><br>
	<% 	
		}
	%>
	
	
	<%@ include file="footer.jsp" %>
</body>
</html>