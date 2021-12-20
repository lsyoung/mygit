<%@page import="com.bread.vo.BreadProductVO"%>
<%@page import="java.util.List"%>
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
			<a href='#' id='<%=vo.getProductId()%>'>
				<!--  jsp말고 do로 가야함!!!!!!!!!!!!! 이거만 수정하면 될거같음...  --> <img
				src="upload/<%=vo.getProductImage()%>" width="200" border="0" />
			</a><br>
		</div>
		<div class="container-body">
			<h1><%=vo.getProductName()%></h1>
			<%=vo.getProductPrice()%>
		</div>
	
		<c:choose>	
			<c:when test="${sessionScope.id eq 'admin' }">
				<div class="adminArea">
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
			</c:when> 
			
			<c:otherwise>
				<div class="container-footer">
					<form action="cartInsert.do" method="get">
						<!-- 필요한 값 String memberId, String productId, int cartCount -->
						<input type="hidden" name="cartCount" value='1'>
						<input type="hidden" name="memberId" value='${sessionScope.id }'>
						<input type="hidden" name="productId" value='<%=vo.getProductId()%>'>
						<input type="submit" value="장바구니 추가">
					</form>
				</div>
			</c:otherwise>
			
		</c:choose>
		<form name='breadshop' action='productOne.do' method='post'>
			<input type='hidden' name='productId'>
		</form>
		
		
		
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
	
	<script>
	
		let btns = document.querySelectorAll('.container-head >a');
		console.log(btns);
		
		for(let i=0;i<btns.length;i++){
			btns[i].addEventListener('click', function(e) {
				e.preventDefault();
				let id = e.target.parentElement.id;
				console.log(id);
				document.forms.breadshop.productId.value = id;
				document.forms.breadshop.submit();
			});
		}
		
		
	</script>


</body>
</html>