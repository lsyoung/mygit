<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src='https://kit.fontawesome.com/a076d05399.js'
   crossorigin='anonymous'></script>
<title>Insert title here</title>
<style type="text/css">
header {
   background-color: #023586;
   height: 170px;
}

.left {
   float: left;
   color: white;
   padding: auto;
}

.right {
   float: right;
}

.member>a, .menu>a, .member, .menu {
   text-decoration: none;
   color: white;
}

.member {
   margin: 10px 10px;
   font-size:15px;
}

.menu {
   
   margin: 10px 10px;
   font-size:20px;
   
}

.button {
   border: 0;
   outline: 0;
   background-color: #023586;
   color: white;
}
form {
   display: inline;
}

.hide{
	background-color:white;
	display:none;
	color:#888888;
}

.slideMenu:hover .hide{
	display:block;
	position:absolute;
}


</style>



</head>
<body>

   <header>
      <div class="header">
         <div class="left">
        	 <li class="slideMenu">
	        	<a><i class='fas fa-bars' style='font-size: 36px'></i></a>
	        	<ul class="hide">
	         		<li> <a href='login.do'>로그인</a></li>
	         		<li>asdf</li>
	         		<li>asdf</li>
	         	</ul>
        	 </div> 
        <div> <a href="index.jsp"><img alt="" src="upload/breadmain.png" width="100"></a> </div>
      </div>

         <div class="right">
            <div class="member">
               <a href='login.do'>로그인</a> &nbsp; &nbsp;| &nbsp; &nbsp; <a href='breadShop/memberInput.jsp'>회원가입</a>
                &nbsp; &nbsp; |<form action='memberInfo.do' method='get'>
                  <input type='hidden' name='id' value='${sessionScope.id }'>
                  <input type='submit' value='내정보보기' class="button member">
               </form>
            </div>
            <div class="menu">
               <a href='productList.do'>전체 상품 조회</a> &nbsp; |&nbsp; <a href='borderList.do'>후기</a>
               &nbsp; |<form action="cartList.do" method="get">
                  <input type='hidden' name='memberId' value=${sessionScope.id }>
                  <br> <input type='submit' value='장바구니 검색' class="button menu">
               </form>
            </div>
         </div>
      </div>
   </header>

</body>
</html>