package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.BreadMemberService;
import com.bread.vo.BreadMemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String name =req.getParameter("name");
		String passwd = req.getParameter("passwd");
		String mail = req.getParameter("mail");
		
		BreadMemberVO vo = new BreadMemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(passwd);
		vo.setMail(mail);
		
		BreadMemberService service = new BreadMemberService();
		service.insert(vo);
		
		req.setAttribute("member", vo);
		req.getRequestDispatcher("breadShop/memberOutput.jsp").forward(req, res);
				


	}

}
