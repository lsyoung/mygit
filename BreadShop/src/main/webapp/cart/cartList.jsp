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
	<section>
		<table>
			<c:forEach var="cart" items="${requestScope.cartList }">
				<tr>
					<td>${cart.cartId }</td>
					<td>${cart.productId }</td>
					<td>${cart.cartPrice }</td>
					<td>${cart.cartCount }</td>
					<td>${cart.productName }</td>
					<td>${cart.productImage }</td>
				</tr>
			</c:forEach>
		</table>
	</section>

</body>
</html>