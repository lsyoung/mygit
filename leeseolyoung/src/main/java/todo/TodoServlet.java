package todo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/TodoServlet")
public class TodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodoServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		TodoDAO dao = new TodoDAO();
		List<TodoVO> list = dao.getTodoList();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.getWriter().print(gson.toJson(list).toString());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//insert
		String cmd = request.getParameter("cmd");
		String content = request.getParameter("content");
		
		if (cmd.equals("insert")) {

			TodoVO vo = new TodoVO();
			vo.setContent(content);
			System.out.println(vo);
			
			TodoDAO dao = new TodoDAO();
			JSONObject obj = new JSONObject();
			
			try {
				dao.insertTodo(vo);
				JSONObject inobj = new JSONObject();
				
				inobj.put("content", vo.getContent());

				obj.put("retCode", "Success");
				obj.put("retVal", inobj);

			} catch (Exception e) {
				e.printStackTrace();
	
				obj.put("retCode", "Fail");
				obj.put("retVal", e.getMessage());
			}
			response.getWriter().print(obj.toString());
				
		} else if (cmd.equals("delete")) {
			
			TodoDAO dao = new TodoDAO();
			JSONObject obj = new JSONObject();
			
			try {
				dao.deleteTodo(content);

				obj.put("retCode", "Success");
				obj.put("retVal", content);

			} catch (Exception e) {
				e.printStackTrace();
	
				obj.put("retCode", "Fail");
				obj.put("retVal", e.getMessage());
			}
			response.getWriter().print(obj.toString());
		}
	}

}
