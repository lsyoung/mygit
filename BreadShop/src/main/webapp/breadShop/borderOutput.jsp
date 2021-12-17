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

<body>
	<%
	BreadBorderVO vo = (BreadBorderVO) request.getAttribute("border");
	List<CommentVO> list = (List<CommentVO>) request.getAttribute("commentList");
	%>
	<table border='1'>
		<tr>
			<th>NAME</th>
			<td><%=vo.getBorderWriter()%></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=vo.getBorderTitle()%></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows='10' cols='60' readonly="readonly"><%=vo.getBorderContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type='button' value='수정'
					onclick="location.href='borderUpdateForm.do?borderId=<%=vo.getBorderId()%>'">
				<input type='button' value='삭제'
					onclick="location.href='borderDelete.do?borderId=<%=vo.getBorderId()%>'">
				<input type='button' value='목록' onclick="location.href='borderList.do'"></td>
		</tr>
	</table>
	<form action='commentInsert.do' method='post'>
		<h3>댓글</h3>
		<input type='hidden' name='borderNo' value='<%=vo.getBorderId() %>'>
		<input type='hidden' name='commentWriter' value='${sessionScope.id }'>
		<textarea cols='40' rows='2' name='commentContent'></textarea>
		<input type='password' name='commentPasswd'>
		<input type="submit" value="댓글등록">
	</form>
	<table border='1'>
		<c:forEach var="item" items="${commentList }">
			<tr id=${item.commentNo}>
				<td>${item.commentWriter }</td>
				<td>${item.commentContent }</td>
				<td>${item.commentDay }</td>
				<td><input type='button' value='수정' onclick="updateComment(${item.commentNo})"></td>
				<td><input type='button' value='삭제' onclick="deleteComment(${item.commentNo})"></td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		//삭제
		function deleteComment(commentNo) {

			let xhtp = new XMLHttpRequest();
			xhtp.open('get', 'commentDelete.do?commentNo=' + commentNo);
			xhtp.send();
			xhtp.onload = function () {
			let data = JSON.parse(xhtp.responseText)
			console.log(data);
			location.reload();
			}
		}

		function updateComment(commentNo) {
			console.log(event.target.value)
			let targetTr = document.getElementById(commentNo);

			if (event.target.value == '수정') {

				let targetTd = targetTr.children[1];
				let tvalue = targetTd.textContent;
				targetTd.innerHTML = '<input type="text" value="' + tvalue + '">';
				targetTr.children[3].children[0].value = '저장';

			} else if (event.target.value == '저장') {

				let xhtp = new XMLHttpRequest();
				xhtp.open('get', 'commentUpdateForm.do?commentNo=' + commentNo);
				xhtp.send();
				xhtp.onload = function () {
					let data = JSON.parse(xhtp.responseText)
					console.log(data);

					targetTr.children[3].children[0].value = '수정';

				}
			}
		}
	</script>

</body>

</html>