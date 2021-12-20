<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- https://github.com/snowleeeee/realWeb/blob/master/src/main/webapp/shop/register_item.html
 -->	
 	<form action="../productInsert.do" name="registerProduct"
         enctype="multipart/form-data" method='post'>
		상품번호 : <input type ='text' name='product_id'></br>
		상품명 : <input type='text' name ='product_name'></br>
		상품설명 : <textarea rows="5" cols="" name="product_desc"></textarea> </br>
		상품 이미지 :  <input type='file' name ='product_image'></br>
		상품 가격 :  <input type='number' name='product_price'></br>
		상품 개수 : <input type ='number' name='product_inventory'></br>
		상품 평점 : <input type ='text' name='product_grade'></br>
		<input type ='hidden' name='product_count' value='0'></br>
		<input type ='submit' value='등록'>
		
	
	</form>

</body>
</html>