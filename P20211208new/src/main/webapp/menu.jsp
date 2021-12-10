<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	ul{
		list-style-type: none;
	}
	li {
		display: inline-block;
		width: 100px;
		background-color: yellow;
	}
	
</style>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/member/memberInput.jsp">회원등록</a></li>
		<li><a href="${pageContext.request.contextPath}/memberList.do">회원목록</a></li>
		<li><a href="${pageContext.request.contextPath}/member/memberSearch.jsp">회원조회</a></li>
		<li><a href="${pageContext.request.contextPath}/member/memberUpdate.jsp">회원수정</a></li>
		<li><a href="${pageContext.request.contextPath}/member/memberDelete.jsp">회원삭제</a></li>	
		<c:if test="${sessionScope.id ne null }">
			<li><a href=" ${pageContext.request.contextPath}/Logout.do">로그아웃</a></li>
		</c:if>
	</ul>
</body>
</html>