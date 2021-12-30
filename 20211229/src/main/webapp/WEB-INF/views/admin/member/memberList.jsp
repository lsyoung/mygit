<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div class="container-fluid">

      <!-- Page Heading -->
      <h1 class="h3 mb-2 text-gray-800">Members</h1>
      <p class="mb-4"></p>

      <!-- DataTales Example -->
      <div class="card shadow mb-4">
         <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">회원목록</h6>
         </div>
         <div class="card-body">
            <div class="table-responsive">
               <table class="table table-bordered" id="dataTable" width="100%"
                  cellspacing="0">
                  <thead>
                     <tr align="center">
                        <th>@ID@</th>
                        <th>@NAME@</th>
                        <th>@TEL@</th>
                        <th>@ADDRESS@</th>
                        <th>@AUTHOR@</th>
                     </tr>
                  </thead>
                  <tbody>
                     <c:forEach items="${members }" var="member">
                        <tr>
                           <td>${member.id }</td>
                           <td>${member.name }</td>
                           <td>${member.tel }</td>
                           <td>${member.address }</td>
                           <td>${member.author }</td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
         </div>
      </div>

   </div>
</body>
</html>