<%@page import="com.bread.vo.BreadProductVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productList.jsp</title>
</head>

<body>
	<!-- 전체 컨테이너 -->
	<section>
		

		<c:forEach var="prod" items="${requestScope.productList }">
		
			<div class="container">
				<div class="container-head">
					<a href='#' id='${prod.productId}' >
					
						<!--  jsp말고 do로 가야함!!!!!!!!!!!!! 이거만 수정하면 될거같음...  -->
						<img src="upload/${prod.productImage}" width="200" border="0" /> 
					<a href='productSearchOutput.jsp?productName=${pord.productName}' >
					<!--  jsp말고 do로 가야함!!!!!!!!!!!!! 이거만 수정하면 될거같음...  -->
					<img src="images/${prod.productImage}" width="200" border="0" /> 
					</a><br>
				</div>
				<div class="container-body">
					<h1>${prod.productName}</h1>
					${prod.productPrice}
				</div>
				<div class="container-footer">
					<form action="cartInsert.do" method="get" id='cartLink' name='link'>
					<!-- 필요한 값 String memberId, String productId, int cartCount -->
						<input type="text" name="cartCount" value='1'>
						<input type="text" name="memberId" value='${sessionScope.id }'>
						<input type="text" name="productId" value='${prod.productId }'>
						
						cartCount : <input type="text" name="cartCount" value='1'>
						memberId : <input type="text" name="memberId" value='${sessionScope.id }'>
						productId : <input type="text" name="productId" value='${prod.productId }'>
						<input type="submit" value="장바구니 추가">
					</form>
				</div>
			</div>
		</c:forEach>
		<form name='breadshop' action='productOne.do' method='post'>
			<input type='text' name='productId'>
		</form>
	</section>
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