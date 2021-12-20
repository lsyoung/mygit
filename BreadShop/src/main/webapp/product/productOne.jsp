<%@page import="com.bread.vo.BreadProductVO"%>
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
	<%
	BreadProductVO vo = (BreadProductVO) request.getAttribute("productOne");
	
	%>
		
		<div class="container">
			<div class="container-head">
			<img src="upload/<%=vo.getProductImage() %>" width="200" border="0" /> 
			</div>
			
			<div class="container-body">
				<h1><%=vo.getProductName() %></h1>
					<%=vo.getProductPrice() %>
				<div>
					<%
					for(int i=0;i<vo.getProductGrade();i++){
						
					%>	
						<div class='full-star'></div>
					<%
					}
					
					if(vo.getProductGrade()-(int)vo.getProductGrade()>0){
					%>
						<div class='half-star'></div>
					<%
					}
					%>
				</div>
			</div>
			
			<div class="container-footer">
				<form action="cartInsert.do" method="get">
					<!-- 필요한 값 String memberId, String productId, int cartCount -->
					cartCount : <input type="text" name="cartCount" value='1'>
					memberId : <input type="text" name="memberId" value='${sessionScope.id }'>
					productId : <input type="text" name="productId" value='<%=vo.getProductId()%>'>
					uri :  <input type='text' name='uri' value='<%= request.getServletPath() %>'>
	
					<input type="submit" value="장바구니 추가">
				</form>
			</div>
		</div>
</body>
</html>