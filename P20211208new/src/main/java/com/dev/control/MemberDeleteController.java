package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String passwd =  req.getParameter("passwd");
		String name =  req.getParameter("name");
		String mail =  req.getParameter("mail");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPasswd(passwd);
		vo.setName(name);
		vo.setMail(mail);
		
		MemberService service = new MemberService();
		service.delete(id);
		
		req.setAttribute("rid", id);
		req.setAttribute("rpass", passwd);
		req.setAttribute("rname", name);
		req.setAttribute("rmail", mail);
		
		req.getRequestDispatcher("member/memberDeleteOutput.jsp").forward(req, res);
	}

}
