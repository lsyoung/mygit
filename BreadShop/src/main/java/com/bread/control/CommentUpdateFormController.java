package com.bread.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bread.service.CommentService;
import com.bread.vo.CommentVO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommentUpdateFormController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/json;charset=utf-8");
		int commentNo = Integer.parseInt(req.getParameter("commentNo"));

		CommentService service = new CommentService();
		CommentVO vo = service.commentOne(commentNo);

		Gson gson = new GsonBuilder().create();
		
		res.getWriter().print(gson.toJson(vo).toString());

	}

}
