<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>memberInput.jsp</title>
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

	.member {
		width: 500px;
		margin: auto;
		margin-top: 50px;
	}

	.member_table {
		margin-top: 10px;
	}

	.member_insert>li {
		margin-bottom: 20px;
		text-align: left;
	}

	.member_info {
		width: 450px;
		height: 50px;
		border: 1px solid #666;
		padding: 10px;
	}

	.button {
		margin-top: 10px;
	}
	.button>ul {
		display: flex;
	}
	.button>ul>li {
		margin-right: 30px;
	}
	input[type=submit]{
		margin-left: 50px;
	}
	input[type=submit],
	input[type=reset],
	input[type=button]{ 
		height: 50px;
		width: 100px;
	}
</style>

<body>
	<div class="member">
		<h1 align="center">회원가입</h1>
		<ul class="member_table">
			<form action='../memberinsert.do' method='get'>
				<div class="member_insert">
					<li><span>아이디</span><br><input type='text' name='id' class="member_info" placeholder="아이디를 입력하세요">
					</li>
					<li><span>비밀번호</span><br><input type='password' name='passwd' class="member_info" placeholder="비밀번호를 입력하세요"></li>
					<li><span>이름</span><br><input type='text' name='name' class="member_info" placeholder="이름을 입력하세요"></li>
					<li><span>이메일</span><br><input type='email' name='mail' class="member_info" placeholder="이메일을 입력하세요"></li>
				</div>
		</ul>
		<div class="button">
			<ul>
				<li><input type="submit" value="가입하기"></li>
				<li><input type="reset" value="다시입력"></li>
				<li><input type="button" value="홈으로가기" onclick="location.href='../index.jsp'"></li>
			</ul>
		</div>
		</form>
	</div>
</body>

</html>