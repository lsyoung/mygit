package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bread.service.BreadMemberService;
import com.bread.vo.BreadMemberVO;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		
		BreadMemberService service = new BreadMemberService();
		BreadMemberVO vo = service.login(id, passwd);
		
		HttpSession session = req.getSession();
		
		if( vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("name", vo.getName());
			
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} else {
			req.getRequestDispatcher("login.jsp").forward(req, res);
		}
	}

}
