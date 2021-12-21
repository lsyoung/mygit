package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bread.service.BreadMemberService;
import com.bread.vo.BreadMemberVO;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		
		BreadMemberVO vo = new BreadMemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setMail(mail);
		
		BreadMemberService service = new BreadMemberService();
		service.delete(id);
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		req.getRequestDispatcher("breadShop/memberDelete.jsp").forward(req, res);

	}

}
