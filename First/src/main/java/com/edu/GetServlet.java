package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset-utf-8");
		
		HttpSession session = req.getSession();//같은 세션만 공유
		ServletContext sc = req.getServletContext();//다른 브라우저도 공유됨
		
		
		PrintWriter out = resp.getWriter();
		String method = req.getMethod();
		
		if(method.equals("GET")) {
			String ui = req.getParameter("user_id");
			String un  = req.getParameter("user_name");

			out.print("<h3>사용자아이디: " + ui + "</h3>");
			out.print("<h3>사용자이름: "+un+"</h3>");
			
			sc.setAttribute("user_aidi", ui);
			sc.setAttribute("user_naim", un);
			
			RequestDispatcher rd = req.getRequestDispatcher("GetDispatcher");
			rd.forward(req, resp);
		}
	}
}
