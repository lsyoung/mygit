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

public class CommentInsertController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	
		int borderNo = Integer.parseInt(req.getParameter("borderNo"));
		String commentContent = req.getParameter("commentContent");
		String commentWriter = req.getParameter("commentWriter");
		String commentPasswd = req.getParameter("commentPasswd");
		//String commentDay = req.getParameter("commentDay");)
		
		
		CommentVO vo = new CommentVO();

		vo.setBorderNo(borderNo);
		vo.setCommentContent(commentContent);
		vo.setCommentWriter(commentWriter);
		vo.setCommentPasswd(commentPasswd);
		//vo.setCommentDay(commentDay);

		CommentService service1 = new CommentService();
		service1.insert(vo);
		
		List<CommentVO> list = service1.commentAll(borderNo);
		req.setAttribute("commentList", list);
		
		BreadBorderService service = new BreadBorderService();
		BreadBorderVO vo1 = service.borderOne(borderNo);
		req.setAttribute("border", vo1);
		
		
		req.getRequestDispatcher("breadShop/borderOutput.jsp").forward(req, res);

	}

}
