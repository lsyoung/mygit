<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<li><a href='<%=request.getContextPath()%>/member/memberInput.jsp'>회원등록</a></li>
		<li><a href='<%=request.getContextPath()%>/member/memberSearch.jsp'>회원조회</a></li>
		<li><a href='<%=request.getContextPath()%>/member/memberUpdate.jsp'>회원수정</a></li>
	</ul>

</body>
</html>