package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//super.service(req, resp);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userId") != null) {
			
			out.print("<h3>이미 로그인 중입니다.</h3>");
			out.print("<h3>당신의 이름은: "+session.getAttribute("userName")+"</h3>");
			
		} else {
			
			//form화면
			out.print("<form action='LoginServlet' method='get' >");
			out.print("사용자아이디: <input type='text' name='user_id'>");
			out.print("사용자비번: <input type='text' name='user_pw'>");
			out.print("사용자이름: <input type='text' name='user_name'>");
			out.print("<input type='submit' value='전송'>");
			out.print("</form>");	
		}
		
	}

}
