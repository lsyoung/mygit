package com.bread.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CommentService;
import com.bread.vo.CommentVO;

public class CommentListController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		CommentService service = new CommentService();
		List<CommentVO> list = service.commentAll(1);
		
		req.setAttribute("commentList", list);
		req.getRequestDispatcher("breadShop/borderOutput.jsp").forward(req, res);

	}

}
