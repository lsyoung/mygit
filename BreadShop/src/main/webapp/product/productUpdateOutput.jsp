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

	%>
	<table>
		<tr>
			<th>상품번호</th>
			<%-- <td><%=request.getAttribute("update_id") %></td> --%>
			<td>${product.productId}</td>
		</tr>
		<tr>
			<th>상품명</th>
			<%-- <td><%=request.getAttribute("update_name")%></td> --%>
			<td>${product.productName}</td>
		</tr>
		<tr>
			<th>상품 설명</th>
			<td>${product.productDesc}</td>
		</tr>
		<tr>
			<th>상품가격</th>
			<td>${product.productPrice}</td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td>${product.productImage}</td>
		</tr>
		<tr>
			<th>상품개수</th>
			<td>${product.productInventory}</td>
		</tr>
		<tr>
			<th>상품평점</th>
			<td>${product.productGrade}</td>
		</tr>


	</table>

</body>
</html>