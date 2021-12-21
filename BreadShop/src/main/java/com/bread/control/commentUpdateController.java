package com.bread.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CommentService;
import com.bread.vo.CommentVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class commentUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));
		String commentContent = req.getParameter("commentContent");
		String commentDay = req.getParameter("commentDay");
		
		CommentVO vo = new CommentVO();
		vo.setCommentNo(commentNo);
		vo.setCommentContent(commentContent);
		vo.setCommentDay(commentDay);
		
		CommentService service = new CommentService();
		service.update(vo);
		
		List<CommentVO> list = service.commentAll(commentNo);
		
		Gson gson = new GsonBuilder().create();
		
		res.getWriter().print(gson.toJson(vo).toString());

	}

}
