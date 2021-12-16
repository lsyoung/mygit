package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CommentService;
import com.bread.vo.CommentVO;

public class CommentDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		int borderNo = Integer.parseInt(req.getParameter("borderNo"));
		String commentWriter = req.getParameter("commentWriter");
		String commentContent = req.getParameter("commentContent");
		String commentPasswd = req.getParameter("commentPasswd");
		
		CommentVO vo = new CommentVO();
		vo.setCommentNo(commentNo);
		vo.setBorderNo(borderNo);
		vo.setCommentWriter(commentWriter);
		vo.setCommentContent(commentContent);
		vo.setCommentPasswd(commentPasswd);
		
		CommentService service = new CommentService();
		service.delete(commentNo);
		
		req.getRequestDispatcher("breadShop/borderOutput.jsp").forward(req, res);
		

	}

}
