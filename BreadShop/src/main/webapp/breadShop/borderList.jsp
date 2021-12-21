<%@page import="com.bread.dao.BreadBorderDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.bread.vo.BreadBorderVO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>borderList.jsp</title>
	<style>
		*{
			margin: 0;
			padding: 0;
		}
		#home {
			position: relative;
			left: 85%;
			text-decoration: none;
			color: black;
		}

		.border {
			width: 800px;
			margin: auto;
			margin-top: 50px;
		}

		#bList {
			margin-top: 20px;
		}
	</style>
</head>

<body>
	<div class='border'>
		<a href='index.jsp' id='home'>홈으로가기</a>
		<table id="bList" width="800" border="3" bordercolor="lightgray">
			<c:choose>
				<c:when test="${sessionScope.id == null }">
					<c:redirect url="login.jsp"></c:redirect>
				</c:when>
				<c:otherwise>
					<thead>
						<tr align='center'>
							<th>No</th>
							<th>Title</th>
							<th>Name</th>
						</tr>
					</thead>
					<tbody align='center'>
						<c:forEach var="item" items="${requestScope.borderList }">
							<tr>
								<td><a href="#" id="${item.borderId }">${item.borderId }</a></td>
								<td>${item.borderTitle }</td>
								<td>${item.borderWriter }</td>
							</tr>
						</c:forEach>
						<tr>
							<td colspan='3' align='right'>
								<input type='button' value='글쓰기' onclick="location.href='breadShop/borderInsert.jsp'">
							</td>
						</tr>
					</tbody>
		</table>
		</c:otherwise>
		</c:choose>
	</div>
	<form name='breadshop' action='borderOne.do' method='post'>
		<input type='hidden' name='borderId'>
	</form>
	<script>
		let btns = document.querySelectorAll('td>a');
		console.log(btns);
		for (let i = 0; i < btns.length; i++) {
			btns[i].addEventListener('click', function (e) {
				e.preventDefault();
				let id = e.target.id;
				console.log(id)
				document.forms.breadshop.borderId.value = id;
				document.forms.breadshop.submit();
			});
		}
	</script>
</body>

</html>