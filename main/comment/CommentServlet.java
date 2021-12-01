package com.yedam.comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");

		JSONObject obj = new JSONObject();

		CommentDAO dao = new CommentDAO();

		try {
			List<CommentVO> list = dao.getCommentList();
			JSONArray ary = new JSONArray();
			for (CommentVO vo : list) {

				JSONObject ino = new JSONObject();

				ino.put("id", vo.getId());
				ino.put("name", vo.getName());
				ino.put("content", vo.getContent());

				ary.add(ino);
			}
			obj.put("retCode", "Success");
			obj.put("retVal", ary);

		} catch (Exception e) {
			e.printStackTrace();
			// {"retCode":"Fail", }
			obj.put("retCode", "Fail");
			obj.put("retVal", e.getMessage());

		}
		response.getWriter().print(obj.toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");

		String cmd = request.getParameter("cmd");
		String name = request.getParameter("name");
		String content = request.getParameter("content");

		if (cmd.equals("insert")) {
			CommentVO vo = new CommentVO();
			vo.setContent(content);
			vo.setName(name);

			CommentDAO dao = new CommentDAO();
			JSONObject obj = new JSONObject();
			try {
				dao.insertComment(vo);
				JSONObject inobj = new JSONObject();
				inobj.put("id", vo.getId());
				inobj.put("name", vo.getName());
				inobj.put("content", vo.getContent());

				// {"retCode":"Success", "retVal":{"id":3,"name":"hong","content":"java.."}}
				obj.put("retCode", "Success");
				obj.put("retVal", inobj);

			} catch (Exception e) {
				e.printStackTrace();
				// {"retCode":"Fail","retVal":e.getMessage()}
				obj.put("retCode", "Fail");
				obj.put("retVal", e.getMessage());
			}
			response.getWriter().print(obj.toString());
		} else if (cmd.equals("update")) {

		} else if (cmd.equals("delete")) {

		}

	}

}
