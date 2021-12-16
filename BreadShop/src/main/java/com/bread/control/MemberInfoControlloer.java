package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.BreadMemberService;
import com.bread.vo.BreadMemberVO;

public class MemberInfoControlloer implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		BreadMemberService service = new BreadMemberService();
		
		BreadMemberVO vo = service.searchOne(id);
		req.setAttribute("member", vo);
		
		req.getRequestDispatcher("breadShop/memberInfo.jsp").forward(req, res);

	}

}
