<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>login.jsp</title>
</head>
<style>
	* {
		margin: 0;
		padding: 0;
		list-style: none;
	}

	body {
		background-color: #F5F6F7;
	}

	.login {
		width: 500px;
		margin: auto;
		margin-top: 50px;
	}

	.login_form {
		width: 500px;
		height: 300px;
		margin: auto;
	}

	.login_field {
		width: 450px;
		height: 30px;
		margin-bottom: 10px;
		padding: 15px;
	}

	.login_btn {
		width: 450px;
		height: 30px;
		margin: 10px 0 0 15px;
		font-size: 24px;
	}
</style>

<body>
	<div class="login">
		<h1 align="center">LOGIN</h1>
		<div class="login_form">
			<form action='login.do' method='post'>
				ID <input type='text' name='id' class="login_field" placeholder='아이디'><br>
				PW <input type='password' name='passwd' class="login_field" placeholder='비밀번호'><br>
				<input type='submit' class="login_btn" value='LOGIN'>
			</form>
		</div>
	</div>
</body>

</html>