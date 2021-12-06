package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String userId = request.getParameter("user_id");
		String userPw = request.getParameter("user_pw");
		String userName = request.getParameter("user_name");

		if (userId.equals("admin") && userPw.equals("1234")) {
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);
			out.print("<h3>" + userName + "님 환영합니다</h3>");
		} else {
			request.getRequestDispatcher("FormServlet.do").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
