package com.dev.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 사용자 입력 정보-> 서비스 -> dao -> 결과 리턴 ->memberOutput.jsp
		// req.getQueryString();

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String passwd = req.getParameter("passwd");
		String mail = req.getParameter("mail");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(passwd);
		vo.setMail(mail);

		// 입력처리
		MemberService service = new MemberService();

		service.insert(vo);

		req.setAttribute("member", vo);

		req.getRequestDispatcher("member/memberOutput.jsp").forward(req, res);
	}
}
