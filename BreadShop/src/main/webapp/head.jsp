<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<style type="text/css">
</style>

</head>
<body>
	<header>
		<div class="header">
			<div>
			줄 세개
			</div>
			<div>
				로고
			</div>
			<div>
				<a href='login.do'>로그인</a> | <a href='breadShop/memberInput.jsp'>회원가입</a> | 
				<form action='memberInfo.do' method='get'>
					<input type='hidden' name='id' value='${sessionScope.id }'>
					<input type='submit' value='내정보보기'>
				</form>
			</div>
			<div>
				<a href='productList.do'>전체 상품 조회</a> | <a href='borderList.do'>후기</a> | 
				<form action="cartList.do" method="get">
					<input type='hidden' name='memberId' value=${sessionScope.id }> <br>
					<input type='submit' value='장바구니 검색'>
				</form> 
			</div>
		</div>
	</header>

</body>
</html>