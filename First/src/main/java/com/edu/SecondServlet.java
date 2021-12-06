package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SecondServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = request.getSession();

		System.out.println("Second Servlet");
		String method = request.getMethod();

		String page = request.getParameter("page");
		String name = request.getParameter("name");

		PrintWriter out = response.getWriter();

		out.print(false);
		out.print("Hello");
		out.print("<h3>" + method + "</h3>");
		out.print("<h3> page: " + page + "</h3>");
		out.print("<h3> name: " + name + "</h3>");
		
		session.setAttribute("userId", "admin");
		session.setAttribute("password", "1234");
		
		request.getRequestDispatcher("ThirdServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
