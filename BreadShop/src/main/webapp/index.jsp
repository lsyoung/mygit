<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	.images>img {
		vertical-align: bottom;
		width: 433px;
		height: 700px ;
		margin-right: -6px;
		padding: 0;	
	}
</style>

<body>

	<jsp:include page="head.jsp"></jsp:include>

	<div class="container">
		<div class="album">
			<div class="images">
				<img src="upload/1.PNG">
				<img src="upload/2.PNG">
				<img src="upload/3.PNG">
				<img src="upload/4.PNG">
			</div>
		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>

</html>