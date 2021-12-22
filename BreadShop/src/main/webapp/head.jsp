<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
	<title>Insert title here</title>
	<style type="text/css">
		* {
			font-family: sans-serif;
		}

		header {
			background-color: #023586;
			height: 170px;
		}

		.left {
			float: left;
			color: white;
			padding: auto;
		}

		.fa-bars {
			margin: 60px;
		}

		.right {
			float: right;
		}

		.member>a,
		.menu>a,
		.member,
		.menu {
			text-decoration: none;
			color: white;
		}

		.mainLogo {
			float: left;
			padding: 60px;
		}

		.member {
			margin: 10px 10px;
			font-size: medium;
		}

		.menu {
			margin: 10px 10px;
			font-size: x-large;
			font-weight: bold;

		}

		.button {
			border: 0;
			outline: 0;
			background-color: #023586;
			color: white;
		}

		form {
			display: inline;
		}

		.hide {
			background-color: white;
			display: none;
			color: #888888;
		}

		.slideMenu {
			list-style: none;
			padding-left: 0px;

		}

		.slideMenu:hover .hide {
			list-style: none;
			padding-left: 0px;
			display: block;
			position: absolute;
		}
	</style>



</head>

<body>
	<header>
		<div class="header">
			<div class="left">
				<li class="slideMenu">
					<a><i class='fas fa-bars' style='font-size: 36px'></i></a>


					<c:choose>
						<c:when test="${sessionScope.id eq 'admin' }">
							<ul class="hide">
								<li><a href='logout.do'>로그아웃</a></li>
								<li><a href='product/productInput.jsp'>상품 입력</a></li>
								<li><a href='product/productUpdate.jsp'>상품 업데이트</a></li>
								<li><a href='product/productDelete.jsp'>상품 삭제</a></li>
								<li><a href='product/productSearchList.jsp'>상품 조회</a></li>
								<li><a href='productList.do'>list...</a></li>
							</ul>
						</c:when>
						<c:otherwise>
							<ul class="hide">
								<li>
									<c:choose>
										<c:when test="${sessionScope.id eq null }">
											<a href='login.do'>로그인</a>
											&nbsp; &nbsp;| &nbsp; &nbsp;
											<a href='breadShop/memberInput.jsp'>회원가입</a>

										</c:when>
										<c:otherwise>
											<a href='logout.do'>로그아웃</a>
											&nbsp; &nbsp;| &nbsp; &nbsp;
											<form action='memberInfo.do' method='get'>
												<input type='hidden' name='id' value='${sessionScope.id }'>
												<input type='submit' value='내정보보기'>
											</form>
											<form action="cartList.do" method="get">
												memberID : <input type='text' name='memberId' value=${sessionScope.id }>
												<br>
												<input type='submit' value='장바구니 검색'>
											</form>
										</c:otherwise>
									</c:choose>
								</li>

								<li><a href='productList.do'>list...</a></li>
								<li><a href='product/productSearchList.jsp'>searchList...</a></li>
								<li><a href='borderList.do'>게시판</a></li>
								<li></li>
								<li></li>
								<li></li>
							</ul>
						</c:otherwise>
					</c:choose>
			</div>
			<div> <a href="index.jsp"><img alt="" src="upload/breadMainLogo.jpg" width="300" class="mainLogo"></a>
			</div>
		</div>

		<div class="right">
			<div class="member">
				<c:choose>
					<c:when test="${sessionScope.id eq null }">
						<a href='login.do'>로그인</a>
					</c:when>
					<c:otherwise>
						<a href='logout.do'>로그아웃</a>
					</c:otherwise>
				</c:choose>
				&nbsp; &nbsp;| &nbsp; &nbsp; <a href='breadShop/memberInput.jsp'>회원가입</a>
				&nbsp; &nbsp; |<form action='memberInfo.do' method='get'>
					<input type='hidden' name='id' value='${sessionScope.id }'>
					<input type='submit' value='내정보보기' class="button member">
				</form>
			</div>
			<div class="menu">
				<a href='productList.do'>전체 상품 조회</a> &nbsp; |&nbsp; <a href='borderList.do'>후기</a>
				&nbsp; |<form action="cartList.do" method="get">
					<input type='hidden' name='memberId' value=${sessionScope.id }>
					<br> <input type='submit' value='장바구니 검색' class="button menu">
				</form>
			</div>
		</div>
		</div>
	</header>

</body>

</html>