<%@page import="com.bread.vo.CommentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>commentUpdateForm.jsp</title>
<%
CommentVO vo = (CommentVO) request.getAttribute("comment");
%>
<script>
var httpRequest = null;

	function getXMLHttpRequest(){
   		 var httpRequest = null;

    if(window.ActiveXObject){
        try{
            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
        } catch(e) {
            try{
                httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e2) { httpRequest = null; }
        }
    }
    else if(window.XMLHttpRequest){
        httpRequest = new window.XMLHttpRequest();
    }
    return httpRequest;    
}

	function checkValue() {
		var form = document.forms[0];   
		console.log(form);
		var commentNo = "<%=vo.getCommentNo()%>"
		console.log(commentNo);
		var commentContent = form.commentContent.value
		console.log(commentContent);
		
		if (!commentContent) {
			alert("내용을 입력하세요");
			return false;
		} else {
			var param = "commentNo=" + commentNo + "&commentContent="
					+ commentContent;

			httpRequest = getXMLHttpRequest();
			httpRequest.onreadystatechange = checkFunc;
			httpRequest.open("POST", "commentUpdateForm.do", true);
			httpRequest.setRequestHeader('Content-Type',
					'application/x-www-form-urlencoded;charset=EUC-KR');
			httpRequest.send(param);
		}
	}

	function checkFunc() {
		if (httpRequest.readyState == 4) {
			// 결과값을 가져온다.
			var resultText = httpRequest.responseText;
			if (resultText == 1) {
				if (opener != null) {
					// 부모창 새로고침
					window.opener.document.location.reload();
					opener.updateForm = null;
					self.close();
				}
			}
		}
	}
</script>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="5" color="gray">댓글수정</font></b>
		<hr size="1" width="550">
		<br>

		<div id="commentUpdateForm">
			<form name="updateInfo" target="parentForm">
				<textarea rows="7" cols="70" name="commentContent"><%=vo.getCommentContent()%></textarea>
				<br> <br> <input type="button" value="등록"
					onclick="checkValue()"> <input type="button" value="창닫기"
					onclick="window.close()">
			</form>
		</div>
	</div>

</body>
</html>