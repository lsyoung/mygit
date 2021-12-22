package com.bread.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		
		
		PrintWriter out = res.getWriter();
		
		BreadMemberVO vo = new BreadMemberVO();
		vo.setId(id);
		vo.setName(name);
		vo.setPasswd(passwd);
		vo.setMail(mail);
		
		BreadMemberService service = new BreadMemberService();
	
		List<BreadMemberVO> list = service.searchAll();
		boolean run = false;
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
			System.out.println(list.get(i).getId());
			if(list.get(i).getId().equals(id)) {
				run = true;
				break;
			}
		}
		
		
		
		if(!run) {
			service.insert(vo);
			req.setAttribute("member", vo);
			req.getRequestDispatcher("breadShop/memberOutput.jsp").forward(req, res);
		} else {
			out.println("<script>alert('존재하는 아이디입니다.'); history.back(); </script>");
		}
				


	}

}
