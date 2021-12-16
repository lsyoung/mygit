<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품 검색(SearchList)</h3>
	<form action="../productSearchList.do" method="get">
		
		<table>
			<tr>
				<td>
					<select name='searchField'>
						<option value='0'>선택</option>
						<option value='product_id'>상품번호</option>
						<option value='product_name'>상품명</option>
					</select>
				</td>
			
				<td>
					<input type='text' name='name'>
					<input type='hidden' name='job' value='searchList'> 
					<input type='submit' value='검색'>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>