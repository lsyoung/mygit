<%@page import="com.bread.vo.BreadProductVO"%>
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
	BreadProductVO vo = (BreadProductVO) request.getAttribute("product");
	%>
	
	
	
	<h1>입력 확인</h1>
	<h3>상품번호 : <%=vo.getProductId() %></h3>
	<h3>상품 명 : <%=vo.getProductName() %></h3>
	<h3>상품 설명 : <%=vo.getProductDesc() %></h3>
	<h3>상품 가격 : <%=vo.getProductPrice() %></h3>
	<h3>상품 이미지 : <%=vo.getProductImage() %></h3>
	<h3>상품 별점 : <%=vo.getProductGrade() %></h3>
	<h3>별점을 남긴 고객의 수 : <%=vo.getProductCount()%></h3>
	<h3>상품 개수 : <%=vo.getProductInventory() %></h3>
	
	
	
</body>
</html>