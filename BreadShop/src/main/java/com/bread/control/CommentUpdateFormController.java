package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CommentService;
import com.bread.vo.CommentVO;

public class CommentUpdateFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		String commentContent = req.getParameter("commentContent");
		String commentDay = req.getParameter("commentDay");
		
		CommentVO vo = new CommentVO();
		vo.setCommentNo(commentNo);
		vo.setCommentContent(commentContent);
		vo.setCommentDay(commentDay);
		
		CommentService service = new CommentService();
		service.update(vo);
		req.setAttribute("comment", vo);
		req.setAttribute("newComment", commentContent);
		req.setAttribute("newDay", commentDay);
		
		
		req.getRequestDispatcher("breadShop/borderOutput.jsp").forward(req, res);


	}

}
