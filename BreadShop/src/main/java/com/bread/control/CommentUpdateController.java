package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CommentService;
import com.bread.vo.CommentVO;

public class CommentUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		
		CommentService service = new CommentService();
		CommentVO vo = service.commentOne(commentNo);
		req.setAttribute("comment", vo);
		
		req.getRequestDispatcher("breadShop/commentUpdate.jsp").forward(req, res);
		
	}

}
