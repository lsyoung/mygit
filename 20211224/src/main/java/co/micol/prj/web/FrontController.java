package co.micol.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.home.command.HomeCommand;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberSelect;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		// 수행할 command들의 집합
		map.put("/home.do", new HomeCommand()); // home.do 요청시 HomeCommand의 초기값을 리턴
		map.put("/memberList.do", new MemberList()); //회원목록보기
		map.put("/memberSelect.do", new MemberSelect()); 
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 실제 요청된 명령을 분석하고, 실행하고, 결과를 돌려주는 역활을 한다.
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI(); // URI를 얻어온다.
		String contextPath = request.getContextPath(); // ContextPath구함
		String page = uri.substring(contextPath.length()); // 실제 요청한 명령을 구한다.

		Command command = map.get(page); // Command command = new HomeCommand(); =>home.do일경우
		String viewPage = command.run(request, response); // command객체를 실행 후 리턴값을 받음

		// view Resolve를 만든다.
		if (!viewPage.equals(null) && !viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
