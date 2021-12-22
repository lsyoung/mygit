<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

.cartList{
	 border : #888888 2px solid;  
	border-collapse:collapse;
	padding: 1px;
}

</style>
</head>
<body>

	<jsp:include page="../head.jsp"></jsp:include>
	<section>
	<%
	int count=1;
	%>
		<c:choose>
			<c:when test="${sessionScope.id eq null }">
				<script>alert('로그인 후 사용해 주세요'); history.back();</script>
			</c:when>
			
			<c:otherwise>
				<table class="cartList" border="">
					<tr>
						<th>번호</th>
						<th>상품번호</th>
						<th>상품명</th>
						<th>상품이미지</th>
						<th>상품개수</th>
						<th>가격</th>
						<th>삭제</th>
					</tr>
					<c:forEach var="cart" items="${requestScope.cartList }">
						<tr>
							<td><%=count++ %></td>
							<td>${cart.productId }</td>
							<td>${cart.productName }</td>
							<td><img src="upload/${cart.productImage }" width="200" border="0" /> </td>
							<td>${cart.cartCount }</td>
							<td>${cart.cartPrice }</td>	
							<td> <form action="cartDelete.do" method="get">
								<input type='text' name='cartId' value='${cart.cartId }'>
								<input type='submit' value='삭제'>
							 </form> </td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	</section>

</body>
</html>