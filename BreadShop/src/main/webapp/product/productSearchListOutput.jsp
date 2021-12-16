<%@page import="com.bread.vo.BreadProductVO"%>
<%@page import="java.util.List"%>
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
	List<BreadProductVO> list = (List<BreadProductVO>) request.getAttribute("productList");
	if (list.size() == 0) {
	%>
	<h3>검색 결과가 없습니다</h3>
	<%
	} else {
	for (BreadProductVO vo : list) {
	%>


	<%-- <img alt="productOutput.jsp?productImage=<%=vo.getProductImage()%>"
			src=""> --%>


	<div class="container">
		<div class="container-head">
			<a
				href='productSearchOutput.jsp?productName=<%=vo.getProductName()%>'>
				<!--  jsp말고 do로 가야함!!!!!!!!!!!!! 이거만 수정하면 될거같음...  --> <img
				src="images/<%=vo.getProductImage()%>" width="200" border="0" />
			</a><br>
		</div>
		<div class="container-body">
			<h1><%=vo.getProductName()%></h1>
			<%=vo.getProductPrice()%>
		</div>
		<div class="container-footer">
			<div class="add-cart">장바구니 추가</div>
		</div>

		<h3>상품업데이트</h3>
		<form action="productSearch.do" method="get">
			상품번호 : <input type='text' name='name' value='<%=vo.getProductId()%>'>
			<br> <input type='hidden' name='job' value='update'> <input
				type='submit' value='수정'>
		</form>

		<h3>상품 삭제</h3>
		<form action="productSearch.do" method="get">
			상품번호 : <input type='text' name='name' value='<%=vo.getProductId()%>'>
			<br> <input type='hidden' name='job' value='delete'> <input
				type='submit' value='삭제'>
		</form>


	</div>




	<%
	}
	}
	%>


</body>
</html>