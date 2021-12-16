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
	
	
	
	<h3><%=vo.getProductName() %></h3>
	<div>
		<div><%=vo.getProductImage() %></div>
		<div>
			<div><%=vo.getProductDesc() %></div>
			<div><%=vo.getProductPrice() %></div>
			<div><%=vo.getProductGrade() %></div>
			<div><%=vo.getProductCount() %></div>
			<div><%=vo.getProductInventory() %></div>
			<!-- count를 구매자 수로 받아도 될거같음 일단 넣어는 본다... 나중에 수정하든가 하자 -->
		</div>
	</div>
	
	<div>장바구니...</div>
	
	<h3>수정</h3>
	<form action="productUpdate.do" method="get" >
		상품명 : <input type='text' name='name' value='<%=vo.getProductId()%>'> <br>
		<input type='hidden' name ='job' value='update'>
		<input type='submit' value='수정'>
	</form>
	

</body>
</html>