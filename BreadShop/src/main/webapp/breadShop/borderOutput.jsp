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
	* {
		margin: 0;
		padding: 0;
	}

	.border {
		width: 800px;
		margin: auto;
		margin-top: 50px;
	}

	#detailBoard {
		margin-bottom: 10px;
	}

	.comment_body {
		text-align: center;
		background-color: #F5F5F5;
	}

	.comment_table {
		margin-top: 10px;
	}

	form>textarea {
		width: 795px;
		height: 36px;
	}

	input[type=password],
	input[type=submit] {
		position: relative;
		left: 550px;
	}

	tr>td>textarea {
		width: 700px;
		height: 280px;
	}
</style>

<body>
<jsp:include page="../head.jsp"></jsp:include>
	<div class='border'>
		<table id="detailBoard" width="800" border="3" bordercolor="lightgray">
			<tr>
				<th>NAME</th>
				<td>${border.borderWriter }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td>${border.borderTitle }</td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<td><textarea rows='12' cols='88' readonly="readonly">${border.borderContent }</textarea></td>
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
		<div id="comment">
			<form action='commentInsert.do' method='post'>
				<input type='hidden' name='borderNo' value='${border.borderId }'>
				<input type='hidden' name='commentWriter' value='${sessionScope.id }'>
				<textarea cols='80' rows='2' name='commentContent' placeholder="댓글을 입력하세요"></textarea>
				<input type='password' name='commentPasswd' placeholder="비밀번호">
				<input type="submit" value="댓글등록">
			</form>
			<table class="comment_table">
				<tbody class="comment_body">
					<c:forEach var="item" items="${requestScope.commentList }">
						<tr id=${item.commentNo} bgcolor="#F5F5F5">
							<td width='100'>${item.commentWriter }</td>
							<td width='350'>${item.commentContent }</td>
							<td width='250'>${item.commentDay }</td>
							<c:if test="${item.commentWriter == sessionScope.id}">
								<td><input type='button' value='수정' onclick="updateComment(${item.commentNo})"></td>
								<td><input type='button' value='삭제' onclick="deleteComment(${item.commentNo})"></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
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