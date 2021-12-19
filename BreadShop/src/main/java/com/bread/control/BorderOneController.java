package com.bread.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.BreadBorderService;
import com.bread.service.CommentService;
import com.bread.vo.BreadBorderVO;
import com.bread.vo.CommentVO;

public class BorderOneController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println(req.getParameter("borderId"));
		int borderId = Integer.parseInt(req.getParameter("borderId"));
		

		BreadBorderService service = new BreadBorderService();
		BreadBorderVO vo = service.borderOne(borderId);
		req.setAttribute("border", vo);
		
		CommentService service1 = new CommentService();
		List<CommentVO> list = service1.commentAll(borderId);
		req.setAttribute("commentList", list);
		

		req.getRequestDispatcher("breadShop/borderOutput.jsp").forward(req, res);

	}

}
