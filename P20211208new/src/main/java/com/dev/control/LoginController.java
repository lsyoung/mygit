package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String pass = req.getParameter("passwd");

		MemberService service = new MemberService();
		MemberVO vo = service.login(id, pass);

		HttpSession session = req.getSession();

		if (vo != null) {
			// index.jsp
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());

			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			// login.jsp
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

}
