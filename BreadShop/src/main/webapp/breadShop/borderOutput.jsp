<%@page import="java.util.List"%>
<%@page import="com.bread.service.BreadBorderService"%>
<%@page import="com.bread.vo.CommentVO"%>
<%@page import="com.bread.vo.BreadBorderVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>borderOutput.jsp</title>
</head>
<style>
	.border {
		width: 800px;
		margin: auto;

	}
</style>

<body>
	<div class='border'>
		<table border='1'>
			<tr>
				<th>NAME</th>
				<td>${sessionScope.id }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>${border.borderTitle }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows='10' cols='60' readonly="readonly">${border.borderContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type='button' value='수정'
						onclick="location.href='borderUpdateForm.do?borderId=${border.borderId }'">
					<input type='button' value='삭제'
						onclick="location.href='borderDelete.do?borderId=${border.borderId }'">
					<input type='button' value='목록' onclick="location.href='borderList.do'">
				</td>
			</tr>
		</table>
		<form action='commentInsert.do' method='post'>
			<h3>댓글</h3>
			<input type='hidden' name='borderNo' value='${border.borderId }'>
			<input type='hidden' name='commentWriter' value='${sessionScope.id }'>
			<textarea cols='50' rows='1' name='commentContent'></textarea>
			<input type='password' name='commentPasswd'>
			<input type="submit" value="댓글등록">
		</form>
		<table border='1'>
			<c:forEach var="item" items="${requestScope.commentList }">
				<tr id=${item.commentNo}>
					<td>${item.commentWriter }</td>
					<td>${item.commentContent }</td>
					<td>${item.commentDay }</td>
					<c:if test="${item.commentWriter == sessionScope.id}">
						<td><input type='button' value='수정' onclick="updateComment(${item.commentNo})"></td>
						<td><input type='button' value='삭제' onclick="deleteComment(${item.commentNo})"></td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
	<script type="text/javascript">
		//삭제
		function deleteComment(commentNo) {
			var msg = confirm("댓글을 삭제합니다.");
			if (msg == true) {
				deleteCmt(commentNo);
			} else {
				return false;
			}
		}

		function deleteCmt(commentNo) {

			console.log(event.target.parentNode.parentNode);

			var param = "commentNo" + commentNo;

			var xhtp = new XMLHttpRequest();
			xhtp.open('get', 'commentDelete.do?commentNo=' + commentNo);
			xhtp.send(param);
			event.target.parentNode.parentNode.remove();

		}


		//수정  
		function updateComment(commentNo) {
			console.log(event.target.value)
			let targetTr = document.getElementById(commentNo);

			if (event.target.value == '수정') {

				let targetTd = targetTr.children[1];
				let tvalue = targetTd.textContent;
				targetTd.innerHTML = '<input type="text" value="' + tvalue + '">';

				targetTr.children[3].children[0].value = '저장';
				console.log(targetTr.children[1].children[0].value);

			} else if (event.target.value == '저장') {

				var content = targetTr.children[1].children[0].value;

				let xhtp = new XMLHttpRequest();
				xhtp.open('get', 'commentUpdateForm.do?commentNo=' + commentNo + '&commentContent=' + content);
				xhtp.send();
				xhtp.onload = function () {
					let update = JSON.parse(xhtp.responseText)
					console.log(update);

					targetTr.children[1].textContent = content;

					targetTr.children[3].children[0].value = '수정';

				}
			}
		}
	</script>

</body>

</html>