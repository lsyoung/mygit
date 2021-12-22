<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>borderInsert.jsp</title>
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
	tr>td>textarea {
		width: 700px;
		height: 280px;
	}
</style>

<body>
<jsp:include page="../head.jsp"></jsp:include>
	<div class='border'>
		<form action='../borderInsert.do' method='post'>
			<table id="detailBoard" width="800" border="3" bordercolor="lightgray">
				<tr>
					<th>NAME</th>
					<td><input type='text' name='borderWriter' value='${sessionScope.id }' readonly="readonly"></td>
				</tr>
				<tr>
					<th>TITLE</th>
					<td><input type='text' name='borderTitle'></td>
				</tr>
				<tr>
					<th>CONTENT</th>
					<td><textarea rows='12' cols='88' name='borderContent'></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type='submit' value='입력'>
						<input type='button' value='취소' onclick="location.href='../borderList.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>