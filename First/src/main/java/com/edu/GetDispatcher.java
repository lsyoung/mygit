package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetDispatcher")
public class GetDispatcher extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset-utf-8");
		
		HttpSession session = req.getSession();
		ServletContext sc = req.getServletContext();
		
		PrintWriter out = resp.getWriter();
		
		out.print("<h3>당신의 아이디는: "+sc.getAttribute("user_aidi")+"</h3>");
		out.print("<h3>당신의 이름은: "+sc.getAttribute("user_naim")+"</h3>");
	}

}
