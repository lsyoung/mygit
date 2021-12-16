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


	<table>
		<tr>
			<th>상품번호</th>
			<td><%=request.getAttribute("update_id")%></td>
		</tr>
		<tr>
			<th>상품명</th>
			<td><%=request.getAttribute("update_name")%></td>
		</tr>
		<tr>
			<th>상품 설명</th>
			<td><%=request.getAttribute("update_desc")%></td>
		</tr>
		<tr>
			<th>상품가격</th>
			<td><%=request.getAttribute("update_price")%></td>
		</tr>
		<tr>
			<th>상품이미지</th>
			<td><%=request.getAttribute("update_image")%></td>
		</tr>
		<tr>
			<th>상품개수</th>
			<td><%=request.getAttribute("update_inventory")%></td>
		</tr>



	</table>


</body>
</html>